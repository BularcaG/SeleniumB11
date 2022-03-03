package com.test.Homework.Pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BuildPageAudiQ5 {

    public BuildPageAudiQ5(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[.='$ 43,300'and @class='nm-module-trimline-engine-price-tag']")
    WebElement startingPricePremium;
    @FindBy(xpath = "//div[.='Premium']")
    WebElement PremiumTag;
    @FindBy(xpath = "//div[@class='audi-headline-order-3 nm-module-trimline-engine-headline']")
    List<WebElement> PremiumPremiumPlusPrestigeTags;
    @FindBy(xpath = "//span[@class='nm-module-trimline-engine-price-tag'and contains(text(),'43,300')]")
    WebElement PremiumStartingPrice;
    @FindBy(xpath = "//span[@class='nm-module-trimline-engine-price-tag'and contains(text(),'48,300')]")
    WebElement PremiumPlusStartingPrice;
    @FindBy(xpath = "//span[@class='nm-module-trimline-engine-price-tag'and contains(text(),'54,000')]")
    WebElement PrestigeStartingPrice;
    @FindBy(xpath = "//li[@data-configurator-id='FYGCAY0WPS_2022']//span[@class='audi-checkbox-symbol nm-module-trimline-engine-checkbox']//*[@class='nm-icon-select-small nm-module-trimline-engine-icon-check']//..")
    WebElement PremiumPlus45TFSIBox;
    @FindBy(xpath = "//*[@id='dbad:audi:basket']//span[.='View key MSRP info']")
    WebElement viewKeyMSRPInfo;
    @FindBy(xpath = "//div[@class='audi-basket-configuration-value audi-basket-price-details__price-value']//span[@class='audi-basket-configuration-value__label' and .='$50,800']")
    WebElement MSRPconfirm;
    @FindBy(xpath = "//div[@class='audi-basket-configuration-value audi-basket-price-details__price-value']//span[@class='audi-basket-configuration-value__label' and .='$595']")
    WebElement aditionalOptions;
    @FindBy(xpath = "//div[@class='audi-basket-configuration-value audi-basket-price-details__price-value']//span[@class='audi-basket-configuration-value__label' and .='$1,195']")
    WebElement destinationCharge;
    @FindBy(xpath = "//div[@class='audi-basket-configuration-value audi-basket-price-details__price-value']//span[@class='audi-basket-configuration-value__label' and .='$52,590']")
    WebElement totalPRICE;





    public String validateStartingPrice(){
        return startingPricePremium.getText();
    }

    public int ValidateNrOfPackagesTypes(){
        return PremiumPremiumPlusPrestigeTags.size();
    }

    public void clickPremiumPlus45TFSIBox(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        BrowserUtils.scrollWithJS(driver,PremiumPlus45TFSIBox);
        BrowserUtils.clickWithJS(driver,PremiumPlus45TFSIBox);
    }
    public void clickMSRPButton(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        BrowserUtils.scrollWithJS(driver,viewKeyMSRPInfo);
        BrowserUtils.clickWithJS(driver,viewKeyMSRPInfo);
    }


    public WebElement getPremiumStartingPrice() {
        return PremiumStartingPrice;
    }

    public WebElement getPremiumPlusStartingPrice() {
        return PremiumPlusStartingPrice;
    }

    public WebElement getPrestigeStartingPrice() {
        return PrestigeStartingPrice;
    }
    public WebElement getMSRPconfirm(){
        return MSRPconfirm;
    }
    public WebElement getAdditionalOptions(){
        return aditionalOptions;
    }

    public WebElement getdestinationCharge(){
        return destinationCharge;
    }
    public WebElement getTotalPrice1(){
        return totalPRICE;
    }

    public double priceValidation(){
        double StartingMSRP=Double.parseDouble(MSRPconfirm.getText().replace("$","").replace(",","."));
        System.out.println(StartingMSRP);
        double additionalOptions=Double.parseDouble(aditionalOptions.getText().replace("$","").replace(",","."));
        System.out.println(additionalOptions);
        double destinationCharge1=Double.parseDouble(destinationCharge.getText().replace("$","").replace(",","."));
        System.out.println(destinationCharge1);
        double Total=StartingMSRP+additionalOptions+destinationCharge1;
        System.out.println(Total);
        return Total;
    }


}
