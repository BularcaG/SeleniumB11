package Alert;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertIntro {
    @Test

    public void intro(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        WebElement click=driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        click.click();
//        WebElement element=driver.findElement(By.tagName("h3"));
//        System.out.println(element.getText());          unhandledAlertexception
        Alert alert=driver.switchTo().alert();
        String actualText=alert.getText();
        String expectedText="I am a JS Alert";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();

        WebElement click1=driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        click1.click();
        Alert alert1=driver.switchTo().alert();
        alert1.dismiss();

        WebElement validateTest=driver.findElement(By.xpath("//p[@id='result']"));
        String actual3= BrowserUtils.getText(validateTest);
        String expected="You clicked: Cancel";
        Assert.assertEquals(actual3,expected);
        WebElement click4=driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        click4.click();
        Alert alert4=driver.switchTo().alert();
        alert4.sendKeys("Techtorial");
        String temp=alert4.getText();
        alert4.accept();
        WebElement message3=driver.findElement(By.xpath("//p[.='You entered: Techtorial']"));
        Assert.assertEquals(message3.getText(),"You entered: Techtorial");






    }
}
