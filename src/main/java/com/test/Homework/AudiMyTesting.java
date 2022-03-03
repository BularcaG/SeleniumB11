package com.test.Homework;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AudiMyTesting {

    @Test

    public void testing() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.audiusa.com/");
        driver.manage().window().maximize();
        WebElement SUVS=driver.findElement(By.xpath("//*[@id=\"nm-id-content\"]/div/div[2]/audi-model-band/div[2]/div[2]/div[1]/ul/li[1]/label[1]/picture[1]/img"));
        BrowserUtils.scrollWithJS(driver,SUVS);
        Thread.sleep(5000);
        SUVS.click();
        WebElement SQ5Car=driver.findElement(By.xpath("//li[@class='nm-model-band-container-item nm-model-band-container-types-item0 nm-model-band-container-item-visible']//span[.='2022 SQ5 Sportback']"));
        SQ5Car.click();
    }
}
