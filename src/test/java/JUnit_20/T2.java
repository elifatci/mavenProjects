package JUnit_20;

import Methods.ReusableMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static Methods.BeforeClass.driver;

public class T2 {
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
     //5) Test whether the Home page has Three Arrivals only
        List<WebElement> sliders=driver.findElements(By.className("woocommerce-LoopProduct-link"));
        if (sliders.size()==3){
            System.out.println("home page has Three Sliders");
        }else {
            System.out.println("home page has not Three Sliders");
        }
     //6) The Home page must contains only three Arrivals
     //7) Now click the image in the Arrivals
        sliders.get(1).click();
     //8) Test whether it is navigating to next page where the user can add that book into his basket.
        WebElement textThinking=driver.findElement(By.cssSelector(".product_title.entry-title"));
        Assert.assertTrue(textThinking.isDisplayed());
        WebElement buttonAddAtToBasket= driver.findElement(By.cssSelector(".single_add_to_cart_button.button.alt"));
        buttonAddAtToBasket.click();
     //9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
        WebElement imageThinking= driver.findElement(By.xpath("//*[@title='Thinking in HTML']"));
        Assert.assertTrue(imageThinking.isEnabled());
        WebElement buttonViewBasket= driver.findElement(By.cssSelector(".button.wc-forward"));
        Assert.assertTrue(buttonViewBasket.isDisplayed());
     //10) Click on Description tab for the book you clicked on.
        WebElement buttonDescription= driver.findElement(By.cssSelector(".description_tab.active"));
        buttonDescription.click();
     //11) There should be a description regarding that book the user clicked on
    WebElement textProductDescription= driver.findElement(By.xpath("(//*[@class='layoutArea'])[2]"));
    Assert.assertTrue(textProductDescription.isDisplayed());
    }
}
