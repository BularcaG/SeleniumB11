package com.test.Task.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpenCartMainPage {

    public void OpenCartMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//i[@class='fa fa-shopping-cart']/following-sibling::h2")
    WebElement totalOrders;
    @FindBy(xpath = "//i[@class='fa fa-credit-card']/following-sibling::h2")
    WebElement totalSales;
    @FindBy(xpath = "//i[@class='fa fa-user']/following-sibling::h2")
    WebElement totalCustomers;




}
