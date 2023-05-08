package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_BasicNavigations {
    public static void main(String[] args) {

           /*
           User Story:
           When user goes to walmart
           Then goes to amazon
           Navigate back to walmart
           Navigate forward to amozon
           Refresh the page
           Close/Quit the browser

          Steps:
     Create a new class under : BasicNavigations
     Create main method
     Set Path
     Create chrome driver
     Maximize the window
     Open google home page https://www.walmart.com/.
     On the same class, Navigate to amazon home page https://www.amazon.com/
     Navigate back to google
     Navigate forward to amazon
     Refresh the page
     Close/Quit the browser
         */



       // step 1: set up
       System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver.exe");

       //step 2: create
        WebDriver driver = new ChromeDriver();

      //step 3: write test scripts

        //        Maximize the window
        driver.manage().window().maximize();

//        Open google home page https://www.walmart.com/
        driver.get("https://www.walmart.com/");

//        On the same class, Navigate to amazon home page https://www.amazon.com/
       // ikinci page gecmek icin asagıdaki 2 yol da kullanabiliriz: river.get() ve driver.navigate().to()
      //  driver.get("https://www.amazon.com/"); //works
        driver.navigate().to("https://www.amazon.com/");

//        Navigate back to walmart
        driver.navigate().back(); //ılk driver a gitmek icin back() kullanıyoruz

//        Navigate forward to amazon :
        driver.navigate().forward();

//        Refresh the page
        driver.navigate().refresh();

//        Close/Quit the browser
   //     driver.close(); en son acık olanı kapatır
        driver.quit();  // butun hepsini kapatır


    }
}
