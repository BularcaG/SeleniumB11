package com.test.Homework.Tests;

import Utils.BrowserUtils;
import com.test.Homework.AudiTestBase;
import com.test.Homework.Pages.AudiMainPage;
import com.test.Homework.Pages.AudiSQ5Page;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AudiSQ5PageTest extends AudiTestBase {

    AudiMainPage audiMainPage;
    AudiSQ5Page  audiSQ5Page;
   // WebDriver driver;
@BeforeMethod

public void initializePages(){
    audiMainPage=new AudiMainPage(driver);
    audiSQ5Page=new AudiSQ5Page(driver);
}
    @Test

    public void NameAndYearValidation() throws InterruptedException {

          audiMainPage.clickSUVAndWagonsButton(driver);
          audiMainPage.clickSQ5Button(driver);
          Assert.assertTrue(audiSQ5Page.SQ5YearAndName().contains("2022"));
          Assert.assertTrue(audiSQ5Page.SQ5YearAndName().contains("Q5"));
    }

}
