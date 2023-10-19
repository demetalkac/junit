package my_notes;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class N02 {
    public static void main(String[] args) {
       // WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

     //"city bike" search(ara)
     driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike", Keys.ENTER);

     //GORUNTULENEN SONUCLARIN SAYISINI YAZDIRIN
        List<WebElement> aramaSonucYazısı =driver.findElements(By.className("sg-col-inner"));
        System.out.println("arama sonuc yazısı" +aramaSonucYazısı.get(0).getText()); //arama sonuc yazısı1-16 of 138 results for "city bike"

     //arama sonuc yasısını konsola yazdırı
     String [] sonucSayısı= aramaSonucYazısı.get(0).getText().split(" ");
     System.out.println("sonucSayısı = " + sonucSayısı[2]); //sonucSayısı = 138

     //sonuc sayısını LAMBDA ile yazdırırnız
        Arrays.stream(aramaSonucYazısı.
                get(0).
                getText().
                split(" ")).
                limit(3).
                skip(2).
                forEach(System.out::println); //138

     //KARSIMIZA CIKAN İLK SONUCUN RESMINE TIKLAYIN
        List<WebElement> ilkWE= driver.findElements(By.className("s-image"));
        ilkWE.get(0).click();


    }
}
