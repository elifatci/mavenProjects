package JUnit_5;

import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class T1 extends TestBase {
    @Test
    public void exercise13() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.id("slider-carousel"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click 'View Product' for any product on home page
        WebElement view = driver.findElement(By.xpath("(//a[text()='View Product'])[1]"));
        js.executeScript("arguments[0].click();", view);

        //5. Verify product detail is opened
        WebElement detail = driver.findElement(By.className("product-information"));
        Assert.assertTrue(detail.isDisplayed());
        //6. Increase quantity to 4
        WebElement quantity = driver.findElement(By.id("quantity"));
        quantity.clear();
        quantity.sendKeys("4");
        //7. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[@type='button']")).click();
        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();
        //9. Verify that product is displayed in cart page with exact quantity
        WebElement result = driver.findElement(By.className("disabled"));
        int expected = 4;
        String actualStr = result.getText();
        int actual = Integer.parseInt(actualStr);
        Assert.assertEquals(expected, actual);
    }
}
