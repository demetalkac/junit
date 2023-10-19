package tests;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Tekrar {
    WebDriver driver;

    @Before
    public void setUp() {
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void LMSPage(){
        driver.get("https://techproeducation.com/");
        driver.findElement(By.partialLinkText("LMS LO")).click();

        String excepted= "https://lms.techproeducation.com/";
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(excepted,driver.getCurrentUrl());
    }
    @Test
    public void loginTest() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        locating username and typing username
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
//        locating password and typing password

    }
    @Test
    public void loginTestCss(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        location username and tyoing username

//        locating password and typing

//        locating submit button and click

    }
}