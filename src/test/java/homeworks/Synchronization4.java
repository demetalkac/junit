package homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Synchronization4 extends TestBase {
    /*
    Create a class:Synchronization4. Create a method: isEnabled
Go to https://the-internet.herokuapp.com/dynamic_controls
Click enable Button
And verify the message is equal to “It's enabled!”
And verify the textbox is enabled (I can type in the box)
And click on Disable button
And verify the message is equal to “It's disabled!”
And verify the textbox is disabled (I cannot type in the box)
NOTE: .isEnabled(); is used to check if an element is enabled or not
     */
    @Test
    public void test() {
//Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//Click enable Button
        WebElement enableButton =   driver.findElement(By.xpath("//button[text()='Enable']"));
        enableButton.click();
        waitForVisibility(enableButton,3);

//And verify the message is equal to “It's enabled!”
       WebElement massageEnable =   driver.findElement(By.xpath("//p[@id='message']"));
       waitForVisibility(massageEnable,3);

//And verify the textbox is enabled (I can type in the box)
       WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
      // textBox.sendKeys("I can type in the box");
        assertTrue(textBox.isEnabled());

//And click on Disable button
       WebElement disableButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
       disableButton.click();
       waitForVisibility(disableButton,3);

//And verify the message is equal to “It's disabled!”

        WebElement message = driver.findElement(By.xpath("//p[@id='message']"));

       Assert.assertEquals("It's disabled!", message.getText());
       waitForVisibility(message,3);

//And verify the textbox is disabled (I cannot type in the box)
        WebElement textBox2 = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(textBox2.isDisplayed());


      //  Assert.assertFalse(driver.findElement(By.xpath("//form[@id='input-example']//input")).isEnabled());

    }




//           HOCANIN COZUMLERI ALTTA
    @Test
    public void test4(){
//        EXPLICIT WAIT MUST BE USER IMPLICIT WAIT CANNOT HANDLE CAUSE OF THE
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //    Click enable Button
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
//        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='text']")).isEnabled()); //FAILS SO EXPLICIT MUST BE USED
        //    And verify the message is equal to “It's enabled!”
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement enabledMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        String enabledMessageText=enabledMessage.getText();
        Assert.assertEquals(enabledMessageText,"It's enabled!");

        //    And verify the textbox is enabled (I can type in the box)
        WebElement textBox=driver.findElement(By.xpath("//input[@type='text']"));
        assertTrue(textBox.isEnabled());//isEnables checks if an element is enable. Returns true if enabled, returns false if disabled.

//        click on disable button
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
        assertTrue(!driver.findElement(By.xpath("//input[@type='text']")).isDisplayed());

    }

}