package my_practices;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElementFaacebook02 {
    /*
    1) https://www.facebook.com adresine gidin
    2) cookies cikarsa kabul et butonuna basin
    3) e-posta kutusuna rastgele bir mail girin
    4) sifre kısmına rastgele bir sifre girin
    5) giris yap butonuna basın
    6) uyarı olarak "The email or mobile number you entered isnt connected to an account. Find your account and log in.
       mesajının cıktıgını test edin
    7) sayfayı kapatın

    Girdiğin e-posta veya cep telefonu numarası bir hesaba bağlı değil. Hesabını bul ve giriş yap.
     */

    public static void main(String[] args) {

        //WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       // 1) https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com/");

       // 2) cookies cikarsa kabul et butonuna basin
      driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")).click();

       // 3) e-posta kutusuna rastgele bir mail girin
       WebElement epostEl = driver.findElement(By.xpath("//input[@name='email']"));
       epostEl.sendKeys("kjhdrVYJ6wer56");

       // 4) sifre kısmına rastgele bir sifre girin
       WebElement sifreEl= driver.findElement(By.xpath("//input[@id='pass']"));
      sifreEl.sendKeys("45vvvh27");
       // 5) giris yap butonuna basın
        driver.findElement(By.xpath("//button[@name='login']")).click();
       // 6) uyarı olarak "The email or mobile number you entered isnt connected to an account. Find your account and log in.
       // mesajının cıktıgını test edin
         WebElement uyarıEle=  driver.findElement(By.xpath("//div[@class='_9ay7']"));
          String exceptedSonucEl= "Girdiğin e-posta veya cep telefonu numarası bir hesaba bağlı değil. Hesabını bul ve giriş yap.";
           String actualSonucEl= uyarıEle.getText();

        Assert.assertEquals(exceptedSonucEl,actualSonucEl);


       // 7) sayfayı kapatın
       driver.quit();

    }
}
