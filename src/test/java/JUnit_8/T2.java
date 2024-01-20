package JUnit_8;

import Methods.ReusableMethods;
import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class T2 extends TestBase {
    @Test
    public void test01(){
        //1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String ilkSayfaHandle= driver.getWindowHandle();
        //3- Cizili alan uzerinde sag click yapin
        WebElement ciziliAlanElementi= driver.findElement(By.cssSelector("#hot-spot"));
        Actions actions=new Actions(driver);
        actions.contextClick(ciziliAlanElementi).perform();
        ReusableMethods.Wait(3);
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlert="You selected a context menu";
        String actualAlert=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlert,actualAlert);
        //5- Tamam diyerek alert’i kapatalim
        ReusableMethods.Wait(2);
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        ReusableMethods.Wait(2);
        driver.findElement(By.linkText("Elemental Selenium")).click();
        Set<String> handleSet=driver.getWindowHandles();
        for (String each:handleSet) {
            if (!each.equals(ilkSayfaHandle)){
                driver.switchTo().window(each);
            }
        }
        //7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim

        ReusableMethods.Wait(5);
        WebElement tagText= driver.findElement(By.tagName("h1"));
        String expecetedText="Make sure your code lands";
        String actualText=tagText.getText();
        Assert.assertEquals(expecetedText,actualText);
    }
}
