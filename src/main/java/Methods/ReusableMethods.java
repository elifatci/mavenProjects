package Methods;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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
}
