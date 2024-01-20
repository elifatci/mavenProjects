package JUnit_16;

import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class T3 extends TestBase {
    @Test
    public void test01(){
        //Yeni bir class olusturalim: MouseActions3
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //mouse’u bu menunun ustune getirin
        WebElement accountList= driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountList).perform();
        //3- “Create a list” butonuna basin
        driver.findElement(By.xpath("(//*[@class='nav-text'])[1]")).click();
        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        WebElement text= driver.findElement(By.xpath("//*[@role='heading']"));
        String expectedText="Your Lists";
        String actualText=text.getText();
        Assert.assertEquals(expectedText,actualText);
    }
}
