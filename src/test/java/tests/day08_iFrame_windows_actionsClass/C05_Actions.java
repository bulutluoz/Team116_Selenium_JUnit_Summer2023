package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;
import utilities.TestBaseQuit;

public class C05_Actions extends TestBaseQuit {

    @Test
    public void test01(){

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapin
        Actions actions = new Actions(driver);
        WebElement ciziliAlanElementi = driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlanElementi).perform();
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.

        String expectedAlertYazisi = "You selected a context menu";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        bekle(2);
        //5- Tamam diyerek alert’i kapatalim

        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaWHD = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        //7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim

        String ikinciSayfaWHD = ReusableMethods.ikinciSayfaWHD(ilkSayfaWHD,driver);

        driver.switchTo().window(ikinciSayfaWHD);

        WebElement yaziElementi = driver.findElement(By.tagName("h1"));

        String expectedYazi = "Make sure your code lands";
        String actualYazi = yaziElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);
        bekle(3);
    }
}
