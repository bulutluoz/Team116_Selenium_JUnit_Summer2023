package tests.day10_waits_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C03_WebTables extends TestBase {

    @Test
    public void test01(){
        //1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        bekle(2);
        //3.Web table tum body’sini yazdirin
        WebElement tumBodyElementi = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBodyElementi.getText());
        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody/tr"));

        int expectedSatirSayisi = 9 ;
        int actualSatirSayisi=satirlarListesi.size();
        Assert.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        //5.Tum satirlari yazdirin

        System.out.println("=================");

        int satirNo = 1;
        for (WebElement eachSatir: satirlarListesi
             ) {
            System.out.println(satirNo + " - "+ eachSatir.getText());
            satirNo++;
        }
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> besinciSatirDatalariList=
                driver.findElements(By.xpath("//tbody/tr[5]/td"));

        int expectedSutunSayisi= 13;
        int actualSutunSayisi= besinciSatirDatalariList.size();
        Assert.assertEquals(expectedSutunSayisi,actualSutunSayisi);

        //7. 5.sutunu yazdirin
        List<WebElement> besinciSutunElementleriList =
                driver.findElements(By.xpath("//tbody/tr/td[5]"));
        System.out.println("======5.Sutun=======");
        for (WebElement eachData: besinciSutunElementleriList
             ) {
            System.out.println(eachData.getText());
        }
        //8.Satir ve sutun sayisini parametre olarak alip,
        //  hucredeki bilgiyi döndüren bir method olusturun
        System.out.println("=======istenen hucredeki yazi=======");
        System.out.println(ReusableMethods.hucredekiYaziyiGetir(5, 5, driver));


    }


}
