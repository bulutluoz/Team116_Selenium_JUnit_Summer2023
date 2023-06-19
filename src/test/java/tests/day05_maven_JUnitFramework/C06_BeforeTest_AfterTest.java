package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_BeforeTest_AfterTest {

    /*
        Bir class'in icinde birden fazla test method'u varsa
        hepsi bagimsiz olarak da calistirilabilsin diye
        her method'a mahserin 4 atlisini eklememiz gerekir

        Ancak bu islem test method'larini gereksiz uzatir.

        Bunun yerine bir setup method'u olusturup
        ilgili ayarlari setup method'unda yapip
        test method'larinda SADECE teste odaklanabiliriz

        Bu yontemde scope'dan kaynaklanan bir sorun olusur

        Eger WebDriver objesini setup method'unda olusturursaniz
        diger test method'larindan kullanamazsiniz.
        Bunun yerine WebDriver driver'i class level'da olusturup
        setup method'unda sadece deger atamasi yapiyoruz.

     */

    WebDriver driver;


    @Test
    public void amazonTesti(){
        // amazon'a gidelim ve url'in amazon icerdigini test edip
        setup();
        driver.get("https://www.amazon.com");

        String expectedUrlIcerik="Ramazon";
        String actualUrl= driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Amazon url testi PASSED");
        }else {
            System.out.println("Amazon url testi FAILED");
            throw new RuntimeException();
        }

        // sayfayi kapatin
        driver.close();
    }

    @Test
    public void wisequarterTesti(){

        // Wise quarter anasayfaya gidip
        setup();

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
        // ve sayfayi kapatin
        driver.close();
    }

    @Test
    public void youtubeTesti(){
        // youtube anasayfaya gidin
        setup();
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
        driver.close();
    }

    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
}
