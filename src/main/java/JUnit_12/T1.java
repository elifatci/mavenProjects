package JUnit_12;

import Methods.ReusableMethods;
import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class T1 extends TestBase {

    @Test
    public void test01(){
        // https://trytestingthis.netlify.app/ adresine gidin
        // Url' den anasayfa' nin gorunurlugunu dogrulayin
        driver.get("https://trytestingthis.netlify.app/");
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("trytestingthis"));
        // "Your Sample Alert Button!" butonuna tiklayip "Iptal" e tiklayin
        driver.findElement(By.xpath("//button[@onclick='alertfunction()']")).click();
        ReusableMethods.Wait(3);
        driver.switchTo().alert().dismiss();
        // "You pressed the Cancel Button!" yazisinin görundugunu dogrulayin
        WebElement text= driver.findElement(By.xpath("(//p[@id='demo'])[1]"));
        String expectedText="You pressed the Cancel Button!";
        String actualText=text.getText();
        Assert.assertEquals(expectedText,actualText);
        // "Your Sample Alert Button!" butonuna tiklayip "Tamam" a tiklayin
        driver.findElement(By.xpath("//button[@onclick='alertfunction()']")).click();
        driver.switchTo().alert().accept();
        // "You Pressed the OK Button!" yazisinin görundugunu dogrulayin
       WebElement text2= driver.findElement(By.xpath("(//p[@id='demo'])[1]"));
       expectedText="You Pressed the OK Button!";
       actualText=text2.getText();
       Assert.assertEquals(expectedText,actualText);
        // This is your sample Double Click butonuna cift tıklayin
        Actions actions=new Actions(driver);
        WebElement doubleClickButton= driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        actions.doubleClick(doubleClickButton).perform();
        //      cift tiklandigini dogrulayin
        WebElement actualResult=driver.findElement(By.xpath("//p[text()='Your Sample Double Click worked!']"));
        Assert.assertTrue(actualResult.isDisplayed());

        //  Pizzayi pizza box icine surukleyip birakin
        WebElement pizzaBox= driver.findElement(By.id("drag1"));
        WebElement field= driver.findElement(By.id("div1"));
        actions.dragAndDrop(pizzaBox,field).perform();
    }

}
