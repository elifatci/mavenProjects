package JUnit_11;

import Methods.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class T3 extends TestBase {
    @Test
    public void test01(){
        //Yeni Class olusturun ActionsClassHomeWork
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverOver= driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(hoverOver).perform();

        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();
        //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHold= driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHold).perform();
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement text=driver.findElement(By.xpath("//div[@style='background: rgb(0, 255, 0); font-size: 30px;']"));
        System.out.println(text.getText());
        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClickButton= driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClickButton).perform();
    }
}
