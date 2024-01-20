package JUnit_13;

import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class T10 extends TestBase {
    @Test
    public void test01(){

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox= driver.findElement(By.xpath("//*[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());
        //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("(//*[@type='button'])[2]")).click();
        WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(textBox.isEnabled());
    }
}
