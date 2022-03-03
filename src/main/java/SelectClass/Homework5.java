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

//TEST CASE 4 PART1
/*

Steps
Navigate to "https://www.saucedemo.com/"
Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Find the highest priced two product on the page
Add them to the cart
Click cart button
Click CheckOut Button



Fill out First Name, Last Name and Zip Code
Click continue button
Validate Item total price is equals to total price of
selected product
Validate Total is equals to Item Total price plus Tax
amount
Validate the Url contains "checkout"
Click finish button
Validate "THANK YOU FOR YOUR ORDER" message is
displayed
Steps
 */

public class Homework5 {
    @Test

    public void h5(){


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


        for(int i=0;i<allprices.size();i++){

            allpricesascending.add(Double.valueOf(BrowserUtils.getText(allprices.get(i)).substring(1)));
            Collections.sort(allpricesascending);
            Collections.reverse(allpricesascending);
        }
        List<WebElement> addToCartButtons=driver.findElements(By.xpath("//button[.='Add to cart']"));

        for(int k=0;k<allprices.size();k++){

            if(Double.valueOf(allprices.get(k).getText().substring(1)).equals(allpricesascending.get(0)))
                addToCartButtons.get(k).click();
            else
            if(Double.valueOf(allprices.get(k).getText().substring(1)).equals(allpricesascending.get(1)))
                addToCartButtons.get(k).click();
        }
        WebElement cartButton=driver.findElement(By.className("shopping_cart_link"));
        cartButton.click();
        WebElement checkoutButton=driver.findElement(By.id("checkout"));
        checkoutButton.click();


        WebElement firstName=driver.findElement(By.id("first-name"));
        firstName.sendKeys("George");
        WebElement lastName=driver.findElement(By.id("last-name"));
        lastName.sendKeys("Black");
        WebElement zip=driver.findElement(By.id("postal-code"));
        zip.sendKeys("60555");
        WebElement continueButton=driver.findElement(By.id("continue"));
        continueButton.click();

        WebElement totalAmount=driver.findElement(By.className("summary_total_label"));
        List<WebElement> allprices3=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        double sum=0.0;
        for(int j=0;j<allprices3.size();j++){
            sum+=Double.valueOf(BrowserUtils.getText(allprices3.get(j)).substring(1));

        }

        WebElement sumarySubTotal=driver.findElement(By.className("summary_subtotal_label"));

        Assert.assertTrue(sumarySubTotal.getText().contains(String.valueOf(sum)));
        WebElement tax= driver.findElement(By.xpath("//div[@class='summary_tax_label']"));
        WebElement total=driver.findElement(By.className("summary_total_label"));
        double expected=sum+Double.valueOf(tax.getText().substring(6));
        String expected1=String.valueOf(expected).substring(0,5);

        Assert.assertTrue(total.getText().contains(expected1));
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout"));
        WebElement finishButton=driver.findElement(By.id("finish"));
        finishButton.click();

        WebElement message=driver.findElement(By.tagName("h2"));
        Assert.assertTrue(message.getText().equals("THANK YOU FOR YOUR ORDER"));




    }


}
