package practices.practice01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q02 {
    /*
    //  ...Practice 2...
    // Set Driver Path
    // Create chrome driver object
    // Maximize the window
    // Open google home page https://www.google.com/
    // Wait for 3 seconds
    // Go to the "https://techproeducation.com/"
    // Get the title and URL of the page
    // Check if the title contains the word "Bootcamps" print console "Title contains Bootcamps" or "Title does not contain Bootcamps"
    // Check if the URL contains the word "Courses" print console "URL contains Courses" or "URL does not contain Courses"
    // Then go to "https://medunna.com/"
    // Get the title and check if it contains the word "MEDUNNA" and print "Title contains MEDUNNA" or "Title does not contain MEDUNNA"
    // Back to the previous webpage
    // Refresh the page
    // Navigate to forward
    // Wait for 3 seconds
    // Close the browser
     */

    public static void main(String[] args) throws InterruptedException {
        // Set Driver Path
        System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver.exe");

        // Create chrome driver object
        WebDriver driver = new ChromeDriver();

        // Maximize the window
        driver.manage().window().maximize();

        // Open google home page https://www.google.com/
        driver.get("https://www.google.com/");

        // Wait for 3 seconds
        Thread.sleep(3000);

        // Go to the "https://techproeducation.com/"
        driver.get("https://techproeducation.com/");

        // Get the title and URL of the page
        String techproTitle = driver.getTitle();
        System.out.println("techproTitle = " + techproTitle);
        String techproUrl =driver.getCurrentUrl();
        System.out.println("techproUrl = " + techproUrl);
        // Check if the title contains the word "Bootcamps" print console "Title contains Bootcamps" or "Title does not contain Bootcamps"
        if (techproTitle.contains("Bootcamps" )){
            System.out.println("Title contains Bootcamps");
        }else {
            System.out.println("Title does not contain Bootcamps");
        }

        // Check if the URL contains the word "Courses" print console "URL contains Courses" or "URL does not contain Courses"
        if (techproUrl.contains("Courses")){
            System.out.println("URL contains Courses");
        }else {
            System.out.println("URL does not contain Courses");
        }

        // Then go to "https://medunna.com/"
        driver.get("https://medunna.com/");

        // Get the title and check if it contains the word "MEDUNNA" and print "Title contains MEDUNNA" or "Title does not contain MEDUNNA"
        String medunnaTitle = driver.getTitle();
        if (medunnaTitle.contains("MEDUNNA")){
            System.out.println("Title contains MEDUNNA");
        }else {
            System.out.println("Title does not contain MEDUNNA");
        }

        // Back to the previous webpage
        driver.navigate().back();
        // Refresh the page
        driver.navigate().refresh();
        // Navigate to forward
        driver.navigate().forward();
        // Wait for 3 seconds
        Thread.sleep(3000);
        // Close the browser
        driver.quit();
    }

    public static class Q01 {

        // ...Practice 1...
        // Set Driver Path
        // Create chrome driver object
        // Maximize the window
        // Open google home page https://www.google.com/
        // Navigate to techproeducation home page https://techproeducation.com/
        // Navigate back to google
        // Navigate forward to techproeducation
        // Refresh the page
        // Close/Quit the browser
        // And last step : print "ALL OK" on console
        public static void main(String[] args) throws InterruptedException {
            // Set Driver Path

            System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver.exe");

            // Create chrome driver object
            WebDriver driver = new ChromeDriver();

            // Maximize the window
            driver.manage().window().maximize();

            // Open google home page https://www.google.com/
            driver.get("https://www.google.com/");

            // Navigate to techproeducation home page https://techproeducation.com/
            driver.navigate().to("https://techproeducation.com/");

            // Navigate back to google
            Thread.sleep(1000); //This will wait 1 second to execute next code==> Java Wait
            driver.navigate().back();

            // Navigate forward to techproeducation
            Thread.sleep(1000);
            driver.navigate().forward();

            // Refresh the page
            driver.navigate().refresh();

            // Close/Quit the browser
            driver.quit();
            // And last step : print "ALL OK" on console
            System.out.println("ALL OK");
        }
    }
}
