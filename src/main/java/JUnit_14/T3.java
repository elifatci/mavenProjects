package JUnit_14;

import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class T3 extends TestBase {
    @Test
    public void test01(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        //2."Login Portal" a kadar asagi inin
        WebElement loginPortalElement= driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']"));
        js.executeScript("arguments[0].scrollIntoView(true);",loginPortalElement);
        String ilkSayfaHandle= driver.getWindowHandle();
        //3."Login Portal" a tiklayin
        js.executeScript("arguments[0].click();",loginPortalElement);
        //4.Diger window'a gecin
        Set<String> windowHandleList=driver.getWindowHandles();
        String ikinciSayfaHnadle="";
        for (String each:windowHandleList) {
            if(!each.equals(ilkSayfaHandle)){
                ikinciSayfaHnadle=each;
            }
        }
        driver.switchTo().window(ikinciSayfaHnadle);
        //5."username" ve "password" insularity deger yazdirin
        Actions actions=new Actions(driver);
        WebElement usernameElement= driver.findElement(By.id("text"));
        actions.click(usernameElement).sendKeys("username").sendKeys(Keys.TAB).sendKeys("password").perform();
        //6."login" butonuna basin
        driver.findElement(By.id("login-button")).click();
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedText="validation failed";
        String actualText=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedText,actualText);
        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkSayfaHandle);
        //10.Ilk sayfaya donuldugunu test edin
        String expectedTitle="WebDriverUniversity.com";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
