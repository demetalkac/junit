package practices.practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class QA02 extends TestBase {
/*
    Given
        Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    When
        Click on the "Animals and Nature" emoji
    And
        Click all the "Animals and Nature"  emoji elements
    And
        Fill the form
    And
        Press the apply button
    Then
        Verify "code" element is displayed
     */
    @Test
    public void test(){
    //Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        //First switch into iframe
        WebElement iFrame = driver.findElement(By.id("emoojis"));
       driver.switchTo().frame(iFrame);

        //Click on the "Animals and Nature" emoji
       driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]")).click();

        //Click all the "Animals and Nature"  emoji elements
        List<WebElement> allEmojis= driver.findElements(By.xpath("//div[@id='nature']/div/img")); //butun hayvan empjilerini almak icin "findElements()" kullandık.Normalde id 1tane ama "/div/img" ile butun emojilerin xpath'ini almıs oldık

//        for (WebElement w : allEmojis){
//            w.click();
//        }


        //Using lambda is recommended
        allEmojis.stream().forEach(WebElement::click);

        //Get out of the iFrame
        driver.switchTo().defaultContent();

        //Fill the form-formu doldur
        List<WebElement> allInputs = driver.findElements(By.xpath("input"));
        List<String> allWords = new ArrayList<>(Arrays.asList("This","iFrame","example","looks","very","funny","does", "not", "it","?","?"));

        for(int i = 0; i<allInputs.size(); i++){
            allInputs.get(i).sendKeys(allWords.get(i));
        }


        //Click the apply button
        driver.findElement(By.id("send")).click();

        //Verify "code" element is displayed
        WebElement code = driver.findElement(By.id("code"));
        assertTrue(code.isDisplayed());

    }
}
