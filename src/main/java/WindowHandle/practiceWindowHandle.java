package WindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class practiceWindowHandle {
    @Test

    public void task() throws InterruptedException {
        /*


         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement element=driver.findElement(By.xpath("//h3[.='Button4']//..//button[contains(text(),'Open Multiple Tabs')]"));
        element.click();
        BrowserUtils.switchByTitle(driver,"Basic Controls");
        WebElement firstName=driver.findElement(By.id("firstName"));
        firstName.sendKeys("Gheorghe");
        driver.findElement(By.id("lastName")).sendKeys("Bularca");
        driver.findElement(By.id("malerb")).click();
        driver.findElement(By.id("email")).sendKeys("Bularca@Gmail.com");
        driver.findElement(By.id("password")).sendKeys("265323");
        driver.findElement(By.id("registerbtn")).click();
        String actual= driver.findElement(By.xpath("//label[.='Registration is Successful']")).getText();
        String expected="Registration is Successful";
        Assert.assertEquals(actual,expected);
        BrowserUtils.switchByTitle(driver,"AlertsDemo");
        driver.findElement(By.id("alertBox")).click();
        Thread.sleep(5000);
        driver.quit();


    }
}
