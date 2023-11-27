package JUnit_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class exercise3 {
 static WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void teardown(){
        driver.close();
    }
    @Test
    public void exercise3(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage=driver.findElement(By.id("slider-carousel"));
      Assert.assertTrue(homePage.isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //5. Verify 'Login to your account' is visible
        WebElement login=driver.findElement(By.className("login-form"));
        Assert.assertTrue(login.isDisplayed());
        //6. Enter incorrect email address and password
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("ee@ee.com");
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("1234567890");
        //7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        //8. Verify error 'Your email or password is incorrect!' is visible
        WebElement error=driver.findElement(By.xpath("//p[@style='color: red;']"));
        String expectedMessage="Your email or password is incorrect!";
        String actualMessage=error.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

}
