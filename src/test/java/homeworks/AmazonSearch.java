package homeworks;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class AmazonSearch {

/*
    //TC01_As user I want to know how many item are there on amazon in the first page after I search “porcelain teapot”?
    TC01_Kullanıcı olarak “porselen çaydanlık” araması yaptıktan sonra ilk sayfada amazon'da kaç ürün olduğunu öğrenmek istiyorum?
       //TC02_Order the the tea pot prices, find the min, max, and average price to the nearest cent.
       TC02_Demlik fiyatlarını sıralayın, minimum, maksimum ve ortalama fiyatı kuruşa yakın olarak bulun.
 */

    WebDriver driver;
    @Before
    public void setUp(){
        //WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test1() {
        driver.get("https://www.amazon.com/");
        WebElement teapot= driver.findElement(By.id("twotabsearchtextbox"));
        teapot.click();
        teapot.sendKeys("porcelain teapot"+ Keys.ENTER);


      String teapotResult = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();
        System.out.println("teapotResult = " + teapotResult);





    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        //TC02_Order the the tea pot prices, find the min, max, and average price to the nearest cent.

        WebElement teapot= driver.findElement(By.id("twotabsearchtextbox"));
        teapot.click();
        teapot.sendKeys("porcelain teapot"+ Keys.ENTER);

        //TC02_Order the the tea pot prices, find the min, max, and average price to the nearest cent.
        Thread.sleep(2000);
        driver.findElement(By.id("a-autoid-0-announce")).click();
        driver.findElement(By.id("s-result-sort-select_0"));
        driver.findElement(By.linkText("Price: Low to High")).click();





       // WebElement drop = driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']"));
      //  Select select = new Select(drop);
      //  select.selectByVisibleText("Price:Low to High");
      //  driver.findElement(By.id("s-result-sort-select_1")).click();
        // driver.findElement(By.xpath("//div[@class='s-no-outline']")).getText();
    }
}
