package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewP03 {

    public static void main(String[] args) {
        //We no longer need to use System.setProperty. We can use WebDriverManager API
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //getPageSource()
        //Note that pageSource is not used a lot to do assertions
        // - pageSource'un assertions yapmak için pek kullanılmadığına dikkat edin.Çünkü çok genel ve yanlış sonuçlara yol açabilir


        driver.get("https://www.amazon.com/");
       String pageSourch= driver.getPageSource();

       String expectedWord= "Registry";


       if (pageSourch.contains(expectedWord)){
           System.out.println("PASS");
       }else {
           System.out.println("FAIL");
           System.out.println("pageSourch = " + pageSourch);
           System.out.println("expectedWord = " + expectedWord);
       }
        driver.quit();

       /*
    @BeforeClass,@AfterClass,    @Before,@After ,  @test,@ıgnore


        */


    }
}
