package JUnit_19;

import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class T2 extends TestBase {
    @Test
    public void exercise25(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        //4. Scroll down page to bottom
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        //5. Verify 'SUBSCRIPTION' is visible
        WebElement subscription= driver.findElement(By.xpath("(//h2)[82]"));
        Assert.assertTrue(subscription.isDisplayed());
        //6. Click on arrow at bottom right side to move upward
        driver.findElement(By.id("scrollUp")).click();
        //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        WebElement text= driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(text.isDisplayed());
    }
}
