package homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Synchronization2 extends TestBase {
   /*
    Create a method: synchronization2
Go to https://the-internet.herokuapp.com/dynamic_loading/2
When user clicks on the Start button
Then verify the ‘Hello World!’ Shows up on the screen
    */
   @Test
   public void test(){
//Go to https://the-internet.herokuapp.com/dynamic_loading/2
    driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

       //When user clicks on the Start button
    driver.findElement(By.xpath("//*[text()='Start']")).click();

       //Then verify the 'Hello World!' Shows up on the screen


   String hello= driver.findElement(By.xpath("//*[text()='Hello World!']")).getText();
      Assert.assertEquals("Hello World!",hello);

       //All is good. We don't need to use explicit wait. //Implicit wait solved the issue
       //Cause the element is not hidden(No display:none on Hello World).
       //The entire element <h4>Hello World!</h4> just renders late

       //  Eger bekleme sorunu olsa bunu kullanabiliriz: WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

   }


   }




