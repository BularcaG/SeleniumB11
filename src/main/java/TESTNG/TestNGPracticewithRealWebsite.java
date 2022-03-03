package TESTNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestNGPracticewithRealWebsite {

    @Test //testing if the website is good or not

    public void validateWebSite() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        String actualWebsite = driver.getCurrentUrl();
        String expectedURLD = "https://demo.opencart.com/admin/";
        Assert.assertEquals(actualWebsite, expectedURLD);
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
    }
        @Test

           public void validateCatalogisDisplayed() {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.opencart.com/admin/");

            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
            loginButton.click();
            WebElement catalogbar=driver.findElement(By.id("menu-catalog"));

            boolean ActualCatalog=catalogbar.isDisplayed();
            boolean ExpectedCatalog=true;
            Assert.assertEquals(ActualCatalog,ExpectedCatalog,"Catalog is not there");
            catalogbar.click();


        }

        @Test

    public void validateProductsIsDisplayed(){
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.opencart.com/admin/");

            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
            loginButton.click();
            WebElement catalogbar=driver.findElement(By.id("menu-catalog"));
            catalogbar.click();
            WebElement productBar=driver.findElement(By.xpath("//a[.='Products']"));
            boolean actualproductbar= productBar.isDisplayed();
            boolean ExpectedProductBar=true;
            Assert.assertEquals(actualproductbar,ExpectedProductBar);
            productBar.click();

        }

        @Test
    public void validationOfBoxes() throws InterruptedException {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.opencart.com/admin/");

            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
            loginButton.click();
            WebElement catalogbar=driver.findElement(By.id("menu-catalog"));
            catalogbar.click();
            WebElement productBar=driver.findElement(By.xpath("//a[.='Products']"));
//            boolean actualproductbar= productBar.isDisplayed();
//            boolean ExpectedProductBar=true;
//            Assert.assertEquals(actualproductbar,ExpectedProductBar);
            Thread.sleep(1000);
            productBar.click();




            List<WebElement> boxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
            for(int i=1;i< boxes.size();i++){
                Thread.sleep(500);
                boxes.get(i).click();
                boolean actualBoxValidation=boxes.get(i).isDisplayed();
                boolean expectedBoxValidation=true;
                boolean actualBoxValidationisSelected=boxes.get(i).isSelected();
                boolean expectedBoxValidationisExpected=true;

                Assert.assertEquals(actualBoxValidation,expectedBoxValidation);
                Assert.assertEquals(actualBoxValidationisSelected,expectedBoxValidationisExpected);



            }

        }

    }

