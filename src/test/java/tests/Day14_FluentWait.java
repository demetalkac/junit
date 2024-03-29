package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;

public class Day14_FluentWait extends TestBase {
    @Test
    public void fluentWaitTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
//        FLUENT WAIT
//        1. Creating Fluent Wait Object
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10)) //Total wait- max bekleme süresi
                .pollingEvery(Duration.ofSeconds(2)) //How often element will be checked- deneme aralıkları yani x sn de bşr elementi buldumu diye kontrol eder.
                .withMessage("Ignoring No Such Element Acception") //OPTIONAL: Give Message
                .ignoring(NoSuchElementException.class); //OPTIONAL : Ignore Exception
// .pollingEvery(Duration.ofSeconds(2)) methodu parantezine ne kadar koyarsak o kadar süre bekle bi daha dene anlamında, 2sn bekle bi daha dene,2sn tekrar bekle tekrar gene dene...
// ignoring(NoSuchElementException.class); kullanılması zorunlu degil. Eger bulamazsa elementi exception fırlatmasın diye kullanıyoruz.

//        2. Using wait object, apply wait. SAME AS EXPLICIT WAIT- wait objesini kullanarak bekleme sorununu cöz.
        WebElement helloElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        Assert.assertEquals("Hello World!",helloElement.getText());
    }


    @Test
    public void fluentTestReusable(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
        //reusable method that accepts the element and max time out as parameters-
        // öğeyi ve maksimum zaman aşımını parametre olarak kabul eden yeniden kullanılabilir yöntem
        WebElement helloElement = fluentWait("//div[@id='finish']//h4",10,3);
        Assert.assertEquals("Hello World!",helloElement.getText());
    }
}
