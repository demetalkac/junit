package tests;

import org.junit.Assert;
import org.junit.Test;

public class Day03_Assertions {

    /*
    3 tane assertion method var,bunları daha cok kullanacagız :assertEquals(),assertTrue(),assertFalse()
    assertFalse() cok kullanılmaz.
    *assertEquals(),assertTrue(),assertFalse(), bunları kullanarak assertion yaptıgımızda hard assertion yapmıs oluruz,
    cunku sonuc eger fail ise test execution stop(yani test durur ve devam etmez).Mesela; Assert.assertEquals(1,5);
    sonucu fail olur ve diger essertionlar calısmaz. Bunun yerine if-else daha kullanıslı.

     */
    @Test
    public void assertions(){
     /*
       What is assertion in testing? (Testte iddia nedir?)
     Assertion is done to check if expected result is equal to actual result.
     (İddia, beklenen sonucun gerçek sonuca eşit olup olmadığını kontrol etmek için yapılır.)
     -expected == actual -> pass
     -expected != actual -> fail
    ------------------
    assertEquals("expected","actual");
    assertTrue(true); -> pass
    assertTrue(false); -> fail
    assertFalse(false); -> pass
    assertFalse(true); -> fail
      */
        Assert.assertEquals(5,5); //pass
       // Assert.assertEquals("Values did not mach",3,5); //fail -->basına mesaj yazabiliriz.
       // if you enter 3 diff values then java will think you are firstly sending assertion msg and then assigning values

        if ("Java".contains("apple")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        Assert.assertEquals("java","java");
        Assert.assertEquals("java".contains("j"),true);//java contains j-->true   true&&true  -->pass
//     ----------------------------------
        Assert.assertTrue("java".contains("j")); //assertTrue & "java".contains("j")=true,pass

//        -----------------------------
        Assert.assertFalse("Java".contains("j")); //assertFalse & "Java".contains("j")==>false --true,pass

 //        HARD ASSERTIOS: TEST EXECUTION STOPS IF ONE THE ASSERTION FAILS. THIS IS CALLED HARD ASSERTIOS
        //BİR ASSERTION BAŞARISIZ OLURSA TEST YÜRÜTME DURUR. BUNA HARD ASSERTIOS Denir
//        VERIFICATION: TEST EXECUTION CONTINUES EVEN IF TEST VERRIFICATION FAILS. VERIFICATION MEANS LIKE IF STATEMENT
        // TEST DOĞRULAMA BAŞARISIZ OLSA BİLE TEST YÜRÜTME DEVAM EDER. DOĞRULAMA, IF BEYANI GİBİ DEMEKTİR

//        What is difference between Assertion and Verification?
//        Assertion stops after assertion fails. Verification continues even after verification fails
        // Assertion başarısız olduktan sonra assertion durur.Verification başarısız olduktan sonra bile verification devam eder
//        Junit assertions are hard assertion. If statement is verification
        // Junit assertions  zor assertions . If statement is verification
//        NOTE: TestNG has soft assertion as well. We will learn it in TestNG
        // NOT: TestNG'nin de soft assertion vardır. TestNG'de öğreneceğiz

/*
String name = "John";
        assertTrue(name.contains("J"));
        assertFalse(name.contains("A"));
 */
    }
}
