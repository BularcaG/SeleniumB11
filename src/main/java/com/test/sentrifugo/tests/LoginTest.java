package com.test.sentrifugo.tests;

import Utils.ConfigReader;
import com.test.orangehrm.TestBase;
import com.test.sentrifugo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


//    @Test
//    public void ValidateSuperAdmin(){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
//        driver.manage().window().maximize();
//        WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
//        username.sendKeys("EM01");
//        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
//        password.sendKeys("sentrifugo");
//        WebElement loginButton=driver.findElement(By.xpath("//input[@id='loginsubmit']"));
//        loginButton.submit();
//    }


    @Test
    public void ValidateSuperAdmin(){

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
//        driver.manage().window().maximize();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.dynamicLogin(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("admin123"));
        //loginPage.login();
        String actualURL=driver.getCurrentUrl();
        String expectedURL="http://demo.sentrifugo.com/index.php/index/welcome";
        Assert.assertEquals(actualURL,expectedURL);

    }

    @Test
    public void ValidateManagement(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        driver.manage().window().maximize();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.dynamicLogin("EM02","sentrifugo");
        //loginPage.login();
        String actualTitle=driver.getTitle();
        String expectedTitle="Sentrifugo - Open Source HRMS";
        Assert.assertEquals(actualTitle,expectedTitle);
    }


}
