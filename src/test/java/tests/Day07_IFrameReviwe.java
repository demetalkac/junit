package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day07_IFrameReviwe extends TestBase {
    @Test
    public void iFrameTest(){
//        Go to https://the-internet.herokuapp.com/iframe
       driver.get("https://the-internet.herokuapp.com/iframe");
//        Verify the Bolded text contains “Editor”
        String title=driver.findElement(By.xpath("//h3")).getText();
         Assert.assertTrue(title.contains("Editor"));
//        Locate the text box
        driver.switchTo().frame(0);
      WebElement box= driver.findElement(By.xpath("//p"));
//        Delete the text in the text box
        box.clear();
//        Type “This text box is inside the iframe”-"Bu metin kutusu iframe'in içindedir" yazın
        box.sendKeys("This text box is inside the iframe");
//        Verify the text Elemental Selenium text is displayed on the page-Elemental Selenium metninin sayfada görüntülendiğini doğrulayın
        driver.switchTo().parentFrame();
        Assert.assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());
    }
}
