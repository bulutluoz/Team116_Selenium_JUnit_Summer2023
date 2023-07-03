package tests.day09_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions_moveToElement extends TestBase {

    @Test
    public void test01(){

        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //   mouse’u bu menunun ustune getirin

        Actions actions = new Actions(driver);
        WebElement accountListsElementi= driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));

        actions.moveToElement(accountListsElementi).perform();
        bekle(2);

        //3- “Create a list” butonuna basin
        WebElement createListElementi = driver.findElement(By.xpath("//span[text()='Create a List']"));
        createListElementi.click();
        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin

        WebElement yourListYaziElementi = driver.findElement(By.xpath("//div[@role='heading']"));

        Assert.assertTrue(yourListYaziElementi.isDisplayed());


        bekle(3);
    }
}
