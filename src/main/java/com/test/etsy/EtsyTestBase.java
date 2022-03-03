package com.test.etsy;

import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class EtsyTestBase {

    public WebDriver driver;
    @BeforeMethod
    public void etsysetup(){
        driver= DriverHelper.getDriver();
        driver.get("https://www.etsy.com/");
    }

    @AfterMethod
    public void Terminate(){
        DriverHelper.tearDown();
    }
}
