package JUnit_4;

import Methods.ReusableMethods;
import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

import java.util.List;

public class T3 extends TestBase {
    @Test
    public void exercise12(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'

        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click 'Products' button
        WebElement products=driver.findElement(By.xpath("//i[@class='material-icons card_travel']"));
        products.click();
        //5. Hover over first product and click 'Add to cart'

       WebElement firstProduct =  driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]"));
        jse.executeScript("arguments[0].scrollIntoView(true);",firstProduct);
        jse.executeScript("arguments[0].click();",firstProduct);
        ReusableMethods.Wait(3);
        //6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        //7. Hover over second product and click 'Add to cart'
        WebElement secondProduct =driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[3]"));
        jse.executeScript("arguments[0].click();",secondProduct);
        //8. Click 'View Cart' button
        ReusableMethods.Wait(3);
       WebElement viewCart= driver.findElement(By.xpath("//u[text()='View Cart']"));
       jse.executeScript("arguments[0].click();",viewCart);
        //9. Verify both products are added to Cart
        List<WebElement> cart=driver.findElements(By.className("product_image"));
        int expectedProduct=2;
        int actualProduct=cart.size();
        Assert.assertEquals(expectedProduct,actualProduct);
        //10. Verify their prices, quantity and total price
        WebElement price1=driver.findElement(By.xpath("(//td[@class='cart_price'])[1]"));
        String expectedPrice="Rs. 500";
        String actualPrice=price1.getText();
        Assert.assertEquals(expectedPrice,actualPrice);
        WebElement price2=driver.findElement(By.xpath("(//td[@class='cart_price'])[2]"));
        String expectedPrice2="Rs. 400";
        String actualPrice2=price2.getText();
        Assert.assertEquals(expectedPrice2,actualPrice2);

        WebElement quantity1=driver.findElement(By.xpath("(//button[@class='disabled'])[1]"));
        String expectedQuantity="1";
        String actualQuantity=quantity1.getText();
        Assert.assertEquals(expectedQuantity,actualQuantity);
        WebElement quantity2=driver.findElement(By.xpath("(//button[@class='disabled'])[2]"));
        String expectedQuantity2="1";
        String actualQuantity2=quantity2.getText();
        Assert.assertEquals(expectedQuantity2,actualQuantity2);

        WebElement total1=driver.findElement(By.xpath("(//p[@class='cart_total_price'])[1]"));
        String expectedTotal="Rs. 500";
        String actualTotal=total1.getText();
        Assert.assertEquals(expectedTotal,actualTotal);
        WebElement total2=driver.findElement(By.xpath("(//p[@class='cart_total_price'])[2]"));
        String expectedTotal2="Rs. 400";
        String actualTotal2=total2.getText();
        Assert.assertEquals(expectedTotal2,actualTotal2);


    }
}
