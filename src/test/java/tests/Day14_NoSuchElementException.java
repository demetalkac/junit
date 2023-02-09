package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day14_NoSuchElementException extends TestBase{

    @Test
    public void noSuchElementTest(){
        driver.get("https://techproeducation.com/");
        //@Before icinde biz 15 sn yazmıstık,locater yanlıs olunca 15 sn bekliyor bulaamayınca NoSuchElementException veriyor

//        Wrong locator
        driver.findElement(By.id("wrong-id")); // org.openqa.selenium.NoSuchElementException:

        //genellikle yanlıs locate den kaynaklanır.Onun haricinde bekleme,iframe,farklı window.. da olabilir.
    }

}
