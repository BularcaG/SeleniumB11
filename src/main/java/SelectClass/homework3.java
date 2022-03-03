package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class homework3 {

/*
Given the user on saucedemo home page
Then user click the burger button on saucedemo home page
And the user will click the logout button
And user should see the login page
When the user navigate back from login page
Then the user still should see login page
Description: The user should not see the home page after
logout since the user already click the logout button. Write the
 test case to test this function and validate it is working correctly or not.
 */
    @Test
    public void h3(){

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
        WebElement burgerButton=driver.findElement(By.id("react-burger-menu-btn"));
        burgerButton.click();
        WebElement logout=driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        logout.click();
        String expectedUrl="https://www.saucedemo.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        driver.navigate().back();
        Assert.assertEquals(actualUrl,expectedUrl);

    }
}
