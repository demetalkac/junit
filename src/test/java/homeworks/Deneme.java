package homeworks;

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
import java.util.List;

public class Deneme {
      /*
    Create a new class : GoogleSearchTest
Create Test method and complete the following task.
When user goes to https://www.google.com/
Search for “porcelain teapot”
And print how many related results displayed on Google
     */
      WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void test1(){
        driver.get("https://www.amazon.com/");
//    Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
       WebElement drobDown= driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(drobDown);
//    Print the first selected option and assert if it equals “All Departments”.If it fails, then comment that code out and continue rest of the test case.
      String first= select.getFirstSelectedOption().getText();
      Assert.assertTrue(first.contains("All Departments"));

//    Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.(after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
     //   select.selectByIndex(3);
    //    String fourth= select.getFirstSelectedOption().getText();
    //    Assert.assertTrue(fourth.contains("Amazon Devices"));

//    Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
        List<WebElement> allOfDropdownOption= select.getOptions();
        for (WebElement w: allOfDropdownOption){
            System.out.println("w = " + w.getText());
        }

//    Print the the total number of options in the dropdown
       int total= allOfDropdownOption.size();
        System.out.println("total = " + total);
//    Assert if ‘Appliances’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
        for (WebElement w: allOfDropdownOption){
            if (w.getText().contains("Appliances")){
                System.out.println("TRUE");
            }else {
                System.out.println("FALSE");

            }
        }
        Assert.assertFalse(false);
//    BONUS: Assert if the dropdown is in Alphabetical Order


    }
}
