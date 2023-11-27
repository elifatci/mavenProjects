package JUnit_6;

import Methods.ReusableMethods;
import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class T3 extends TestBase {
    @Test
    public void dropdownTest() {

        // https://the-internet.herokuapp.com/dropdown adresine gidin.

        driver.get("https://the-internet.herokuapp.com/dropdown");
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement selection = driver.findElement(By.id("dropdown"));
        Select select = new Select(selection);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> optionList = select.getOptions();
        System.out.println(ReusableMethods.strListeOlustur(optionList));
        //5. Dropdown’un boyutunun 3 olduğunu test edin
        Assert.assertEquals(3, optionList.size());
    }

}
