package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_TitleVerification {
    public static void main(String[] args) {

        /*
               Verifying Page Title-Sayfa Başlığını Doğrulama
       1.Create a new class: VerifyTitleTest-Yeni bir sınıf oluşturun: TitleTest'i Doğrulayın
	   2.Navigate to techproeducation homepage-2.techpro eğitim ana sayfasına gidin
	   3.Verify if page title is “Techpro Education | Online It Courses & Bootcamps”
	     Google başlığının “Techpro Education | Çevrimiçi BT Kursları ve Eğitim Kampları”

         */

        //System.setProperty("webdriver.chrome.driver", "./src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techproeducation.com");

        //get the title
        String actualTitle = driver.getTitle();
        String expectedTitle ="Techpro Education | Online It Courses & Bootcamps";

     //Verify if page title is "Techpro Education | Online It Courses & Bootcamps"
        if (actualTitle.equals(expectedTitle)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("ACTUAL TITLE :" +actualTitle);
            System.out.println("BUT EXPECTED TITLE :"+expectedTitle);
        }

        driver.quit();


/*
Manual testing to verify page title:
go to title --> right click--> inspect --> scroll down--> find <title> --> take screenshot
 */





    }

}
