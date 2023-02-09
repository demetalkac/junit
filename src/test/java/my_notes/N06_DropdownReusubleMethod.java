package my_notes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class N06_DropdownReusubleMethod {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    @Test
    public  void selectTest(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        // YIL,AY VE GUN SECENEKLERİNİ LOCATE ET "2000, January,10" olsun
        WebElement year=  driver.findElement(By.id("year"));
        Select yearDropdown= new Select(year);
        yearDropdown.selectByIndex(22);

        WebElement month = driver.findElement(By.id("month"));
        Select monthDropdown= new Select(year);
        monthDropdown.selectByValue("0");

        WebElement day = driver.findElement(By.id("day"));
        Select dayDropdown= new Select(year);
        dayDropdown.selectByVisibleText("10");
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

    @Test
    public  void selectFromDropdown(){

     //Burda "Selec"classından selec objeck olusturmadan dropdown u hallettik.Cunku yukarda bunun icin reusable method olusturduk ve onu kullndık.
        selectFromDropdown(driver.findElement(By.id("year")),"2005");
        selectFromDropdown(driver.findElement(By.id("month")),"November");
        selectFromDropdown(driver.findElement(By.id("day")),"10");
        selectFromDropdown(driver.findElement(By.id("state")),"Texas");

    }



}
