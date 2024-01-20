package JUnit_11;

import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class T4 extends TestBase {
    @Test
    public void test01(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        //1- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //2- video’yu gorecek kadar asagi inin
        WebElement iframeElement= driver.findElement(By.xpath("(//iframe)[1]"));
        js.executeScript("arguments[0].scrollIntoView(true);", iframeElement);
        //3- videoyu izlemek icin Play tusuna basin
        driver.switchTo().frame(iframeElement);
        WebElement playButton=driver.findElement(By.xpath("//button[@title='Oynat']"));
        playButton.click();

    }
}
