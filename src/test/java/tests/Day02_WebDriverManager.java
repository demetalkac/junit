package tests;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_WebDriverManager {

    /*
    So far we used drivers in our local--Şimdiye kadar yerelimizde sürücüler kullandık
    yani bunu kullandık oncesinde==>//System.setProperty("webdriver.chrome.driver", "./src/resources/drivers/chromedriver.exe");
  Not:Bazı sirketler "System.setProperty"i , bazı sirketler  "WebDriverManager.chromedriver().setup();"ı kullanır.
  NOT: Farklı browzerları kullanacagımız "crosbrowzer testing,paralel testing"'lerinde
       WebDriverManager.chromedriver().setup(); bize yardımcı olacak

    We can use WebDriverManager dependency on a maven project
   (Bir maven projesinde WebDriverManager bağımlılığını kullanabiliriz)
    This helps us to setup and use driver faster
    (Bu, sürücüyü daha hızlı kurmamıza ve kullanmamıza yardımcı olur)
    This is the second was of using driver--Bu, driver kullanmanın ikincisiydi
    From now on we will use WebDriverManager--Bundan sonra WebDriverManager'ı kullanacağız

    For this, go to mvnrepository.com and get the WebDriverManager dependency
    https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager
     */
    public static void main(String[] args) {
    //System.setProperty("webdriver.chrome.driver", "./src/resources/drivers/chromedriver.exe");
        //We no longer need to use System.setProperty. We can use WebDriverManager API
        //WebDriverManager.chromedriver().setup();

        // REST IS THE SAME
        //Create driver
        WebDriver driver = new ChromeDriver();
        //maximize
        driver.manage().window().maximize();
        //going to the page
        driver.get("https://www.techproeducation.com");
        //close
        driver.quit();




    }
}
