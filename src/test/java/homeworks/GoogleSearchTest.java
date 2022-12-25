package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GoogleSearchTest {
    /*
    Create a new class : GoogleSearchTest
Create Test method and complete the following task.
When user goes to https://www.google.com/
Search for “porcelain teapot”
And print how many related results displayed on Google
     */
    /*
    Then create 3 different test methods using the following names. And Go to google.
    titleTest =>Verify if google title = “Google”
    imageTest => Verify if google image displays or not
    gmailLinkTest => Verify if the Gmail link is displayed or not
    Close the browser after each test
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public  void test1(){
//        Create Test method and complete the following task.
//        When user goes to https://www.google.com/
        driver.get("https://www.google.com/");
//        Search for “porcelain teapot”
        driver.findElement(By.id("L2AGLb")).click();
       WebElement teapot= driver.findElement(By.xpath("//input[@class='gLFyf']"));
       teapot.sendKeys("porcelain teapot"+ Keys.ENTER);
    //   teapot.click();

      String fin=driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
        System.out.println("fin = " + fin);
        //Assert.assertEquals("Yaklaşık 18.900.000 sonuç bulundu (0,31 saniye)",fin);
//        And print how many related results displayed on Google
    }
    @Test
    public  void test2(){
        driver.get("https://www.google.com/");
        // titleTest =>Verify if google title = “Google”
       String title= driver.getTitle();
       Assert.assertTrue(title.contains("Google"));
    }
    @Test
    public  void imageTest(){
        driver.get("https://www.google.com/");
        //imageTest => Verify if google image displays or not
       Assert.assertTrue(driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed());
    }
    @Test
    public  void gmailTest(){
        driver.get("https://www.google.com/");
        //gmailLinkTest => Verify if the Gmail link is displayed or not
        Assert.assertTrue(driver.findElement(By.linkText("Gmail")).isDisplayed());
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
