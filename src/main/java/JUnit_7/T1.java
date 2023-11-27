package JUnit_7;

import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class T1 extends TestBase {
    @Test
    public void test01() {
        //1. Test
        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //- 1.alert'e tiklayin
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        //- Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedYazi = "I am a JS Alert";
        String actualYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi, actualYazi);
        //- OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
    }

    @Test
    public void test02() {
        //2.Test
        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        //- Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();
        WebElement sonuc = driver.findElement(By.cssSelector("#result"));
        String expectedResult = "You clicked: Cancel";
        String actualResult = sonuc.getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test03() {
        //3.Test
        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        //- Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");
        //- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();
        //- Cikan sonuc yazisinin Abdullah icerdigini test edelim
        WebElement result = driver.findElement(By.cssSelector("#result"));
        String expected = "Abdullah";
        String actual = result.getText();
        Assert.assertTrue(actual.contains(expected));
    }
}
