package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day07_AlertReviwe extends TestBase {


 @Test
    public void test1(){
 //go to: "https://testcenter.techproeducation.com/index.php?page=javascript-alerts"
   driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
 //    acceptAlert() => click on the first alert,
     driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

//             verify the text “I am a JS Alert” ,
      String actualAlert = driver.switchTo().alert().getText();
     Assert.assertEquals("I am a JS Alert",actualAlert);
//     click OK ,
     driver.switchTo().alert().accept();

//     and Verify “You successfully clicked an alert”
     String actualAlertText =driver.findElement(By.id("result")).getText();
     Assert.assertEquals("You successfully clicked an alert",actualAlertText);

 }
  @Test
    public void test2(){
//      dismissAlert()=> click on the second alert,
      driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
      driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

//      verify text "I am a JS Confirm”,
     String actualText1= driver.switchTo().alert().getText();
     Assert.assertEquals("I am a JS Confirm",actualText1);
//      click cancel,
      driver.switchTo().alert().dismiss();
//            and Verify “You clicked: Cancel”
      String actualTest2 = driver.findElement(By.id("result")).getText();
      Assert.assertEquals("You clicked: Cancel",actualTest2);
  }
  @Test
    public void test3(){
      driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//      sendKeysAlert()=> click on the third alert,
      driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

//              verify text “I am a JS prompt”,
      String actualTest1= driver.switchTo().alert().getText();
      Assert.assertEquals("I am a JS prompt",actualTest1);

//      type “Hello World”
      driver.switchTo().alert().sendKeys("Hello World");
//
//      click OK,
      driver.switchTo().alert().accept();
//      and Verify “You entered: Hello World”
      String actualTest2=driver.findElement(By.id("result")).getText();
      Assert.assertEquals("You entered: Hello World",actualTest2);


  }

}
