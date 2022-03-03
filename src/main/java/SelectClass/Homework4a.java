package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Homework4a {
    @Test

    public void h5() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        WebElement name = driver.findElement(By.id("user-name"));
        name.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        List<WebElement> allprices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<Double> allpricesascending = new ArrayList<>();
        List<WebElement> addToCartButtons=driver.findElements(By.xpath("//button[.='Add to cart']"));

        for(int i=0;i< allprices.size();i++){

            allpricesascending.add(Double.valueOf(BrowserUtils.getText(allprices.get(i)).substring(1)));
            Collections.sort(allpricesascending);
        }

        for(int j=0;j<allprices.size();j++){

            if(Double.valueOf(allprices.get(j).getText().substring(1)).equals(allpricesascending.get(0)))
                addToCartButtons.get(j).click();
            else
            if(Double.valueOf(allprices.get(j).getText().substring(1)).equals(allpricesascending.get(1)))
                addToCartButtons.get(j).click();
        }

        WebElement cartButton=driver.findElement(By.className("shopping_cart_link"));
        cartButton.click();

        List<WebElement> allprices1 = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        
        Double expectedPrice1=allpricesascending.get(0);
        Double expectedPrice2=allpricesascending.get(1);
        Double actualPrice=Double.valueOf(allprices1.get(0).getText().substring(1));

      Assert.assertTrue(allprices1.get(0).isDisplayed());
      Assert.assertTrue(allprices1.get(1).isDisplayed());


    }
}