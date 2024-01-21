package JUnit_20;

import Methods.ReusableMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class T1 {

    public static void main(String[] args) {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://practice.automationtesting.in/");
        //3) Click on Shop Menu
        driver.findElement(By.cssSelector("#menu-item-40")).click();
        //4) Now click on Home menu button
        driver.findElement(By.linkText("Home")).click();
        //5) Test whether the Home page has Three Sliders only
        List<WebElement> sliders=driver.findElements(By.cssSelector(".row_inner_wrapper"));
        if (sliders.size()==3){
            System.out.println("home page has Three Sliders");
        }else {
            System.out.println("home page has not Three Sliders");
        }





    }
}
