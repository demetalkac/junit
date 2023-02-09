package homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class Jqueryui extends TestBase {
    @Test
    public void test1() {
 /*
  When user goes to https://jqueryui.com/accordion/
And user clicks on Section2 accordion
Verify the text contains “Sed non urna.”
  */
        //  When user goes to https://jqueryui.com/accordion/
        driver.get("https://jqueryui.com/accordion/");

        //And user clicks on Section2 accordion
        driver.switchTo().frame(0);

        driver.findElement(By.id("ui-id-3")).click();
        //Verify the text contains “Sed non urna.”
       String texst= driver.findElement(By.id("ui-id-4")).getText();
       waitFor(2);
        assertTrue(texst.contains("Sed non urna."));
    }
    @Test  //HOCANUN COZ
    public void accordion() throws InterruptedException {
        driver.get("https://jqueryui.com/accordion/");
//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
//        We need to use Actions class to drag and drop


//        Elements are inside the iframe, so switch first
        driver.switchTo().frame(0);

        WebElement section2 = driver.findElement(By.id("ui-id-3"));


        Actions actions = new Actions(driver);
        actions.click(section2).perform();

//        Thread.sleep(1);
        String text = driver.findElement(By.xpath("//p[contains(text(),'Sed non urna.')]")).getText();
        System.out.println(text);

    }

    @Test
    public void test2(){
  /*
   When user goes to https://jqueryui.com/datepicker/
And select the next date of the current date
EG if today is August 30, 2022 -> select August 31, 2022
   */
 // When user goes to https://jqueryui.com/datepicker/
        driver.get("https://jqueryui.com/datepicker/");
        //And select the next date of the current date
        driver.switchTo().frame(0);
//        driver.findElement(By.id("datepicker")).sendKeys("09/10/2023");

        WebElement date=  driver.findElement(By.id("datepicker"));
      date.isSelected();
      date.sendKeys("01/06/2023");

        //EG if today is August 30, 2022 -> select August 31, 2022

    }


    @Test
    public void test3(){
  /*
   When user goes to https://jqueryui.com/toggle/
Print the text that should be : Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
Eg: System.out.println(element); -> Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
Then click on Run Effect button
Then print the text and verify it is empty.
Eg: System.out.println(element); -> NO TEXT
Then click on Run Effect button one more time
Print the text that should be : Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
Eg: System.out.println(element); -> Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
You can use hard wait if needed.
   */
//     When user goes to https://jqueryui.com/toggle/
        driver.get("https://jqueryui.com/toggle/");
        driver.switchTo().frame(0);
//Print the text that should be : Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
   String metin=  driver.findElement(By.xpath("//div[@class='toggler']")).getText();
        System.out.println("metin = " + metin);
//Eg: System.out.println(element); -> Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
//Then click on Run Effect button
        waitFor(2);
        driver.findElement(By.id("button")).click();
//Then print the text and verify it is empty.
        waitFor(2);
        String metin2=  driver.findElement(By.xpath("//div[@class='toggler']")).getText();
        System.out.println("NO TEXT = " + metin2);
        waitFor(2);
        Assert.assertTrue("NO TEXT",metin2.isEmpty());
//Eg: System.out.println(element); -> NO TEXT
//Then click on Run Effect button one more time
        waitFor(2);
        driver.findElement(By.id("button")).click();
//Print the text that should be : Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
//Eg: System.out.println(element); -> Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
//You can use hard wait if needed.
        String metin3=  driver.findElement(By.xpath("//div[@class='toggler']")).getText();
        System.out.println("metin3 = " + metin3);

    }

    @Test  //HOCANIN COZUMU
    public void effectsTest() throws InterruptedException {
        driver.get("https://jqueryui.com/toggle/");
        driver.switchTo().frame(0);
        String before = driver.findElement(By.xpath("//div[@id='effect']//p")).getText();
        System.out.println("Before : "+before);
        driver.findElement(By.xpath("//button[@id='button']")).click();

        Thread.sleep(2000);
        String after = driver.findElement(By.xpath("//div[@id='effect']//p")).getText();
        System.out.println("After : "+after);

        driver.findElement(By.xpath("//button[@id='button']")).click();
        Thread.sleep(2000);
        String after1 = driver.findElement(By.xpath("//div[@id='effect']//p")).getText();
        System.out.println("After1 : "+after1);



    }

    @Test
    public void test4(){
    /*
      When user goes to https://jqueryui.com/autocomplete/

And type "Apple"
Then select Applescript
     */
        driver.get("https://jqueryui.com/autocomplete/");
        driver.switchTo().frame(0);
        driver.findElement(By.id("tags")).sendKeys("Apple");
        driver.findElement(By.xpath("//div[@class='ui-menu-item-wrapper']")).click();
     //  WebElement apple= driver.findElement(By.xpath("//div[@class='ui-menu-item-wrapper']"));
     //   Select select=new Select(apple);
      //  select.selectByIndex(0);

    }
}
