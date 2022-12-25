package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_URLVerification {
    public static void main(String[] args) {

        /*
             VERIFYING PAGE URL-SAYFA URL'SİNİ DOĞRULAMAK
        1.Create a new class: VerifyURLTest-Yeni bir sınıf oluşturun: URL Testini Doğrulayın
	    2.Navigate to TechProEducation homepage-echPro Education ana sayfasına gidin
	    3.Verify if google homepage url is “https://techproeducation.com/”
	      Google ana sayfa url'sinin "https://techproeducation.com/" olduğunu doğrulayın
         */
        System.setProperty("webdriver.chrome.driver", "./src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techproeducation.com");


        //Verify if homepage url is “https://techproeducation.com/”
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://techproeducation.com/";
        if (actualURL.equals(expectedURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("ACTUAL URL : "+actualURL);
            System.out.println("BUT EXPECTED URL : "+expectedURL);
        }
        driver.quit();

         /*
                   WHAT IS YOUR APPROACH FOR AUTOMATION?
        -I read the acceptance criteria carefully.
        -I then create my test cases
        -Then I do my manual testing FIRST
         -If all good, then I start complete my automation script
         -If I find a bug/defect, then I talk to dev. Dev fixes the issue, then I retest.
         If all is good then complete my automation script
        -When the automation is complete, I prepare the report for the user story. In fact, My automation script
        generates html reports for us. I upload those reports to the JIRA.
        -For my manual test cases, I manually take screenshots and prepare reports and attach them to the JIRA.

                    OTOMASYONA YAKLAŞIMINIZ NEDİR?
         -Kabul kriterlerini dikkatlice okudum.
         -Daha sonra test senaryolarımı oluşturuyorum
         -Sonra İLK manuel testimi yaparım
          -Her şey yolundaysa, otomasyon betiğimi tamamlamaya başlarım
          -Eğer bir bug/kusur bulursam dev ile konuşurum. Dev sorunu düzeltir, ardından yeniden test ederim.
          Her şey yolundaysa otomasyon betiğimi tamamla
         -Otomasyon tamamlandığında kullanıcı hikayesi için rapor hazırlarım. Aslında, Otomasyon betiğim
         bizim için html raporları oluşturur. Bu raporları JIRA'ya yüklüyorum.
         -Manuel test durumlarım için manuel olarak ekran görüntüsü alıp raporlar hazırlayıp JIRA'ya ekliyorum.


       -------------------------------------------------
    WHAT DO WE DO WHEN OUR TEST CASE PASS ?    TESTİNİZ GEÇTİKTEN SONRA NE YAPIYORUZ?
    - Prepare report and upload to JIRA        Rapor hazırlayın ve JIRA'ya yükleyin
--------------------------------------------------
    WHAT DO YOU DO WHEN YOUR TEST CASE FAILS?
    -Retest to make sure from the failure.It can be data issue, typo, documentation issue or is can be a real bug.
    -If that is a bug, then talk to the dev and let them fix the bug.
    -After the fix, we retest. when test cases passes we upload to JIRA
               TEST DURUMUNUZ BAŞARISIZ OLDUĞUNDA NE YAPARSINIZ?
    - Hatadan emin olmak için yeniden test edin. Veri sorunu, yazım hatası, dokümantasyon sorunu veya gerçek bir hata olabilir.
    -Eğer bu bir bug ise geliştirici ile konuşun ve hatayı düzeltmelerine izin verin.
    -Düzeltmeden sonra tekrar test ediyoruz. test senaryoları geçtiğinde JIRA'ya yükleriz
------------------------------------------------
    WHAT DO YOU DO WHEN YOU FIND A BUG ?
    -Retest to make sure from the failure.It can be data issue, typo, documentation issue or is can be a real bug.
    -If that is a bug, then talk to the dev and let them fix the bug.
    -After the fix, we retest. when test cases passes we upload to JIRA
                   BİR HATA BULDUĞUNDA NE YAPARSINIZ?
     - Hatadan emin olmak için yeniden test edin. Veri sorunu, yazım hatası, dokümantasyon sorunu veya gerçek bir hata olabilir.
     -Eğer bu bir bug ise geliştirici ile konuşun ve hatayı düzeltmelerine izin verin.
     -Düzeltmeden sonra tekrar test ediyoruz. test senaryoları geçtiğinde JIRA'ya yükleriz

------------------------------------------------


        */





    }
}
