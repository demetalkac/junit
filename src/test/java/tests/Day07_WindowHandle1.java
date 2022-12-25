package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class Day07_WindowHandle1 extends TestBase {
    /*
   //        Create a new Class Tests package: WindowHandleExample
//        Method name:windowHandle
//        Given user is on the https://the-internet.herokuapp.com/windows
//        Then user verifies the text : “Opening a new window”
//        Then user verifies the title of the page is “The Internet”
//        When user clicks on the “Click Here” button
//        Then user verifies the new window title is “New Window”
//        Then user verifies the text:  “New Window”
//        When user goes back to the previous window and then verifies the title : “The Internet”
     */

    @Test
    public  void windowHandleTest() throws InterruptedException {

//        Given user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows ");

//        Then user verifies the text : “Opening a new window”
        String window1Text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",window1Text);

//        Then user verifies the title of the page is “The Internet”
        Assert.assertEquals("The Internet", driver.getTitle());

//        GETTING THE WINDOW 1 HANDLE(UNIQUE PAGE ID)
        String window1Handle = driver.getWindowHandle(); //RETURNS THE CURRENT WINDOW ID
        System.out.println(window1Handle);

//        When user clicks on the “Click Here” button
        driver.findElement(By.linkText("Click Here")).click();



//        WE DO TESTING IN A NEW WINDOW, SO WE MUST SWITCH TO THAT WINDOW-YENİ BİR PENCEREDE TEST YAPIYORUZ, O PENCEREYE GEÇMELİYİZ
//        AS OF NOW 2 WINDOWS OPEN. USE getWindowHandles() TO GET BOTH IDs-ŞU ANDA 2 PENCERE AÇIKTIR. HER İKİ KİMLİK ALMAK İÇİN getWindowHandles() KULLANIN
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles);
        for (String eachHandle : allWindowHandles){//looping through the windows-pencereler arasında döngü
            if (!eachHandle.equals(window1Handle)){//if we are not in windows 1 (means windows 2)-Windows 1'de değilsek (Windows 2 anlamına gelir)
                driver.switchTo().window(eachHandle);//then switch the window 2--sonra pencere 2'ye değiştir
            }
        }
//        AT THIS POINT DRIVER IS SWITCHED TO WINDOWS 2-BU NOKTADA SÜRÜCÜ WINDOWS 2'YE GEÇTİRİLMİŞTİR

        String window2Handle = driver.getWindowHandle();// WINDOW 2 ID.
//        Then user verifies the text:  “New Window”

//        Then user verifies the new window title is “New Window”
        Assert.assertEquals("New Window",driver.getTitle());

        String window2Text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("New Window",window2Text);
        Thread.sleep(5000);
//        When user goes back to the previous window and then verifies the title : “The Internet”
        driver.switchTo().window(window1Handle);//switches window 1
//        Then user verifies the title of the page is “The Internet”
        Assert.assertEquals("The Internet", driver.getTitle());
        Thread.sleep(5000);
//        Switch back to window 2
        driver.switchTo().window(window2Handle);
        Thread.sleep(5000);
//        Switch back to window 1
        driver.switchTo().window(window1Handle);
        Thread.sleep(5000);
        //        Switch back to window 2
        driver.switchTo().window(window2Handle);
        Thread.sleep(5000);
//        Switch back to window 1
        driver.switchTo().window(window1Handle);

    }
}
