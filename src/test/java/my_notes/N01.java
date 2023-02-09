package my_notes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class N01 {
    public static void main(String[] args) {
      WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

        //Amozon sayfasındaki <input> ve <a> taglarının sayısını yazdırınız

        List<WebElement> inputTag = driver.findElements(By.tagName("input"));
        System.out.println("input Tag sayısı= " + inputTag.size());

        List<WebElement> linkList = driver.findElements(By.tagName("a"));
        System.out.println("Link sayısı= " + linkList.size());
        for (WebElement w: linkList){
            System.out.println(w.getText());
        }

        //


    }
}

