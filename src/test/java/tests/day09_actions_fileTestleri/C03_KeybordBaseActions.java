package tests.day09_actions_fileTestleri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_KeybordBaseActions extends TestBase {

    @Test
    public void test01(){
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        // tum alanlari tek tek locate etmek yerine,
        // Ad kutusunu locate edip sonrasini TAB tusuyla devam edelim

        Actions actions = new Actions(driver);
        WebElement adKutusu = driver.findElement(By.xpath("//input[@name='firstname']"));

        actions.click(adKutusu)
                .sendKeys("Yavuz")
                .sendKeys(Keys.TAB)
                .sendKeys("Rahman")
                .sendKeys(Keys.TAB)
                .sendKeys("asdfg@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("asdfg@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("1234567")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("5")
                .sendKeys(Keys.TAB)
                .sendKeys("Mar")
                .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .perform();
        bekle(3);
        //4- Kaydol tusuna basalim

        driver.findElement(By.xpath("//button[@name='websubmit']")).click();

        bekle(10);
    }
}
