package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

//we are going to store our element locations and methods here

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "loginsubmit")
    WebElement loginButton;

    public void login(String username1,String password1){

        username.sendKeys("EM01");
        password.sendKeys("sentrifugo");
        loginButton.click();
    }

    public void dynamicLogin(String username,String password){
        this.username.clear();
        this.username.sendKeys(username);
        this.username.clear();
        this.password.sendKeys(password);
        loginButton.submit();
    }

}
