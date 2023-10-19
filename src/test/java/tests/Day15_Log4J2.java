package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
   /*
   System.out.println()konsola birseyler yazdırmak icin kullanıyoruz. LOG4J de System.out.println()ne benzer
  NOT: log4j'i devoloperlar ekler projeye, testerlar degil.
   - Dependencies leri ekliyoruz: 2 tane
   -Create Logger object:
public static Logger logger = LogManager.getLogger(Day15_Log4J2.class.getName());
    Logger class bir cok cesidi var. Biz  "org.apache.logging.log4j.Logger;"den import ediyoruz, cünkü apache'nın dependencies'lerini kullandık
    "LogManager." de "org.apache.logging.log4j.LogManager;"den import ediyoruz.
    -Use logger object to log/print information
        logger.fatal("Fatal Log !!!");....
    -Log4j configuration file ekleme:
        1. Create a resources folder in the project level
        2. Create a folder in project level : resources
         Resources sag tık =>new => file :name: log4j2.xml

        3. Create a log file under resources : log4j2.xml
          log4j2.xml sag tıkla =>Mark drectory as => test resources rood

        4. Add configuration in the file: https://logging.apache.org/log4j/2.x/manual/configuration.html 1.

    */


public class Day15_Log4J2 {
//  Create object

    public static Logger logger = LogManager.getLogger(Day15_Log4J2.class.getName());

    @Test
    public void log4jTest(){
//     Use logger object to log/print information
        logger.fatal("Fatal Log !!!");
        logger.error("Error Log !!!");
        logger.warn("Warm Log !!!");
        logger.debug("Debug Log !!!");
        logger.info("Info Log !!!");

        //not: ilk calıstırınca ilk 2'sini(fatal,error) konsolda görürüz.
    }
}

