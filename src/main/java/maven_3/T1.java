package maven_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class T1 {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Products' button
    //5. Verify user is navigated to ALL PRODUCTS page successfully
    //6. Enter product name in search input and click search button
    //7. Verify 'SEARCHED PRODUCTS' is visible
    //8. Verify all the products related to search are visible
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationexercise.com");
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

    @Test
    public void HomePage() {
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        WebElement homepage = driver.findElement(By.xpath("//a[@href='/']"));
        Assert.assertTrue(homepage.isDisplayed());
    }

    @Test
    public void allProducts() {
        //4. Click on 'Products' button
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        driver.findElement((By.xpath("//a[@href='/products']"))).click();
        WebElement allproduct = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(allproduct.isDisplayed());
    }

    @Test
    public void searchedProduct() {
        //6. Enter product name in search input and click search button
        //7. Verify 'SEARCHED PRODUCTS' is visible

        driver.findElement(By.xpath("//*[@name='search']")).sendKeys("dress");
        driver.findElement(By.xpath("//button[@type='button']")).sendKeys(Keys.ENTER);

        WebElement searced = driver.findElement(By.xpath("//h2[text()='Searched Products']"));
        Assert.assertTrue(searced.isDisplayed());
    }

    @Test
    public void result() {
        driver.get("http://automationexercise.com");
        driver.findElement(By.xpath("//a[@href='/']"));
        driver.findElement((By.xpath("//a[@href='/products']"))).click();
        driver.findElement(By.xpath("//*[@name='search']")).sendKeys("dress");
        driver.findElement(By.xpath("//button[@type='button']")).sendKeys(Keys.ENTER);
        List<WebElement> results = driver.findElements(By.xpath("//ul[@class='nav nav-pills nav-justified']"));

        int expectedresult = 9;
        int actualresult = results.size();
        Assert.assertEquals(expectedresult, actualresult);


    }
}
