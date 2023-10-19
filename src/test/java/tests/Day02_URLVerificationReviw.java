package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_URLVerificationReviw {

    public static void main(String[] args) {
        //System.setProperty("webdriver.crome.driver","./src/resources/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techproeducation.com");

        String actualURL= driver.getCurrentUrl();
        String exceptedURL = "https://techproeducation.com/";



        if (actualURL.equals(exceptedURL)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("actualURL = " + actualURL);
            System.out.println("exceptedURL = " + exceptedURL);
        }

        driver.quit();
    }
}
