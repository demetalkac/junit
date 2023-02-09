package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day09_Actions4 extends TestBase {
    /*
    Create a class: Action4
    Create a method dragAndDropTest
    Given user is on https://jqueryui.com/droppable/
    And user moves the target element(Drag me to my target) in to destination(Drop here)
    (Ve kullanıcı hedef elemanı (beni hedefime sürükle) hedef(buraya bırakın))
     */
    @Test
    public void dragAndDropTest(){
        driver.get("https://jqueryui.com/droppable/");
//        And user moves the target element(Drag me to my target) in to destination(Drop here)

//        Below elements are in the iframes so switch to iframe first-Aşağıdaki öğeler iframe'lerdedir, bu nedenle önce iframe'e geçin
      driver.switchTo().frame(0);//switching to the first iframe

        WebElement sourch = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

//        user Actions class to move source into target--kaynağı hedefe taşımak için kullanıcı Actions sınıfı
       Actions actions = new Actions(driver);
       actions.dragAndDrop(sourch,target).perform();
// NOTE: dragAndDrop() methodu 2 parameter kullanılır,birincisini(source;kaynag)ı ikincisine(target;hedef)e tasır,yani surukleme islemi yapar.
    }
    /*
    When test fails:
    1. check locator
    2. wait issue or syncronization issue
    3. iframe --->>> THIS WAS THE ISSUE
     */

   @Test
   public void clickAndHoldTest() {
       driver.get("https://jqueryui.com/droppable/");
//      And user moves the target element(Drag me to my target) in to  destination(Drop here)

//        Below elements are in the iframes so switch to iframe first
       driver.switchTo().frame(0);//switching to the first iframe
       WebElement source = driver.findElement(By.id("draggable"));
       WebElement target = driver.findElement(By.id("droppable"));
//        user Actions class to move source into target
       Actions actions = new Actions(driver);
       actions
               .clickAndHold(source) //clickAndHold() methodu kaynagı tutar
               .moveToElement(target)//moveToElement() methodu hedefe koyar
               .release() //kaynagı(sourch)'ı "bırak" anlamındadır.
               .build()
               .perform();//holding the source and moving into the target

// NOTE1 : .build() :buildden onceki methodların iliskisini kur,guclendir anlamınd
// Note2 : perform(); islemi gerceklestir
// Note3 :  release() //kaynagı(sourch)'ı "bırak" anlamındadır.
   }
   @Test
    public void moveByOffsetTest(){
       driver.get("https://jqueryui.com/droppable/");
//      And user moves the target element(Drag me to my target) in to  destination(Drop here)

//        Below elements are in the iframes so switch to iframe first
       driver.switchTo().frame(0);//switching to the first iframe
       WebElement source = driver.findElement(By.id("draggable"));
       WebElement target = driver.findElement(By.id("droppable"));
//        user Actions class to move source into target
       Actions actions = new Actions(driver);
       actions.
               clickAndHold(source).
              moveByOffset(160,30).
              build().
              perform();
// moveByOffset() methodunun parametreleri koordinat vermemiz icin ise yarar,yanı elementi koymak istedigimiz yerin koordinatlarını yazarız parantezine.
   }

    @Test
    public void dragAndDropBy(){
        driver.get("https://jqueryui.com/droppable/");
//      And user moves the target element(Drag me to my target) in to  destination(Drop here)
//        Below elements are in the iframes so switch to iframe first
        driver.switchTo().frame(0);//switching to the first iframe
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
//        user Actions class to move source into target
        Actions actions = new Actions(driver);
        actions
                .dragAndDropBy(source,160,30)
                .perform();
    }

   }
