package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day07_IFrame extends TestBase {

    /*
    Create a class: IFrame
    Create a method: iframeTest
    Go to https://the-internet.herokuapp.com/iframe
    Verify the Bolded text contains “Editor”
    Locate the text box
    Delete the text in the text box
    Type “This text box is inside the iframe”-"Bu metin kutusu iframe'in içindedir" yazın
    Verify the text Elemental Selenium text is displayed on the page-Elemental Selenium metninin sayfada görüntülendiğini doğrulayın
     */
    @Test
    public void iframeTest(){
//        Go to https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");
//        Verify the Bolded text contains “Editor”
//Header is not in the iframe so do not switch to iframe-Başlık iframe'de değil, bu yüzden iframe'e geçmeyin
        String header = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(header.contains("Editor"));
//NOTE: textbox is in the iframe so we have to switch to teh iframe-metin kutusu iframe'de olduğundan iframe'e geçmemiz gerekiyor
//        GETTING IN THE IFRAME
//        THERE ARE 3 WAYS TO SWITCH TO AN IFRAME
        driver.switchTo().frame(0);// INDEX OF IFRAME. INDEX STARTS AT 0
//        driver.switchTo().frame("mce_0_ifr");// ID OR NAME OF IFRAME. PREFERRED ONE.
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));// WEBELEMENT OF IFRAME

//        Locate the text box -Metin kutusunu bulun
        WebElement box = driver.findElement(By.xpath("//p"));
//        Delete the text in the text box
        box.clear();//clear() is used to delete the text is the elements
//        Type “This text box is inside the iframe”
        box.sendKeys("This text box is inside the iframe");
//        SO FAR DRIVER IS IN THE IFRAME BUT Elemental Selenium text IS OUTSIDE OF THE FRAME
//        ŞİMDİYE KADAR DRIVER IFRAME İÇİNDE AMA "Elemental Selenium" metni ÇERÇEVE DIŞINDA(FRAME'IN DISINDA)
//        GETTING OUT OF THE FRAME
        driver.switchTo().parentFrame();
//        ALTERNATIVELY WE CAN USE defaultContent()
//        Verify the text Elemental Selenium text is displayed on the page
        Assert.assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());

    }
}
/*
    What might be the reason for your test case to fail?
  *There may be wait problem. The page may be very slow. Internet maybe not fast enough.
   -Put some more wait. We can use explicit wait in selenium(we will learn later)
  *Locator might be incorrect.
   -Double check locator and fix if needed
  *Data issue. Typo in our expected values.
   -If there is any documentation issue, we can talk to BA to fix the document and then we can use correct expected values
  *Maybe there is an iframe on the page
   -We first need to switch to the frame
  *Maybe there is an alert on the page
   -We first need to handle the alert by accepting or dismissing
  *Maybe the page opens in a new tab or window
   -We first need to switch the target window
  *It may be a real bug that is caused by the latest codes.
   -We discuss the issue with the team then raise a bug ticket if needed
 */