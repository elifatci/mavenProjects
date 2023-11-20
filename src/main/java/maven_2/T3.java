package maven_2;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class T3 {
    WebDriver driver;


    @Test
    public void exercise7() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        if (homePage.isDisplayed()) {
            System.out.println("HomePage test PASSED");
        } else {
            System.out.println("HomePage test FAİLED");
        }
        //4. Click on 'Test Cases' button
        driver.findElement(By.xpath("//a[@href='/test_cases']")).click();
        //5. Verify user is navigated to test cases page successfully

        WebElement testCase = driver.findElement(By.xpath("//*[text()='Test Cases']"));
        if (testCase.isDisplayed()) {
            System.out.println("TestCase test is PASSED");
        } else {
            System.out.println("TestCase test is FAİLED");
        }
        driver.quit();
    }

    @Test
    public void exercise8() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("(//a[@href='/'])[2]"));
        if (homePage.isDisplayed()) {
            System.out.println("HomePage test is PASSED");
        } else {
            System.out.println("HomePage test is FAİLED");
        }
        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProducts = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        if (allProducts.isDisplayed()) {
            System.out.println("AllProducts test is PASSED");
        } else {
            System.out.println("AllProducts test is FAİLED");
        }
        //6. The products list is visible
        WebElement productsList = driver.findElement(By.xpath("//div[@class='features_items']"));
        if (allProducts.isDisplayed()) {
            System.out.println("List test is PASSED");
        } else {
            System.out.println("List test is FAİLED");
        }
        //7. Click on 'View Product' of first product
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
        //8. User is landed to product detail page
        WebElement detail = driver.findElement(By.xpath("//div[@class='product-information']"));
        if (detail.isDisplayed()) {
            System.out.println("Detail test is PASSED");
        } else {
            System.out.println("Detail test is FAİLED");
        }
        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        WebElement productName = driver.findElement(By.xpath("//h2[text()='Blue Top']"));
        WebElement category = driver.findElement(By.xpath("//p[text()='Category: Women > Tops']"));
        WebElement price = driver.findElement(By.xpath("//span[text()='Rs. 500']"));
        WebElement availability = driver.findElement(By.xpath("//b[text()='Availability:']"));
        WebElement condition = driver.findElement(By.xpath("//b[text()='Condition:']"));
        WebElement brand = driver.findElement(By.xpath("//b[text()='Brand:']"));

        if (productName.isDisplayed()) System.out.println("ProductName test is PASSED");
        else System.out.println("ProductName test is FAİLED");
        if (productName.isDisplayed()) System.out.println("Category test is PASSED");
        else System.out.println("Category test is FAİLED");
        if (productName.isDisplayed()) System.out.println("Price test is PASSED");
        else System.out.println("Price test is FAİLED");
        if (productName.isDisplayed()) System.out.println("availability test is PASSED");
        else System.out.println("availability test is FAİLED");
        if (productName.isDisplayed()) System.out.println("condition test is PASSED");
        else System.out.println("condition test is FAİLED");
        if (productName.isDisplayed()) System.out.println("Brand test is PASSED");
        else System.out.println("Brand test is FAİLED");

        driver.quit();

    }
}
