package friends;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Automation02 {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void test01(){
  // 1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        assertTrue(driver.findElement(By.xpath("//a[.=' Home']")).isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[.=' Signup / Login']")).click();

        //5. Verify 'Login to your account' is visible
       assertTrue(driver.findElement(By.xpath("//h2[.='Login to your account']")).isDisplayed());

        //6. Enter correct email address and password
        driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys("aaaYYYYsss@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("A1B2");
        //7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();


        //8. Verify that 'Logged in as username' is visible
        WebElement created= driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(created.isDisplayed());

        driver.findElement(By.linkText("Continue")).click();
        //9. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[.=' Delete Account']")).click();
        //10. Verify that 'ACCOUNT DELETED!' is visible
    }
}
