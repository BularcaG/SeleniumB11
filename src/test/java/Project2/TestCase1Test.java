package Project2;

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

import static org.testng.Assert.*;
/*

Navigate to "http://automationpractice.com/index.php" Validate Cart (empty) text is displayed
Get all the product prices
Assert that sum of all product prices are $196.38 in main page
 */

public class TestCase1Test {

    @Test

    public void tc1(){


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        WebElement viewMyShoppingCart=driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
        Assert.assertTrue(viewMyShoppingCart.getText().contains("(empty)"));
        List<WebElement> allprices=driver.findElements(By.xpath("//span[@itemprop='price']"));
        List<WebElement> displayedPrices=new ArrayList<>();

        List<Double> doublePrices=new ArrayList<>();
        int sum=0;

        for(int i=0;i< allprices.size();i++){

            if(allprices.get(i).isDisplayed()){
                displayedPrices.add(allprices.get(i));
                sum+=Double.parseDouble(allprices.get(i).getText().trim().replace("$",""));
                doublePrices.add(Double.parseDouble(allprices.get(i).getText().trim().replace("$","")));
            }
        }
        Assert.assertTrue(sum==196.38,"Failed");
        Collections.sort(doublePrices);
        System.out.println("the lowest price on the site is "+doublePrices.get(0));
        Assert.assertTrue(16.4==doublePrices.get(0),"Lowest price failed to Match expected");




    }

}