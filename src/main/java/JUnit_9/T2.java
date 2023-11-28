package JUnit_9;

import Methods.ReusableMethods;
import Methods.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class T2 extends TestBase {
    @Test
    public void test01(){

        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2- Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hoverKutusu= driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(hoverKutusu).perform();
        ReusableMethods.Wait(3);
        //3- Link 1" e tiklayin
        WebElement link1Kutusu= driver.findElement(By.xpath("(//a[@class='list-alert'])[1]"));
        ReusableMethods.Wait(4);
        actions.click(link1Kutusu).perform();
        //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHoldKutusu= driver.findElement(By.xpath("//p[text()='Click and Hold!']"));
        actions.clickAndHold(clickAndHoldKutusu).perform();
        ReusableMethods.Wait(5);
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement textElement= driver.findElement(By.xpath("//div[text()='Well done! keep holding that click now.....']"));
        System.out.println(textElement.getText());
        //8- “Double click me" butonunu cift tiklay
        WebElement doubleClick=driver.findElement(By.id("double-click"));
        actions.doubleClick().perform();
        ReusableMethods.Wait(6);
    }
}
