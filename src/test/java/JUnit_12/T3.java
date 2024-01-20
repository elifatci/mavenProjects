package JUnit_12;

import Methods.ReusableMethods;
import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class T3 extends TestBase {

    @Test
    public void test01(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        // https://trytestingthis.netlify.app/ adresine gidin
        driver.get("https://trytestingthis.netlify.app/");
        // Choose an option bolumunde bulunan
        // This is your form title bolumunde bulunan
        //      Choose applicable options bolumunde
        //         Option2 ve Option3 u secin, bunlarin secili
        //              ve Option1 in secili olmadigini dogrulayin
        WebElement option1= driver.findElement(By.xpath("(//input[@id='moption'])[1]"));
        WebElement option2= driver.findElement(By.xpath("(//input[@id='moption'])[2]"));
        WebElement option3= driver.findElement(By.xpath("(//input[@id='moption'])[3]"));
        Actions actions=new Actions(driver);
        actions.click(option2).click(option3).perform();
        Assert.assertTrue(option2.isSelected()&&option3.isSelected());
        Assert.assertFalse(option1.isSelected());
        ReusableMethods.Wait(3);

        // Start typing and it till automatically guess answer bolumune
        //      tahmini cevabinizi yazin

        driver.findElement(By.xpath("//input[@list='datalists']")).sendKeys("Chocolate");
        //js.executeScript("arguments[0].scrollIntoView(true);",dropDownBox);

        // Select your favorite color renginizi secin

        // Select a date bolumunden bir tarih secin
        driver.findElement(By.xpath("//input[@type='date']")).sendKeys("20091993");
        // Scroll to see a range value ile "66" yi secin ve birakin
        WebElement scrollValue= driver.findElement(By.xpath("//input[@type='range']"));
       // WebElement fieldValue= driver.findElement(By.xpath("//output[text()='66']"));
        //actions.dragAndDrop(scrollValue,fieldValue).perform();
        // Select a file bolumune bir dosya upload edin ve dogrulayin
       WebElement fileBox= driver.findElement(By.xpath("//input[@type='file']"));
        js.executeScript("arguments[0].click();",fileBox);
       fileBox.sendKeys("C:\\Users\\Elif\\Downloads\\logo.png");
        ReusableMethods.Wait(3);
        // Select a quantity from a range' i 4' e getirin ve dogrulayin
        driver.findElement(By.id("quantity")).sendKeys("4");
        ReusableMethods.Wait(3);
        // Long Message bolumune bir metin girin
       WebElement message= driver.findElement(By.name("message"));
       message.clear();
       message.sendKeys("happy weekend");
        ReusableMethods.Wait(9);
        // Submit yapin
        driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
        ReusableMethods.Wait(3);
    }

}
