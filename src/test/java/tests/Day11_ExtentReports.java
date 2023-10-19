package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Day11_ExtentReports extends TestBase {
    /*
    //      Create Report Path
        //      Create HTML report in the path
        //      create extent reports object for generating the Entire reports with configuration
        //      Add custom System Info
        //      Add more custom info
        //      Done With Configuration
        //      Create extent test
        //      Use reports
        //      Generate the report
     */
 // Hatırlamamız gereken 3 class
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest; // "extentTest" yerine "logger" kelimesi de kullanılabiliyor bazen
    @BeforeClass
    public static void extentReportsSetUp() {
        //      REPORT  PATH
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/reports/" + currentTime + "html_report.html";
//        creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);
//        creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports(); //bu objeckti kullanarak sirketle ilgili bilgileri giriyoruz.
//        ***************
//  ****   raporu customize etme:
//        adding custom System Info -- sirkete ait ve sirkete göre eklenmesi istenen bilgileri burda koyabiliyoruz.
        extentReports.setSystemInfo("Test Environment", "Regression"); //setSystemInfo() bu method key-value gibi bilgi girebiliriz
        extentReports.setSystemInfo("Application", "TechProEd");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Team", "Eagles");
        extentReports.setSystemInfo("SQA", "John Fox");
        extentReports.setSystemInfo("Sprint Number","SP205");

// *** adding more custom config info -- extra ropor ismi ve dokuman ismi icin kullanıyoruz:extentHtmlReporter.config().
        extentHtmlReporter.config().setReportName("TechProEd home page");
        extentHtmlReporter.config().setDocumentTitle("TechProEd extent reports");
//        ********************ustte rapor ayarları vardı ve bitti******************
//        DONE WITH CONFIGURATION (attach Reporter) - raporu projeme ekliyorum:
        extentReports.attachReporter(extentHtmlReporter);
//      SUMMARY: Extent Reports and Extent HTML Reporter is used to add custom information on the report and create the report in a PATH

//        REPORT IS DONE. NOW CREATING EXTENT TEST TO LOG INFO IN THE TEST CASE
//        Creating extent - test objesi olustur
//               createTest()'in icine;       test ismini yazmak zorunlu   ,  acıklama(description) yazmak zorunlu degil
        extentTest = extentReports.createTest("My Extent Reporter", "Regression Test Report");

    }

    @Test
    public void extentReportsTest(){

            driver.get("https://www.techproeducation.com");
            extentTest.pass("User is on TechPro Education Home page");
//        click on LMS
            driver.findElement(By.linkText("LMS LOGIN")).click();
            extentTest.pass("User is on LMS home page");
//        verify the URL
            String expectedURL ="https://lms.techproeducation.com/";
            String actualURL=driver.getCurrentUrl();
            extentTest.pass("Asserting the LMS URL");
            Assert.assertEquals("LMS LOGIN PAGE IS NOT DISPLAYED",expectedURL,actualURL);
            extentTest.pass("TEST IS COMPLETE");
        }
/*
yukardaki testi bu sekildede kullanabiliriz.
 public void extentReportsTest(){
   extentTest.pass("Going to the App home page");
        driver.get("https://www.techproeducation.com");

//        click on LMS
        extentTest.pass("Clicking on LMS Login button");
        driver.findElement(By.linkText("LMS LOGIN")).click();
//        verify the URL
        extentTest.pass("Verify the LMS URL");
        String expectedURL ="https://lms.techproeducation.com/";
        String actualURL=driver.getCurrentUrl();
        Assert.assertEquals("LMS LOGIN PAGE IS NOT DISPLAYED",expectedURL,actualURL);
        extentTest.pass("TEST IS COMPLETE");
    }
 */
@Test
public void extentReportsTest2(){
  // genelde  extentTest."pass" ve "info" kullanılır, raporlamalarda.
//        pass is used to mark the step as PASSED
    extentTest.pass("PASS");
//        info is used to just give an information for that step. ınfo bilgilendirme mesajı vermek icin kullanılır
    extentTest.info("INFO");
//        fail is used to mark the step as FAILED
    extentTest.fail("FAILED");
//        skip is used to mark the step as SKIPPED
    extentTest.skip("SKIPPED");
//        warning is used to give working information. Warning uyarı demek
    extentTest.warning("WARNING");
}

    @AfterClass
    public static void extentReportsTearDown(){
//        generating the report
        extentReports.flush(); //kullanılması zorunludur.Raporun gözükmesi icin(test-output) ve kapatılması icin kullanılır.
    }

}
//NOTE: Raporu nasıl acıyoruz? *Raporu nasıl acıyoruz: intellj de solda test-output altındaki reports içindeki gelen raporun üstüne gel  mause sag click->Open in ->Brawser ->Chrome
//*WINDOWS'ta rapor klasörüne gitmek: Raporu nasıl acıyoruz: intellj de solda test-output altındaki reports içindeki gelen raporun üstüne gel  mause sag click-> Open in ->Explorer
/*
   EXTENT REPORTS:
   ayrı bir API'dir.Selenıum dısında da kullanılabilir
   Otomasyon raporları almak icin kullanılır
   Onemli 3 class var:
     -ExtentReports ->sablom olusturmada kullanılır
     -ExtentHtmlReporter ->sablonu projeye ekler
     -ExtentTest -> raporlama islemini yapar.Logları rapora yazar.

 NOT: Raporları jıraya yukleyebiliriz. Veya menager ile takım arkadasları ile paylasılabilir.Bu raporları mail ile veya
  baska  bir sekilde baskasına gonderdiysek veya aldıysak, dosyayı once bilgisayara indirip sonra browser(chrome) ile
  acmalıyız. Yoksa html kodları gibi gorunur.
 */