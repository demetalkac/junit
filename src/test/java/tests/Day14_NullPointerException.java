package tests;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class Day14_NullPointerException extends TestBase {
    //    DECLARED BUT NEVER INSTANTIALTED-BİLDİRİLDİ AMA HİÇ BAŞLATILMADI
    WebDriver driver;
    Faker faker; // Faker faker = new Facer(); seklinde olması gerekiyordu
    @Test
    public void nullPointerTest(){
        driver.get("https://techproeducation.com/");//java.lang.NullPointerException
    }
    @Test
    public void nullPointerTest1(){
        System.out.println(faker.name().fullName());//NullPointerException
    }
}
 /*
 Degiskenleri olusturup instantiate etmedigimizde (yani "new" ile tamamlamadıysam) alırız.
 ornegin;  WebDriver driver; deyip =new ChromeDriver() demez isek null pointer exception alırız.

 WebDriver driver; seleniumdan gelir.Ama "NullPointerException" exceptionu java'dan gelir.

 cozüm: Degiskeni instantiate et
  */