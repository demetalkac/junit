package my_notes;

// io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class N000000 {

    WebDriver driver;
    @Before
    public void setUp(){
       // WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void radioButtonTest(){

       //2)https://www.youtube.com adresinegidin
        driver.get("https://www.youtube.com");
        //3)Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleriyapin
        //○titleTest
        //○imageTest
        //=> Sayfa başlığının “YouTube” oldugunu testedin
      String title=  driver.getTitle();
        Assert.assertEquals("YouTube",title);
        //=> YouTube resminin görüntülendiğini (isDisplayed()) testedin
     WebElement rdes= driver.findElement(By.xpath("//*[@id='logo'][1]"));
        Assert.assertTrue(rdes.isDisplayed());

        //○Search Box 'in erisilebilir oldugunu test edin(isEnabled())
        WebElement serc=  driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(serc.isEnabled());
        //○wrongTitleTest => Sayfa basliginin “youtube” olmadiginidogrulayin
        Assert.assertFalse(title.equals("youtube"));

    }
    @Test
    public void test(){
        //1.Bir Class olusturalimYanlisEmailTesti
        //2.http://automationpractice.com/index.php sayfasinagidelim
        //3.Sign in butonunabasalim
        //4.Email kutusuna @isareti olmayan bir mail yazipenter’a
        //bastigimizda “Invalid email address” uyarisi ciktigini testedelim
    }

}

