package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class Day08_Actions2 extends TestBase {
    /*
    Create a class: Actions2
Create test method : hoverOver()(mouse u üzerinde bekletme) and test the following scenario:
Given user is on the https://www.amazon.com/
When use click on “Account” link
Then verify the page title contains “Your Account”
     */
    @Test
    public void hoverOverTest(){
//       Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com/");

//       When use click on “Account” link
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).perform();

        driver.findElement(By.linkText("Account")).click();
//        Then verify the page title contains “Your Account”


    }


/*
NOT:Yasin H'dan bu kısım
        Given
                Go to https://testpages.herokuapp.com/styled/csspseudo/css-hover.html
        When
                Hover over "Hover Div"
        And
                Click on “Can you click me?” link.
        Then
                Verify the text "Action Complete".
        */

    @Test
    public void hoverOverTest2() throws InterruptedException {
        //Go to https://testpages.herokuapp.com/styled/csspseudo/css-hover.html
        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");

        //Hover over "Hover Div" -->Fareyle "Hover Div"in üzerine gelin
        Actions actions = new Actions(driver);
        WebElement hoverDiv = driver.findElement(By.id("hoverdivpara"));
        Thread.sleep(2000);
        actions.moveToElement(hoverDiv).perform();

        //Click on “Can you click me?” link.
        Thread.sleep(2000);
        driver.findElement(By.id("hoverlink")).click();

        //Verify the text "Action Complete".
        String actionCompleteText = driver.findElement(By.xpath("//h1")).getText();
        assertEquals("Action Complete",actionCompleteText);
    }


}
