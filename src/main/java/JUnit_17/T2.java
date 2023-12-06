package JUnit_17;

import Methods.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class T2 extends TestBase {
    @Test
    public void test01() throws IOException {
        // testotomasyonu anasayfaya gidin
      driver.get("https://www.testotomasyonu.com");
        // dress icin arama yapin
        driver.findElement(By.id("global-search")).sendKeys("dress"+Keys.ENTER);
        // arama sonucunda urun bulunabildigini test edin
        WebElement sonucElementi= driver.findElement(By.className("product-count-text"));
        String sonucStr=sonucElementi.getText().replaceAll("\\D","");
        int sonuc=Integer.parseInt(sonucStr);
        Assert.assertTrue(sonuc>0);

        // arama sonuc yazisinin screenshot'ini kaydedin
        File istenilenSShots=new File("target/screenshots/aramaSonucYazisi.jpg");
        File geciciResim=sonucElementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,istenilenSShots);


    }
}
