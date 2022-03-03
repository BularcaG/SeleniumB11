package com.test.Homework;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class AudiTestBase {

    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.audiusa.com/");
        driver.manage().window().maximize();
//        WebElement SUVS=driver.findElement(By.xpath("//label[@for='nm-model-band-1183220-types-0']//img"));
//        BrowserUtils.scrollWithJS(driver,SUVS);
//        SUVS.click();
//        WebElement SQ5Car=driver.findElement(By.xpath("//li[@class='nm-model-band-container-item nm-model-band-container-types-item0 nm-model-band-container-item-visible']//span[.='2022 SQ5 Sportback']"));
//        SQ5Car.click();

    }


}
