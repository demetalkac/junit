package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day09_FileDownloadTest extends TestBase {
    /*
    Dosya indirme testi:
      Create a class:FileDownloadTest
      downloadTest()
      In the downloadTest() method, do the following test:
      https://testcenter.techproeducation.com/index.php?page=file-download
      Download some-file.txt file
      Then verify if the file downloaded successfully
     */
    @Test
    public void downloadTest() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
//    Download junit-4.13-beta-3.jar file
        driver.findElement(By.partialLinkText("b10 all test cases")).click(); //downloading the file
        Thread.sleep(2000); //After click, it takes a few millisecond, so using hard wait. Burda explicitWait ve implicitlyWait kullanamayız, masaüstü ile ,ilgili bir durum cünkü.

//    Then verify if the file downloaded successfully
        String homeDirectory = System.getProperty("user.home");
//        String filePath = homeDirectory+"/Downloads/junit-4.13-beta-3.jar";//MAC
        String filePath = homeDirectory+"\\Downloads\\b10 all test cases, code.docx"; // WINDOWS -  Downloads:indirilenler
        boolean isDownloaded = Files.exists(Paths.get(filePath)); // "Files" ve "Paths" javadan import ediyoruz.
        Assert.assertTrue(isDownloaded);
    }

}
