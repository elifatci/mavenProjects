package JUnit_18;

import Methods.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class T3 extends TestBase {

    @Test
    public void test01(){

        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2- Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hoverOver= driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
        actions.moveToElement(hoverOver).perform();
        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[text()='Link 1'])[1]")).click();
        //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndhold= driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndhold).perform();
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndhold.getText());

        //8- “Double click me" butonunu cift tiklayin
            WebElement doubleClick= driver.findElement(By.id("double-click"));
            actions.doubleClick(doubleClick).perform();

    }
}
