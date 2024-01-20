package JUnit_8;

import Methods.ReusableMethods;
import Methods.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class T4 extends TestBase {
    @Test
    public void test01(){
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Cookies kabul edin
        //3- Yeni hesap olustur butonuna basalim
        ReusableMethods.Wait(4);

        driver.findElement(By.linkText("Yeni hesap oluştur")).click();
        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement ilkLocator= driver.findElement(By.name("firstname"));
        WebElement ikinciLocator= driver.findElement(By.name("lastname"));
        Actions actions=new Actions(driver);
        actions.click(ilkLocator)
                .sendKeys("elif")
                .click(ikinciLocator)
                .sendKeys("elif")
                .sendKeys(Keys.TAB)
                .sendKeys("ee@rf.com")
                .sendKeys(Keys.TAB)
                .sendKeys("ee@rf.com")
                .sendKeys(Keys.TAB)
                .sendKeys("19")
                .perform();
        WebElement ddm= driver.findElement(By.id("day"));
        WebElement monthElement=driver.findElement(By.id("month"));
        WebElement yearElement=driver.findElement(By.id("year"));
        Select select=new Select(ddm);
        select.selectByVisibleText("24");
        Select select1=new Select(monthElement);
        select1.selectByVisibleText("Eyl");
        Select select2=new Select(yearElement);
        select2.selectByVisibleText("1991");
        ReusableMethods.Wait(6);
        driver.findElement(By.xpath("(//label[@class='_58mt'])[1]")).click();
        //5- Kaydol tusuna basalim
        driver.findElement(By.name("websubmit")).click();
        ReusableMethods.Wait(4);
    }
}
