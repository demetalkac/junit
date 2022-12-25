package friends;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AmazonTest {
      /*
         1- Amazona gir
         2- Sign In’e tıkla
         3-Email gir ve continue butonuna bas
         4- Şifre gir ve Giriş yap
         5- Giriş yaptığını onayla
         Eğer hesabınız yoksa amazonda, giriş yapamazsınız
       */
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
    }
    @Test public void amazonHesap(){

      // 2- Sign In’e tıkla
        driver.findElement(By.linkText("Sign in")).click();

      //  3-Email gir ve continue butonuna bas
        driver.findElement(By.id("ap_email")).click();

      // 4- Şifre gir ve Giriş yap

    }
    @After
    public void tearDown(){
        driver.quit();
    }


}
