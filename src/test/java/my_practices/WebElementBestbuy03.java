package my_practices;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class WebElementBestbuy03 {

    /*
    TEST CASE:
    - https://www.bestbuy.com adresine gidin
    -  cookies cikarsa kabul et butonuna basin
    - sayfadaki kac adet button tag'i oldugunu yazdırın
    - sayfadaki herbir button uzerindeki yazıları yazdırın
     */
    public static void main(String[] args) {
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


       // - https://www.bestbuy.com adresine gidin
           driver.get(" https://www.bestbuy.com");

       // -  cookies cikarsa kabul et butonuna basin
       // - sayfadaki kac adet button tag'i oldugunu yazdırın
      List<WebElement> buttonList = driver.findElements(By.tagName("button"));
        System.out.println(buttonList.size());

       //  - sayfadaki herbir button uzerindeki yazıları yazdırın

        for (WebElement each:buttonList){
            System.out.println(each.getText());
        }

        //3
        //English
        //Français
        //Español
    }
}
