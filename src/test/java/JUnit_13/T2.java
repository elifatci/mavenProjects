package JUnit_13;

import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class T2 extends TestBase {
    @Test
    public void exercise19(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        //4. Verify that Brands are visible on left sidebar
        WebElement brands= driver.findElement(By.className("brands-name"));
        Assert.assertTrue(brands.isDisplayed());
        //5. Click on any brand name
        js.executeScript("arguments[0].scrollIntoView(true);",brands);
        driver.findElement(By.xpath("//a[@href='/brand_products/H&M']")).click();
        //6. Verify that user is navigated to brand page and brand products are displayed
        WebElement brandPage= driver.findElement(By.xpath("//li[text()='H&M']"));
        Assert.assertTrue(brandPage.isDisplayed());
        //7. On left sidebar, click on any other brand link
        driver.findElement(By.xpath("//a[text()='Polo']")).click();
        //8. Verify that user is navigated to that brand page and can see products
        brandPage= driver.findElement(By.xpath("//li[text()='Polo']"));
        Assert.assertTrue(brandPage.isDisplayed());
    }
}
