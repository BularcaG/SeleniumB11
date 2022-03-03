package com.test.orangehrm.Tests;

import com.test.orangehrm.Pages.LoginPage;
import com.test.orangehrm.Pages.MainPage;
import com.test.orangehrm.Pages.PimPage;
import com.test.orangehrm.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PimTest extends TestBase {
    LoginPage loginPage;
    MainPage mainPage;
    PimPage pimPage;
    @BeforeMethod
    public void initiliazingPages(){
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        pimPage = new PimPage(driver);
    }
    @Test
    public void ValidateTheCreationOfEmployee() throws InterruptedException {
        loginPage.login("Admin","admin123");
        mainPage.clickPimButton();
        pimPage.addEmployeeForPIM("ahmet","Baldir","1991","/Users/techtorial/Desktop/usa.png");
        Assert.assertEquals(pimPage.validateFirstName(),"ahmet");
        Assert.assertEquals(pimPage.validateLastName(),"Baldir");
        Assert.assertTrue(pimPage.validateEmployeeId("1991"));

    }
    @Test
    public void ValidatePersonalDetailElement() throws InterruptedException {
        loginPage.login("Admin","admin123");
        mainPage.clickPimButton();
        pimPage.addEmployeeForPIM("ahmet","Baldir","1991","/Users/techtorial/Desktop/usa.png");
        pimPage.editPersonalDetails("Turkish","1991-08-13","Single");
        Assert.assertEquals(pimPage.validateTheNationality(),"Turkish");
    }


}
