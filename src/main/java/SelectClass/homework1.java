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

import java.util.*;

public class homework1 {

    /*

    TEST CASE 1

    Navigate to "https://www.saucedemo.com/"
Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Select Name (Z-A) from drop down box
Validate the products are displayed in descending order
     */

    @Test

    public void h1(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        WebElement name=driver.findElement(By.id("user-name"));
        name.sendKeys("standard_user");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton=driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement menu=driver.findElement(By.className("product_sort_container"));
        menu.click();
        BrowserUtils.selectBy(menu,"za","value");



        List<WebElement> productNames=driver.findElements(By.xpath("//a/div"));

        List<String> actualProductNames=new LinkedList<>();
        List<String> expectedProductNames=new ArrayList<>();

        for(int i=0;i< productNames.size();i++){
            actualProductNames.add(BrowserUtils.getText(productNames.get(i)));
            expectedProductNames.add(BrowserUtils.getText(productNames.get(i)));
            Collections.sort(expectedProductNames);
            Collections.reverse(expectedProductNames);

        }
        System.out.println(actualProductNames);
        System.out.println(expectedProductNames);
        Assert.assertEquals(actualProductNames,expectedProductNames);
    }
}
