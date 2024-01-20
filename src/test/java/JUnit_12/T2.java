package JUnit_12;

import Methods.ReusableMethods;
import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class T2 extends TestBase {

    @Test
    public void test01(){
        // https://trytestingthis.netlify.app/ adresine gidin
        driver.get("https://trytestingthis.netlify.app/");
        // This is your form title bolumunde bulunan
        //      First name:
        //      Last name:
        //      Gender(Kendinize uygun olani) doldurun
        Actions actions=new Actions(driver);
        WebElement firstNameBox= driver.findElement(By.id("fname"));
        actions.click(firstNameBox).sendKeys("elif")
                .sendKeys(Keys.TAB)
                .sendKeys("elif")
                .perform();
        driver.findElement(By.xpath("//label[@for='female']")).click();
        // Choose an option bolumunde bulunan
        //   Lets you select only one optionda Option2 yi secerek
        //      Option2 nin secili digerlerinin secili olmadigini dogrulayin
        WebElement dropdownBox= driver.findElement(By.xpath("//select[@name='option']"));
        Select select=new Select(dropdownBox);
        select.selectByVisibleText("Option 2");
        WebElement option= driver.findElement(By.xpath("(//option[@value='option'])[1]"));
        WebElement option1= driver.findElement(By.xpath("(//option[@value='option 1'])[1]"));
        WebElement option2= driver.findElement(By.xpath("(//option[@value='option 2'])[1]"));
        WebElement option3= driver.findElement(By.xpath("(//option[@value='option 3'])[1]"));
        Assert.assertTrue(option2.isSelected());
        Assert.assertFalse(option.isSelected()&&option1.isSelected()&&option3.isSelected());

        // Lets you select multiple options bolumunde bulunan
        //      Option ve Option4 u secip digerlerini secmeden
        //          secili olanlari ve olmayanlari dogrulayin
       option= driver.findElement(By.xpath("(//option[@value='option'])[2]"));
       option1= driver.findElement(By.xpath("(//option[@value='option 1'])[2]"));
       option2= driver.findElement(By.xpath("(//option[@value='option 2'])[2]"));
       option3= driver.findElement(By.xpath("(//option[@value='option 3'])[2]"));

       actions.keyDown(Keys.CONTROL).click(option).click(option3).perform();
       Assert.assertTrue(option.isSelected()&&option3.isSelected());
       Assert.assertFalse(option1.isSelected()&&option2.isSelected());

    }

}
