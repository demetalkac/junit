package practices.practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Q02 extends TestBase {
    /*
    Given
        Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
    When
       Type "My File" into "Notes about the file" input
    And
        Select the file to upload
    And
        Click "Choose File" button
    And
        Click on "Press" button
    Then
        Assert that "Your notes on the file were" equals "My File"
    And
        Assert that file Content contains "Hello, I am uploaded file"
     */
    @Test
    public void test() {
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
        //Masa ustune bir txt dosyası actık,sonra bize verilen url ye gidip "choose File"(dosya sec) kısmından masaustundeki txt
       // dosyasını sectik ve "Press"e bastık
        //Type "My File" into "Notes about the file" input --> "Notes about the file"ın locate ettik
        driver.findElement(By.name("note")).sendKeys("My File");

        // Select the file to upload-->"choose File"ın locate ettik ve actıgımız txt dosyasının path'ini kopyalayıp buraya yapıstırdık
        //Click "Choose File" button--> click yapmadık ,sendKeys() ile path gonderdik.
       // driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\DEMET\\Desktop\\my file.txt"); -->Boyle yapınca dinamik olmuyor
        String userHome = System.getProperty("user.home"); //farklı bilgisayarlarda aynı kodu calıstırabiliriz bununla
        driver.findElement(By.name("upfile")).sendKeys(userHome+"/Desktop/text.txt");

        //Click on "Press" button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //Assert that "Your notes on the file were" equals "My File"
       String note = driver.findElement(By.xpath("//blockquote")).getText();
                   //driver.findElement(By.tagName("blockquote")).getText();
       assertEquals("My File",note);


        //        Assert that file Content contains "Hello, I am uploaded file"
        String fileContent = driver.findElement(By.xpath("//pre")).getText();
        assertTrue(fileContent.contains("Hello, I am uploaded file"));
        //Assert.assertTrue(driver.findElement(By.tagName("pre")).getText().contains("Hello, I am uploaded file"));
    }

}
