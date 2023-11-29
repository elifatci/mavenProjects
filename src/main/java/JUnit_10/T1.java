package JUnit_10;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class T1 extends TestBase {
    @Test
    public void exercise15() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("(//div[@class='carousel-inner'])[1]"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click 'Signup / Login' button
        ReusableMethods.Wait(3);
        driver.findElement(By.partialLinkText("Login")).click();
        //5. Fill all details in Signup and create account
        WebElement name = driver.findElement(By.xpath("//input[@type='text']"));
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        actions.click(name).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        ReusableMethods.Wait(4);
        driver.findElement(By.xpath("(//div[@class='radio-inline'])[2]")).click();
        WebElement nameElement = driver.findElement(By.xpath("//*[@id='name']"));
        actions.click(nameElement).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys("10")
                .sendKeys(Keys.TAB)
                .sendKeys("July")
                .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.company().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().secondaryAddress())
                .sendKeys(Keys.TAB)
                .sendKeys("Canada")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().state())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().city())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        ReusableMethods.Wait(4);
        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement textElement = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertTrue(textElement.isDisplayed());
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        //7. Verify ' Logged in as username' at top
        WebElement logged = driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        Assert.assertTrue(logged.isDisplayed());
        //8. Add products to cart
        ReusableMethods.Wait(2);
        js.executeScript("arguments[0].scrollIntoView(true);", logged);
        ReusableMethods.Wait(2);
        driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[10]")).click();
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[16]")).click();
        ReusableMethods.Wait(2);
        driver.findElement(By.linkText("View Cart")).click();
        //9. Click 'Cart' button
        driver.findElement(By.xpath("//a[text()=' Cart']")).click();
        //10. Verify that cart page is displayed
        WebElement cartPage = driver.findElement(By.className("active"));
        Assert.assertTrue(cartPage.isDisplayed());
        //11. Click Proceed To Checkout
        ReusableMethods.Wait(3);
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        //12. Verify Address Details and Review Your Order
        WebElement addressDetail = driver.findElement(By.id("address_delivery"));
        //13. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.className("form-control")).sendKeys("thank u!");
        ReusableMethods.Wait(4);
        driver.findElement(By.linkText("Place Order")).click();
        //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        WebElement cardName = driver.findElement(By.name("name_on_card"));
        actions.click(cardName)
                .sendKeys(faker.business().creditCardType())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.business().creditCardNumber())
                .sendKeys(Keys.TAB)
                .sendKeys("000")
                .sendKeys(Keys.TAB)
                .sendKeys("20")
                .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .perform();
        //15. Click 'Pay and Confirm Order' button
        ReusableMethods.Wait(2);
        driver.findElement(By.id("submit")).click();
        //16. Click 'Delete Account' button
        ReusableMethods.Wait(3);
        driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();
        //17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement text0 = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(text0.isDisplayed());
        ReusableMethods.Wait(2);
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
    }
}
