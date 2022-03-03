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

public class MultiSelect {

    @Test
    public void multipleSelectandfirstSelectPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.navigate().to("file:///Users/gheorghebularca/Desktop/Techtorial/HTML/Techtorial%20(2).html");
        driver.manage().window().maximize();
        WebElement multiSelectBox=driver.findElement(By.xpath("//select[@class='select']"));
        BrowserUtils.selectBy(multiSelectBox,"Two","text");
        BrowserUtils.selectBy(multiSelectBox,"3","index");
        BrowserUtils.selectBy(multiSelectBox,"1","value");

        Select select =new Select(multiSelectBox);
        select.deselectByIndex(3);
        // trim() --> it removes the space from both sides of the string
        WebElement countryList=driver.findElement(By.name("country"));
        Select country =new Select(countryList);

        //String actualFirstSelectedOption=country.getFirstSelectedOption().getText().trim();  // junior level
        String actualFirstSelectedOption=BrowserUtils.getText(country.getFirstSelectedOption()); // senior level
        String expectedUSA="UNITED STATES";
        Assert.assertEquals(actualFirstSelectedOption,expectedUSA);

        //select.deselectAll();




    }
}
