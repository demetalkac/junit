package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day14_StaleElementException extends TestBase {
    @Test
    public void staleException1(){
        driver.get("https://techproeducation.com/");
//        location lmsLgin
        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
//        clicking lmsLogin
        lmsLogin.click();
        waitFor(5);
//        going back to home page
        driver.navigate().back();
        waitFor(5);
//        clicking lmsLogin

//        FAILED cause lmsLogin is no longer fresh. It is OLD. It is STALE-çünkü lmsLogin artık güncel değil. Bu eski, STALE
        lmsLogin.click();//org.openqa.selenium.StaleElementReferenceException:

//        SOLUTION : RELOCATE THE ELEMENT
//        driver.findElement(By.linkText("LMS LOGIN")).click();
        /*
        stale:tarihi gecmis,eskimis anlamı var.
        Stale Element;element eski,kullanılamaz durumda,kullanım artık elverisli degil.
        -sayfayı yeniledigimizde(refresh)
        Sayfada ileri geri gittigimizde bu exception ile karsılasırız.
        Cozum:SAYFAYI YENİLEDİK VEYA İLER-GERİ YAPTIKTAN SONRA TEKRAR elementi  BULMAMIZ GEREİR
         */

    }

    @Test
    public void staleException2() {    //bu testte sayfaya git->elemanı bul->sayfayı refresh yap->sonra lmsLogin'e clic yap
        driver.get("https://techproeducation.com/");
        waitFor(5);
        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);
        driver.navigate().refresh();
        waitFor(5);
        lmsLogin.click();       //org.openqa.selenium.StaleElementReferenceException
        //problemi cozmek icin elementi tekrar locate et:
        //  driver.findElement(By.linkText("LMS LOGIN")).click();

    }

}
