package my_notes;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Methodlar {
    public static void main(String[] args) {
       // WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
 //                     ----"get" METHODLARI-----
        //1- driver.get("url")-->yazdıgımız url'ye gider
        driver.get("https://www.amazon.com");

        //2- driver.getTitle() -->icinde oldugu sayfanın baslıgını dondurur
        driver.getTitle();//bunu ya String icine atmalıyız, ya da yazdırmalıyız(sout)
        System.out.println("sayfa title"+driver.getTitle());//Amazon.com.Spend less.Smile more.

        //3- driver.getCurrentUrl() -->icinde oldugu sayfanın URL'ini dondurur
        System.out.println(driver.getCurrentUrl()); // https://www.amazon.com/

        //4- driver.getPageSource()-->icinde oldugu sayfanın kaynak kodlarını(html codlarını) dondurur
        System.out.println(driver.getPageSource());// arka planda calısan sayfakodlarını yazdırır

       // NOT:Sayfanın HTML codlarını nasıl görebiliriz?
        // - istedigimiz sayfaya browser ile baglan => sayfada bos olan(image'lerin istünde degil) da sag tıkla
        // => "View Page Source"a tıklayınca html codlarını görürüz.

        //5- driver.getWindowHandle()-->icinde oldugu sayfanın UNIQUE hash kodunu verir
        System.out.println(driver.getWindowHandle()); //CDwindow-FTJKLSKJSIYERJM5749WFJKNFJ57
        //BU GELEN KOD HER DEFASINDA FARKLI GELIR.Biz bu hash degerlerini bir Stringe atayıp pencereler arası gecis yapabilirz

        //6-driver.getWindowHandles() -->driver calısırken acılan tum sayfaların UNIQUE hash kodunu getırır

 //NOT1:SAYFAYI CALISTIRINCA SAYFANIN KAYNAK KODLARINI GORMEK ISTERSEK SAYFA ACIKKEN "Ctrl +U" TUSLARINA BASARAK YAPABILIRIZ
 //     YANI HTML KODLARINI GETIRIR.

//           ------ driver.navigate() METHODLARI------------
        //1- driver.navigate().to("url") -->methodu istenen url'i getirir. driver.get("url") methodu ile aynı islemi yapar.
        //   Fakat bu method forward ve back yapılabilmesine imkan saglar,yani bir onceki sayfaya,tekrar bi sonraki sayfaya gidip gelmeyi saglar.
        driver.get("https://www.amazon.com");
        driver.navigate().to("https://www.facebook.com");

        //2- driver.navigate().back(); -->bir onceki sayfaya donus yapar
        driver.navigate().back(); //burdaki ornege gore amazona geri doner

        //3- driver.navigate().forward(); -->bir sonrası sayfaya donus yapar
        driver.navigate().forward(); //burdaki ornege gore facebook'a geri doner

        //4- driver.navigate().refresh(); -->icinde oldugu sayfayı yeniler
        driver.navigate().refresh();


        //driver olusturuldugunda acılan sayfayı kapatmak istersek kullanıyoruz
        driver.close();

        //driver calısırken birden fazla tab veya window actıysa tumunu kapatmak icin kullanılır
        driver.quit();


     //                ------------"driver.manage"  Methodları --------------

          //1- driver.manage().window() methodları
         //1a-driver.manage().window().getSize(); --> icinde oldugu sayfanın pixel olarak ölculerini dondurur, yani sayfanın boyutlarını verir
        System.out.println(driver.manage().window().getSize()); //(1050,832) pixel
        System.out.println(driver.manage().window().getSize().height); //832 (yukseklıkve en ayarlaması ıcınde method var)

        //1b- driver.manage().window().getPosition() --> icinde oldugu sayfanın pixel olarak konumunu dondurur,yani sayfanın konumunu verir
        // selenium driver methodları bize sayfanın sol-alt kosesinden baslar acılan sayfanın ,saga ve yukarıya dogru sayfanın ne kadar pixel oldugunu verır

        System.out.println(driver.manage().window().getPosition() ); //ornegin (10, 10)

        //1c- driver.manage().window().setPosition(new Point(15,15)) --> biz istedigimiz pixel degerini girersek set onunun atamasını yapar
        //icinde oldugu sayfanın sol alt kosesini bizim yazacagımız pixel noktasına tasir.
        // (new Point(15,15))-->icine "new Point" yazmalıyız,yani bunun yeni bir point oldugunu ostermis oluruz.
        driver.manage().window().setPosition(new Point(15,15));

        //1d- driver.manage().window().setSize(new Dimansion(900,600)) -->
        //icinde oldugu sayfanın sol alt kosesini sabit olarak bizim yazacagımız olculere getirir.
        //boyutunu da degistirebiliriz orn:setSize(new Dimansion(900,600))
        driver.manage().window().setSize(new Dimension(900,600));

        //konumu ve boyutu yeniledikten sonra tekrar calıstırırsak
        System.out.println("yeni pencere olculeri :"+driver.manage().window().getSize()); //(900, 600)
        System.out.println("yeni pencere konumu :"+driver.manage().window().getPosition()); // (15, 15)

        //1e- driver.manage().window().maximize();--> icinde oldugu sayfayı maximize yapar
        //1f- driver.manage().window().fullscreen();--> icinde oldugu sayfayı fullscreen yapar

        //farklarını gormek icin bu methodlerı kullanıp,baslangıc noktalarını ve boyutlarını yazdıralım
        driver.manage().window().maximize();
        System.out.println("maximize konum :"+driver.manage().window().getPosition()); // (-8,-8)
        System.out.println("maximize boyutu :"+driver.manage().window().getSize());  // (1616, 868)

        driver.manage().window().fullscreen();
        System.out.println("fullscreen konum :"+driver.manage().window().getPosition()); // (0, 0)
        System.out.println("fullscreen boyutu :"+driver.manage().window().getSize()); // (1600, 900)


        //1g- driver.manage().window().minimize();--> sayfayı simge durumunda kucultur
        driver.manage().window().minimize();

        //2- driver.manage().timeouts() methodları

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
        implicitlyWait : driver'a sayfanın yuklenmesi ve kullanacagimiz web elementlerinin bulunması icin
                         bekleyecegi maximum sureyi belirtir.
                       driver bu sure icerisinde sayfa yuklenir/web elemanları bulunursa
                       beklemeden calısmaya devam eder.
                       Belirtilen sure bittigi halde sayfa yuklenmemis/web elementleri bulunamamıssa
                       exception vererk calısmayı durdurur.

         Duration.ofSeconds(15) : Duration class'i Selenium-4 ile gelen zman classıdır.
                                  Driverin ne kadar bekleyecegini soyler.
                                  ofSeconds(15) yerine milis,minutes, horas da kullanılabilir.
         */
        /*
        HER CLASS'IN BASINDA BU DORT SEYI YAPMALIYIZ:
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        NOT:Driverin istedigimiz islemleri yaparken sorunla karsılasmaması icin
            maximize() ve  implicitlyWait() methodlarını her testte kullanılması faydalı olur.
         */
 //                ---------WEB ELEMENTLERI METODLARI-----------

         //amazoda arama kutusunu test ediyoruz burdakı methodları kullanarak:
        // driver.findElement(By.LOCATOR) -->Bir WebElement olusturup bu methodu kullanarak locate ederiz.
        WebElement elemetId = driver.findElement(By.id("ıdBurayaYapıstır"));

        // sendKeys() --> Arama kutusuna "Nutella" yazısını gonderır.Yani bu method istedigimiz elemente istedigimiz yazıyı gonderir
        elemetId.sendKeys("Nutella");

        // elemetId.submit(); -->Web element ile islem yaparken Enter tusuna basmıs gibi aramayı baslatir, yani "enter" gorevi gorur.
        elemetId.submit();

        //webElement.sentKeys("metin" + Keys.ENTER); İSTEDİGİMİZ METNİ YOLLAYIP,SONRA ENTER'A BASAR

        // getText()-->arama cubuguna yazılan yazıyı bize dondurur.
        WebElement sonucYazısıEl =driver.findElement(By.xpath("//div[@class='a-section ......']"));
        System.out.println(sonucYazısıEl.getText()); //Sonuc yazısı webElementi uzerindeki yazıyı bize dondurur.

        //webElement.getAttribute("Att.ismi");-->ismi girilen attrubute'un degerini getirir

        //webElement.getTagName(); web elementinin tag ismini getirir

        //webElement.isEnable(); Web elementi erisilebilir ise true yoksa false doner

        //webElement.isDisplayed(); Web elementi gorunur ise true yoksa false doner

        //webElement.isSelected(); Web elementi secili ise true yoksa false doner






    }
}
