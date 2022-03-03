package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;
/*
Navigate to "https://demos.telerik.com/kendo-
ui/websushi#"
Click on top of Shiromi picture
Click > arrow
validate next item is Tekka maki
Click < arrow
Validate the item is Shiromi
Validate number of item 0 in the cart
 */

public class Homework1 {
    @Test

    public void h1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        Actions actions=new Actions(driver);
        WebElement shiromiPicture=driver.findElement(By.xpath("//img[@title='Shiromi']"));
        actions.moveToElement(shiromiPicture).perform();
        actions.click().perform();
        WebElement navigateText=driver.findElement(By.id("navigate-next"));
        actions.moveToElement(navigateText).perform();
        Thread.sleep(1000);
        actions.click().perform();
        Thread.sleep(1000);
        WebElement tekkamaki=driver.findElement(By.xpath("//h1[.='Tekka maki']"));

        String actual= tekkamaki.getText();
        String expected="Tekka maki";
       Assert.assertEquals(actual,expected);
       WebElement backArrow=driver.findElement(By.xpath("//a[@href='#/menu/8']"));

       actions.moveToElement(backArrow).perform();
       Thread.sleep(1000);
       actions.click().perform();
       Thread.sleep(1000);
       WebElement shiromi=driver.findElement(By.xpath("//h1[.='Shiromi']"));
       String actual1= shiromi.getText();
       String expected1="Shiromi";
       Assert.assertEquals(actual1,expected1);
       WebElement cart=driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
       String actual2=cart.getText();
       String expected2="0";
       Assert.assertEquals(actual2,expected2);

    }
    @Test

    public void Homework2() throws InterruptedException {
        /*
        Navigate to "https://demos.telerik.com/kendo-
ui/websushi#"
Click Add to cart for Edamame
Validate Item number is 1
Validate price of the product is $4
Click empty cart
Validate item number is 0
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        WebElement edamame = driver.findElement(By.xpath("//a[@href='#/menu/4']/following-sibling::button"));
//        Actions actions=new Actions(driver);
//        actions.moveToElement(edamame).click().perform();

       Thread.sleep(1000);
        edamame.click();
        Thread.sleep(1000);
       // BrowserUtils.clickWithJS(driver,edamame);

        WebElement one=driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
        String actual = one.getText();
        String expected="1";
        Assert.assertEquals(actual,expected);
        WebElement totalPrice=driver.findElement(By.xpath("//p[@class='total-price']"));
        String actual1=totalPrice.getText();
        System.out.println(totalPrice.getText());
        String expected1="$4.00";
        Assert.assertEquals(actual1,expected1);
        WebElement emptyCart=driver.findElement(By.xpath("//a[.='empty cart']"));
        emptyCart.click();
        one=driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
        Assert.assertEquals(one.getText(),"0");


    }

    @Test

    /*

    Navigate to "https://demos.telerik.com/kendo-
ui/websushi#"
Click picture of the Salmon Teriyaki
Click Add to cart button 2 times
Validate total price is $26
Validate item number is 1
Click > arrow button
Click add to cart for Gohan
Validate total price is $29
Validate total items 2
     */

    public void Homework3() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        WebElement salmon =driver.findElement(By.xpath("//a[@href='#/menu/16']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(salmon).click().perform();
        WebElement addToCart= driver.findElement(By.xpath("//button[.='Add to cart']"));
        Thread.sleep(2000);
        actions.moveToElement(addToCart).click().perform();
        addToCart= driver.findElement(By.xpath("//button[.='Add to cart']"));
        Thread.sleep(2000);
        actions.moveToElement(addToCart).click().perform();
        Thread.sleep(2000);
        WebElement totalPrice=driver.findElement(By.xpath("//p[@class='total-price']"));
        Assert.assertEquals(totalPrice.getText().trim(),"$26.00");
        WebElement one=driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
        Assert.assertEquals(one.getText().trim(),"1");
        WebElement navigateText=driver.findElement(By.id("navigate-next"));
        actions.moveToElement(navigateText).click().perform();
        Thread.sleep(1000);
        WebElement addToCart1= driver.findElement(By.xpath("//button[@class='buy']"));
        Thread.sleep(1000);
        actions.moveToElement(addToCart1).click().perform();
        WebElement number=driver.findElement(By.xpath("//p[.='$29.00']"));
        String actual=number.getText();
        String expected="$29.00";
        Assert.assertEquals(actual,expected);
        WebElement nrOfItems=driver.findElement(By.xpath("//span[@data-bind='text: cart.contentsCount']"));
        String actual1= nrOfItems.getText();
        String expected1="2";
        Assert.assertEquals(actual1,expected1);
        Thread.sleep(10000);
        driver.quit();

    }

    @Test
    /*
    Navigate to "https://demos.telerik.com/kendo-
ui/websushi#"
Validate price of all the products are less than $25
     */

    public void Homework4() throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");

        List<WebElement> allPrices=driver.findElements(By.xpath("//span[@class='price']"));


        int count=0;
        for(int i=0;i<allPrices.size();i++){

            Assert.assertTrue((Double.parseDouble(allPrices.get(i).getText().replace("$",""))<=25));
            System.out.println(allPrices.get(i).getText());
        }


    }
    @Test
    /*
    Navigate to "https://demos.telerik.com/kendo-
ui/websushi#"
Add 3 items to your cart
Click X button on the top added items
Validate items number is 2
     */
    public void Homework5() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        driver.findElement(By.xpath("//div[@class='k-listview-content']//li[1]//button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='k-listview-content']//li[2]//button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='k-listview-content']//li[3]//button")).click();
        Thread.sleep(2000);
        Actions actions=new Actions(driver);
//        for(int i=0;i<2;i++){
//            driver.findElement(By.xpath("//li[@class='selected-products-list k-listview-item'][1]//a")).click();
//            Thread.sleep(2000);
//        }
        WebElement e1=driver.findElement(By.xpath("//li[@class='selected-products-list k-listview-item'][1]//a"));


//        Thread.sleep(1000);
//        e1.click();
//        WebElement e2=driver.findElement(By.xpath("//li[@class='selected-products-list k-listview-item'][2]//a"));
//        Thread.sleep(2000);
//        e2.click();
//        Thread.sleep(1000);
//        WebElement e3=driver.findElement(By.xpath("//li[@class='selected-products-list k-listview-item'][1]//a"));
//        BrowserUtils.clickWithJS(driver,e3);
//        Thread.sleep(1000);


        Thread.sleep(10000);
        driver.quit();

    }
    @Test
    /*
    Navigate to "https://demos.telerik.com/kendo-
ui/websushi#"
Add Shiromi and Ebi Rolls into the cart
Click checkout button
Validate total price is 17
Increase the count of Ebi Roll with 2
Validate total is $25
Click order now
Validate cart is 0
     */
    public void Homework6() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        driver.findElement(By.xpath("//div[@class='k-listview-content']//li[8]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='k-listview-content']//li[14]/button")).click();
        WebElement checkoutButton=driver.findElement(By.xpath("//a[@href='#/checkout']"));
        Thread.sleep(5000);
        checkoutButton.click();
        WebElement total=driver.findElement(By.xpath("//span[.='$17.00']"));
        String actual=total.getText();
        String expected="$17.00";
        WebElement increase=driver.findElement(By.xpath("//tr[1]//button[@title='Increase value']"));
        increase.click();
        Thread.sleep(5000);
        increase.click();
        Thread.sleep(10000);
        WebElement totala=driver.findElement(By.xpath("//span[.='$35.00']"));
        String actual2= totala.getText();
        String expected2="$35.00";
        Assert.assertEquals(actual2,expected2);

       // Thread.sleep(60000);
       // driver.quit();


    }
}
