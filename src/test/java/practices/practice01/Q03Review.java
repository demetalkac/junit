package practices.practice01;

// io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Q03Review {
    WebDriver driver;
    @Before
    public void setUp(){
        // Create chrome driver by using @Before annotation and WebDriverManager
        // Go to url : http://www.uitestpractice.com/
        //WebDriverManager.chromedriver().setup();
         driver =new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
         driver.get("http://www.uitestpractice.com/");

    }
   @Test
    public void test1(){
       // Click on 'Form'
       driver.findElement(By.xpath("//a[@href='/Students/Form']")).click();

       // Fill the First Name: John
       driver.findElement(By.id("firstname")).sendKeys("John");

       // Fill the Last Name: Doe
       driver.findElement(By.id("lastname")).sendKeys("Doe");

       // Check the Marital Status: Married
       driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();

       // Check the Hobby: Reading
       driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();

       // Select the Country : Canada
      WebElement countryElement= driver.findElement(By.id("sel1"));
       Select select= new Select(countryElement);
       select.selectByVisibleText("Canada");

       // Fill the Date Of Birth: 1st February 2000
       driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("02/01/2022");

       // Fill the Phone Number: 12345
       driver.findElement(By.id("phonenumber")).sendKeys("12345");

       // Fill the User Name: john_doe
       driver.findElement(By.id("username")).sendKeys("john_doe");

       // Fill the Eamil: john@doe.com
       driver.findElement(By.xpath("//input[@id='email']")).sendKeys("john@doe.com");

       // Fill the About Yourself: My name is John Doe. I am a famous man. Because my name is used as a mock data everywhere.
       driver.findElement(By.id("comment")).sendKeys("My name is John Doe. I am a famous man. Because my name is used as a mock data everywhere.");

       // Fill the Password: John.123
       driver.findElement(By.xpath("//input[@type='password']")).sendKeys("John.123");

       // Click on Submit Button
       driver.findElement(By.xpath("//button[@type='submit']")).click();
       //WebElement a = driver.findElement(By.xpath("//button[@type='submit']"));
       //a.sendKeys(Keys.ENTER); //EGER CLICK CALISMAZSA BUNU KULLAN
   }


    // Close the browser by using @After annotation
        @After
    public void tearDown(){
        driver.quit();
        }
}
