package maven_7;

import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class T2 extends TestBase {
    @Test
    public void authentication01(){

        //1- https://the-internet.herokuapp.com/basic_auth
        //sayfasina gidin
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        //2- asagidaki yontem ve test datalarini kullanarak
        //authentication’i yapin
        //Html komutu : https://username:password@URL
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //Username : admin
        //password : admin
        //4- Basarili sekilde sayfaya girildigini dogrulayin
        WebElement result= driver.findElement(By.tagName("p"));
        Assert.assertTrue(result.isDisplayed());
    }
}
