package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NewP {
    public static void main(String[] args) {

        //1.set up Chrome Driver:
        // System.setProperty("web","PATH");

        System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver.exe");

        //2.Create Chrome Driver
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.walmart.com/");


        driver.navigate().to("https://www.amazon.com/");

        driver.navigate().back();

        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();


        /*
        CHROME : WebDriver driver = new ChromeDriver(); OPP consept java da polimorphism.
Polymorphism nedir?
Polmorfzm is using in maltıble form
HOW DİD YOU USE İN YOUR PROJECKT
Creating web driver,I tested an application with diffrent browzer

         */

    }
}
