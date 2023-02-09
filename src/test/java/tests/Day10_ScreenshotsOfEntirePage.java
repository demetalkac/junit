package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;

public class Day10_ScreenshotsOfEntirePage extends TestBase {
    /*
    Given user search for ‘uni’
    And select United Kingdom
    Add click on submit button
    Then verify the result contains united Kingdom
     */
    @Test
    public void takeScreenShotTest() throws  InterruptedException {
//        Given user search for ‘uni’
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
//      TAKE A SCREENSHOT. CREATE A REUSABLE METHOD AND CALL THAT METHOD
        takeScreenshotOfPage();
//       COMPLETE AS HOMEWORK
//        And select United Kingdom
//        searchAndSelectFromList("uni","United Kingdom");
//        When user type “uni” in the search box
        driver.findElement(By.id("myCountry")).sendKeys("uni");
//       And select the ‘United Kingdom’ from the suggestions
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='United Kingdom']")).click();
//        TAKE SCREENSHOT
        Thread.sleep(2000);
        takeScreenshotOfPage();
//        Add click on submit button
        //    And click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();
//        TAKE SCREENSHOT
        Thread.sleep(2000);
        takeScreenshotOfPage();
//        Then verify the result contains united Kingdom
        //    Then verify the result contains ‘United Kingdom’
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("United Kingdom"));
//        TAKE SCREENSHOT
        Thread.sleep(2000);
        takeScreenshotOfPage();
    }

}
/*
  *Ekran goruntusu:
  * getScreenshotAs() methodu ile alınır. Bu method Seleniumdan gelir
  * getScreenshotAs() methodu TekaScreenshot api'ndan gelir
  * 2 farklı ekran goruntusu alınabilir:tum sayfa,ozel bir elementin screenshotı alınabiliyor.ikincisi selenium 4 den itibaren var

 */