package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class Day08_WindowHandle2 extends TestBase {
    /*
    Open 3 new windows and verify their TITLES
    Open 3 new tabs and verify their TITLES
    Open 3 new windows and verify their titles --
    Given
        Open "https://www.techproeducation.com" on window 1
    When
        Get the title of the page
    Then
        Verify that title contains "Techpro Education"
    When
        Open "https://www.amazon.com" on a NEW window 2
    And
        Get the title of the page
    Then
        Verify that title contains "Amazon"
    When
        Open "https://www.linkedin.com" on a NEW window 3
    And
        Get the title of the page
    Then
        Verify that title contains "LinkedIn"
    When
        Switch back to Techpro
    And
        Switch back to Amazon
    And
        Switch back to Linkedin
     */
    @Test
    public void newWindowTest() throws InterruptedException {
//        open techproeducation on window 1
        driver.get("https://www.techproeducation.com");
        String techProTitle = driver.getTitle();

        Thread.sleep(3000);

        Assert.assertTrue(techProTitle.contains("TechPro Education"));
        Thread.sleep(3000);

        String techProHandle = driver.getWindowHandle();//getting window 1 id
        Thread.sleep(3000);
//        open amazon on a new window 2
        driver.switchTo().newWindow(WindowType.WINDOW);//creates a new window and switches to that window automatically
        driver.get("https://www.amazon.com");
        String amazonTitle = driver.getTitle();
        Assert.assertTrue(amazonTitle.contains("Amazon"));
        String amazonHandle = driver.getWindowHandle();//getting window 2 id
// NOT: "WindowType" ı "import org.openqa.selenium.WindowType;"dan import ediyoruz.

//        open linkedin on a new window 3
        Thread.sleep(3000);
        driver.switchTo().newWindow(WindowType.WINDOW);//creates a new window and switches to that window automatically
        driver.get("https://www.linkedin.com");
        String linkedinTitle = driver.getTitle();
        Assert.assertTrue(linkedinTitle.contains("LinkedIn"));
        String linkedinHandle = driver.getWindowHandle();//getting window 3 id



        Thread.sleep(3000);
        //Switch back to Techpro
        driver.switchTo().window(techProHandle);
        System.out.println("TechPro : " + driver.getCurrentUrl());
        Thread.sleep(3000);
//        Switch back to Amazon
        driver.switchTo().window(amazonHandle);
        System.out.println("Amazon : " +driver.getCurrentUrl());

        Thread.sleep(3000);
//        switching back to Linkedin
        driver.switchTo().window(linkedinHandle);
        System.out.println("Linkedin : "+driver.getCurrentUrl());
    }
   /*
   -- Open 3 new tabs and verify their titles --
    Given
        Open "https://www.techproeducation.com" on Tab 1
    When
        Get the title of the page
    Then
        Verify that title contains "Techpro Education"
    When
        Open "https://www.amazon.com" on a NEW Tab 2
    And
        Get the title of the page
    Then
        Verify that title contains "Amazon"
    When
        Open "https://www.linkedin.com" on a NEW Tab 3
    And
        Get the title of the page
    Then
        Verify that title contains "LinkedIn"
    When
        Switch back to Techpro
    And
        Switch back to Amazon
    And
        Switch back to Linkedin
*/

    @Test
    public void newTabTest() throws InterruptedException {
        //WINDOW -> TAB
        //        open techproeducation on TAB 1
        driver.get("https://www.techproeducation.com");
        String techProTitle = driver.getTitle();
        Assert.assertTrue(techProTitle.contains("TechPro Education"));
        String techProHandle = driver.getWindowHandle();//getting TAB 1 id
        Thread.sleep(3000);
//        open amazon on a new window 2-TAB
        driver.switchTo().newWindow(WindowType.TAB);//creates a new TAB and switches to that TAB automatically
        driver.get("https://www.amazon.com");
        String amazonTitle = driver.getTitle();
        Assert.assertTrue(amazonTitle.contains("Amazon"));
        String amazonHandle = driver.getWindowHandle();//getting TAB 2 id
//        open linkedin on a new window 3
        Thread.sleep(3000);
        driver.switchTo().newWindow(WindowType.TAB);//creates a new TAB and switches to that TAB automatically
        driver.get("https://www.linkedin.com");
        String linkedinTitle = driver.getTitle();
        Assert.assertTrue(linkedinTitle.contains("LinkedIn"));
        String linkedinHandle = driver.getWindowHandle();//getting TAB 3 id
        Thread.sleep(3000);
        //Switch back to Techpro
        driver.switchTo().window(techProHandle);
        System.out.println("TechPro : " + driver.getCurrentUrl());
        Thread.sleep(3000);
//        Switch back to Amazon
        driver.switchTo().window(amazonHandle);
        System.out.println("Amazon : " +driver.getCurrentUrl());
        Thread.sleep(3000);
//        switching back to Linkedin
        driver.switchTo().window(linkedinHandle);
        System.out.println("Linkedin : "+driver.getCurrentUrl());
    }


}
