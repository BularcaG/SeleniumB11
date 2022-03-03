package com.test.etsy.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EtsyMainPage {

    public EtsyMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='global-enhancements-search-query']")
    WebElement searchBar;
    @FindBy(xpath = "//li//h3")
    List<WebElement> allHeathers;


    public void inputSearch(String input){
        searchBar.sendKeys(input,Keys.ENTER);
    }

    public boolean validateHeader(){
        for(WebElement header:allHeathers){
            String headr=header.getText().toLowerCase();
            if(!(headr.contains("iphone")||headr.contains("case")||headr.contains("13"))) return false;
        }
        return true;
    }

}
