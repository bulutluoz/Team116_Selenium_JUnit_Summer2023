package tests.day12_screenshot_jsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_WebElementScreenshot extends TestBase {

    @Test
    public void test01(){

        // google'a gidelim
        driver.get("https://www.google.com");

        // cikiyorsa cookies reddedin

        driver.findElement(By.xpath("//*[text()='Reject all']")).click();
        // nutella aratalim

        WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@name='q']"));
        aramaKutusu.sendKeys("Nutella");
        aramaKutusu.submit();

        // arama sonuc sayisinin screenshot'ini alalim
        WebElement aramaSonucElementi = driver.findElement(By.xpath("//div[@id='result-stats']"));

        ReusableMethods.webElementFotoCek(driver,aramaSonucElementi);


    }
}
