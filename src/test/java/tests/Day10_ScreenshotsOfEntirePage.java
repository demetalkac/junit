package tests;


import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @Test
    public  void tamEkranScreenshotTest() throws IOException {
  //Techpro education a git ve Sayfanin goruntusunu al. -“QA” aramasi yap
  //Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: qa”
        driver.get("https://www.techproeducation.com");
 //1- Ekran goruntusunu getScreenshotAs() ile alıp File olarak olusturalm
 //   getScreenshotAs() methodu return "File"
 //  OutputType.FILE =>DOSYA TİPİdir. Dosyayı direk resim olarak alamıyoruz o nedenle "FILE" sectik burda.

   File goruntu = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  //Bununla screenshot ı aldık
//2- Almıs oldugum ekran goruntusunu belirledigim bir PATH e kaydet. dir=directory(dosya)
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); //currentDate olusturmamızın sebebi aldıgımız her ekran göruntusunu ayrı vakitlerde gösterdikki daha dinamik olsun kodumuz.
     String path = System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/"+currentDate+"image.png";
     File hedef = new File(path);
//3- goruntu ile dosyayı birlestirip kaydet
        FileUtils.copyFile(goruntu,hedef);

/*ALTERNATIF OLARAK TUM ADIMLARI TEK SEFERDE DEGISKEN KULLANMADAN YAZABILIRIZ:
  FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),
   new File(System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/image.png"));
*/
   //     -“QA” aramasi yap
   driver.findElement(By.id("searchHeaderInput")).sendKeys("QA"+ Keys.ENTER);
waitFor(3);
  String expected ="Search Results for: QA";
  String text = driver.findElement(By.xpath("//*contains(text(),'Search Rearch Results for')]")).getText();
  Assert.assertTrue(expected.contains(text));

        // Reusable method yardımıyla ekran goruntusu alma:
        takeScreenshotOfPage();

    }






}
/*
  Seleniumda tum ekran goruntusunasıl alınır?
  *Seleniumdan gelen "getScreenshotAs()" methodu ile alınır.
  * Seleniumdaki TakeScreenshot api'dan gelen "getScreenshotAs()" methodu kullanılır.
  * 2 farklı ekran goruntusu alınabilir:tum sayfa,ozel bir elementin screenshotı alınabiliyor.
       ikincisi Selenium 4 ile spesifik bir elemanın screenshot'ını alabiliyoruz.
 */