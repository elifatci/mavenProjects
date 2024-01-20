package JUnit_14;

import Methods.ReusableMethods;
import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class T5 extends TestBase {
    @Test
    public void test01(){
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com/");
        //2- tum cookie’leri listeleyin
        ReusableMethods.Wait(10);
        Set<Cookie> tumCookies=driver.manage().getCookies();
        int siraNo = 1 ;

        for (Cookie each : tumCookies
        ) {
            System.out.println(siraNo + "==> " + each);
            siraNo++;
        }

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin

        int expectedCookieSayisi = 5;
        int actualCookiesayisi = tumCookies.size();
        Assert.assertTrue(actualCookiesayisi > expectedCookieSayisi);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedValue="USD";
       String actualValue= driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals(expectedValue,actualValue);
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        //olusturun ve sayfaya ekleyin
        Cookie yeniCookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(yeniCookie);
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        Set<Cookie> tumCookiesYeni=driver.manage().getCookies();
        Assert.assertTrue(tumCookiesYeni.size()>tumCookies.size());
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assert.assertTrue(driver.manage().getCookieNamed("skin")==null);

        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        tumCookiesYeni=driver.manage().getCookies();
        Assert.assertTrue(tumCookiesYeni.size()==0);

    }
}
