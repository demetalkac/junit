package tests;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Gunduz01 {
    /*
        User goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        Locate the elements of Username textbox, Password textbox, and Login button
        Enter below username and password then click on login button
                Username :  Admin
                Password :  admin123
        Verify the login is successful
        Sign out from the page
        */
    WebDriver driver;
    @Before
    public void setUp(){
       // WebDriverManager.chromedriver().setup();
         driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @Test
    public void login(){


       // Locate the elements of Username textbox, Password textbox, and Login button
      WebElement username= driver.findElement(By.name("username"));
      WebElement password= driver.findElement(By.name("password"));
      WebElement login= driver.findElement(By.tagName("button"));

      username.sendKeys("Admin");
      password.sendKeys("admin123");
      login.click();

      //assert the login is successful
      //https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index => Current Url
      boolean actual=  driver.getCurrentUrl().contains("dashboard");
     assertTrue(actual);


    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
