package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class homework2 {
    /*
    Steps
Navigate to "https://www.saucedemo.com/"
Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Select Price (low-high) from drop down box
Validate the products are displayed according to their price
and they are displayed low price to high price
     */

    @Test

    public void h2(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        WebElement name=driver.findElement(By.id("user-name"));
        name.sendKeys("standard_user");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton=driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement menu=driver.findElement(By.className("product_sort_container"));
        menu.click();
        BrowserUtils.selectBy(menu,"Price (low to high)","text");

        List<WebElement> allPrices=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        List<Double> actualPrices=new ArrayList<>();
        List<Double> expectedPrices=new ArrayList<>();




        for(int i=0;i<allPrices.size();i++){
            actualPrices.add(Double.parseDouble(BrowserUtils.getText(allPrices.get(i)).substring(1)));
            expectedPrices.add(Double.parseDouble(BrowserUtils.getText(allPrices.get(i)).substring(1)));
            Collections.sort(expectedPrices);

        }
        System.out.println(actualPrices);
        System.out.println(expectedPrices);
        Assert.assertEquals(actualPrices,expectedPrices);

    }
}
