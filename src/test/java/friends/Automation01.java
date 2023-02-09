package friends;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Automation01 {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void test01() throws InterruptedException {
        /*
        Test Case 1: Register User
        1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
         */
        driver.get("http://automationexercise.com");
        String title =driver.getTitle();
        Assert.assertTrue(title.contains("Automation Exercise"));
        // Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //Verify 'New User Signup!' is visible
       WebElement newUserSignup= driver.findElement(By.xpath("(//h2)[3]"));
       Assert.assertTrue(newUserSignup.isDisplayed());
//6. Enter name and email address
      driver.findElement(By.xpath("//input[@name='name']")).sendKeys("ayse");
      driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("aaaYYYYsss@gmail.com");
//7. Click 'Signup' button
        Thread.sleep(2000);
        WebElement signupButton =driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signupButton.click();
//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInform=driver.findElement(By.xpath("(//b)[1]"));
        Assert.assertTrue(enterAccountInform.isDisplayed());
//9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//*[.='Title']")).click();
        driver.findElement(By.xpath("//*[@for='id_gender2']")).click();
        driver.findElement(By.xpath("//input[@data-qa='name']")).click();
        driver.findElement(By.xpath("//input[@disabled='disabled']")).click();
        driver.findElement(By.id("password")).sendKeys("A1B2");

       WebElement day= driver.findElement(By.id("days"));
        Select select1 =new Select(day);
        select1.selectByIndex(3);

        WebElement mounth=  driver.findElement(By.id("months"));
        Select select2 =new Select(mounth);
        select2.selectByIndex(3); //select2.selectByVisibleText("February");

        WebElement years=  driver.findElement(By.id("years"));
        Select select3 =new Select(mounth);
        select3.selectByIndex(8);//select3.selectByVisibleText("2003);
//10. Select checkbox 'Sign up for our newsletter!'

        driver.findElement(By.xpath("//*[@for='newsletter']")).click();
//11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//*[@for='optin']")).click();
//12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.id("first_name")).sendKeys("ayse");
        driver.findElement(By.id("last_name")).sendKeys("Bilir");
        driver.findElement(By.id("company")).sendKeys("Bilirler");
        driver.findElement(By.id("address1")).sendKeys("Bilir street,Toronto");
        driver.findElement(By.id("address2")).sendKeys("Bilir street,Toronto");
        WebElement country= driver.findElement(By.id("country"));
        Select select4 = new Select(country);
        select4.selectByIndex(2);
        driver.findElement(By.xpath("//*[@id='state']")).sendKeys("Bilir street");
        driver.findElement(By.id("city")).sendKeys("Toronto");
        driver.findElement(By.id("zipcode")).sendKeys("234533");
        driver.findElement(By.id("mobile_number")).sendKeys("2345334398");

//13. Click 'Creame' button
      driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
//16. Verify that 'Logged in as username' is visible
       WebElement created= driver.findElement(By.xpath("//h2[@class='title text-center']"));
       Assert.assertTrue(created.isDisplayed());

       driver.findElement(By.linkText("Continue")).click();


//17. Click 'Delete Account' button ////div[@class='toprow']
      //  driver.switchTo().frame("ad_iframe");


        driver.findElement(By.xpath("//a[.=' Delete Account']")).click();

//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("(//*[.='Account Deleted!'])[2]")).isDisplayed());
    }
}
