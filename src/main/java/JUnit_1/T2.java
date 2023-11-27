package JUnit_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T2 {
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
        //5. Verify 'New User Signup!' is visible
        WebElement newUser = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        if (newUser.isDisplayed()) {
            System.out.println("newUser test is PASSED");
        } else {
            System.out.println("newUser test is FAİLED");
        }
        //6. Enter name and already registered email address
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("elif");
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("ee@dd.com");
        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        //8. Verify error 'Email Address already exist!' is visible
        WebElement alreadyExist = driver.findElement(By.xpath("//p[text()='Email Address already exist!']"));
        if (alreadyExist.isDisplayed()) {
            System.out.println("alreadyExist test is PASSED");
        } else {
            System.out.println("alreadyExist test is FAİLED");
        }
        driver.quit();
    }
}
