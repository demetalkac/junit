package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day08_Authentication extends TestBase {
    @Test
    public void authTest(){
     /*
        1) https://the-internet.herokuapp.com/basic_auth sayfasına gidin
        2) asagıda verilen test datalarını kullanarak authentication yapın
        username : admin
        pass     : admin
        url      : the-internet.herokuapp.com/basic_auth
        SPECIAL URL FOR AUTHENTICATION:
        GO LINK  : https://username:pass@url-->authenticatio icin bunu kullanmalıyız: https:, sonra username, sonra password,sonra URL
         normal sayfanın url'si: https://the-internet.herokuapp.com/basic_auth
         authentication yapmak icin bize verilen blgilerleboyle yazıyoruz "driver.get()"tin icine: https://admin:admin@the-internet.herokuapp.com/basic_auth
         */
            //this will do authentication
            driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    //assertion
    String successMessage = driver.findElement(By.xpath("//p")).getText();
        Assert.assertTrue(successMessage.contains("Congratulations! You must have the proper credentials."));
    }
}
