package JUnit_11;

import Methods.ReusableMethods;
import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class T2 extends TestBase {
    @Test
    public void exercise17() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("(//div[@class='carousel-inner'])[1]"));
        assertTrue(homePage.isDisplayed());
        //4. Add products to cart
        WebElement product = driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]"));
        js.executeScript("arguments[0].click();", product);
        driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();
        WebElement product2 = driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[7]"));
        js.executeScript("arguments[0].click();", product2);
        driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();
        ReusableMethods.Wait(4);
        //5. Click 'Cart' button
        driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[1]")).click();
        //6. Verify that cart page is displayed
        WebElement cartPage = driver.findElement(By.className("active"));
        assertTrue(cartPage.isDisplayed());
        List<WebElement> productList = driver.findElements(By.xpath("//td[@class='cart_product']"));
        List<String> strList = new ArrayList<>();
        for (WebElement each : productList) {
            strList.add(each.getText());
        }
        System.out.println(strList.size());
        //7. Click 'X' button corresponding to particular product

        driver.findElement(By.className("cart_quantity_delete")).click();


    }
}
