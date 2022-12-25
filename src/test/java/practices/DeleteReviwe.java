package practices;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class DeleteReviwe extends TestBase {
    @Test
    public  void test1(){
        // Go to url : http://www.uitestpractice.com/
        driver.get("http://www.uitestpractice.com/");
        // Click on 'Form'
        driver.findElement(By.xpath("//a[@href='/Students/Form']")).click();
        // Fill the First Name: John
        driver.findElement(By.id("firstname")).sendKeys("John");

        // Fill the Last Name: Doe
        driver.findElement(By.id("lastname")).sendKeys("Doe");

        // Check the Marital Status: Married
        driver.findElement(By.xpath("(//input[@name='optradio'])[1]")).click();

        // Check the Hobby: Reading
        driver.findElement(By.xpath("(//label[@class='checkbox-inline'])[2]")).click();
        // Select the Country : Canada
        WebElement drobdown=driver.findElement(By.id("sel1"));
        Select select= new Select(drobdown);
//        select.selectByVisibleText("Canada");
       select.selectByIndex(13);
        List<WebElement> tumSecenekler=select.getOptions();
        for (WebElement w:tumSecenekler){
            System.out.println(w.getText());
        }

        // Fill the Date Of Birth: 1st February 2000
        driver.findElement(By.id("datepicker")).sendKeys("02/01/2000");
        // Fill the Phone Number: 12345
        driver.findElement(By.id("phonenumber")).sendKeys("12345");
        // Fill the User Name: john_doe
        driver.findElement(By.id("username")).sendKeys("john_doe");
        // Fill the Eamil: john@doe.com
        driver.findElement(By.id("email")).sendKeys("john@doe.com");
        // Fill the About Yourself: My name is John Doe. I am a famous man. Because my name is used as a mock data everywhere.
        driver.findElement(By.id("comment")).sendKeys("My name is John Doe. I am a famous man. Because my name is used as a mock data everywhere.");
        // Fill the Password: John.123
        driver.findElement(By.id("pwd")).sendKeys("John.123");
        // Click on Submit Button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
    @Test
    public void test2(){
        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        // Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();
        //DROPDOWN
       WebElement dropdoen= driver.findElement(By.id("function"));
       Select select =new Select(dropdoen);
       select.selectByVisibleText("minus");



        // Type any number in the first input
     driver.findElement(By.id("number1")).sendKeys("45");
        // Type any number in the second input
       driver.findElement(By.id("number2")).sendKeys("23");
        // Click on Calculate
       driver.findElement(By.id("calculate")).click();
        // Get the result
      String minus=driver.findElement(By.id("answer")).getText();

        Assert.assertEquals("22",minus);
        System.out.println("minus = " + minus);
        // Verify the result
        // Print the result
    }
    @Test
    public void alertTest(){
        /*
Go to https://the-internet.herokuapp.com/javascript_alerts
 Create a class: AlertTest
Create setUp method
 Create 3 test methods:
         acceptAlert() => click on the first alert,
         verify the text “I am a JS Alert” ,
         click OK ,
         and Verify “You successfully clicked an alert”
                 dismissAlert()=> click on the second alert,
                 verify text "I am a JS Confirm”,
                 click cancel,
                 and Verify “You clicked: Cancel”
                               sendKeysAlert()=> click on the third alert,
                               verify text “I am a JS prompt”,
                                type “Hello World”,
                                click OK,
                                and Verify “You entered: Hello World”
 */

    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

       String alert1= driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS Alert",alert1);
        driver.switchTo().alert().accept();
    String result1= driver.findElement(By.xpath("//p[@id='result']")).getText();
    Assert.assertEquals("You successfully clicked an alert",result1);

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        String alert2= driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS Confirm",alert2);
        driver.switchTo().alert().dismiss();
        String result2= driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals("You clicked: Cancel",result2);

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        String alert3= driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS prompt",alert3);
        driver.switchTo().alert().sendKeys("Hello World");
        driver.switchTo().alert().accept();
        String result3= driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals("You entered: Hello World",result3);

    }




}
