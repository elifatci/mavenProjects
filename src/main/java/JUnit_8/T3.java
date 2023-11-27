package JUnit_8;

import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class T3 extends TestBase {
    @Test
    public void test01(){

        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement suruklenecekElement= driver.findElement(By.cssSelector("#draggable"));
        WebElement birakilacakAlanElementi= driver.findElement(By.cssSelector("#droppable"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(suruklenecekElement,birakilacakAlanElementi).perform();
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedAlanYazisi="Dropped!";
        String actualAlanYazisi=birakilacakAlanElementi.getText();
        Assert.assertEquals(expectedAlanYazisi,actualAlanYazisi);
    }
}
