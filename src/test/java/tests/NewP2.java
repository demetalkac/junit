package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class NewP2 {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.navigate().to("https://www.amazon.com/");

        //get the title
       String actual= driver.getTitle();
       String exceptedTitle ="Amazon.com. Spend less. Smile more.";
       assertEquals(actual,exceptedTitle);

       /*
Manual testing to verify page title:
go to title --> right click--> inspect --> scroll down--> find <title> --> take screenshot
 */

        //Verify if homepage url is
        String actualT=driver.getCurrentUrl();
        String exceptedUrl ="https://www.amazon.com/";
        assertEquals(actual,exceptedUrl);




    }

}
