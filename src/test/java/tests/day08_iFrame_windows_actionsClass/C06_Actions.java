package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_Actions extends TestBase {

    @Test
    public void test01(){

        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement tasinacakElement = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement hedefAlan = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Actions actions = new Actions(driver);

        actions.dragAndDrop(tasinacakElement,hedefAlan).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        WebElement droppedYaziElementi = driver.findElement(By.xpath("//p[text()='Dropped!']"));

        String expectedYazi = "Dropped!";
        String actualYazi = droppedYaziElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);
    }
}
