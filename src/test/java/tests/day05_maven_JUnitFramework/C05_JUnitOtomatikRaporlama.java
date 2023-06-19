package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_JUnitOtomatikRaporlama {

    /*
        Junit framework'unde
        bir class veya test method'u calistirildiginda
        JUnit tum class veya istenen method'un
        sorunsuz olarak sonuna kadar calisip calismadigini kontrol eder

        - sorunsuz calisirsa test PASSED
        - kodlar sorun ciktigi icin calistirilamazsa test FAILED
        olarak isaretlenir

        Eger if-else ile yaptigimiz testlerde
        JUnit'in raporlarinin da test sonuclari ile uyumlu olmasini isterseniz
        FAILED durumlarinda throw keyword ile herhangi bir exception olustuttabiliriz.
     */

    @Test
    public void amazonTesti(){
        // amazon'a gidelim ve url'in amazon icerdigini test edip
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
}
