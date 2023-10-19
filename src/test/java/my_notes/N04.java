package my_notes;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class N04 {

    public static void main(String[] args) {
       // WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://www.amazon.com/ sayfasinagidelim
        driver.get("https://www.amazon.com/");

        //2 arama kutusunu locateedelim
        WebElement aramaKutus = driver.findElement(By.id("twotabsearchtextbox"));

        //3 “Samsung headphones” ile aramayapalim
        aramaKutus.sendKeys("Samsung headphones");
        aramaKutus.submit();
        //4 Bulunan sonuc sayisiniyazdiralim

        WebElement aramaSonucu = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("aramaSonucu = " + aramaSonucu);
        //5 Ilk urunutiklayalim
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

        //6 Sayfadaki tum basliklariyazdiralim
        List<WebElement> sayfaBaslıklarıLists = driver.findElements(By.xpath("//h1"));
        for (WebElement w : sayfaBaslıklarıLists) {
            System.out.println(w.getText());
        }
    //lambda ile:
    //    sayfaBaslıklarıLists.forEach(t-> System.out.println(t.getText()));

        driver.close();
    }
}