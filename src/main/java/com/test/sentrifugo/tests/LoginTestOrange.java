package com.test.sentrifugo.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginTestOrange {


public LoginTestOrange(WebDriver driver){
    PageFactory.initElements(driver,this);

}

@FindBy(id = "txtUsername")
WebElement userName;
}
