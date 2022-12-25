package practices.practice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Q01 extends TestBase {
    /*
    Given
         Go to url : https://phptravels.com/demo/
    When
         Fill the form
    And
         Click on 'SUBMIT'
    Then
         Assert that the form has been sent
     */
    @Test
    public void test(){
      //Go to url : https://phptravels.com/demo/
      driver.get("https://phptravels.com/demo/");

      //Fill the form
        driver.findElement(By.name("first_name")).sendKeys("John");
        driver.findElement(By.name("last_name")).sendKeys("Doe");
        driver.findElement(By.name("business_name")).sendKeys("QA Engineer");
        driver.findElement(By.name("email")).sendKeys("john");
        int number1 = Integer.parseInt(driver.findElement(By.id("numb1")).getText());//String olan veriyi int'e ceviiriyoruz once matematik islemi yapmak icin(auto widening)
        int number2 = Integer.parseInt(driver.findElement(By.id("numb2")).getText());
      String result = String.valueOf(number1+number2); //numb1 ve numb2 integer oldugu icin once onları Stringe ceviriyoruz.Stringe 1)valueOf() ile veya 2)concatinations ile yaıyorz
      //  String result = number1+number2+ "";
       driver.findElement(By.id("number")).sendKeys(result);

       //Click on 'SUBMIT'
     WebElement  submitButon = driver.findElement(By.id("demo"));
        submitButon.sendKeys(Keys.ENTER); //driver.findElement(By.id("demo")).click(); click():calısmassa bunu kullan

      //Assert that the form has been sent
       WebElement thankYou = driver.findElement(By.xpath("//strong[.=' Thank you!']"));
        boolean isThankYou = thankYou.isDisplayed();
        assertTrue(isThankYou);  //".assertTrue" yaparken isDisplayed() calısmazsa "isEnabled()"kullan

        /*
        Thread.sleep(5000);
        assertTrue(thankYou.isDisplayed());
        NOt: isDisplayed() calısması icin sayfaya biraz zaman verdigimizde olur.
         */

        //or
        String textOfElement = thankYou.getText();
        assertTrue(textOfElement.contains("Thank you"));

    }
}
