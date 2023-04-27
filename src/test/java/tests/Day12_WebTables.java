package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Day12_WebTables extends TestBase {
    /*
    https://the-internet.herokuapp.com/tables
Create a class: WebTables
Task 1 : Print the entire table
Task 2 : Print All Rows
Task 3 : Print Last row data only
Task 4 : Print column 5 data in the table body
Task 5 : Write a method that accepts 2 parameters
Parameter 1 = row number
Parameter 2 = column number
printData(2,3); => prints data in 2nd row 3rd column
     */
    private static Logger logger = (Logger) LogManager.getLogger(Day12_WebTables.class.getName());
    //(Logger) casting yaptık
    @Test
    public void printTableData(){
        logger.info("Going to the home page");

        driver.get("https://the-internet.herokuapp.com/tables");
//        Task 1 : Print the entire table
        System.out.println("PRINT ENTIRE TABLE***");
        logger.info("Printing the webtable information");
        //1.(butun rowlar bir arada goruruz)yani tabloyu butun halınde aldık: //table[@id='table1']")).getText();
        String entireTable = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println(entireTable);

        //2.way(her rowdaki bilgiyi daha rahat goruruz)
        List<WebElement> allTableElements = driver.findElements(By.xpath("//table[@id='table1']//td"));
//lambda:  allTableElements.forEach(t-> System.out.println(t.getText()));
        for (WebElement eachElement : allTableElements){
            System.out.println(eachElement.getText());
//            logger.info(eachElement.getText());
        }
//        We can get specific cell data(spesifik bir datayı almak istersek 2.yontem kullanmak daha uygun)
        System.out.println("5th DATA in the table "+allTableElements.get(5).getText());
    }

    @Test
    public void printRows(){
        //        Task 2 : Print All Rows
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
//lambda:        allRows.forEach(t-> System.out.println(t.getText()));
        int rowNum=1;
        for (WebElement eachRow:allRows){
            System.out.println("Row "+rowNum+" => "+eachRow.getText());
            rowNum++;
        }
//        We can get specific row data
        System.out.println("5th Row Data : "+allRows.get(4).getText());
//        Task 3 : Print Last row data only
        System.out.println("Last Row Data : "+allRows.get(allRows.size()-1).getText());
 /*
    // 3.Row datalarını print et
     driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> ucuncuRows = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[3]//td"));
//lambda:        ucuncuRows.forEach(t-> System.out.println(t.getText()));

  */
    }

//       son row daki datalari print edin   // last() son row'u almak icin xpath icinde kullanabiliriz
    @Test
    public void sonSatirVerileri(){
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> sonSatir = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[last()]//td"));
        sonSatir.forEach(veri-> System.out.println(veri.getText()));
    }
    @Test


    public void printColumns(){
        driver.get("https://the-internet.herokuapp.com/tables");
        //        Task 4 : Print column 5 data in the table body
        List<WebElement> col5Data = driver.findElements(By.xpath("//table[@id='table1']//tr//td[5]"));
        int colNum =1;
        for (WebElement eachData : col5Data){
            System.out.println("Row "+colNum+" Column 5 => "+eachData.getText());
            colNum++;
        }
    }
    //        HOMEWORK
//        Task 5 : Write a method that accepts 2 parameters
//        Parameter 1 = row number
//        Parameter 2 = column number
//        printData(2,3);  => prints data in 2nd row 3rd column
    public void printData(int rowNum, int colNum){ //reusable method olusturduk,ama bu table icin gecerli.
//   String xpath = "//table[@id='table1']//tbody//tr[1]//td[2]"; //concatination yaparak row ve column'ları dinamic yapıyoruz
        String xpath = "//table[@id='table1']//tbody//tr["+rowNum+"]//td["+colNum+"]";
    }
    @Test
    public void printDataTest(){
        printData(2,3);//fbach@yahoo.com
        printData(4,1);//Conway
    }
}