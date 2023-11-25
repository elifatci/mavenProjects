package maven_6;

import Methods.ReusableMethods;
import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class T1 extends TestBase {
    @Test
    public void exercise14(){
        JavascriptExecutor js=(JavascriptExecutor) driver;

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.id("slider-carousel"));
        Assert.assertTrue(homePage.isDisplayed());
        js.executeScript("arguments[0].scrollIntoView(true);",homePage);
        //4. Add products to cart

       WebElement addToCart= driver.findElement(By.xpath("(//a[text()='Add to cart'])[1]"));

        js.executeScript("arguments[0].click();",addToCart);
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        WebElement addTo=driver.findElement(By.xpath("(//a[text()='Add to cart'])[5]"));
        js.executeScript("arguments[0].click();",addTo);
        WebElement button=driver.findElement(By.xpath("//button[text()='Continue Shopping']"));
        js.executeScript("arguments[0].click();",button);
        //5. Click 'Cart' button
        driver.findElement(By.xpath("//a[text()=' Cart']")).click();
        //6. Verify that cart page is displayed
        String expectedUrl="cart";
        String actual=driver.getCurrentUrl();
        Assert.assertTrue(actual.contains(expectedUrl));
        //7. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        //8. Click 'Register / Login' button
        driver.findElement(By.xpath("//u[text()='Register / Login']")).click();
        //9. Fill all details in Signup and create account
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("elif");
        driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]")).sendKeys("ee@sn.com");
        driver.findElement(By.xpath("//button[text()='Signup']")).click();
        driver.findElement(By.xpath("//label[@for='id_gender2']")).click();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Elif");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("11");
        driver.findElement(By.xpath("//option[@value='24']")).click();
        driver.findElement(By.xpath("(//option[@value='9'])[2]")).click();
        driver.findElement(By.xpath("//option[@value='1991']")).click();
        WebElement select1 = driver.findElement(By.xpath("(//div[@class='checkbox'])[1]"));
        js.executeScript("arguments[0].click();",select1);
        WebElement select2 = driver.findElement(By.xpath("(//div[@class='checkbox'])[2]"));
        js.executeScript("arguments[0].click();",select2);
        driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("Elif");
        driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("EA");
        driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys("wise");
        driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("istanbul");
        driver.findElement(By.xpath("//input[@data-qa='address2']")).sendKeys("istanbul");
        driver.findElement(By.xpath("//option[@value='Canada']")).click();
        driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("Turkey");
        driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("istanbul");
        driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("34000");
        driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("11111112201");
        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
       WebElement accountDelete= driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        js.executeScript("arguments[0].click();",accountDelete);
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        //11. Verify ' Logged in as username' at top
        WebElement logged=driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        Assert.assertTrue(logged.isDisplayed());
        //12.Click 'Cart' button
        driver.findElement(By.xpath("//a[text()=' Cart']")).click();
        //13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        //14. Verify Address Details and Review Your Order
        WebElement addressDetail=driver.findElement(By.id("address_delivery"));
        Assert.assertTrue(addressDetail.isDisplayed());
        //15. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.className("form-control")).sendKeys("I hope I will be satisfied. :)");
        driver.findElement(By.xpath("//a[text()='Place Order']")).click();
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.name("name_on_card")).sendKeys("wertdhsvhccd");
        driver.findElement(By.name("card_number")).sendKeys("115165414147514194619");
        driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("368");
        driver.findElement(By.name("expiry_month")).sendKeys("09");
        driver.findElement(By.name("expiry_year")).sendKeys("2000");
        //17. Click 'Pay and Confirm Order' button
        WebElement confirm=driver.findElement(By.id("submit"));
        confirm.click();

        //18. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[text()=' Delete Account']")).click();
        //19. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement accountDeleted=driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        String expectedAccount="ACCOUNT DELETED!";
        String actualAccount=accountDeleted.getText();
        Assert.assertEquals(expectedAccount,actualAccount);
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
    }
}
