package tests.day07_testBase_dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C02_DropdownMenu extends TestBase {

    @Test
    public void test01(){

        // Amazon anasayfaya gidin
            driver.get("https://www.amazon.com");
        // arama kutusunun yanindaki dropdown menude 28 secenek oldugunu test edin
            // dropdown menuyu locate et
        WebElement dropdownMenuElementi = driver.findElement(By.id("searchDropdownBox"));

            // Select class'indan bir obje olusturalim
        Select select = new Select(dropdownMenuElementi);

        int expectedOptionSayisi = 28;
        int actualOptionSayisi = select.getOptions().size();

        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);

        // dropdown menuden Baby kategorisini secin
        select.selectByVisibleText("Baby");

        // Arama kutusuna Nutella yazip aratin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // bulunan sonuc sayisinin 10'dan fazla oldugunu test edin
        String sonucYazisi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText();

        String sonucSayisiStr = sonucYazisi.substring(0,sonucYazisi.indexOf(" ")); //  "13"

        int sonucSayisiInt = Integer.parseInt(sonucSayisiStr); // int olarak 13

        Assert.assertTrue(sonucSayisiInt>10);


        // sectigimiz opsiyonu yazdirin
        /*
            Biz daha once dropdown menuyu locate etmis
            ve bu menuyu kullanarak select objesi olusturmustuk

            ANCAK
            arama yaptirdigimizda HTML kodlar yenilendigi icin
            eski elementleri BULAMAYABILIR
            bu durumda "stale element" / bayat element uyarisi verir

            Yapmamiz gereken :
            Yeniden obje olusturmak degil
            var olan objelere
            ayni degerleri tekrar atamaktir.
         */
        dropdownMenuElementi = driver.findElement(By.id("searchDropdownBox"));
        select = new Select(dropdownMenuElementi);

        System.out.println(select.getFirstSelectedOption().getText()); // Baby


        // sectigimiz opsiyon'un Baby oldugunu test edin

        String expectedSeciliOption = "Baby";
        String actualSeciliOption = select.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedSeciliOption,actualSeciliOption);

        bekle(3);
    }

}
