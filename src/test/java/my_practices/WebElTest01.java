package my_practices;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElTest01 {

    /*
    1- https:www.amazon.com sayfasına gidin
    2- arama cubuguna "Nutella" yazdırın
    3- Nutella yazdıktan sonra ENTER'a basarak arama islemini yapin
    4- Bulunan sonuc yazısını yazdırın
     */
    public static void main(String[] args) {
       //WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

     // 1- https:www.amazon.com sayfasına gidin
     driver.get("https://www.amazon.com/");

    // 2- arama cubuguna "Nutella" yazdırın
     WebElement aramaCubuguEl = driver.findElement(By.id("twotabsearchtextbox"));
      aramaCubuguEl.sendKeys("Nutella");
     // 3- Nutella yazdıktan sonra ENTER'a basarak arama islemini yapin
        aramaCubuguEl.submit();

     // 4- Bulunan sonuc yazısını yazdırın

       WebElement sonucYazısıEl = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazısıEl.getText());

        driver.quit();

    }
}
