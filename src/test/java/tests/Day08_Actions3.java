package tests;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day08_Actions3 extends TestBase {
    /*
    Create a class: ActionClass3
    Create test method : scrollUpDown()// mouse ve klavyedeki oklar ile sayfayı yukarı-asagı hareket ettirmek
    Go to techproeducation
    Scroll the page down
    Scroll the page up
     */
    // NOTE: sendKeys(Keys.PAGE_DOWN) YAPINCA SAYFA AZCIK ASAGI İNER COK DEGİL, BU SEKILDE KULLANABİLİRİZ,YANI SAYFAYI
    // TAMAMEN ASAGIYA CEKMEZ.bi tık asagı inmemiz gerektigi zaman kullanabilirim.
    @Test
    public void pageUpDownTest() throws InterruptedException {
        driver.get("https://www.techproeducation.com");
        Actions actions = new Actions(driver);
//        sendKeys(Keys.PAGE_DOWN) is used to scroll the page down
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        Thread.sleep(3000);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        Thread.sleep(3000);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        Thread.sleep(3000);
//        CHAIN METHOD. SCROLLING 3 TIMES
//        .build() is recommended to be used when we chain multiple commends to make sure the connection is strong.
//        .perform() is used when there is single or multiple commends to execute the action
        actions.
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                build().
                perform();
        Thread.sleep(3000);
// NOTE: sendKeys(Keys.PAGE_DOWN) YAPINCA SAYFA AZCIK ASAGI İNER COK DEGİL, BU SEKILDE KULLANABİLİRİZ,YANI SAYFAYI TAMAMEN ASAGIYA CEKMEZ.bi tık asagı inmemiz gerektigi zaman kullanabilirim.
//        ARROW DOWN = scroll down a little bit. This scrolls less than page down
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(3000);

//      PAGE_UP = scroll up
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);

//      ARROW_UP = scroll up a little bit. This scrolls less than page up
        actions.sendKeys(Keys.ARROW_UP).perform();


//        actions.sendKeys(Keys.ARROW_LEFT).perform(); //sayfayı saga-sola da hareket ettirebiliriz,baska methodlarda var kullanılabilir.
//        actions.sendKeys(Keys.ARROW_RIGHT).perform();
    }

}
