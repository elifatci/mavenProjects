package JUnit_18;

import Methods.TestBase;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class T2 extends TestBase {

    @Test
    public void test01(){
        //1. "https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");
        //2. “create new account” butonuna basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();
        //3. “firstName” giris kutusuna bir isim yazin
        // 4. “surname” giris kutusuna bir soyisim yazin
        //        //5. “email” giris kutusuna bir email yazin
        //        //6. “email” onay kutusuna emaili tekrar yazin
        //        //7. Bir sifre girin
        //        //8. Tarih icin gun secin
        //        //9. Tarih icin ay secin
        //        //10. Tarih icin yil secin
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
                .sendKeys(faker.internet().password()).perform();

        WebElement day= driver.findElement(By.name("birthday_day"));
        Select select=new Select(day);
        select.selectByValue("24");
        WebElement month= driver.findElement(By.name("birthday_month"));
        Select select1=new Select(month);
        select1.selectByVisibleText("Eyl");
        WebElement year= driver.findElement(By.name("birthday_year"));
        Select select2=new Select(year);
        select2.selectByVisibleText("1991");



        //11. Cinsiyeti secin
        WebElement kadin= driver.findElement(By.xpath("(//*[@class='_8esa'])[1]"));
        WebElement erkek= driver.findElement(By.xpath("(//*[@class='_8esa'])[2]"));
        WebElement ozel= driver.findElement(By.xpath("(//*[@class='_8esa'])[3]"));
        kadin.click();

        //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        Assert.assertTrue(kadin.isSelected());
        Assert.assertFalse(erkek.isSelected() && ozel.isSelected());
        //13. Sayfayi kapatin

    }

}
