package my_notes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class N05 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//1-C01_TekrarTestiisimlibirclassolusturun
        driver.get("https://www.google.com/ ");
        WebElement cerez= driver.findElement(By.xpath("//*[@id='L2AGLb']"));
       cerez.click();
// 2-https://www.google.com/ adresine gidin
// 3-cookiesuyarisinikabulederekkapatin

//4 Sayfabasliginin“Google”ifadesiicerdiginitestedin
  driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed();

//5Aramacubuguna“Nutella”yaziparatin
     WebElement nutalla=   driver.findElement(By.name("q"));
     nutalla.sendKeys("Nutella");
     nutalla.submit();


//6Bulunansonucsayisiniyazdirin
       String sonuc= driver.findElement(By.id("result-stats")).getText();
        System.out.println("sonuc = " + sonuc);
//7sonucsayisinin10milyon’danfazlaoldugunutestedin
//8Sayfayikapatin



    }
}
