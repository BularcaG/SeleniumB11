package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
/*
Navigate to "https://demoqa.com/select-menu"
Select Group 2, option 1
Select Prof. and validate they are selected.
Steps
 */

public class Homework6 {
    @Test

    public void h6(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        Actions action=new Actions(driver);
      //  WebElement dropDown=driver.findElement(By.xpath("///*[contains(text(),'Select Option')]"));
        WebElement input=driver.findElement(By.id("react-select-2-input"));

        input.sendKeys("Group 2, option 1", Keys.ENTER);

       // WebElement element=driver.findElement(By.id("withOptGroup"));
     //   element.click();

//        action.moveToElement(dropDown).perform();
//        action.clickAndHold().perform();
       // action.moveToElement(element).perform();


    }



}
