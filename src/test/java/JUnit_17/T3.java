package JUnit_17;

import Methods.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class T3 extends TestBase {
    @Test
    public void test01(){
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslikElementleri=driver.findElements(By.xpath("//*[@class='rt-thead -header']/*[@class='rt-tr']/*[@role='columnheader']"));
        for (int i = 0; i < baslikElementleri.size(); i++) {
            System.out.println(i+1+". baslik elementi: "+ baslikElementleri.get(i).getText());
        }
        //3. 3.sutunun basligini yazdirin
        WebElement ucuncuSutunBaslik= driver.findElement(By.xpath("(//*[@role='columnheader'])[3]"));
        System.out.println(ucuncuSutunBaslik.getText());
        //4. Tablodaki tum datalari yazdirin
        List<WebElement> tumDatalar= driver.findElements(By.xpath("//*[@role='gridcell']"));
        for (WebElement each:tumDatalar) {
            System.out.println(each.getText());
        }
        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        int sayac=0;
        for (int i = 0; i < tumDatalar.size(); i++) {
            if (tumDatalar.get(i).getText().equals(" ")||tumDatalar.get(i).getText().equals("")){
                sayac++;
            }

        }
        System.out.println("dolu datalar: " +(tumDatalar.size()-sayac));
        //6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleri=driver.findElements(By.xpath("//*[@class='rt-tbody']//*[@class='rt-tr-group']"));
        System.out.println("Satir sayisi: "+satirElementleri.size());
        //7. Tablodaki sutun sayisini yazdirin
        List<WebElement> sutunElementleri=driver.findElements(By.xpath("(//*[@class='rt-tr-group'])[1]//*[@class='rt-td']"));
        System.out.println("Sutun sayisi: "+sutunElementleri.size());


    }
}
