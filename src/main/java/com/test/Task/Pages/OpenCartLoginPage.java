package com.test.Task.Pages;

import com.test.Task.TaskTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCartLoginPage {

    public void OpenCartLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "input-username")
    WebElement username;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    public void OpenCartLoginPage1(String username2,String password2){
        this.username.clear();
        this.username.sendKeys(username2);
        this.password.clear();
        this.password.sendKeys(password2);
        loginButton.click();
    }
}
