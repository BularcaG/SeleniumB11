package com.test.sentrifugo.tests;

import com.test.orangehrm.TestBase;
import com.test.sentrifugo.pages.LoginPage;
import com.test.sentrifugo.pages.MainPage;
import com.test.sentrifugo.pages.PimPage;
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
        Assert.assertEquals(pimPage.validateLastName(),"Baldird");
        Assert.assertTrue(pimPage.validateEmployeeId("1991"));
    }

    @Test
    public void validatePersonalDetailElement() throws InterruptedException {
    loginPage.login("Admin","admin123");
    mainPage.clickPimButton();
    pimPage.addEmployeeForPIM("ahmet","Baldir","1991","/Users/techtorial/Desktop/usa.png");
    pimPage.editPersonalData("Romania","1991-02-22","Single");
    Assert.assertEquals(pimPage.validateNAtionality(),"Turkish");


    }
}
