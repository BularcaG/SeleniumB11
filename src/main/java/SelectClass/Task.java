package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Task {


    @Test

    public void task1(){


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.cars.com/");
        WebElement options=driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(options,"used","value");

        WebElement make=driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(make,"lexus","value");

        WebElement model=driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(model,"10","index");
        WebElement maxprice=driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        BrowserUtils.selectBy(maxprice,"10","index");
        WebElement distance=driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance,"10","index");
        WebElement zip=driver.findElement(By.xpath("//input[@class='sds-text-field']"));
        zip.clear();
        zip.sendKeys("60646");
        WebElement button=driver.findElement(By.xpath("//button[@data-linkname='search-used-make']"));
        button.click();

       WebElement header=driver.findElement(By.tagName("h1"));
       String actualheader=BrowserUtils.getText(header);
       String expected="Used Lexus GS 300 for sale";

        List<WebElement> headers=driver.findElements(By.xpath("//h2[@class='title']"));
        for(WebElement element:headers){

            boolean contains=element.getText().trim().contains("Lexus");
            Assert.assertTrue(contains);
        }









//select[@id='make-model-maximum-distance']

    }
}
