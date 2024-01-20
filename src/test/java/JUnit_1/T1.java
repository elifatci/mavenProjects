package JUnit_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //2. Navigate to url 'http://automationexercise.com'

        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        if (homePage.isDisplayed()) {
            System.out.println("HomePage test is PASSED");
        } else {
            System.out.println("HomePage test is FAİLED");
        }
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //5. Verify 'Login to your account' is visible
        WebElement loginTo = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        if (loginTo.isDisplayed()) {
            System.out.println("LoginTo test is PASSED");
        } else {
            System.out.println("LoginTo test is FAİLED");
        }
        //6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ee@dd.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("11");
        //7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        //8. Verify that 'Logged in as username' is visible
        WebElement logged = driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        if (logged.isDisplayed()) {
            System.out.println("Logged test is PASSED");
        } else {
            System.out.println("Logged test is FAİLED");
        }
        //9. Click 'Logout' button
        driver.findElement(By.xpath("//a[@href='/logout']")).click();
        //10. Verify that user is navigated to login page
        loginTo = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        if (loginTo.isDisplayed()) {
            System.out.println("LoginTo test is PASSED");
        } else {
            System.out.println("LoginTo test is FAİLED");
        }
        driver.quit();

    }
}
