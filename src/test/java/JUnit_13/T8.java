package JUnit_13;

import Methods.ReusableMethods;
import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class T8 extends TestBase {

    @Test
    public void test01(){
        JavascriptExecutor js=(JavascriptExecutor) driver;

        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //3. chooseFile butonuna basalim
        WebElement chooseFileButton=driver.findElement(By.id("file-upload"));
        js.executeScript("arguments[0].click();", chooseFileButton);

        //4. Yuklemek istediginiz dosyayi secelim.
        chooseFileButton.sendKeys("C:\\Users\\Elif\\Downloads\\logo.png");
        //5. Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //6. “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement text= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(text.isDisplayed());
    }

}
