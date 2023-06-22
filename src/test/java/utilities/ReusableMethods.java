package utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class ReusableMethods {


    public static String ikinciSayfaWHD(String ilkSayfaWindowHandleDegeri, WebDriver driver){

        String ikinciSayfaWHD="";

        Set<String> windowHandlesSeti  = driver.getWindowHandles();

        for (String each: windowHandlesSeti
             ) {

            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWHD = each;
            }
        }


        return ikinciSayfaWHD;
    }
}
