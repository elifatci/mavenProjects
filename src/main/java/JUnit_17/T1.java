package JUnit_17;

import Methods.ReusableMethods;
import Methods.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class T1 extends TestBase {

    @Test
    public void test01() throws IOException {
        //1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        ReusableMethods.Wait(10);
        //2- amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        String expectedUrl="https://www.amazon.com/";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        TakesScreenshot ts= (TakesScreenshot) driver;
        File tumSayfaScreenshots=new File("target/screenshots/tumSayfaScreenshots.jpg");
        File geciciResim=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,tumSayfaScreenshots);
        //3- Nutella icin arama yapin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella");
        //4- sonucun Nutella icerdigini test edin
        WebElement siralamaKutusu= driver.findElement(By.xpath("(//*[@role='navigation'])[2]"));
        siralamaKutusu.click();
        Assert.assertTrue(siralamaKutusu.isDisplayed());

    }
}
