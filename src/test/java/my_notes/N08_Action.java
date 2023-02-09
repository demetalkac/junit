package my_notes;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class N08_Action extends N_TestBase{
    /*
    Create a method keyboardActions
    Google a gidin https://www.google.com
    "iPhone X fiyatlari" yazdır (SHIFT TUSUNA BASILARAK)
    "Cok pahalı!" yazdır (shift tusuna basılmayarak)
    ve "enter" tuduna bas
     */
    @Test
    public void keyboardActions(){

//  Google a gidin https://www.google.com
        driver.get("https://www.google.com");
//    "iPhone X fiyatlari" yazdır (SHIFT TUSUNA BASILARAK)
//    "Cok pahalı!" yazdır (shift tusuna basılmayarak)
//    ve "enter" tuduna bas

        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@class='gLFyf']"));
    //   aramaKutusu.sendKeys("iPhone X fiyatlari" + Keys.ENTER); //bununla biz hangi sekilde yazdıysak oyle gonderir ve enter a basar(kucuk harf ise kucuk harf, buyuk harf ile yazdıysak buyuk harf olarak gonderir)Actions'suz buda calısır
        Actions actions = new Actions(driver);
        actions.
                keyDown(aramaKutusu,Keys.SHIFT)  //arama kutusunun ustunde Shift tusuna bas
                .sendKeys("iPhone X fiyatlari")  //shift e basılı iken yazı yaz
                .keyUp(aramaKutusu,Keys.SHIFT)   //shift de artık basma
                .sendKeys("Cok pahalı!"+Keys.ENTER)  //normal halde yaz ve ENTER tusuna bas
                .perform();
   // google arama yerine bu sekilde yazdırdı: "IPHONE X FIYATLARI cok pahalı!"
   //yani shift tusuna basılı olarak yazınca yazı buyuk harfler ile yazılıyor. Shift'e basılı tutmak icin  "keyDown()", Shift'en cekmek icin de  " keyUp()" methodlarını kullanıyoruz.



    }
}
/*
            SORULAR
            1- Actions nedir? Actions Class nedir?
            --Actions selenium'dan gelen bir kütüphanedir.Mouse ve Keyboard islemlerini gerceklestirmek icin kullandıgımız hazır bir selenium kutuphanesidir.
            Örnegin, sag tıklama(contextClick), cift tıklama(doubleClick), elementin uzerine gitmek(moveToElement), gibi mouse islemlerini gerceklestirebiliriz.
            Aynı zamanda, shift,control,delete,enter gibi keyboard tuslarınada actions yardımıyla basabiliriz.
            Bu tur islemlerde sentKeys() methodu kullanılır.

            2- Ne tür methodlar kullandın?
            Actions methodları önemlidir.Ve tekrar tekra kullanmam gerektiginden, Actions methodlarını iceren Reusable methodları olusturdum. Ve gerektiginde bu reusable methodları kullanıyorum.
            Örnegin: rightClick metodunu bir elemente saga tıklamak icin test classımdan cagırabilirim.

 */