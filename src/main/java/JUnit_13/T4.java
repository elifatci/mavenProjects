package JUnit_13;

import Methods.ReusableMethods;
import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class T4 extends TestBase {
    @Test
    public void exercise21(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        //4. Verify user is navigated to ALL PRODUCTS page successfully
        String expectedTitle="All Products";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //5. Click on 'View Product' button
        WebElement allProductsElement= driver.findElement(By.xpath("//h2[@class='title text-center']"));
        js.executeScript("arguments[0].scrollIntoView(true);",allProductsElement);
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
        //6. Verify 'Write Your Review' is visible
        WebElement reviewVisible= driver.findElement(By.xpath("//div[@class='category-tab shop-details-tab']"));
        Assert.assertTrue(reviewVisible.isDisplayed());
        //7. Enter name, email and review
        WebElement name= driver.findElement(By.xpath("//input[@type='text']"));
        Actions actions=new Actions(driver);
        actions.click(name).sendKeys("elif").sendKeys(Keys.TAB).sendKeys("ee@ab.com").sendKeys(Keys.TAB)
                .sendKeys("ı was not satisfied").perform();
        //8. Click 'Submit' button
        driver.findElement(By.id("button-review")).click();
        //9. Verify success message 'Thank you for your review.'
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='alert-success alert'])[1]")));
       Assert.assertTrue(message.isDisplayed());


    }

}
