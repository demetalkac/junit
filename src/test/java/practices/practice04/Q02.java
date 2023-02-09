package practices.practice04;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class Q02 extends TestBase {

    /*
    Given
        Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
    When
        Click on "click me" button
    Then
        Verify that "Event Triggered"
     */
    @Test
    public void test(){
//       Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");
//        Click on "click me" button
        waitFor(4); //TestBase'deki kullandıgımız "implicitlyWait" buttona tıklamada yeterli olmayınca ,yine TestBase'deki HARD WAIT olarak yaptıgımız methodu kullandık.
        driver.findElement(By.id("growbutton")).click();

//        Verify that "Event Triggered"
       String event= driver.findElement(By.id("growbuttonstatus")).getText();
       assertEquals("Event Triggered",event);
    }
}
