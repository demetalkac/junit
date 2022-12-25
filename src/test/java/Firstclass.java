import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Firstclass {
    public static void main(String[] args) {
       // firefox: webdriver.gecko.driver ==>biz bunu kullanmayacagız. cromdriver kullanacagız.
      // chrome:webdriver.chrome.driver
     //1.set up Chrome Driver:
       // System.setProperty("web","PATH");
        System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver.exe");
       // System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver"); //MAC
     //2.Create Chrome Driver
        WebDriver driver = new ChromeDriver();

     //3. Now that we created webdriver, we can automate web applicattion
        driver.get("https://www.techproeducation.com");


    }
}
