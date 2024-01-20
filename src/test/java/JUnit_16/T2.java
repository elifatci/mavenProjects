package JUnit_16;

import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class T2 extends TestBase {
    @Test
    public void test01(){
        //Yeni bir class olusturalim: MouseActions2
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe= driver.findElement(By.id("draggable"));
        WebElement dropHere=driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(dragMe,dropHere).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement text=driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String expectedText="Dropped!";
        String actualText=text.getText();
        Assert.assertEquals(expectedText,actualText);

    }
}
