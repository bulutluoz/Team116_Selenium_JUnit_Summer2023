package tests.day06_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Before_AfterClassNotasyonlari {

    /*
        Bir class'daki test method'lari birbiri ile baglantili ise
        birinin calisabilmesi icin onceki test method'un calismasi gerekiyorsa
        yani test method'lari bagimsiz olarak calistirilmayacaksa

        @BeforeClass ve @AfterClass notasyonlarini kullanabiliriz

        ANCAK,....
        bu notasyonlara sahip method'larin static olmasi gerekir


     */

    // Amazon anasayfaya gidin
    // 3 farkli test method'u olusturup, verilen testleri yapin
    // 1- url'in amazon icerdigini test edin
    // 2- Nutella arattirin ve sonuclarin nutella icerdigini test edin
    // 3- ilk urune click yapip, urun isminin Nutella icerdigini test edin
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        // 1- url'in amazon icerdigini test edin

        String expectedurlIcerik = "amazon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedurlIcerik)){
            System.out.println("Url testi PASSED");
        }else{
            System.out.println("Url testi FAILED");
            throw new RuntimeException();
        }

    }


    @Test
    public void test02(){
        // 2- Nutella arattirin ve sonuclarin Nutella icerdigini test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        WebElement sonucYaziElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String expectedIcerik ="Nutella";
        String actualYazi = sonucYaziElementi.getText();

        if (actualYazi.contains(expectedIcerik)){
            System.out.println("Nutella testi PASSED");
        }else {
            System.out.println("Nutella testi FAILED");
            throw new RuntimeException();
        }
    }

    @Test
    public void test03(){
        // 3- ilk urune click yapip, urun isminin Nutella icerdigini test edin
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

        WebElement urunIsimElementi= driver.findElement(By.xpath("//span[@id='productTitle']"));

        String expectedIcerik = "Nutella";
        String actualUrunIsmi= urunIsimElementi.getText();

        if(actualUrunIsmi.contains(expectedIcerik)){
            System.out.println("Urun isim testi PASSED");
        }else {
            System.out.println("Urun isim testi FAILED");
            throw new RuntimeException();
        }
    }

}
