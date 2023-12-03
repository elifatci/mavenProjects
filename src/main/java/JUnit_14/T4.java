package JUnit_14;

import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class T4 extends TestBase {
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
        String expecetedTitle="The Internet";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expecetedTitle,actualTitle);
        //● Click Here butonuna basın.
        String ilkSayfaHandle= driver.getWindowHandle();
        driver.findElement(By.partialLinkText("Here")).click();
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu
        //dogrulayin.
        Set<String> sayfaHandleList=driver.getWindowHandles();
        String ikinciSayfaHandle="";
        for (String each: sayfaHandleList) {
            if (!each.equals(ilkSayfaHandle)){
                ikinciSayfaHandle=each;
            }
        }
        driver.switchTo().window(ikinciSayfaHandle);
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement sayfaText= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(sayfaText.isDisplayed());
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”
        //olduğunu doğrulayın
        driver.switchTo().window(ilkSayfaHandle);
        String expectedSayfaTitle="The Internet";
        String actualSayfaTitle=driver.getTitle();
        Assert.assertEquals(expectedSayfaTitle,actualSayfaTitle);

    }
}
