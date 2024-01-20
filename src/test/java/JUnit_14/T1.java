package JUnit_14;

import Methods.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class T1 extends TestBase {
    @Test
    public void test01(){
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2. "Hover over Me First" kutusunun ustune gelin
        WebElement hoverBox= driver.findElement(By.xpath("(//*[@*='dropbtn'])[1]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(hoverBox).perform();
        //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@class='list-alert'])[1]")).click();
        //4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6. "Click and hold" kutusuna basili tutun
        WebElement clickAndHoldElement= driver.findElement(By.xpath("//p[text()='Click and Hold!']"));
        actions.clickAndHold(clickAndHoldElement).perform();
        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement clickText= driver.findElement(By.xpath("//div[@id='click-box']"));
        System.out.println(clickText.getText());
        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickMe= driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClickMe).perform();
    }
}
