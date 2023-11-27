package JUnit_5;

import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class T2 extends TestBase {
    @Test
    public void test01() {
        // Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
        // a. Verilen web sayfasına gidin.
        // https://facebook.com
        driver.get("https://facebook.com");
        // 	b. Cookies’i kabul edin
        // 	c. Create an account buton’una basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        // 	d. Radio button elementlerini locate edin ve size uygun olani secin
        WebElement kadinRadioButton = driver.findElement(By.xpath("(//input[@class='_8esa'])[1]"));
        kadinRadioButton.click();
        WebElement erkekRadioButton = driver.findElement(By.xpath("(//input[@class='_8esa'])[2]"));
        WebElement digerRadioButton = driver.findElement(By.xpath("(//input[@class='_8esa'])[3]"));
        // 	e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assert.assertTrue(kadinRadioButton.isSelected());
        Assert.assertFalse(erkekRadioButton.isSelected());
        Assert.assertFalse(digerRadioButton.isSelected());
    }

}
