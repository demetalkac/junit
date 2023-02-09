package tests.log4Jtests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


public class Day15_LogTests {
/*
- (Day15_LogTests.class.getName());->bu kısım bu sınıfa tanımlandıgını gösterir.
-"private" yaptık.  public de yapabiliriz ama sadece diger sınıflarda karısıklık olmasın diye
-"logger" objeye genelde bu isim verilir, farklı isimde kullanılabilir.

  1-Logger object olustur= private static Logger logger = LogManager.getLogger(Day15_LogTests.class.getName());
  2-Logger fonksiyonuyla istenilen fonksiyonu kullan (logger objecsi ,le yazdırma islemi yap)=logger.fatal("FATAL");
        logger.error("ERROR");
        logger.warn("WARNING")....
 */
   private static Logger logger = LogManager.getLogger(Day15_LogTests.class.getName());
    @Test
    public void test1(){
        logger.fatal("FATAL");//ölümcül
        logger.error("ERROR");
        logger.warn("WARNING"); //uyarı
        logger.debug("DEBUG"); //kod kaldıktan sonra ;neden kaldıgını anlamak icin
        logger.info("INFO");

    }
}
   /*
   NOT: Run yapınca console da default olanları goruruz:;logger.fatal("FATAL") ve logger.error("ERROR"); Cunku bunların
    seviyeleri var log4j bize bu ikisini verir sadece.Bunun icin bir ayar dosyası,xml dosyası olusturmalıyız.
   -Resources => proje isminin oldugu yerde(.idea yazanın ustunde) sag tıkla ->New drectory:"resources" adında bir
    dosya olusturduk -> onun altında da "log4j2.xml" adında bir file dosyası olusturduk -> icine hocanın verdigini yapıstırdk
   pom.xml gibİ,benzer bir dosya, log4j icin ayar dosyası bu.
    **"resources" ustunde bayrakları yapmak zorunlu.Bir kere yapınca sistem kendi yapıyor, yoksa bizim yapmamız gerekli.
    resources östunde sag click -> Mark Directory as ->Resources Root TEKRAR resources östunde sag click
    -> Mark Directory as ->Test Resources Root sec.(ilk yapınca test resources root cıkmaya biliyor, ikincide oluyor)
  -save yap
                       -log4j.xml icindekiler:
  -log4j.xml icindek,:  <Logger name="tests.log4Jtests" level="debug" additivity="false"> bu kısmın icindeki "level="debug" "
  yerde debug yerine ne yazarsak onun seviyesine kadar olanlrı print eder.
  Ornegin:<Logger name="tests.log4Jtests" level="info" additivity="false"> info'nun oldugu yere kadar print yapar konsolda:
           logger.fatal("FATAL");
            logger.error("ERROR");
            logger.warn("WARNING");
            logger.debug("DEBUG");
            logger.info("INFO");
     WARNING yazsak WARNING2e kadar olanı yazdırır altını yazdırmaz.
 -- "tests.log4Jtests" bu kısmınada ayar vermek istedigimiz dosyayı yazıyoruz.Yani "test"altında yer alan
*-<Property name="basePath">target/logs</Property> :"target"'ın altında "logs" dosyası olsun.
 -filePattern="${basePath}/LogRepor-%d{HH-mm-ss-SSS}.log"> :"LogRepor" bu ismi istedigimiz sekilde yazabiliriz. Ve su
 anlama geliyor :dosyam "LogRepor" ile baslasın tarih olsun ve sonunda "log" yazsın

 -BU dosyaları cift tıklayarak acabiliriz.

NOT: "resources" VE "log4j2.xml" yazarken dikkat etmeliyiz, harf hatası yapmamalıyız, bunlar özel isimlerdir.
    */
