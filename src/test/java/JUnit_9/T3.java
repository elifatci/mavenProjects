package JUnit_9;

import Methods.ReusableMethods;
import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class T3 extends TestBase {
    @Test
    public void test01(){
        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
        //3. Login kutusuna “username” yazin
        // 4. Password kutusuna “password” yazin
        WebElement loginKutusu= driver.findElement(By.id("user_login"));
        Actions actions=new Actions(driver);
        actions.click(loginKutusu)
                .sendKeys("username")
                .sendKeys(Keys.TAB)
                .sendKeys("password")
                .perform();

        //5. Sign in tusuna basin, back tusuna basarak sayfaya donun
        driver.findElement(By.name("submit")).click();
        ReusableMethods.Wait(2);
        driver.navigate().back();
        //6. Online banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement dropdownKutusu= driver.findElement(By.id("pc_currency"));
        Select select=new Select(dropdownKutusu);
        select.selectByVisibleText("Eurozone (euro)");
        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount")).sendKeys("500");
        //10. “US Dollars” in secilmedigini test edin
        WebElement radioButton=driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(radioButton.isSelected());
        //11. “Selected currency” butonunu secin
        driver.findElement(By.xpath("(//label[@class='radio inline'])[3]")).click();
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
        //kontrol edin
        WebElement text=driver.findElement(By.id("alert_content"));
        String expectedText="Foreign currency cash was successfully purchased.";
        String actualText=text.getText();
        Assert.assertEquals(expectedText,actualText);
        ReusableMethods.Wait(3);
    }
}
