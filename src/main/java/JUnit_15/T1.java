package JUnit_15;

import Methods.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class T1 extends TestBase {
    @Test
    public void test01(){

        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        //2.Web table tum body’sini yazdirin
        WebElement tumBody=driver.findElement(By.xpath("//table/tbody"));
        System.out.println(tumBody.getText());

        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedIcerik="Comfortable Gaming Chair";
        String actualIcerik=tumBody.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));

        //4.Web table’daki satir sayisinin 5 oldugunu test edin
        List<WebElement> tumSatir=driver.findElements(By.xpath("//tbody/tr"));
        int expectedSize=5;
        int actualSize=tumSatir.size();
        Assert.assertEquals(expectedSize,actualSize);

        //5.Tum satirlari yazdirin
        for (int i = 0; i < tumSatir.size(); i++) {
            System.out.println(i+1+". satir: "+tumSatir.get(i).getText());

        }

        //6. Web table’daki sutun sayisinin 4 olduğunu test edin
        List<WebElement> sutunList=driver.findElements(By.xpath("//tbody/tr[1]/td"));
        int expectedSutun=4;
        int actualSutun=sutunList.size();
        Assert.assertEquals(expectedSutun,actualSutun);

        //7. 3.sutunu yazdirin
        List<WebElement> ucuncuSutun=driver.findElements(By.xpath("//tbody/tr/td[3]"));
        List<String> ucuncuSutunStr=new ArrayList<>();
        for (WebElement each:ucuncuSutun) {
            ucuncuSutunStr.add(each.getText());
        }
        System.out.println(ucuncuSutunStr);


        //8. Tablodaki basliklari yazdirin
        List<WebElement> basliklarList=driver.findElements(By.xpath("//thead/tr/th"));
        for (int i = 0; i < basliklarList.size(); i++) {
            System.out.println(i+1+". baslik:"+basliklarList.get(i).getText());

        }

        //9. Satir ve sutun sayisini parametre olarak alip,
        //  hucredeki bilgiyi döndüren bir method olusturun

        System.out.println(bilgiyiDondurenMethod(2, 4));
        System.out.println(bilgiyiDondurenMethod(5,3));


        //10.  4.satirdaki category degerinin "Furniture" oldugunu test edin

        String expectedDeger="Furniture";
        String actualDeger=bilgiyiDondurenMethod(4,2);

        Assert.assertEquals(expectedDeger,actualDeger);


    }
    public String bilgiyiDondurenMethod(int satirNo, int sutunNo){
        // dinamik olmasi gereken locate'i duzenleyelim //tbody/tr[satirNo]/td[sutunNo]

        String dinamikYol="//tbody/tr["+satirNo+"]/td["+sutunNo+"]";
        WebElement dinamikLocate= driver.findElement(By.xpath(dinamikYol));

        return dinamikLocate.getText();
    }



    }
