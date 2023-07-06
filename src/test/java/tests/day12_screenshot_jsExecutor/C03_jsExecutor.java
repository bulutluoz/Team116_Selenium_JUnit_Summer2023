package tests.day12_screenshot_jsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_jsExecutor extends TestBase {

    @Test
    public void test01(){

       // wisequarter anasayfaya gidelim
        driver.get("https://www.wisequarter.com");

       // jsExecutor kullanarak contact linkini tiklayin

        WebElement contactLinkElementi= driver.findElement(By.xpath("//a[text()='Contact']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",contactLinkElementi);

        bekle(2);

        // anasayfaya geri donun
        // asagida bulunan “Go To Career Page” butonuna kadar asagi inin ve bu butona click yapin

        driver.navigate().back();
        bekle(1);
        WebElement goTocareerButonu= driver.findElement(By.xpath("//*[@class='fas fa-paper-plane']"));

        jse.executeScript("arguments[0].scrollIntoView(true);",goTocareerButonu);

        bekle(5);

        goTocareerButonu.click();

        jse.executeScript("alert('yasasinnnn');");

        bekle(3);

    }
}
