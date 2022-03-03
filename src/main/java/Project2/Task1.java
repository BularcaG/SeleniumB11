package Project2;
import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.web.WebErrorEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Task1 {

    @Test
    public void TestCase1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        WebElement cartEmpty = driver.findElement(By.className("ajax_cart_no_product"));
        String actualCartEmpty = cartEmpty.getText().trim();
        String expectedCartEmpty = "(empty)";
        Assert.assertEquals(actualCartEmpty, expectedCartEmpty);
        //Assert.assertTrue(cartEmpty.getText().contains("(empty)"));

        //Get all the product prices --> there are 28, not 7
        List<WebElement> allPrices = driver.findElements(By.xpath("//span[@class='price product-price']"));
        List<WebElement> allDisplayedPrices = new ArrayList<>();
        List<Double> doublePrice = new ArrayList<>();

        double sum = 0;
        for (int i = 0; i < allPrices.size(); i++) {
            if (allPrices.get(i).isDisplayed()) {
                sum += Double.parseDouble(allPrices.get(i).getText().trim().replace("$", ""));
                doublePrice.add(Double.parseDouble(allPrices.get(i).getText().trim().replace("$", "")));
            }

        }


        Assert.assertTrue(sum == 196.38, "Sum of prices failed to mathc expected");
        Collections.sort(doublePrice);
        System.out.println("The lowest price on the site is " + doublePrice.get(0));
        Assert.assertTrue(16.4 == doublePrice.get(0), "LOWEST PRICE FAILED TO MATCH EXPECTED");

    }

    @Test
    /*

    Navigate to
"http://automationpractice.com/index.php"
Find cheapest product and assert that it is 16.40
(NOTE: your code should find the cheapest product
price on that page everytime. Chepest product price
can be $8 if there is new product added.)
     */

    public void TestCase2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        List<WebElement> allxpaths = driver.findElements(By.xpath("//span[@class='price product-price']"));
        TreeSet<Double> allPrices = new TreeSet<>();
        int min = 0;
        for (int i = 0; i < allxpaths.size(); i++) {

            if (allxpaths.get(i).isDisplayed()) {
                allPrices.add(Double.parseDouble(allxpaths.get(i).getText().replace("$", "")));
            }
        }
        double actual = allPrices.first();
        double expected = 16.40;
        Assert.assertEquals(actual, expected);

    }

    @Test
    /*
    Navigate to
"http://automationpractice.com/index.php"
Click add card button for first product
Validate "Product successfully added to your
shopping cart" message displayed
Validate color of text is green
     */

    public void TestCase3() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
//        List<WebElement> allxpath=driver.findElements(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=cart&add=1&id_product=1&token=e817bb0705dd58da8db074c69f729fd8']"));
//        for(WebElement real:allxpath){
//            actions.moveToElement(driver.findElement(By.xpath("//img[@alt='Faded Short Sleeve T-shirts']"))).perform();
//            if(real.isDisplayed()) real.click();
//
//        }
        actions.moveToElement(driver.findElement(By.xpath("//img[@alt='Faded Short Sleeve T-shirts']"))).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=cart&add=1&id_product=1&token=e817bb0705dd58da8db074c69f729fd8']")).click();
        Thread.sleep(5000);
        WebElement text = driver.findElement(By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//h2//i//.."));
        String actual = BrowserUtils.getText(text);
        String expected = "Product successfully added to your shopping cart";
        Assert.assertEquals(actual, expected);
        String actualcolor = text.getCssValue("color");
        String expectedcolor = "rgba(70, 167, 78, 1)";
        Assert.assertEquals(actualcolor, expectedcolor);

    }

    @Test
    /*
    Navigate to
"http://automationpractice.com/index.php"
Click Women
Click Summer Dresses
Click "Add to cart" for first product
Validate text "Product successfully added to your
shopping cart"
Validate price is matching in Popup
Validate the text "There is (*number*) item in your
cart."
Click Continue shopping
Validate "Cart (*number*) Product" text
     */

    public void TestCase4() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        WebElement women=driver.findElement(By.xpath("//a[@title='Women']"));
        Thread.sleep(5000);
        women.click();
        Thread.sleep(5000);
        Actions actions=new Actions(driver);
        WebElement dresses=driver.findElement(By.xpath("//div[@id='block_top_menu']//ul//li//ul//a[@title='Dresses']"));

//        actions.moveToElement(dresses).perform();
//        WebElement summerDresses=driver.findElement(By.xpath("//div[@id='block_top_menu']//ul//li//ul//li//ul//li//a[@title='Summer Dresses']"));
//        actions.moveToElement(summerDresses).click().perform();
//        //a[.='Summer Dresses']

    }

}
