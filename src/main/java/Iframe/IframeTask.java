package Iframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTask {
    @Test

    public void task1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");
        WebElement pavilion=driver.findElement(By.linkText("Pavilion"));
        Thread.sleep(2000);
        pavilion.click();
        BrowserUtils.switchByTitle(driver,"Home - qavalidation");
        WebElement Selenium=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']//.."));
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(Selenium).perform();
        WebElement seleniumJava=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Java']//.."));
        Thread.sleep(2000);
        actions.click(seleniumJava).perform();
        WebElement header= driver.findElement(By.tagName("h1"));
        String actualheader=BrowserUtils.getText(header);
        String expectedheader="Selenium-Java Tutorial – Basic to Advance";
        Assert.assertEquals(actualheader,expectedheader);
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver,"iframes");//I am switching the window to main window
        driver.switchTo().frame("Frame1");
        WebElement category1= driver.findElement(By.xpath("//a[.='Category1']"));//nosuch element because it is in iframe
        Thread.sleep(2000);
        category1.click();
        BrowserUtils.switchByTitle(driver,"qavalidation");
        Assert.assertTrue(driver.getTitle().endsWith("qavalidation"));
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame2");
        WebElement category3= driver.findElement(By.xpath("//a[.='Category3']"));
        Thread.sleep(2000);
        category3.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives");
        Assert.assertTrue(driver.getCurrentUrl().equals("https://qavalidation.com/category/softwaretesting/"));
        Thread.sleep(2000);
    }
}
