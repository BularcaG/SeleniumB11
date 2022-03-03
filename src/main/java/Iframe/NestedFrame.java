package Iframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFrame {

@Test
    public void nestedframeValidation(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.get("https://the-internet.herokuapp.com/nested_frames\n");
    driver.manage().window().maximize();
    driver.switchTo().frame(0);   // this is exemple of using webelementto switch
    //This is exemple of using webElement to switch
    WebElement middleframe=driver.findElement(By.name("frame-middle"));
    driver.switchTo().frame(middleframe); //I am on the middle frame
    WebElement textbox=driver.findElement(By.xpath("//div[@id='content']"));
    String actuslName= BrowserUtils.getText(textbox);
    String expected="MIDDLE";
    Assert.assertEquals(actuslName,expected);
    driver.switchTo().parentFrame(); //top
    driver.switchTo().frame("frame-left");
    WebElement leftBox=driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
    String actualText= leftBox.getText();
    String expectedText="LEFT";
    Assert.assertEquals(actualText,expectedText);
//    driver.switchTo().parentFrame();
//    driver.switchTo().parentFrame();

    driver.switchTo().defaultContent(); //GOES DIRECTLY TO HTML
    driver.switchTo().frame("frame-bottom");
    String actual33= driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText();
    String expected33="BOTTOM";
    Assert.assertEquals(actual33,expected33);

}
}
