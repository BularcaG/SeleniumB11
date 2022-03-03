package JavaScriptExecutor;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSMethods {
        //whenever normal methods are not working than last decision shoul be java script


    @Test

    public void TitleMethod(){


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle()+" from driver");

//        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;
//        String title=javascriptExecutor.executeScript("return document.title").toString();
//        System.out.println(title+" from java script");

        String actualTitle= BrowserUtils.GetTitleWithJavaScript(driver);
        String expectedTitle="Home Page - Techtorial";
        Assert.assertEquals(expectedTitle,actualTitle);
    }


    @Test // I use this OFTEN !!!

    public void ClickWithJS(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        WebElement browserCourse=driver.findElement(By.xpath("//a[.='Browse Course']"));

//        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;
//        javascriptExecutor.executeScript("arguments[0].click()",browserCourse) ;

        BrowserUtils.clickWithJS(driver,browserCourse);

        WebElement login=driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Student login']"));

        BrowserUtils.clickWithJS(driver,login);

    }


    @Test

    public void ScrollIntoView(){     // MOST IMPORTANT !!

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        WebElement copyright=driver.findElement(By.xpath("//p[contains(text(),'Copy')]"));

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",copyright);

        WebElement browser=driver.findElement(By.xpath("//a[.='Browse Course']"));
        BrowserUtils.clickWithJS(driver,browser);
        WebElement getStarted=driver.findElement(By.xpath("//h4[..//.='On-Campus Course']//..//a"));
        BrowserUtils.scrollWithJS(driver,getStarted);
        BrowserUtils.clickWithJS(driver,getStarted);


    }

@Test
    public void ScrollWithXandYCoordinatTest(){

        // This is interview question (Point Class)

    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.get("http://www.techtorialacademy.com/");
    WebElement copyright=driver.findElement(By.xpath("//p[contains(text(),'Copy')]"));
//    JavascriptExecutor js=(JavascriptExecutor) driver;
//    Point location=copyright.getLocation();
//    System.out.println(location.getX());
//    System.out.println(location.getY());
//    int xCord=location.getX();
//    int yCord=location.getY();
//    js.executeScript("window.scrollTo("+xCord+","+yCord+")");
   // BrowserUtils.scrollWithXandYCord(driver,copyright);

    WebElement contact=driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Contact Us']"));

    Point coordinatesOFContactUs=contact.getLocation();
    int xCord=coordinatesOFContactUs.getX();
    int YCord=coordinatesOFContactUs.getY();

    Actions actions=new Actions(driver);
    actions.moveByOffset(xCord,YCord).click().perform();
//    BrowserUtils.scrollWithXandYCord(driver,contact);
//    BrowserUtils.clickWithJS(driver,contact);


}


}
