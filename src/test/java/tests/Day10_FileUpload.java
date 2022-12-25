package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day10_FileUpload extends TestBase {
    /*
    Class Name: FileUploadTest
Method Name: fileUploadTest
When user goes to https://the-internet.herokuapp.com/upload
When user selects an image from the desktop
And click on the upload button
Then verify the File Uploaded!  Message displayed
     */
    @Test
    public void fileUploadTest(){
        driver.get("https://the-internet.herokuapp.com/upload");
//        1. locate choose file and click choose a file
//        <input type="file">
        WebElement chooseAFileButton = driver.findElement(By.id("file-upload"));

//        2. select a file from your computer
        String userHOME=System.getProperty("user.home");
        String pathOfFile = userHOME +"\\Desktop\\logo.jpeg";

//      Sending
        chooseAFileButton.sendKeys(pathOfFile);
//        3. then locate and click upload
        driver.findElement(By.id("file-submit")).click();

//       4.Asserting
      boolean isEqual =driver.findElement(By.xpath("//H3")).getText().equals("File Uploaded!");
        Assert.assertTrue(isEqual);
    }


      /*
    How do you upload a file with selenium?
    -First selenium has limitation automation of files. But file upload can be done with selenium.
    We locate the chose file button and use send keys function to send the path of the file.
    Then we click upload button to upload the file.
    Path of the file should be dynamic - use System.getProperty("user.home");

        LIMITATION:
   Selenium has limitation automation DESKTOP APPS
   For example, we can not find path of files, or verify if file exists on out machines with selenum
   Instead we use java File libraries
    ------------
    Selenyum içeren bir dosyayı nasıl yüklersiniz?
     -İlk selenyum dosya otomasyonunda sınırlama vardır. Ancak dosya yükleme selenium ile yapılabilir.
     Dosya seç düğmesini buluyoruz ve dosyanın yolunu göndermek için gönderme tuşları işlevini kullanıyoruz.
     Daha sonra dosyayı yüklemek için upload butonuna tıklıyoruz.
     Dosyanın yolu dinamik olmalıdır - System.getProperty("user.home"); kullanın

     SINIRLAMA:
    Selenium'un sınırlama otomasyonu vardır MASAÜSTÜ UYGULAMALARI
    Örneğin, dosyaların yolunu bulamıyoruz veya selenumlu makinelerde dosya olup olmadığını doğrulayamıyoruz.
    Bunun yerine Java Dosya kitaplıklarını kullanıyoruz
     */

}
