package com.test.Homework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
/*
Navigate to "https://www.audiusa.com/" Click SUVs & Wagons
Get all the product prices for SUVs & Wagons Select 2022 Q5
Validate the car year and Q5 is matching
Click Build button
Validate starting price is "44,100"
Validate three version of car
Premium starting at 44,100 Premium Plus starting at 49,100 Prestige starting at 54,800
Validate three version has two different options
45 TFSI
55 TFSI® e Plug-in hybrid
 */
/*
Select Premium Plus 45 TFSI
Click View "View key MSRP info" button Validate MSRP is $44,100
Validate Additional Options is $595 Validate Destination Charge is $1,095
Validate Total price is Base price + Additonal Options + Destination Charge
Close the MSRP Info
 */

public class AudiSQ5Page {

    public AudiSQ5Page(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//a[@class='sc-fzqBZW jkEZoQ']")
    WebElement buildButton;

    @FindBy(xpath = "//h1[@class='sc-pbxSd jSSYpn']//span")
    WebElement carDescription;

    public String SQ5YearAndName(){
        return carDescription.getText();
    }

    public void clickBuildButton() throws InterruptedException {
        Thread.sleep(1000);
        buildButton.click();
    }

}
