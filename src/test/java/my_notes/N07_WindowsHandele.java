package my_notes;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class N07_WindowsHandele extends N_TestBase{

   @Test
    public void handelWindowTest(){
//        Given user is on the https://the-internet.herokuapp.com/windows
       driver.get("https://the-internet.herokuapp.com/windows ");

//  https://the-internet.herokuapp.com/windows adresinegidin.

//      Sayfadaki textin “Opening a new window” olduğunudoğrulayın.
      String actualWindow1Text = driver.findElement(By.xpath("//h3")).getText();
       String expectedWindow1Text ="Opening a new window";
       assertEquals(expectedWindow1Text,actualWindow1Text);

//      Sayfa başlığının(title) “The Internet” olduğunudoğrulayın.
       String actualWindow1Title = driver.getTitle();
       String expectedWindow1Title ="The Internet";
       assertEquals(expectedWindow1Title,actualWindow1Title);

       String window1Handle= driver.getWindowHandle();

//      Click Here butonunabasın.
       driver.findElement(By.linkText("Click Here")).click();

       //ikinci pencere acılır ve ikinci pencerede islem yapmak icin switch(gecis) yapmalıyıoz
       switchToWindow(1); //N_TestBase clasındaki switchToWindow() methodunu kullanarak 2. windowa gectimve driver 2. windowda

//      Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunudogrulayin.
       String actualWindow2Title = driver.getTitle();
       String expectedWindow2Title ="New Window";
       assertEquals(expectedWindow2Title,actualWindow2Title);

   }

}
