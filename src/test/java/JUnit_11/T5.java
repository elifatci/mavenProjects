package JUnit_11;

import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class T5 extends TestBase {
    @Test
    public void test01(){
        // https://trytestingthis.netlify.app/ adresine gidin
        driver.get("https://trytestingthis.netlify.app/");
        // Title' den anasayfa' nin gorunurlugunu dogrulayin
        String expectedTitle="Try Testing This";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        // "This is your Sample login page" de bulunan "username" ve "password" de
        //YANLIS degerleri girerek login olun
        Actions actions=new Actions(driver);
       WebElement name=driver.findElement(By.name("uname"));
       actions.click(name).sendKeys("est").sendKeys(Keys.TAB).sendKeys("est").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        // Cikan alerti "Tamam" diyerek kapatin ve Alert mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        // Bir onceki sayfaya geri donun
        //driver.navigate().back();
        // "Home" elementine tiklayin
        driver.findElement(By.partialLinkText("ome")).click();
        // "This is your Sample login page" alaninin(field) gorundugunu
        //              dogrulayin ve elementlerini yazdirin.

        WebElement textArea= driver.findElement(By.xpath("(//fieldset)[1]"));
        Assert.assertTrue(textArea.isDisplayed());
        String text=textArea.getText();
        System.out.println(text);
    }

}
