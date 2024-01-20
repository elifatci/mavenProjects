package JUnit_13;

import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class T3 extends TestBase {
    @Test
    public void exercise20(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        //4. Verify user is navigated to ALL PRODUCTS page successfully
        String expectedTitle="All Products";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //5. Enter product name in search input and click search button
        driver.findElement(By.id("search_product")).sendKeys("tshirt");
        driver.findElement(By.id("submit_search")).click();
        //6. Verify 'SEARCHED PRODUCTS' is visible
        String expectedUrl="tshirt";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        //7. Verify all the products related to search are visible
        WebElement allProducts= driver.findElement(By.className("features_items"));
        Assert.assertTrue(allProducts.isDisplayed());
        //8. Add those products to cart
        js.executeScript("arguments[0].scrollIntoView(true);",allProducts);
        driver.findElement(By.xpath("//a[@data-product-id='2']")).click();
        driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();
        driver.findElement(By.xpath("//a[@data-product-id='28']")).click();
        driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();
        driver.findElement(By.xpath("//a[@data-product-id='29']")).click();
        driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();
        WebElement product= driver.findElement(By.xpath("//a[@data-product-id='30']"));
        js.executeScript("arguments[0].scrollIntoView(true);",product);
        js.executeScript("arguments[0].click();",product);
        driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();
        driver.findElement(By.xpath("//a[@data-product-id='31']")).click();
        driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();
        driver.findElement(By.xpath("//a[@data-product-id='43']")).click();
        driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();
        //9. Click 'Cart' button and verify that products are visible in cart
        driver.findElement(By.xpath("//a[text()=' Cart']")).click();
        WebElement cartPage= driver.findElement(By.xpath("//li[text()='Shopping Cart']"));
        Assert.assertTrue(cartPage.isDisplayed());
        //10. Click 'Signup / Login' button and submit login details
        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
        WebElement email= driver.findElement(By.xpath("(//input[@type='email'])[1]"));
        Actions actions=new Actions(driver);
        actions.click(email).sendKeys("ee@ab.com").sendKeys(Keys.TAB).sendKeys("12").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //11. Again, go to Cart page
        driver.findElement(By.xpath("//a[text()=' Cart']")).click();
        //12. Verify that those products are visible in cart after login as well
        WebElement products= driver.findElement(By.id("cart_info"));
        Assert.assertTrue(products.isDisplayed());
    }
}
