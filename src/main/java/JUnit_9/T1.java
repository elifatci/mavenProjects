package JUnit_9;

import Methods.ReusableMethods;
import Methods.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class T1 extends TestBase {
    @Test
    public void fakerTest(){
        //1. "https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");
        //2. “create new account” butonuna basin
        ReusableMethods.Wait(3);
        driver.findElement(By.linkText("Yeni hesap oluştur")).click();
        //3. “firstName” giris kutusuna bir isim yazin
        //4. “surname” giris kutusuna bir soyisim yazin
        //5. “email” giris kutusuna bir email yazin
        //6. “email” onay kutusuna emaili tekrar yazin
        //7. Bir sifre girin
        //8. Tarih icin gun secin
        //9. Tarih icin ay secin
        //10. Tarih icin yil secin
        //11. Cinsiyeti secin
        WebElement firstName= driver.findElement(By.name("firstname"));
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();
        actions.click(firstName)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("28")
                .sendKeys(Keys.TAB)
                .sendKeys("Kas")
                .sendKeys(Keys.TAB)
                .sendKeys("2020")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_LEFT)
                .perform();
        ReusableMethods.Wait(5);

        //13. Kaydol'a basip sayfayi kapatin
        driver.findElement(By.name("websubmit")).click();

        ReusableMethods.Wait(3);

    }
}
