package JUnit_13;

import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class T5 extends TestBase {
    @Test
    public void exercise22() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Scroll to bottom of page
        //4. Verify 'RECOMMENDED ITEMS' are visible
        WebElement recommendedElement = driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]"));
        js.executeScript("arguments[0].scrollIntoView(true);", recommendedElement);
        //5. Click on 'Add To Cart' on Recommended product
        driver.findElement(By.xpath("(//a[@data-product-id='4'])[3]")).click();
        //6. Click on 'View Cart' button
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();
        //7. Verify that product is displayed in cart page
        List<WebElement> tableElement = driver.findElements(By.xpath("//tbody/tr"));
        int expectedSize = 1;
        int actualSize = tableElement.size();
        Assert.assertEquals(expectedSize, actualSize);

    }
}
