package MentoringWithNikita;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumPaint {
    public static int y=0;
    public static int x=0;

    public static void main(String[] args) throws InterruptedException {




        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://kleki.com/");
        WebElement canvas=driver.findElement(By.xpath("//canvas"));
        Actions actions =new Actions(driver);
//        actions.moveToElement(canvas).clickAndHold().moveByOffset(40,40).perform();
//        actions.release().perform();
//        actions.moveToElement(canvas).clickAndHold().moveByOffset(-40,-40).perform();
//        actions.moveToElement(canvas).clickAndHold().moveByOffset(0,140).perform();
//        actions.moveByOffset(x,y).clickAndHold().moveByOffset(40,40).perform();



        Thread.sleep(10000);
        driver.quit();

    }
}
