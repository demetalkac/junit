package practices.practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Q04Review {
     /*
    // ...Practice 4...
    // Create chrome driver by using @Before annotation and WebDriverManager
    // Navigate to  https://testpages.herokuapp.com/styled/index.html
    // Click on  Calculator under Micro Apps
    // Type any number in the first input
    // Type any number in the second input
    // Click on Calculate
    // Get the result
    // Verify the result
    // Print the result
    // Close the browser by using @After annotation
     */
     WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testpages.herokuapp.com/styled/index.html");
    }
    @Test
    public void test1(){
        // Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();

        // Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("4");

        // Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("6");

        // Click on Calculate
        driver.findElement(By.id("calculate")).click();


        // Get the result
       String result= driver.findElement(By.id("answer")).getText();
        // assert the result
        Assert.assertEquals("10",result); 
        
        // Print the result
        System.out.println("result = " + result);
    }
    // Click on  Calculator under Micro Apps
    //Select 'divide' operation
    // Type any number in the first input
    // Type any number in the second input
    // Click on Calculate
    // Get the result
    // Assert the result
    // Print the result
    @Test
    public void divisionTest(){
        // Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();

        //Select 'divide' operation
       WebElement divideOprsn= driver.findElement(By.id("function"));
        Select select =new Select(divideOprsn);
        select.selectByVisibleText("divide");

        // Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("8");

        // Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("2");

        // Click on Calculate
        driver.findElement(By.id("calculate")).click();

        // Get the result
       String result2= driver.findElement(By.id("answer")).getText();
        
        // Assert the result
        Assert.assertEquals("4",result2);
        // Print the result
        System.out.println("result2 = " + result2);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
