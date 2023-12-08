package JUnit_19;

import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class T3 extends TestBase {
    @Test
    public void exercise26(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        //4. Scroll down page to bottom
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        //5. Verify 'SUBSCRIPTION' is visible
        WebElement subscription= driver.findElement(By.xpath("(//h2)[82]"));
        Assert.assertTrue(subscription.isDisplayed());
        //6. Scroll up page to top
        actions.sendKeys(Keys.HOME).perform();
        //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        WebElement text= driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(text.isDisplayed());
    }
}
