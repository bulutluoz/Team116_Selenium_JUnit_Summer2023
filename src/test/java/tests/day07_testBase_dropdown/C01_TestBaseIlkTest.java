package tests.day07_testBase_dropdown;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseIlkTest extends TestBase {


    // Bir class'in test class'i olarak kullanilabilmesi icin
    // oncelikle WebDriver ayarlarinin yapilmasi ve obje olusturulmasi gerekir
    // Java OOP consept cercevesinde WebDriver objesinin illa da bu class'da olmasi
    // Baska class'daki ozellikleri sahiplenmenin en kolay yolu o class'i parent edinmektir.

    @Test
    public void test01()  {

        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        bekle(3);
    }

}
