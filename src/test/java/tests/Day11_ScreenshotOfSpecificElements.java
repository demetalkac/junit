package tests;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Day11_ScreenshotOfSpecificElements extends TestBase {

    /*
        Given
            Go to https://www.techproeducation.com
        Then
            Assert the logo is displayed
        And
            Take screenshot  of logo
        And
            Take screenshot of social media icons
         */
    @Test
    public void screenshotTest() throws IOException {
        driver.get("https://www.techproeducation.com");
        WebElement techProEdLogo = driver.findElement(By.xpath("//div[@data-id='898ce2e']"));
        //verifying the logo
        Assert.assertTrue(techProEdLogo.isDisplayed());
        //getting the screenshot using reusable method
        takeScreenshotOfTheElement(techProEdLogo);

//        taking screenshot of social media icons
        WebElement socials = driver.findElement(By.xpath("//div[@data-id='d7545f2']"));
        takeScreenshotOfTheElement(socials);
//takeScreenshotOfTheElement(driver.findElement(By.xpath("//div[@data-id='d7545f2']")))-->boylede yapabiliriz.

    }



}
