package JUnit_19;

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
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Files;
import java.nio.file.Paths;

public class T1 extends TestBase {
    @Test
    public void exercise24(){

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        //4. Add products to cart
        JavascriptExecutor js= (JavascriptExecutor) driver;
        WebElement firstProduct=driver.findElement(By.xpath("(//*[@data-product-id='1'])[1]"));
        js.executeScript("arguments[0].scrollIntoViewIfNeeded()",firstProduct);
        firstProduct.click();
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
        driver.findElement(By.xpath("(//*[@data-product-id='3'])[1]")).click();
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
        //5. Click 'Cart' button
        driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[1]")).click();
        //6. Verify that cart page is displayed
        String expectedUrl="https://automationexercise.com/view_cart";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        //7. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();
        //8. Click 'Register / Login' button
        driver.findElement(By.xpath("(//u)[1]")).click();
        //9. Fill all details in Signup and create account
        Faker faker=new Faker();
        WebElement name= driver.findElement(By.xpath("//*[@type='text']"));
        name.sendKeys(faker.name().firstName());
        WebElement email= driver.findElement(By.xpath("(//*[@type='email'])[2]"));
        email.sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
        driver.findElement(By.id("id_gender2")).click();
        Actions actions=new Actions(driver);
        WebElement passwordKutusu= driver.findElement(By.xpath("(//*[@class='form-control'])[3]"));
        actions.click(passwordKutusu).sendKeys(faker.internet().password()).perform();
        js.executeScript("arguments[0].scrollIntoView(true)",passwordKutusu);
        WebElement daySelect= driver.findElement(By.xpath("(//*[@class='form-control'])[4]"));
        WebElement monthSelect= driver.findElement(By.xpath("(//*[@class='form-control'])[5]"));
        WebElement yearSelect= driver.findElement(By.xpath("(//*[@class='form-control'])[6]"));


        Select select=new Select(daySelect);
        select.selectByValue("24");
        select=new Select(monthSelect);
        select.selectByValue("9");
        select=new Select(yearSelect);
        select.selectByValue("1991");

        WebElement firstName=driver.findElement(By.xpath("(//*[@class='form-control'])[7]"));

        actions.click(firstName).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.company().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress()).perform();

        WebElement countrySelect= driver.findElement(By.xpath("(//*[@class='form-control'])[12]"));
       select=new Select(countrySelect);
        select.selectByValue("Canada");
        WebElement state= driver.findElement(By.xpath("(//*[@class='form-control'])[13]"));
        js.executeScript("arguments[0].scrollIntoView(true)",state);
        actions.click(state).sendKeys(faker.address().state())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().city())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber()).perform();

            WebElement createAccountLinki= driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
            createAccountLinki.click();
        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        expectedUrl="https://automationexercise.com/account_created";
        actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
        //11. Verify ' Logged in as username' at top
        WebElement loggedUsernam= driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        Assert.assertTrue(loggedUsernam.isDisplayed());
        //12.Click 'Cart' button
        driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[1]")).click();
        //13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        //14. Verify Address Details and Review Your Order
        WebElement adressDetail= driver.findElement(By.className("checkout-information"));
        Assert.assertTrue(adressDetail.isDisplayed());
        //15. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.className("form-control")).sendKeys("thank u");
        driver.findElement(By.partialLinkText("rder")).click();
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        WebElement cardName=driver.findElement(By.name("name_on_card"));
        actions.click(cardName).sendKeys(faker.business().creditCardType())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.business().creditCardNumber())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.business().creditCardExpiry())
                .sendKeys(Keys.TAB)
                .sendKeys("11")
                .sendKeys(Keys.TAB)
                .sendKeys("1999").perform();


        //17. Click 'Pay and Confirm Order' button
        driver.findElement(By.id("submit")).click();
        //18. Verify success message 'Your order has been placed successfully!'
        WebElement message=driver.findElement(By.xpath("//p[text()='Congratulations! Your order has been confirmed!']"));
        Assert.assertTrue(message.isDisplayed());
        //19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
        driver.findElement(By.partialLinkText("nvoice")).click();
        String expectedDosyaYolu="C:\\Users\\Elif\\Downloads\\invoice.txt";
        ReusableMethods.Wait(3);
        Assert.assertTrue(Files.exists(Paths.get(expectedDosyaYolu)));
        //20. Click 'Continue' button
        driver.findElement(By.partialLinkText("ontinue")).click();
        //21. Click 'Delete Account' button
        driver.findElement(By.partialLinkText("ccount")).click();
        //22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        expectedUrl="https://automationexercise.com/delete_account";
        actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        driver.findElement(By.partialLinkText("tinue")).click();
    }
}
