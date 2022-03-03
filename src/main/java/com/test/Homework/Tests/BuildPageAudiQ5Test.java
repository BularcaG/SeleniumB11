package com.test.Homework.Tests;

import Utils.BrowserUtils;
import com.test.Homework.AudiTestBase;
import com.test.Homework.Pages.AudiMainPage;
import com.test.Homework.Pages.AudiSQ5Page;
import com.test.Homework.Pages.BuildPageAudiQ5;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BuildPageAudiQ5Test extends AudiTestBase {
    AudiMainPage audiMainPage;
    AudiSQ5Page  audiSQ5Page;
    BuildPageAudiQ5 buildPageQ5;
    // WebDriver driver;
    @BeforeMethod

    public void initializePages(){
        audiMainPage=new AudiMainPage(driver);
        audiSQ5Page=new AudiSQ5Page(driver);
        buildPageQ5=new BuildPageAudiQ5(driver);
    }

    @Test
         public void ValidateStartingPrice() throws InterruptedException {
        audiMainPage.clickSUVAndWagonsButton(driver);
        audiMainPage.clickSQ5Button(driver);
        audiSQ5Page.clickBuildButton();
        Assert.assertTrue(buildPageQ5.validateStartingPrice().contains("43,300"));
    }
    @Test
    public void ValidateNrOfPackageOptions() throws InterruptedException {

        audiMainPage.clickSUVAndWagonsButton(driver);
        audiMainPage.clickSQ5Button(driver);
        audiSQ5Page.clickBuildButton();
        Assert.assertEquals(buildPageQ5.ValidateNrOfPackagesTypes(),3);

    }

    @Test

    public void ValidateStartingPricesforAllQ5Packages() throws InterruptedException {
        audiMainPage.clickSUVAndWagonsButton(driver);
        audiMainPage.clickSQ5Button(driver);
        audiSQ5Page.clickBuildButton();
        String PremiumStartingPrice=buildPageQ5.getPremiumStartingPrice().getText();
        String PremiumPlusStartingPrice=buildPageQ5.getPremiumPlusStartingPrice().getText();
        String PrestigeStartingPrice=buildPageQ5.getPrestigeStartingPrice().getText();
        Assert.assertTrue(PremiumStartingPrice.contains("43,300"));
        Assert.assertTrue(PremiumPlusStartingPrice.contains("48,300"));
        Assert.assertTrue(PrestigeStartingPrice.contains("54,000"));
    }

    @Test
    public void ValidateMSRPPrice() throws InterruptedException {
        audiMainPage.clickSUVAndWagonsButton(driver);
        audiMainPage.clickSQ5Button(driver);
        Thread.sleep(5000);
        audiSQ5Page.clickBuildButton();
        buildPageQ5.clickPremiumPlus45TFSIBox(driver);
        buildPageQ5.clickMSRPButton(driver);
        Assert.assertEquals(buildPageQ5.getMSRPconfirm().getText(),"$50,800");
        Assert.assertEquals(buildPageQ5.getAdditionalOptions().getText(),"$595");
        Assert.assertEquals(buildPageQ5.getdestinationCharge().getText(),"$1,195");
   //     Double TotalPricee=Double.parseDouble(buildPageQ5.getTotalPrice1().getText().replace("$",""));
       buildPageQ5.priceValidation();
      //  Assert.assertEquals(buildPageQ5.getTotalPrice1(),TotalPricee);

    }



}
