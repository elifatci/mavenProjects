package maven_7;

import Methods.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class T4 extends TestBase {
    @Test
    public void test01() {
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
        System.out.println(iframeList.size());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement playIframe = driver.findElement(By.xpath("(//iframe)[4]"));
        driver.switchTo().frame(playIframe);
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        //5) ikinci iframe'deki (Jmeter Made Easy) linke
        //(https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement linkIframe = driver.findElement(By.xpath("(//iframe)[5]"));
        driver.switchTo().frame(linkIframe);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
    }
}
