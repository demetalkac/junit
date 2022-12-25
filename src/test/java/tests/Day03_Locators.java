package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day03_Locators {

    /*
   Create a class : LocatorsIntro
   Create test method locators
   user goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
   Locate the elements of email textbox, password textbox, and signin button
   Enter below username and password then click sign in button
   Username :  testtechproed@gmail.com
   Password : Test1234!
   Then verify that the expected user id  testtechproed@gmail.com (USE getText() method to get the text from the page)
   Verify the Addresses and Sign Out  texts are displayed
   Find the number of total link on the page
   Sign out from the page
       */

    /*
    /*
        User goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        Locate the elements of Username textbox, Password textbox, and Login button
        Enter below username and password then click on login button
                Username :  Admin
                Password :  admin123
        Verify the login is successful
        Sign out from the page
        */

    WebDriver driver; //Scop issu :eger WebDriver driver'i  @Before'ın icinde olsa diger @test'lerde kullanamayız buna denir
    @Before
    public void setUp(){
//     user goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();

//      ismi: IMPLICIT WAIT:yavas calısınca test etme fail verebiliyor,onun ,cin bu kodu kullanıyoruz
//     note:(Duration.ofSeconds(15)) altınsda compare time yani altı kırmızı olursa ustunde bekle
//          "set language level to 8...."ı sec. pom.xml'e otomatık kendi birseyler ekliyor.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @Test
    public void logInTest(){


//        Locating the username and typing
       WebElement username = driver.findElement(By.name("username")); ////Location username by name
       username.sendKeys("Admin");// typing Admin


//        Locating the password and typing
       WebElement password = driver.findElement(By.name("password"));
       password.sendKeys("admin123");
//        Locating the button and cliking
        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

//                Verifying the log in is successful
//        1. We can use default page URL to do assertion
//        2. Or we can locate a  specific element on the default page to assert is that element is displayed on the page
//        Login Page : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//        Default Page : https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        Assert.assertEquals("LOGIN FAILED",expectedURL,actualURL);//If login successful PASS, if not FAIL and print message LOGIN FAILED"


//      NOTE : We do not need to use containers. We can use method chain in selenium
//        driver.findElement(By.name("username")).sendKeys("Admin");ustteki kodlar ile aynı islemi yaparlar,memoride az yer kaplar
//        driver.findElement(By.name("password")).sendKeys("admin123");
//        driver.findElement(By.tagName("button")).click();

    }
    @After
    public  void tearDown(){
        driver.quit();
    }

}
