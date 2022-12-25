package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2TitleVerificationReview {
    public static void main(String[] args) {
        System.setProperty("webdriver.crome.driver","./src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techproeducation.com");

        String actualTitle = driver.getTitle();
        String exceptedTitle = "Techpro Education | Online It Courses & Bootcamps";


        if (actualTitle.equals(exceptedTitle)){
            System.out.println("test is PASS");
        }else {
            System.out.println("test is FAIL");
            System.out.println("actualTitle = " + actualTitle);
            System.out.println("exceptedTitle = " + exceptedTitle);
        }

        driver.quit();
    }
}
