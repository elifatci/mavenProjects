package JUnit_7;

import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class T5 extends TestBase {
    @Test
    public void test01(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.

        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text= driver.findElement(By.tagName("h3"));
        String expectedText="Opening a new window";
        String actualText=text.getText();
        Assert.assertEquals(expectedText,actualText);
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle="The Internet";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        String ilkSayfaWHD=driver.getWindowHandle();
        Set<String> whdSeti= driver.getWindowHandles();
        String ikinciSayfaWHD="";
        for (String each:whdSeti) {
            if (!each.equals(ilkSayfaWHD)){
                ikinciSayfaWHD=each;
            }
        }

        driver.switchTo().window(ikinciSayfaWHD);

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu
        //dogrulayin.
        String expectedTtle="New Window";
        String actualTle= driver.getTitle();
        Assert.assertEquals(expectedTtle,actualTle);
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement windowText=driver.findElement(By.tagName("h3"));
        String expectedWindowText="New Window";
        String actualWindowText=windowText.getText();
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”
        //olduğunu doğrulayın
        driver.switchTo().window(ilkSayfaWHD);
       expectedTitle="The Internet";
       actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
