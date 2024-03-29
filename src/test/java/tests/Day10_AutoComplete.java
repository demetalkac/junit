package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day10_AutoComplete extends TestBase {
    /*

    Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
    When user type “uni” in the search box
    And select the ‘United Kingdom’ from the suggestions
    And click on submit button
    Then verify the result contains ‘United Kingdom’
    --
    xpath("//div[@id='myCountryautocomplete-list']//div[.='United Kingdom']"))--> “uni” yazınca birden fazla secenek
    cıkıyor.xpath'ini alırken genel id kullanıyoruz,sonra altında div'ler ile sıralanan ulkeler icinden hangisini
    sececegimizi belirtmek icin //div[.='United Kingdom']") bunu kullanarak ulke ismini yazıyoruz value kısmına.
   --
   Auto completw için: url git
    => locate’ini aldığın kutuya sendKeys() ile aramak istediğin yazıyı gönder.
    => ve o sekilde locate al, birçok seçenek oluğu için child div’ler olacak.
    O nedenle biz neyi arayacak isek onun bulunduğu div’i index ile değil(çünkü eklemcıkarma
    olabilir) value’sunu al. Ve click yap:
    driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='United Kingdom']")).click();

     */
    @Test
    public void autoCompleteTest(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
//      When user type “uni” in the search box
        driver.findElement(By.id("myCountry")).sendKeys("uni");


//    And select the ‘United Kingdom’ from the suggestions
    // //div[@id='myCountryautocomplete-list']//div[.='United Kingdom']") bunu parentten childa dogru div leri alıyoruz
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='United Kingdom']")).click();
//    And click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();

//    Then verify the result contains ‘United Kingdom’
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("United Kingdom"));


    }
    @Test
    public void autoCompleteTestWithReusableMethod() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
        searchAndSelectFromList("uni","United Kingdom"); //TEST CASE 1

        searchAndSelectFromList("an","Angola"); //TEST CASE 2

        searchAndSelectFromList("bah","Bahamas"); //TEST CASE 3
        searchAndSelectFromList("tur","Turkey");
    }
}
