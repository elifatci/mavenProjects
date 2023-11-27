package Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static List<String> strListeOlustur(List<WebElement> elementler){
        List<String> stringlerList=new ArrayList<>();
        for (WebElement each:elementler) {
            stringlerList.add(each.getText());
        }
        return stringlerList;
    }

    public static void Wait(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public static WebDriver titleVerilenSayfayaGider(WebDriver driver,String title){
        Set<String> handleListesi=driver.getWindowHandles();
        for (String each:handleListesi) {

            String sayfaTitle=driver.switchTo().window(each).getTitle();
            if (sayfaTitle.equals(title)){
                return driver;
            }
        }
        return null;
    }
}
