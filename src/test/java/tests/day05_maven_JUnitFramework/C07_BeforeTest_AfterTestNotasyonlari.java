package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_BeforeTest_AfterTestNotasyonlari {
    /*
        Junit ile class'daki her test method'u calismaya baslamadan once
        calismasini istedimiz method'lari
        @Before,
        her test method'undan sonra calismasini istedigimiz method'lari ise
        @After notasyonu ile isaretleriz

        Boylece test method'u calismaya baslarken
        ekstradan methodCall yapmaya gerek olmadan
        @Before Notasyonuna sahip method calisir

        test method'u bitince de hic bir method Call olmaksizin
        @After notasyonuna sahip method calisir

        BU class, class level'dan calistirildiginda
        class'daki method'lar toplam kac kere calismis oldu ?
        @Before
        amazon
        @After
        @Before
        wiseQuarter
        @After
        @Before
        youtube
        @After

        sadece youtube test method'unu calistirmak istesek
        @Before
        youtube
        @After

     */

    WebDriver driver;


    @Test
    public void amazonTesti(){
        // amazon'a gidelim ve url'in amazon icerdigini test edip
        driver.get("https://www.amazon.com");

        String expectedUrlIcerik="amazon";
        String actualUrl= driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Amazon url testi PASSED");
        }else {
            System.out.println("Amazon url testi FAILED");
            throw new RuntimeException();
        }
    }

    @Test
    public void wisequarterTesti(){

        // Wise quarter anasayfaya gidip
        driver.get("https://www.wisequarter.com");
        // Title'in Wise Quarter icerdigini test edin

        String expectedTitleIcerik = "Wise Quarter";
        String actualTitle= driver.getTitle();
        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Wise Quarter title testi PASSED" );
        }else{
            System.out.println("Wise Quarter title testi FAILED" );
            throw new RuntimeException();
        }
    }

    @Test
    public void youtubeTesti(){
        // youtube anasayfaya gidin
        driver.get("https://www.youtube.com");
        // title'in YouTube oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Youtube Testi PASSED");
        }else{
            System.out.println("Youtube Testi FAILED");
            throw new RuntimeException();
        }
    }

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){
        driver.close();
    }
}
