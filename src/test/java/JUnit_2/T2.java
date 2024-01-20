package JUnit_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);
        //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        //4. Login tusuna basin
        driver.findElement(By.xpath("//*[@value='Login']")).click();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        driver.findElement(By.xpath("(//div[@class='inventory_item_name '])[1]")).click();
        Thread.sleep(2000);
        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("(//button[@id='add-to-cart-sauce-labs-backpack'])[1]")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Thread.sleep(2000);
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement urunElement = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        String expectedUrun = "Sauce Labs Backpack";
        String actualUrun = urunElement.getText();
        if (expectedUrun.equals(actualUrun)) {
            System.out.println("Urun ekleme testi PASSED");
        } else {
            System.out.println("Urun ekleme testi FAİLED");
        }
        //9. Sayfayi kapatin
        Thread.sleep(2000);
        driver.quit();
    }
}
