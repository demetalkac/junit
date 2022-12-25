package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_GetPageSource {

    /*
                             getPageSource()
      //getPageSource() returns page source code as a string-sayfa kaynak kodunu bir string olarak döndürür
      //We might use this to verify if a certain text exist in the entire page
      - Bunu, belirli bir metnin tüm sayfada var olup olmadığını doğrulamak için kullanabiliriz
      //Note that pageSource is not used a lot to do assertions
      - pageSource'un onaylama yapmak için pek kullanılmadığına dikkat edin
      //Because it is too general and can lead false result
      - Çünkü çok genel ve yanlış sonuçlara yol açabilir

       TEST CASE:
       Test if amazon contains “Registry” on the homepage
       Create a new class : GetPageSource
     */
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "./src/resources/drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Test if amazon contains “Registry” on the homepage
        driver.get("https://www.amazon.com/");
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        String expectedWord = "Registry";

        if(pageSource.contains(expectedWord)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("PAGE SOURCE : "+pageSource);
            System.out.println("EXPECTED WORD : "+expectedWord);
        }
      //  driver.quit();





    }
}
