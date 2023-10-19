package my_notes;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class N03_RelativeLocators {
    public static void main(String[] args) {

       // WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1)https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresinegidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        //2) Sayfadaki Berlin’i WE'İNİ relative locator ile tıklayın
        WebElement nycWebelementi= driver.findElement(By.xpath("//*[@id='pid3_thumb']"));
        WebElement bayAreaWebelementi= driver.findElement(By.cssSelector("img[id='pid8_thumb']"));
        WebElement berlinWebelementi= driver.findElement(with(By.tagName("li")).below(nycWebelementi).toLeftOf(bayAreaWebelementi));
        berlinWebelementi.click();

        // Web elementlerini locate ederken sorun olduysa, elementi locate etmek icin yanında ,sagında-solunda-altında-ustunde
        // yer alan baska bir elementin locate ni yapıp,daha sonra locatenı yapmak istedigimiz elementi locate edebiliriz:
        //locatenı yapmak istedigimiz elementin sagındaki,solundak, diye belirterek yapabiliriz.
        // Bunu yapmak icin aynı "tagname"e sahip olanları seciyoruz.Buna da RelativeLocators deniyor.Selenium 4 ile gelen yeniliklerden biridr


    }


}
