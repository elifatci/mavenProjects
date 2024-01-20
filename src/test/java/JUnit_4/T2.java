package JUnit_4;

import Methods.ReusableMethods;
import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class T2 extends TestBase {

    @Test
    public void exercise11() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'

        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click 'Cart' button
        driver.findElement(By.xpath("//a[text()=' Cart']")).click();
        //5. Scroll down to footer
        //6. Verify text 'SUBSCRIPTION'
        WebElement subs = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        WebElement text = driver.findElement(By.xpath("//h2[text()='Subscription']"));
        String expectedText = "SUBSCRIPTION";
        String actualText = text.getText();
        Assert.assertEquals(expectedText, actualText);
        //7. Enter email address in input and click arrow button
        WebElement email = driver.findElement(By.id("susbscribe_email"));
        email.sendKeys("ee@ee.com");
        WebElement button = driver.findElement(By.xpath("//i[@class='fa fa-arrow-circle-o-right']"));
        button.click();
        ReusableMethods.Wait(3);
        //8. Verify success message 'You have been successfully subscribed!' is visible
        WebElement message = driver.findElement(By.id("success-subscribe"));
        String expectedMessage = "You have been successfully subscribed!";
        String actualMessage = message.getText();
        System.out.println(actualMessage);
    }
}
