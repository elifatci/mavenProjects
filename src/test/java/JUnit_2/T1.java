package JUnit_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T1 {


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@class='signin btn btn-info']")).click();
        //3. Login alanine “username” yazdirin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");
        //4. Password alanina “password” yazdirin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@value='Sign in']")).click();
        //6. Back tusu ile sayfaya donun
        driver.navigate().back();
        //7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();
        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@class='span1']")).sendKeys("500");
        //9. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("2020-09-10");
        //10. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();
        //11. “The payment was successfully submitted.” mesajinin
        //ciktigini test edin
        WebElement mesajElement = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
        String expectedMesaj = "The payment was successfully submitted.";
        String actualMesaj = mesajElement.getText();

        if (expectedMesaj.equals(actualMesaj)) {
            System.out.println("Mesaj testi PASSED");
        } else {
            System.out.println("Mesaj testi FAİLED");
        }
        Thread.sleep(2000);
        driver.quit();
    }

}



