package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day10_FileUpload extends TestBase {
    /*
    Class Name: FileUploadTest-Dosya Yükleme Testi
Method Name: fileUploadTest
When user goes to https://the-internet.herokuapp.com/upload
When user selects an image from the desktop
And click on the upload button
Then verify the File Uploaded!  Message displayed
---------
       FileUpload -Dosya Yükleme
   1-  url'e git:
   driver.get("https://the-internet.herokuapp.com/upload");
   2- Sayfada yükleyecegimiz yerin locate'i al-locate choose file and click choose a file:
   "choose file"(dosya sec),locate'nı al,-->.id("file-upload"
   3- tıkla ve yuklemek istedigin dosyayı sec kendi bilgisayarımdan- select a file from your computer
    -->sectigim dosyanın path'ini kopyala:
    String userHOME=System.getProperty("user.home");
    String pathOfFile = userHOME +"\\Desktop\\logo.jpeg";

   4- Sending the path of the file that I want to upload.
     we can use send keys cause the input type file combination
        chooseAFileButton.sendKeys(pathOfFile);

   5- upload yaptıktan sonra upload olduguna dagir, acılan yerdeki bir elementin locate'i al.-then locate and click uploated
      "upload" ın locate ni al -->id("file-submit")
      driver.findElement(By.id("file-submit")).click();

   6- Asserting
      boolean isEqual =driver.findElement(By.xpath("//H3")).getText().equals("File Uploaded!");
      Assert.assertTrue(isEqual);
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

//      Sending the path of the file that I want to upload.
//      we can use send keys cause the input type file combination
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
     -İlk olarak selenyum dosya otomasyonunda sınırlama vardır. Ancak dosya yükleme selenium ile yapılabilir.
     Dosya seç düğmesini buluyoruz ve dosyanın yolunu göndermek için gönderme tuşları işlevini kullanıyoruz.
     Daha sonra dosyayı yüklemek için upload butonuna tıklıyoruz.
     Dosyanın yolu dinamik olmalıdır - System.getProperty("user.home"); kullanın

     SINIRLAMA:
    Selenium'un sınırlama otomasyonu vardır MASAÜSTÜ UYGULAMALARI
    Örneğin, dosyaların yolunu bulamıyoruz veya selenumlu makinelerde dosya olup olmadığını doğrulayamıyoruz.
    Bunun yerine Java Dosya kitaplıklarını kullanıyoruz
     */

}
