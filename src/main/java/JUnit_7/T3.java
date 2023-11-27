package JUnit_7;

import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class T3 extends TestBase {
    @Test
    public void iframeTest01(){
        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        //2 )- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
        //konsolda yazdirin.
        WebElement text=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(text.isEnabled());
        System.out.println(text.getText());
        //- Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframeElementi= driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElementi);
        WebElement textBox= driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya!");
        //- TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        //gorunur oldugunu dogrulayin ve konsolda yazdirin.
        driver.switchTo().defaultContent();
        WebElement linkText= driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkText.isDisplayed());
    }
}
