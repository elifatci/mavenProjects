package JUnit_14;

import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class T2 extends TestBase {
    @Test
    public void test01(){

        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        //2. “Our Products” butonuna basin
        WebElement iframeElement= driver.findElement(By.id("frame"));
        driver.switchTo().frame(iframeElement);
        driver.findElement(By.xpath("//a[text()='Our Products']")).click();
        //3. “Cameras product”i tiklayin
        driver.findElement(By.id("camera-img")).click();
        //4. Popup mesajini yazdirin
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement popMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='modal-body']")));
        System.out.println(popMessage.getText());
        //5. “close” butonuna basin
        driver.findElement(By.xpath("//*[text()='Close']")).click();
        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[text()='WebdriverUniversity.com (IFrame)']")).click();
        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedUrl="index";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }
}
