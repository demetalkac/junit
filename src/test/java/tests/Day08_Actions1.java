package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day08_Actions1  extends TestBase {
    /*
    Create a class: Actions1
    Create a test method : contextClickMethod()(right click) and test the following scenario:
    Given user is on the https://the-internet.herokuapp.com/context_menu
    When use Right clicks on the box
    Then verify the alert message is “You selected a context menu”
    Then accept the alert
     */
    @Test
    public  void rightClickTest(){
        driver.get("https://the-internet.herokuapp.com/context_menu");

//        When use Right clicks on the box
//        1. creating action object to do right click
        Actions actions = new Actions(driver);
//        2. locating the element that I want to right click
        WebElement box = driver.findElement(By.id("hot-spot"));
//        3. use actions object and appropriate function to right click(Use actions object with proper method)-sağ tıklamak için eylemler nesnesini ve uygun işlevi kullanın
        actions.contextClick(box).perform();
//        Then verify the alert message is “You selected a context menu”
//       Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText()); //object olusturmadan yapmak daha iyi,eger "wait" gerektiren bir durum yoksa
        String text = driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu",text);

//        Then accept the alert-Ardından uyarıyı kabul edin
        driver.switchTo().alert().accept();


    }
}
