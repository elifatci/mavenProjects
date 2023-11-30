package JUnit_11;

import Methods.ReusableMethods;
import Methods.TestBase;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class T1 extends TestBase {
    @Test
    public void exercise16(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage= driver.findElement(By.xpath("(//div[@class='carousel-inner'])[1]"));
        assertTrue(homePage.isDisplayed());
        //4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
        //5. Fill email, password and click 'Login' button
        driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys("ee@ee.com");
        driver.findElement(By.xpath("(//input[@name='password'])[1]")).sendKeys("12");
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        //6. Verify 'Logged in as username' at top
        WebElement text= driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        assertTrue(text.isDisplayed());
        //7. Add products to cart
        ReusableMethods.Wait(3);
        js.executeScript("arguments[0].scrollIntoView(true);", text);
        js.executeScript("arguments[0].scrollIntoView(true);", text);

       WebElement product= driver.findElement(By.xpath("(//a[@data-product-id='6'])[1]"));
        js.executeScript("arguments[0].click();", product);
        driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();
        //8. Click 'Cart' button
        driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']")).click();
        //9. Verify that cart page is displayed
        WebElement cartPage= driver.findElement(By.className("active"));
        assertTrue(cartPage.isDisplayed());
        //10. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
        //11. Verify Address Details and Review Your Order
        WebElement adressDetails= driver.findElement(By.id("address_delivery"));
        assertTrue(adressDetails.isDisplayed());
        //12. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("thank u!");
        driver.findElement(By.partialLinkText("Order")).click();
        //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        Faker faker=new Faker();
        Actions actions=new Actions(driver);
        WebElement nameOnCard=driver.findElement(By.xpath("//input[@name='name_on_card']"));
        actions.click(nameOnCard)
                .sendKeys(faker.business().creditCardType())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.business().creditCardNumber())
                .sendKeys(Keys.TAB)
                .sendKeys("000")
                .sendKeys(Keys.TAB)
                .sendKeys("13")
                .sendKeys(Keys.TAB)
                .sendKeys("1990").perform();

        //14. Click 'Pay and Confirm Order' button
        ReusableMethods.Wait(3);
        driver.findElement(By.id("submit")).click();
        ReusableMethods.Wait(3);
        //15. Click 'Delete Account' button
        driver.findElement(By.partialLinkText("Account")).click();

    }
}
