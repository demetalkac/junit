package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class Day13_JSExecutor extends TestBase {
    /*
    Not:Javascript Executer'i web elelemntlerinin kontrollerini saglarken selenium komutları yetersiz kaldıgında kullanılır.
    (click, belirli bir elemente scroll yapma,type,input^daki degerleri okuma...)
    -Javascript HTML kodlarına direk erisip yönetebilen bir script dili oldugundan bize kolaylık saglar.

    When user goes to home page
    And scroll on the WE OFFER element
    And scroll on the search box element
    Given
        Go to https://techproeducation.com/"
    When
        Scroll into "WE OFFER"
    And
        Scroll into "LMS LOGIN"
    And
        Scroll into "WHY US"
    And
        Scroll back up to "Enroll Free"
    And
        Scroll all the way down
    And
        Scroll all the way up
    Then
        Take a screenshot of each step
     */

  @Test
  public void scrollIntoViewTest() throws IOException {
    driver.get("https://techproeducation.com/");
    waitFor(3);
//        1. create js executor object
    JavascriptExecutor js =(JavascriptExecutor)driver; //"JavascriptExecutor"ı "driver"a cast yaptık aralarındaki iliskiden dolayı(interfase)
//  JavascriptExecutor classı seleniumdan gelir.
//   executeScript() methodu   JavascriptExecutor classından gelir.
//   scrollIntoView(true) methodu belirli bir elemente scroll(kaydırmak) yapmak icin kullanilir.
//  arguments[0] parandezdeki indexe yazılana gore elementi verir "scrollIntoView(true)"dan sonra 2 parametre yazdıysak;
//  "arguments[0]" ilkini verir,"arguments[1]" ise ikincisini verir  , fakat genelde"0" yazılır cunku bir element bulmada
//  kullanılır. Baska bulmak istedigimiz element icin tekrardan "js.executeScript(...) olusturuyoruz.Bunun icinde reusable methot olusturup onu kullnmak daha mantıklı.
//        2. execute the command
    waitFor(3);
//        scrolling "We Offer" element
    js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[.='we offer']")));
    takeScreenshotOfPage();
    waitFor(3);
//        scrolling "LMS LOGIN" element
    js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//span[.=' Enroll Free ']")));
    takeScreenshotOfPage();

    waitFor(3);
// **       scrolling "WHY US" element ->burda olusturdugumuz useble methodu kullandık:"scrollIntoViewJS()"
    scrollIntoViewJS(driver.findElement(By.xpath("//h3[.='WHY US?']")));
    takeScreenshotOfPage();
    waitFor(3);
//        scrolling back up to enroll free
    scrollIntoViewJS(driver.findElement(By.xpath("//span[.=' Enroll Free ']")));
    takeScreenshotOfPage();


//**        scroll all the way down(sayfanın en ustune cıkma)
    scrollAllDownByJS();
    waitFor(3);
    takeScreenshotOfPage();

// **       scroll all the way up(sayfanın en altına inme)
    scrollAllUpByJS();
    waitFor(3);
    takeScreenshotOfPage();


  }
//=======================================================================================
   /*
  -clickByJSTest() i olustur.
  -techpro education ana sayfasına git
  -"LMS LOGIN" elementine tıkla(click)
  -cıkan sayfanın URL'sinin  "https://techproeducation.com/" oldugunu test et
   */
  @Test
  public void clickByJSTest(){
//  techpro education ana sayfasına git
    driver.get("https://techproeducation.com/");
//        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
//        clickByJS(lmsLogin);
//    "LMS LOGIN" elementine tıkla(click)
    clickByJS(driver.findElement(By.linkText("LMS LOGIN")));
    waitFor(3);
//   cıkan sayfanın URL'sinin  "https://techproeducation.com/" oldugunu test et
    Assert.assertEquals("https://lms.techproeducation.com/",driver.getCurrentUrl());
  }

  @Test
  public void clickByJSTest2(){
    //gunduz dersinden bu test
    //Go to http://www.uitestpractice.com/Students/Form
    driver.get("http://www.uitestpractice.com/Students/Form");

    //Click on "submit" button
   // driver.findElement(By.xpath("//button[.='Submit']")).click(); bu calıstı ama clıck calısmasaydı,asagıdakini kullanabilirdik(clickByJS)yani JS click
    clickByJS(driver.findElement(By.xpath("//button[.='Submit']")));



  }

  /*
   -selenıumdaki sendKeys() yerine JS kullanınca
   -web elementlerin html kodlarında bazı kutulara data gondermek icin; <input...value> input tagli bir yapı olur
   bu value'ya value="QA" yazsak onu kutuda gorebiliriz, aynı sendKeys() methodu ile value gondermek gibi.Fakat sayfanın
   HTML yapısını degistirir
   -JS'da "set atribute" diye bir fonksiyon var,bunu developerlar kullanır, HTML'deki degerleri degistirmek icin
     kullanırlar.Bunu kullanarak "input" icindeki; name, class,type.. gibi atributelerin degerlerini degistirebilir
   */
  @Test
  public void typeInTheInputTest(){
    //Go to https://techproeducation.com/
    driver.get("https://techproeducation.com/");

    //Type "QA" into search box
    setValueByJS(driver.findElement(By.xpath("//input[@type='search']")), "QA");
  }

  @Test
  public void getValueOfInputTest(){
    //selenıumdaki getText() yerine JS kullanınca
    driver.get("https://www.priceline.com/");
    getValueByJS("hotelDates");

  }


 /*
  Normal text'leri(metinleri)ni "getText()" methodu ile alabiliriz. Fakat kutular icinde yer alan value(degerler)i
  alamayız. Bunlar icin JS kullanarak html codundaki valuenun degerini alabiliriz.
  -web elementlerin html kodlarında bazı kutulardan data almak icin; <input...value> input tagli bir yapı olur, JS
  burdaki yazıları html kodlarını kullanarak alaır.
  */
  /*
  1-"getValueByJSTest()" methodu olustur
  2-Go to https://www.carettahotel.com/
  3-Get the value of "CHECK-IN DATE" (tarih kısmındaki yazılı metinleri al ve yazdır)
   */
  @Test
  public void getValueByJSTest(){
    //gunduz dersinden bu test
    //Go to https://www.carettahotel.com/
    driver.get("https://www.carettahotel.com/");
    driver.findElement(By.id("details-button")).click();
    driver.findElement(By.id("proceed-link")).click();//We did use these two because of security issue

    //Get the value of "CHECK-IN DATE"(tarih kısmındaki yazılı metinleri al ve yazdır)
//   System.out.println("Selenium getText(): "+driver.findElement(By.id("checkin_date")).getText());//It does not take the default value of web element by using selenium getText()
//  Yani  "getText()" ile value'yu konsola yazdıramadık,degeri alamadık.
    getValueByJS("checkin_date");

  }


  @Test
  public void colorByJSTest(){
    driver.get("https://www.priceline.com/");
    changeBackgroundColorByJS(driver.findElement(By.xpath("//button[@data-testid='HOTELS_SUBMIT_BUTTON']")),"red");
    addBorderWithJS(driver.findElement(By.xpath("//button[@data-testid='HOTELS_SUBMIT_BUTTON']")),"5px solid green");
  }

  @Test
  public void changeBackgroundColorAndBorderByJs(){
    //gunduz dersinden bu test
    //Go to https://www.carettahotel.com/
    driver.get("https://www.carettahotel.com/");
    driver.findElement(By.id("details-button")).click();
    driver.findElement(By.id("proceed-link")).click();//We did use these two because of security issue

    //Change the color of "Check Availability"
    WebElement checkAvailability = driver.findElement(By.xpath("//input[@type='submit']"));
    changeBackgroundColorByJS(checkAvailability,"red");



  }

}
