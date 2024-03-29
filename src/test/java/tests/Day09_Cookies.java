package tests;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class Day09_Cookies extends TestBase {
    /*
    Method: handleCookies
//        -Go to amazon  and automate the tasks:
//        1. Find the total number of cookies
//        2. Print all the cookies
//        3. Get the cookies by their name
//        4. Add new cookie
//        5. Delete cookie by name
//        6. Delete all of the cookies
     */
   /*
    Cookies are temporary data/files that is generated by the browsers.
    It's a way for a website to remember you, your preferences, and your habits online.
    Çerezler, tarayıcılar tarafından oluşturulan geçici veriler/dosyalardır.
     Bir web sitesinin sizi, tercihlerinizi ve çevrimiçi alışkanlıklarınızı hatırlamasının bir yolu.

    Cookies'leri  "driver.manage()." yani manage methodu ile alıyoruz.
    getCookies() methodu ile tüm cookieleri alıyoruz.getCookies() " Set<Cookie>" return eder.

     */
    @Test
    public void cookieTest() throws InterruptedException {
//        -Go to amazon  and automate the tasks:
        driver.get("https://www.amazon.com");
//        1. Find the total number of cookies
        Set<Cookie> allCookies = driver.manage().getCookies();  //<Cookie> 'i "selenium"dan import ediyoruz.
        int numOfCookies = allCookies.size();
        System.out.println("Number Of Cookies : "+numOfCookies);//Mine is 7
//        2. Print all the cookies
//        allCookies.stream().forEach(t-> System.out.println(t.getName())); //lambda ile yapımı
        for (Cookie eachCookie : allCookies){
            System.out.println("Cookie ==>>> "+eachCookie);  // tüm cookiesleri yazdırdk
            System.out.println("Cookie Value ===>>> "+eachCookie.getValue());
            System.out.println("Cookie Name ===>>> "+eachCookie.getName());
        }
    //NOT: For ile cookiesleri aldıktan sonra cookies'lerin bazı özelliklerinide alabiliriz:getValue(),getName())...
//        3. Get the cookies by their name-Çerezleri isimlerine göre alın
        System.out.println("Cookie Named : "+driver.manage().getCookieNamed("i18n-prefs"));//entering cookie name and getting the entire cookie
//                                                                                           çerez adını girme ve çerezin tamamını alma
//        4. Add new cookie
        Cookie cookie = new Cookie("my-fav-cookie","apple-pie"); //cookie olusturduk
        driver.manage().addCookie(cookie); //sayfaya yeni cookie ekledik
        Thread.sleep(2000);

//        System.out.println("Yeni Cookie Sayısı"+driver.manage().getCookies().size()); //cookie ekledikten sonra yeni sayıyı bu sekildede gorebiliriz (yeni bir "set<cookie>" konteynerina koymadan da)
        Set<Cookie> newCookies = driver.manage().getCookies();
        System.out.println("New Number Of Cookie ===>>> "+newCookies.size());//1 more than original number of cookie-Orijinal çerez sayısından 1 fazla
//        5. Delete cookie by name
        driver.manage().deleteCookieNamed("session-id");
        Thread.sleep(2000);
        int lastNumberOfCookies = driver.manage().getCookies().size();
        System.out.println("Last Number of Cookies ===>>> "+lastNumberOfCookies);
//        6. Delete all of the cookies
        driver.manage().deleteAllCookies();
        Thread.sleep(2000);
        int finalNumberOfCookies = driver.manage().getCookies().size();
        System.out.println("Final Number Of cookies ===>>> "+finalNumberOfCookies);
        // System.out.println("Number of cookies after delete all: "+driver.manage().getCookies().size());//0
        //direkt sout ,cine de yazabiliriz(int konteynırına almadan)
    }
}
