package tests;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;

public class Day05_Dropdown {
    /*
    NOT: * developerlar <select> tag'i ni Dropdown'ları (html kodları icinde) yazmak icin kullanırlar.
    *<select> taginin altında da <option> tagleri yeralır.
    *select clasını  dropdownları handle ederken kullanacagız sadece
     *Bazı dropdownlar da tek sey secilirken bazen bircok secenegi isaretleyebiliriz.
     */
    WebDriver driver;
    @Before
    public void setUp(){
       // WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    @Test
    public void selectByIndexTest(){
//    select Option 1 by index from the dropdown
//        1. locate the dropdown
        WebElement dropdown = driver.findElement(By.id("dropdown"));
//        2. Create Select object cause dropdown is in the select tag. this is for only dropdowns
        Select select = new Select(dropdown);
//        3. Select any option using the select object
        select.selectByIndex(1); // index starts at 0
    }
    /*
      //Go to https://testcenter.techproeducation.com/index.php?page=dropdown
      //1.Create method selectByIndexTest and Select Option 1 using index
      //2.Create method selectByValueTest Select Option 2 by value
      //3.Create method selectByVisibleTextTest Select Option 1 value by visible text
      //4.Create method printAllTest Print all dropdown value
      //5. Verify the dropdown has Option 2 text
      //6.Create method printFirstSelectedOptionTest Print first selected option
      //7.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
     */
    //2.Create method selectByVisibleTextTest Select Option 2 by visible text
    @Test
    public void selectByVisibleTextTest(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 2");
    }
    //3.Create method selectByValueTest Select Option 1 value by value
    @Test
    public void selectByValueTest() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        Thread.sleep(3000);//HARD WAIT. WAITS 3 SECONDS
        select.selectByValue("1");
        Thread.sleep(3000);
        select.selectByValue("2");
        Thread.sleep(3000);
        select.selectByValue("1");
        Thread.sleep(3000);
        select.selectByValue("2");
    }
    //4.Create method printAllTest Print all dropdown value
    @Test
    public void printAllTest(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
//        getOptions(); returns all of the dropdown options
        List<WebElement> allOptions = select.getOptions();
        for (WebElement eachOption : allOptions){
//            getText() returns the TEXT of the webelements as STRING. getText() methodu String return eder.
            System.out.println(eachOption.getText());
        }
       // allOptions.stream().forEach(t->System.out.println(t.getText())); -->lambda ile kullanımı
//    5. Verify the dropdown has Option 2 text
        boolean isOption2Exist=false; //2ç option secilmemis ise
        for (WebElement eachOption : allOptions){
            if (eachOption.getText().equals("Option 2")){ //getText ile aldıgımız optionlardan Option 2'ye esit ise dogru olacak bu kodlarla
                isOption2Exist=true;
            }
        }
//        fails if Option 2 is not in the dropdown
//        pass if Option 2 is in the dropdown
        Assert.assertTrue(isOption2Exist);
    }
//    6.Create method printFirstSelectedOptionTest Print first selected option
@Test
public void printFirstSelectedOptionTest(){
    WebElement dropdown = driver.findElement(By.id("dropdown"));
    Select select = new Select(dropdown);
//        printing the selected option
    System.out.println("Selected Option : "+select.getFirstSelectedOption().getText());
 //getFirstSelectedOption() return webElement
//        selecting a different option from the dropdown
    select.selectByIndex(2);
//        printing the selected option
    System.out.println("Selected Option : "+select.getFirstSelectedOption().getText());
//        7.Find the size of the dropdown,
//        Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
    int numberOfOptions = select.getOptions().size();
    int expectedNumberOfOptions = 3;

//        Assertion will print Expected Is Not Equal Actual ONLY IF THIS ASSERTION FAILS
    Assert.assertEquals("Expected Is Not Equal Actual",expectedNumberOfOptions,numberOfOptions);
}
    @After
    public void tearDown(){
        driver.quit();
    }

    /*
    -What is a dropdown?
        ---Dropdown is a webelement. It has list of options.
    -How do you handle dropdown? What do you do to automate dropdown?
        ---Dropdowns are created using Select class. So we first locate the dropdown element, then use select class
        to interact with dropdown elements.
    -How do you select dropdown elements?
        ---We actually have 3 options to select a dropdown(index,value,visible text)
     -Tum dropdown seceneclerini nasıl print ederiz?
        ---Tum dropdown elementlerini getOptions() methodu ile list'e koyarız sonra secenekleri loop ile yazdırabilirz
     -Bir secenegin secili oldugunu otomate etmek icin ne yapılır?
        ---  getFirstSelectedOption() secili olan secenegi return eder
     */


}




