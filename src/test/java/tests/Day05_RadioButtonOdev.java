package tests;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day05_RadioButtonOdev {

    /*
            Radio Button
   - Create a class : RadioButton
   -Complete the following task.
   -Go to https://www.facebook.com/
   -Click on Create an Account button
    -Locate the elements of radio buttons
    -Then click on the radio buttons for your gender if they are not selected

            TEST CASE:
    -Click on Create new account
    -Enter first name
    -Enter last name
    -Enter mobile number or email
    -Enter new password
    -Enter birthday(LATER)
    -Enter gender
    -Click Sign Up
     */
    WebDriver driver;
    @Before
    public void setUp(){
       // WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com/");
    }
    @Test
    public void radioButtonTest(){
        //-Click on Create an Account button

      WebElement accountButton= driver.findElement(By.linkText("Yeni Hesap Oluştur"));
        //-Locate the elements of radio buttons
        //-Then click on the radio buttons for your gender if they are not selected
         driver.findElement(By.linkText("Kadın"));
    }
}

