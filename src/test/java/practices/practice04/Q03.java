package practices.practice04;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class Q03 extends TestBase {
      /*
    Given
        Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
    When
        Click all the buttons
    Then
        Assert all buttons clicked
     */

    @Test
    public void test() {
//        Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

//        Click all the buttons
        driver.findElement(By.id("onblur")).click();
        waitFor(2);
        driver.findElement(By.id("onclick")).click();//This is for clicking on "on Blur" button
        waitFor(2);
        driver.findElement(By.id("onclick")).click();//This is for clicking on "on Click" button

        WebElement oncontextmenu = driver.findElement(By.id("oncontextmenu")); //sag'a tıklayınca oluyor
        WebElement ondoubleclick = driver.findElement(By.id("ondoubleclick"));
        WebElement onfocus = driver.findElement(By.id("onfocus"));
        WebElement onkeydown = driver.findElement(By.id("onkeydown")); //üstüne tıkla entera bas:onkeydown,onkeyup,onkeyup
        WebElement onkeyup = driver.findElement(By.id("onkeyup"));  //onkeydown,onkeyup ikisi birlikte calısıyor normalde
        WebElement onkeypress = driver.findElement(By.id("onkeypress"));
        WebElement onmouseover = driver.findElement(By.id("onmouseover"));
        WebElement onmouseleave = driver.findElement(By.id("onmouseleave"));
        WebElement onmousedown = driver.findElement(By.id("onmousedown"));

        Actions actions = new Actions(driver);

        waitFor(1);
        actions.contextClick(oncontextmenu).perform(); //contextClick() sag'a tıklama methodu
        waitFor(1);
        actions.doubleClick(ondoubleclick).perform();  //doubleClick() 2 kere tıklama methodu
        waitFor(1);
        actions.click(onfocus).perform();
        waitFor(1);
        actions.click(onkeydown).sendKeys(Keys.ENTER).perform();
        waitFor(1);
        actions.click(onkeyup).sendKeys(Keys.ENTER).perform();
        waitFor(1);
        actions.click(onkeypress).sendKeys(Keys.ENTER).perform();
        waitFor(1);
        actions.moveToElement(onmouseover).perform(); //moveToElement() methodu; mause ile üzerine gelince(basmayacagız mause'a)
        waitFor(1);
        actions.moveToElement(onmouseleave).perform();
        waitFor(1);
        actions.click(onmousedown).perform();//This one did not work because of previous leave action ,yani mause burda ve ayrılalı ki bu butona tıklayabilsin,onedenle bir tane daha tıkladık asafıda.
        waitFor(1);
        actions.click(onmousedown).perform();


//        Assert all buttons clicked
        int numberOfClickedButtons = driver.findElements(By.xpath("//p[.='Event Triggered']")).size();
        assertEquals(11, numberOfClickedButtons);


        //List<WebElement> allTexts = driver.findElements(By.xpath("//p[.='Event Triggered']"));
        //Assert.assertEquals(11, allTexts.size());

    }

}
