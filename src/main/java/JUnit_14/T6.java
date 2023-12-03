package JUnit_14;

import Methods.TestBase;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class T6 extends TestBase {
    @Test
    public void exercise23(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        String expected="Automation Exercise";
        String actual= driver.getTitle();
        Assert.assertEquals(expected,actual);
        //4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //5. Fill all details in Signup and create account
        Faker faker=new Faker();
        WebElement name= driver.findElement(By.xpath("//input[@type='text']"));
        Actions actions=new Actions(driver);
        actions.click(name).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        driver.findElement(By.xpath("(//*[@class='top'])[2]")).click();
        WebElement password=driver.findElement(By.id("password"));
        String firstName=faker.name().firstName();
        String lastname=faker.name().lastName();
        actions.click(password).sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys("9")
                .sendKeys(Keys.TAB)
                .sendKeys("June")
                .sendKeys(Keys.TAB)
                .sendKeys("1993")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(firstName)
                .sendKeys(Keys.TAB)
                .sendKeys(lastname)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.company().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().streetAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Canada")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().state())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().city())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("account_created"));
        driver.findElement(By.xpath("(//a[@href='/'])[3]")).click();
        //7. Verify ' Logged in as username' at top
        WebElement text= driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        Assert.assertTrue(text.isDisplayed());
        //8. Add products to cart
       WebElement product= driver.findElement(By.xpath("//a[@data-product-id='1']"));
       js.executeScript("arguments[0].scrollIntoView(true)",product);
       product.click();
       driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();
       driver.findElement(By.xpath("//a[@data-product-id='5']")).click();
        driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();
        //9. Click 'Cart' button
        driver.findElement(By.partialLinkText("art")).click();
        //10. Verify that cart page is displayed
        actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("view_cart"));
        //11. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();
        //12. Verify that the delivery address is same address filled at the time registration of account
        WebElement deliveryAddress= driver.findElement(By.id("address_delivery"));
        Assert.assertTrue(deliveryAddress.isDisplayed());
        //13. Verify that the billing address is same address filled at the time registration of account
        WebElement billingAddress=driver.findElement(By.id("address_invoice"));
       Assert.assertTrue(billingAddress.isDisplayed());
        //14. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        //15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement accountDeleted=driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        Assert.assertTrue(accountDeleted.isDisplayed());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
    }
}
