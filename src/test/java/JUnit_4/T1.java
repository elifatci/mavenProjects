package JUnit_4;

import Methods.BeforeClass;
import Methods.ReusableMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class T1 extends BeforeClass {

    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
    }
@Test
    public void test02(){
    //3. Verify that home page is visible successfully
    // 4. Scroll down to footer
    WebElement homePage= driver.findElement(By.xpath("//div[@class='logo pull-left']"));
    Assert.assertTrue(homePage.isDisplayed());
    ReusableMethods.Wait(2);

}
@Test
    public void test03(){
    JavascriptExecutor jse = (JavascriptExecutor) driver;
        //5. Verify text 'SUBSCRIPTION'
    WebElement homePage= driver.findElement(By.xpath("//div[@class='logo pull-left']"));
    jse.executeScript("arguments[0].scrollIntoView(true);",homePage);
    WebElement text= driver.findElement(By.xpath("//h2[text()='Subscription']"));
    String expectedText="SUBSCRIPTION";
    String actualText=text.getText();
    Assert.assertEquals(expectedText,actualText);
}
@Test
    public void test04(){
    //6. Enter email address in input and click arrow button
    WebElement email= driver.findElement(By.id("susbscribe_email"));
    email.sendKeys("ee@ee.com");
   WebElement button= driver.findElement(By.xpath("//i[@class='fa fa-arrow-circle-o-right']"));
   button.click();
    ReusableMethods.Wait(3);
    //7. Verify success message 'You have been successfully subscribed!' is visible
    WebElement message= driver.findElement(By.id("success-subscribe"));
    String expectedMessage="You have been successfully subscribed!";
    String actualMessage=message.getText();
    System.out.println(actualMessage);

}

}
