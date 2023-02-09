package tests;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day12_WriteExcel {
    @Test
    public void excelWriteTest() throws IOException {
//Create a new class: WriteExcel
//Create a new method: writeExcel()
//Store the path of the file as string and open the file
        String path = "./src/test/java/resources/Capitals.xlsx";
//Open the workbook(dosyayı acıyoruz)
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

//Open the first worksheet
        Sheet sheet1 = workbook.getSheet("Sheet1");

//Go to the first row
        Row row1 = sheet1.getRow(0);
//buraya kadar Excel icin diger sayfada yaptıklarımız ile aynı.Bunun icin kullanıslı method yapıp onu kullanmak daha iyi.
// cunku tekrar tekrar kullanmamız gerektiginde daha kullanıslı olur tekrardan yazmaya gerek kalmaz

 //excel tablosuna yeni veri ekleyecegiz,bunun icin yeni yeni sutun olusturacagız,ama sutun uzerinden calısmadıgı icin excel "cell" ekleyip,onun icine yazacagız veriyi

//Create a cell on the 3rd column (2nd index) on the first row
     Cell r1c3 = row1.createCell(2); // createCell() ile yeni cell olusturduk, icine yazmak icin.

//Write “POPULATION” on that cell
        r1c3.setCellValue("POPULATION"); //setCellValue() methodu ile excel dosyasına cell'e deger ekliyoruz,yazıyoruz.

//Create a cell on the 2nd row 3rd cell(index2), and write 150000
        sheet1.getRow(1).createCell(2).setCellValue("150000");

//Create a cell on the 3rd row 3rd cell(index2), and write 250000
        sheet1.getRow(2).createCell(2).setCellValue("250000");

//Create a cell on the 4th row 3rd cell(index2), and write
        sheet1.getRow(3).createCell(2).setCellValue("54000");

//Write and save the workbook(Kaydetme islemi "FileOutputStream" ile yapılır .)
        FileOutputStream fileOutputStream =new FileOutputStream(path);
        workbook.write(fileOutputStream);

//**"createCell()" ile cell olusturduk=> "setCellValue()" ile cellin icine deger koyduk =>FileOutputStream fileOutputStream =new FileOutputStream(path);
//        workbook.write() ile de yaptıklarımızı kaydettik.


//Close the file
        fileInputStream.close();
        fileOutputStream.close();
//        Close the workbook
        workbook.close();



    }
}
