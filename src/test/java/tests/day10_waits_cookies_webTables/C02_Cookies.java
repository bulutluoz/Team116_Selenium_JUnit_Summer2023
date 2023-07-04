package tests.day10_waits_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C02_Cookies extends TestBase {

    @Test
    public void test01(){
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookiesSeti = driver.manage().getCookies();

        int siraNo=1;
        for (Cookie eachCookie: cookiesSeti
             ) {
            System.out.println(siraNo+" - "+eachCookie);
            siraNo++;
        }

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookiesSeti.size() > 5);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expectedValue = "USD";
        Assert.assertEquals(expectedValue,actualValue);
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun
        //   ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);

        System.out.println("=========");
        cookiesSeti = driver.manage().getCookies();
        siraNo=1;
        for (Cookie eachCookie: cookiesSeti
        ) {
            System.out.println(siraNo+" - "+eachCookie);
            siraNo++;
        }

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        actualValue = driver.manage().getCookieNamed("en sevdigim cookie").getValue();
        expectedValue = "cikolatali";
        Assert.assertEquals(expectedValue,actualValue);

        //7- ismi skin olan cookie’yi silin ve silindigini test edin

        driver.manage().deleteCookieNamed("skin");
        System.out.println("=========");
        cookiesSeti = driver.manage().getCookies();
        siraNo=1;
        for (Cookie eachCookie: cookiesSeti
        ) {
            System.out.println(siraNo+" - "+eachCookie);
            siraNo++;
        }


        // yok oldugunu test etmek icin tum cookie isimlerini kontrol edelim
        // bir flag kullanip, ismi skin olan varsa flag'i degistirelim

        boolean skinVarMi=false;

        cookiesSeti = driver.manage().getCookies();
        for (Cookie eachCookie: cookiesSeti
        ) {

            if (eachCookie.getName().equals("skin")){
                skinVarMi=true;
                break;
            }
        }

        Assert.assertFalse(skinVarMi);

        //8- tum cookie’leri silin ve silindigini test edin

        driver.manage().deleteAllCookies();
        cookiesSeti = driver.manage().getCookies();

        Assert.assertTrue(cookiesSeti.size() == 0);


        bekle(2);
    }
}
