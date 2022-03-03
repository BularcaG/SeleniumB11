package com.test.orangehrm.Tests;

import com.test.orangehrm.Pages.AdminPage;
import com.test.orangehrm.Pages.LoginPage;
import com.test.orangehrm.Pages.MainPage;
import com.test.orangehrm.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminTest extends TestBase {
    AdminPage adminPage;
    @BeforeMethod
    public void initiliazePages(){
        adminPage = new AdminPage(driver);
    }

    @Test
    public void validateTheCreationOfEmployeeMessage() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("Admin","admin123");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAdminButton();
        // AdminPage adminPage = new AdminPage(driver);
        adminPage.sendingAllInformationForEmployee();
        Assert.assertTrue(adminPage.ValidationTheEmployeeIsCreated("ahmetnewahmet1546"));
    }
}
