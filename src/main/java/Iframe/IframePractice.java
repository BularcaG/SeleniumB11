package Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframePractice {

    @Test
    public void iframeTest(){


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();

        driver.switchTo().frame("mce_0_ifr"); // !!!!!! OPENING THE DOOR

        WebElement text1=driver.findElement(By.id("tinymce"));
        text1.clear();
        text1.sendKeys("testing");
        driver.switchTo().parentFrame();   // DO NOT FORGET TO SWITCH YOUR FRAME BEFORE YOU FIND THE ELEMENT( CLOSE THE DOOR )
        String actual=driver.findElement(By.tagName("h3")).getText();
        String expected="An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actual,expected);




    }
}
