package JUnit_18;

import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class T1 extends TestBase {
    @Test
    public void test01(){
        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");
        //2.Web table tum header ve tum body'sini yazdirin
        WebElement tableHeader= driver.findElement(By.xpath("//table/thead"));
        System.out.println(tableHeader.getText());
        WebElement tableBody= driver.findElement(By.xpath("//table/tbody"));
        System.out.println(tableBody.getText());
        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedIcerik="Comfortable Gaming Chair";
        Assert.assertTrue(tableBody.getText().contains(expectedIcerik));
        //4.Web table'daki satir sayisinin 5 oldugunu test edin
        List<WebElement> satirElementleri=driver.findElements(By.xpath("//tbody//tr"));
        Assert.assertTrue(satirElementleri.size()==5);
        //5.Tum satirlari yazdirin
        for (int i = 0; i < satirElementleri.size(); i++) {
            System.out.println(i+1+". element: "+satirElementleri.get(i).getText());
        }
        //6. Web table'daki sutun sayisinin 4 olduğunu test edin
        List<WebElement> sutunElementleri= driver.findElements(By.xpath("//tr[1]//td"));
        Assert.assertTrue(sutunElementleri.size()==4);
        //7. 3.sutunu yazdirin
        List<WebElement> ucuncuSatir=driver.findElements(By.xpath("//tr//td[3]"));
        for (WebElement each:ucuncuSatir) {
            System.out.println("Ucuncu sutun elementleri: "+each.getText());
        }
        //8. Tablodaki basliklari yazdirin
        List<WebElement> baslikElementleri=driver.findElements(By.xpath("//tr//th"));
        for (WebElement each:baslikElementleri) {
            System.out.println(each.getText());
        }
        //10.  4.satirdaki category degerinin "Furniture" oldugunu test edin
        WebElement dorduncuSatirElementi= driver.findElement(By.xpath("//tr[4]//td[2]"));
        String expectedDeger="Furniture";
        Assert.assertEquals(expectedDeger,dorduncuSatirElementi.getText());

    }
}
