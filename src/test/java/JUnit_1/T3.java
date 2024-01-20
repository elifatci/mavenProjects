package JUnit_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T3 {
    public static void main(String[] args) throws InterruptedException {
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
        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();
        //5. Verify 'GET IN TOUCH' is visible
        WebElement getinTouch = driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]"));
        if (getinTouch.isDisplayed()) {
            System.out.println("getinTouch test is PASSED");
        } else {
            System.out.println("getinTouch test is FAİLED");
        }
        //6. Enter name, email, subject and message
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("elif");
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("ee@dd.com");
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("giris sorunu");
        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("giris yapamiyorum");
        //7. Upload file
        WebElement file = driver.findElement(By.xpath("//input[@name='upload_file']"));
        file.sendKeys("C:/Users/Elif/OneDrive/Masaüstü/el.png");


        //8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //9. Click OK button
        Thread.sleep(4000);
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement success = driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        if (success.isDisplayed()) {
            System.out.println("Success test is PASSED");
        } else {
            System.out.println("Success test is FAİLED");
        }
        //11. Click 'Home' button and verify that landed to home page successfully
        WebElement home = driver.findElement(By.xpath("//span[text()=' Home']"));
        home.click();
        homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        if (homePage.isDisplayed()) {
            System.out.println("HomePage test is PASSED");
        } else {
            System.out.println("HomePage test is FAİLED");
        }
        driver.quit();
    }
}
