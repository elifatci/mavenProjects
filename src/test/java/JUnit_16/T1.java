package JUnit_16;

import Methods.ReusableMethods;
import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;


public class T1 extends TestBase {

    @Test
    public void exercise10(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        String expectedUrl="https://automationexercise.com/";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        //4. Scroll down to footer
        //Actions actions=new Actions(driver);
        //actions.sendKeys(Keys.END).perform();
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        //5. Verify text 'SUBSCRIPTION'
        WebElement text= driver.findElement(By.xpath("//*[text()='Subscription']"));
        String expectedText="SUBSCRIPTION";
        String actualText=text.getText();
        Assert.assertEquals(expectedText,actualText);
        //6. Enter email address in input and click arrow button
        driver.findElement(By.id("susbscribe_email")).sendKeys("ee@ee.com");
        driver.findElement(By.id("subscribe")).click();
        //7. Verify success message 'You have been successfully subscribed!' is visible

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success-subscribe")));

        String expectedMessage="You have been successfully subscribed!";
        String actualMessage=message.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage,actualMessage);


    }
}
