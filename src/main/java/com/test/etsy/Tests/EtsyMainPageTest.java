package com.test.etsy.Tests;

import com.test.etsy.EtsyTestBase;
import com.test.etsy.Pages.EtsyMainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;






public class EtsyMainPageTest extends EtsyTestBase {
    @Parameters("input")
    @Test
    public void Testing(String input){
        EtsyMainPage mainPageEtsy=new EtsyMainPage(driver);
        mainPageEtsy.inputSearch(input);
      //  Assert.assertTrue(mainPageEtsy);
    }


}
