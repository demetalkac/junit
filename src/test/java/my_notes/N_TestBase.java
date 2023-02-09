package my_notes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class N_TestBase {
   protected static WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() {

         driver.quit();
    }



    //  REUSABLE METHOD: Dropdown icin tekrar tekrar kullanabilecegimiz bir method olusturalım.
//       Yıl, Ay ve Gun leri secmemiz gereken bir dropdown icin method olusturuyoruz
    public void selectFromDropdown(WebElement dropdown, String secenek){
//              selectFromDropdown(driver.findElement(By.id("year")),"2005");
//              selectFromDropdown(driver.findElement(By.id("month")),"January");
//              selectFromDropdown(driver.findElement(By.id("day")),"12");

//     Gonderilen dropdown elementlerinin tum optionları alınır
        List<WebElement> options = dropdown.findElements(By.tagName("option"));//Tum "option" tagli elementleri alıyorum
        for (WebElement eachOption : options) {
            if (eachOption.getText().equals(secenek)){
                eachOption.click();
                break;
            }
        }
    }


   //    MULTIBLE WINDOW
  // 1 parametre alır : Gecis yapmak istedigimiz sayfanın title
  // ornek :   driver.get("https://the-internet.herokuapp.com/windows ");
  //          switchToWindow("New Window");  (Day07_WindowHandle1 classında ing daki yaptıgımız calısma icin)
  //          switchToWindow("The Internet");
   public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle:driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
              return; //metodun dısına cık anlamında
            }
        }
        driver.switchTo().window(origin);
   }

//   windowNumber sıfırdan (0)'dan baslıyor
//   index numarasını parametre olarak alır ve o indexli  pencereye gecis yapar
    public static void switchToWindow(int windowNumber){
        List<String> list =new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }


    /*   HARD WAIT:
       @param : second
   */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    // ACTIONS_RIGHT CLICK
    public  static void rightClickOnElementActions(WebElement element){
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    // ACTIONS_DOUBLE CLICK
    public  static void doubleClick(WebElement element){
        new Actions(driver).doubleClick(element).build().perform();
    }

    // ACTIONS_HOVER_OVER
    public static void hoverOverOnElementActions(WebElement element){
 //       Actions actions = new Actions(driver); //bunu yoruma alma sebebi bi alttaki gibi de kullanılabiliyor,yazılabiliniyor. o nedenle buna ihtiyac yok
        new Actions(driver).moveToElement(element).perform();
    }

    // ACTIONS_SCROLL_DOWN
    public static void scrollDownActions(){
//       Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
    }


    // ACTIONS_SCROLL_UP
    public static void scrollUpActions(){
//       Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
    }

    // ACTIONS_SCROLL_RIGHT
    public static void scrollRightActions(){
//       Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
    }

    // ACTIONS_SCROLL_LEFT
    public static void scrollLeftActions(){
//       Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).perform();
    }

    // ACTIONS_DRAG_AND_DROP
    public static void dragAndDropActions(WebElement source, WebElement target){
//       Actions actions = new Actions(driver);
        new Actions(driver).dragAndDrop(source,target).perform();
    }

    // ACTIONS_DRAG_AND_DROP_BY
    public static void dragAndDropActions(WebElement source, int x, int y){
//       Actions actions = new Actions(driver);
        new Actions(driver).dragAndDropBy(source,x,y).perform();
    }


}
