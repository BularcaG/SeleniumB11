package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksAndTags {

    public static void main(String[] args) {

        // LINK
        WebDriver driver= new ChromeDriver();
        driver.get("file:///Users/gheorghebularca/Desktop/Techtorial%20(2).html");
        driver.manage().window().maximize();
        WebElement javalink=driver.findElement(By.linkText("Java"));
        javalink.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().back();
        WebElement cucumber=driver.findElement(By.linkText("Cucumber"));
        cucumber.click();
        driver.navigate().back();
        javalink=driver.findElement(By.linkText("Java"));
        javalink.click();
        driver.navigate().back();

        WebElement restAPI=driver.findElement(By.partialLinkText("Rest"));
        restAPI.click();
        driver.navigate().back();

        //TAG
        WebElement version=driver.findElement(By.tagName("u"));
        System.out.println(version.getText());



    }
}
