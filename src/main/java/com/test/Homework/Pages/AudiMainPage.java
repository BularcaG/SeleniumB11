package com.test.Homework.Pages;

import Utils.BrowserUtils;
import com.test.Homework.AudiTestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AudiMainPage {

   // WebDriver driver=new ChromeDriver();

    /*
    public AudiMainPage(WebDriver driver){
            PageFactory.initElements(driver,this);
        }
        */

    // public WebDriver driver;


    public AudiMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

   @FindBy(xpath = "//*[@id=\"nm-id-content\"]/div/div[2]/audi-model-band/div[2]/div[2]/div[1]/ul/li[1]/label[1]/picture[1]/img")
    WebElement SuvAndWagons;

   @FindBy(xpath = "//li[@class='nm-model-band-container-item nm-model-band-container-types-item0 nm-model-band-container-item-visible']//span[.='2022 Audi Q5']")
    WebElement Q52022;

    public void clickSUVAndWagonsButton(WebDriver driver) throws InterruptedException {

        BrowserUtils.scrollWithJS(driver,SuvAndWagons);
        Thread.sleep(1000);
        SuvAndWagons.click();
        Thread.sleep(2000);
    }

    public void clickSQ5Button(WebDriver driver) throws InterruptedException {

        Thread.sleep(1000);
        Q52022.click();
        Thread.sleep(2000);
    }
}

