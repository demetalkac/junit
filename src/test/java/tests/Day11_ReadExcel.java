package tests;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day11_ReadExcel {

    /*
      EXCEL
   1- excel dosyasını koymak icin intellj'de package olustur:
      test => java ,new package:resources
   2- exel dosyasını projeye yükle:
      Bilgisayarındaki exel dosyasını drag and drop (dosyayı tut ve bırak) resources package'nın icine.=>"refactor" bas
   3- Intellj'e yuklenen excel dosyasının path'ini kopyala String icine koy:
     (Store the path of the  file in a string))
        String path = "./src/test/java/resources/Capitals.xlsx";
//        ".\\src\\test\\java\\resources\\Capitals.xlsx" //WINDOWS
  4-  "workbook>worksheet>row>cell"
  5-     Open the file - Dosyayı ac
        FileInputStream fileInputStream = new FileInputStream(path);
  6-      Workbook workbook = WorkbookFactory.create(fileInputStream);
  7-      Sheet sheet1 = workbook.getSheet("Sheet1");
  8-      Row row1 = sheet1.getRow(0);
  9-      Cell cell1 = row1.getCell(0);
  10-     We can convert the cell data to string
           String cell1Data = cell1.toString();
           System.out.println(cell1Data);
  11-     Find the number of row
      *  int numberOfRow = sheet1.getLastRowNum()+1;//index starts at 0, so add 1 to find total number of row
         System.out.println("ROW COUNT : "+numberOfRow); //11
      *  int numberOfData = sheet1.getPhysicalNumberOfRows();//getPhysicalNumberOfRows(); index starts at 1. Returns the number of row that has a DATA
 ***
    FileInputStream fileInputStream = new FileInputStream(path); =>File javadan geldigi icin obje olustururken "new" kullanıyoruz
    FAKAT; Workbook workbook = WorkbookFactory.create(fileInputStream);
           Sheet sheet1 = workbook.getSheet("Sheet1");
           Row row1 = sheet1.getRow(0);
            Cell cell1 = row1.getCell(0); ==> OLUSTURURKEN "new" KULLANMIYORUZ CUNKU BUNLAR "import org.apache.poi.ss.usermodel.*;"dan gelirler.
     */
    @Test
    public void readExcelTest() throws IOException {
//        workbook>worksheet>row>cell
//        Store the path of the  file in a string -->"./" means is ignore before parts in file's path
        String path = "./src/test/java/resources/Capitals.xlsx";
//        ".\\src\\test\\java\\resources\\Capitals.xlsx" //WINDOWS
//        Open the file - Dosyayı ac
        FileInputStream fileInputStream = new FileInputStream(path);

//        Open the workbook using fileinputstream ("Workbook" apache.poi libray'sinden)
        Workbook workbook = WorkbookFactory.create(fileInputStream);

//        Open the first worksheet
//    Sheet sheet1 = workbook.getSheetAt(0); //getSheetAt():exceldeki var olan sheet'leri indexine gore verir. index 0'dan baslıyor
        Sheet sheet1 = workbook.getSheet("Sheet1");

//        workbook.getSheetAt(0);//ALTERNATIVELY(indexs ile de alabiliriz sheet'i,bir tane sheetimiz oldugu icin "0"aldık)
//  **Sheet i ismiyle veya indexine göre alabiliriz: getSheetAt():index , getSheet("Sheet1"):sheet ismi
//        Go to first row
        Row row1 = sheet1.getRow(0);//index starts at 0. going to the first row

//        Go to first cell on that first row and print
        Cell cell1 = row1.getCell(0);//index starts at 0. reading the first cell data that is on the first row
        System.out.println(cell1);
//        We can convert the cell data to string
        String cell1Data = cell1.toString();
        System.out.println(cell1Data);
        System.out.println("??????????????????????");

//        Go to second cell on that first row and print
        Cell r1c2 = row1.getCell(1);
        System.out.println("R1C2 : "+r1c2.toString());

//        Go to 2nd row first cell  and assert if the data equal to USA
        String r2c1 = sheet1.getRow(1).getCell(0).toString();//METHOD CHAIN //string e cevirdik, cunku assert yaparken hem data kontrol ediyor hem de data tipini kontrol ediyor.
        Assert.assertEquals("USA",r2c1);                  //Yani assertion yapmak icin stringe cevirmemiz gerekir.

//        Go to 3rd row 2nd cell-chain the row and cell
        String r3c2 = sheet1.getRow(2).getCell(1).toString();
        System.out.println(r3c2);

//        Find the number of row
        int numberOfRow = sheet1.getLastRowNum()+1;//index starts at 0, so add 1 to find total number of row
        System.out.println("ROW COUNT : "+numberOfRow); //11
 // getLastRowNum() son satır numarasını verir, int return eder.

//**Exceldeki toplam kullanılan satır sayısını 2 sekilde bulabiliriz:1)getLastRowNum() ve 2)getPhysicalNumberOfRows() ile.
// Fakat getLastRowNum() en son satırı ve index 0'dan baslar iken  getPhysicalNumberOfRows() kullanılan(bazı satırlar bos
// olabilir aralarda onları saymaz) ve  1'den baslar, idex kullanmaz.

//        Find the number of used row
        int numberOfData = sheet1.getPhysicalNumberOfRows();//getPhysicalNumberOfRows(); index starts at 1. Returns the number of row that has a DATA
        System.out.println("Number of Data : "+numberOfData);
// getPhysicalNumberOfRows();  1'den baslıyor saymaya. icinde data olan row sayısını verir.

//        Print country, capitol key value pairs as map object(ulke ve baskentleri key-value olarak map'a alıp prit et)
//        {{USA,D.C},{ France,Paris },...}
//        Create a Map that will store the country, capital pairs
// Variable olusturalım, bu variable exceldeki country,capital verilerini tutacak.
        Map<String,String> countryCapitals = new HashMap<>();

        for (int rowNum =1 ; rowNum<numberOfRow; rowNum++) {//row index starts at 1, ends at 11
            String county = sheet1.getRow(rowNum).getCell(0).toString();
            String capital = sheet1.getRow(rowNum).getCell(1).toString();
            countryCapitals.put(county, capital); //put() verileri Map'e eklemek icin.
//       countryCapitals.put(sheet1.getRow(rowNum).getCell(0).toString(),sheet1.getRow(rowNum).getCell(1).toString());
        }
        System.out.println(countryCapitals);
    }
}
