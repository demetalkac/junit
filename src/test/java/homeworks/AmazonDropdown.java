package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmazonDropdown {
     /*
    Create A Class: AmazonDropdown
    Create A Method dropdownTest
    Go to https://www.amazon.com/
    Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
    Print the first selected option and assert if it equals “All Departments”.If it fails, then comment that code out and continue rest of the test case.
    Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.(after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
    Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
    Print the the total number of options in the dropdown
    Assert if ‘Appliances’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
    BONUS: Assert if the dropdown is in Alphabetical Order

     */
     WebDriver driver;
  @Before
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
  }
  @Test
    public void dropdownTest(){
//      Go to https://www.amazon.com/
      driver.get("https://www.amazon.com/");

//      Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
     WebElement drobDown = driver.findElement(By.id("searchDropdownBox"));
     Select select =new Select(drobDown);

//      Print the first selected option and assert if it equals “All Departments”.If it fails, then comment that code out and continue rest of the test case.
     String firstOption =select.getFirstSelectedOption().getText();
     Assert.assertEquals("All Departments",firstOption);


//      Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.(after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
  //  select.selectByIndex(3);
  //  String fourthOption =select.getFirstSelectedOption().getText();
  //  Assert.assertEquals("Amazon Devices",fourthOption);


//      Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
    List<WebElement> allOption = select.getOptions();
    for (WebElement w: allOption){
      System.out.println("w = " + w.getText());
    }

//      Print the the total number of options in the dropdown
       int totalOptionNumber= allOption.size();
    System.out.println("totalOptionNumber = " + totalOptionNumber);

//      Assert if ‘Appliances’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
     boolean flag = false;
     for (WebElement w: allOption){
       if (w.getText().contains("Appliances")){
         flag = true;
       }
     }
    Assert.assertFalse(false);
     /*
     diger cozumu:
      for (WebElement w: allOfDropdownOption){
            if (w.getText().contains("Appliances")){
                System.out.println("TRUE");
            }else {
                System.out.println("FALSE");
            }
        }
        Assert.assertFalse(false);
      */

//              BONUS: Assert if the dropdown is in Alphabetical Order
    List<String> options = new ArrayList<>();
    System.out.println("options = " + options);
    for (WebElement w : allOption){
      options.add(w.getText());
    }
    System.out.println("options = " + options);

    List<String> newOptions = new ArrayList<>(options);
    System.out.println("newOptions = " + newOptions);
    Collections.sort(newOptions);

    Assert.assertEquals(options, newOptions);
    //Assert.assertTrue(options.equals(newOptions));
    //Assert.assertFalse(!options.equals(newOptions));
      /*
      List<String> sortedList = listOfOptions.stream().sorted().collect(Collectors.toList());
        System.out.println("sortedList = " + sortedList);
        assertEquals("Dropdown is not in Alphabetical Order",listOfOptions,sortedList);
    }
       */

  }




  @After
  public void tearDown() {
    driver.quit();
  }
}
