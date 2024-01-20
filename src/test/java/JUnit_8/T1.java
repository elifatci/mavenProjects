package JUnit_8;

import Methods.ReusableMethods;
import Methods.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T1 extends TestBase {

    @Test
    public void test01(){
        //● https://testotomasyonu.com/addremove/ adresine gidin.

        driver.get("https://testotomasyonu.com/addremove/");
        String WHD=driver.getWindowHandle();

        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        WebElement text= driver.findElement(By.tagName("h2"));
        String expectedText="Add/Remove Elements";
        String actualText=text.getText();
        Assert.assertEquals(expectedText,actualText);

        //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        String expectedTitle="Test Otomasyonu";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        //● ’Please click for Electronics Products’ linkine tiklayin.
        driver.findElement(By.linkText("Electronics Products")).click();

        //● Electronics sayfasinin acildigini test edin

        driver=ReusableMethods.titleVerilenSayfayaGider(driver,"Test Otomasyonu - Electronics");

        ReusableMethods.Wait(3);

        //● Bulunan urun sayisinin 16 olduğunu test edin
       WebElement result=driver.findElement(By.className("product-count-text"));
       int expectedResult=16;
       String actual=result.getText().replaceAll("\\D","");
       int actualResult=Integer.parseInt(actual);
       Assert.assertEquals(expectedResult,actualResult);

       ReusableMethods.Wait(3);
        //● Ilk actiginiz addremove sayfasina donun
        driver.switchTo().window(WHD);

        ReusableMethods.Wait(3);
        //● Url’in addremove icerdigini test edin
        String expectedUrl="addremove";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        ReusableMethods.Wait(4);



    }
}
