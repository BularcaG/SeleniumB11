package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class homework4 {
    /*

    Steps
Navigate to "https://www.saucedemo.com/"
Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Find the cheapest two product on the page
Add them to the cart
Click cart button
Validate these two products is added to the cart
     */
    @Test

    public void h4(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        WebElement name=driver.findElement(By.id("user-name"));
        name.sendKeys("standard_user");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton=driver.findElement(By.id("login-button"));
        loginButton.click();

        List<WebElement> allprices=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<Double> allpricesascending=new ArrayList<>();

        for(int i=0;i< allprices.size();i++){

            allpricesascending.add(Double.valueOf(BrowserUtils.getText(allprices.get(i)).substring(1)));
            Collections.sort(allpricesascending);

        }
        System.out.println(allpricesascending);

        WebElement cheap1= allprices.get(0);
        WebElement cheap2=allprices.get(1);
        for(int j=0;j<allprices.size();j++){

            if(Double.valueOf(allprices.get(j).getText().substring(1)).equals(allpricesascending.get(0)))
            cheap1 = allprices.get(j);
            else
            if(Double.valueOf(allprices.get(j).getText().substring(1)).equals(allpricesascending.get(1)))
            cheap2=allprices.get(j);
        }
        System.out.println(cheap1.getText());
        System.out.println(cheap2.getText());
        Actions actions=new Actions(driver);

        List<WebElement> priceBar=driver.findElements(By.className("pricebar"));
        List<WebElement> addToCartButtons=driver.findElements(By.xpath("//button[.='Add to cart']"));


        for(int k=0;k<priceBar.size();k++){
            if(priceBar.get(k).getText().contains(cheap1.getText()))
                addToCartButtons.get(k).click();
            if(priceBar.get(k).getText().contains(cheap2.getText()))
                addToCartButtons.get(k).click();
        }

        WebElement cartButton=driver.findElement(By.className("shopping_cart_link"));
        cartButton.click();

        List<WebElement> allprices1=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        String actualprice1=allprices1.get(0).getText();
        String expected1=cheap1.getText();

        String actualprice2=allprices1.get(1).getText();
        String expected2=cheap2.getText();
        Assert.assertEquals(actualprice1,expected1);
        Assert.assertEquals(actualprice2,expected2);





        }





    }

