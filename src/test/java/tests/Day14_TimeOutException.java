package tests;


import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day14_TimeOutException extends TestBase {

    @Test
    public void timeOutTest(){

        driver.get("https://techproeducation.com/");
//      Trying to locate the element using Explicit wait-

//        We get timeout exception because explicit wait could not handle the issue.
//     Explicit  bekleme sorunu çözemediği için zaman aşımı istisnası alıyoruz.
        waitForVisibility(By.id("wrong-id"),15); //org.openqa.selenium.TimeOutException

    }


    /*
    sebep: - Explicit wait kullandıgımızda öğeyi bulmaya çalışır ve bulamaz ise "TimeOutException" verir.
            -Explicit wait - yanlıs locator =TimeOutException
            -Explicit wait - dogru locator - sure yeterli degil =TimeOutException
            -Explicit wait - dogru locator - sure yeterli -iframe var = TimeOutException

      YANI explicit wait kullandıgımda ve locator bulunamadıgında alırım bu exceptionu


    cozum: -sure artırılır
    - farklı exclicit wait kullanılır: wait visibilityOfElementLocated yerine presenceOfElementLocated  kullanılabilir
      yada javascript executer da ki waiter kullanılabilir sayfa gecislerini beklemek icin.
    -locater kontrol edilir
    -Frameworkumda hazır reusable methodlar var.Bu durumlarda timeoutexception aldıgımda hızlıca o methodlar yardımıyla problemi cözebiliriz
     */
//
}

