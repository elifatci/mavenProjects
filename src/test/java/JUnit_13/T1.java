package JUnit_13;

import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class T1 extends TestBase {
    @Test
    public void exercise18(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that categories are visible on left sidebar
        WebElement categories= driver.findElement(By.id("accordian"));
        Assert.assertTrue(categories.isDisplayed());
        //4. Click on 'Women' category
        js.executeScript("arguments[0].scrollIntoView(true);",categories);
        driver.findElement(By.xpath("(//a[@data-toggle='collapse'])[1]")).click();
        //5. Click on any category link under 'Women' category, for example: Dress
        driver.findElement(By.xpath("//a[@href='/category_products/1']")).click();
        //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        WebElement categoryPage= driver.findElement(By.xpath("//li[text()='Women > Dress']"));
       Assert.assertTrue(categoryPage.isDisplayed());
        //7. On left sidebar, click on any sub-category link of 'Men' category
        driver.findElement(By.xpath("(//a[@data-toggle='collapse'])[2]")).click();
        driver.findElement(By.xpath("//a[@href='/category_products/3']")).click();
        //8. Verify that user is navigated to that category page
        categoryPage= driver.findElement(By.xpath("//li[text()='Men > Tshirts']"));
        Assert.assertTrue(categoryPage.isDisplayed());
    }
}
