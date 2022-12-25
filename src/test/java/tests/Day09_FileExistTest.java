package tests;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class Day09_FileExistTest {
    /*
    Class: FileExistTest
    Method: isExist
    Pick a file on your desktop-Masaüstünüzden bir dosya seçin
    And verify if that file exist on your computer or not-Ve bu dosyanın bilgisayarınızda var olup olmadığını kontrol edin.
     */
    @Test
    public void isExistTest(){

        String userDIR=System.getProperty("user.dir"); //=>gives the path of the current projeckt folder-geçerli proje klasörünün yolunu verir
        System.out.println("userDIR = " + userDIR); //C:\Users\DEMET\IdeaProjects\SeleniumNewProject

        String userHOME=System.getProperty("user.home");// =>gives you the user folder
        System.out.println("userHOME = " + userHOME);   //C:\Users\DEMET

//        Pick a file on your desktop
//        And verify if that file exist on your computer or not
        String pathOfFile = userHOME +"\\Desktop\\logo.jpeg"; //WRITING THE PATH DYNAMICALLY SO TIS PATH CAN WORKS ON OTHER LAPTOPS
//                                                            DİĞER DİZÜSTÜ BİLGİSAYARLARDA ÇALIŞABİLMEK İÇİN YOLU DİNAMİK OLARAK YAZMAK
        boolean isExist = Files.exists(Paths.get(pathOfFile));//returns TRUE if file exists. FALSE if file doesn't exists
        assertTrue(isExist); //Passes if file exist, Fails if files doesnt exists

    }

      /*
    Given
        Create a file on desktop
    When
        Copy the path of file
    Then
        Assert if the file exists
    */



}
