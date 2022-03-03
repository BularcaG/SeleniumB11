package com.test.sentrifugo.tests;

import com.test.orangehrm.TestBase;
import com.test.sentrifugo.pages.LoginPage;
import com.test.sentrifugo.pages.MainPage;
import org.testng.annotations.Test;

public class AdminTest extends TestBase {

    @Test
    public void validateTheCreationOfTheEmployeeMessage(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("Admin","admin123");
        MainPage mainpage=new MainPage(driver);
       // mainpage.

    }
}
