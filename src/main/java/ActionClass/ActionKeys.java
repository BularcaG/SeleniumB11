package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.security.Key;

public class ActionKeys {




    @Test

    public void keys(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
       // driver.get("https://www.google.com/");
       // driver.manage().window().maximize();

      //  Actions actions=new Actions(driver);
        //WebElement googleSearchBox=driver.findElement(By.name("q"));


       // actions.moveToElement(googleSearchBox).click().keyDown(Keys.SHIFT).sendKeys("s").keyUp(Keys.SHIFT).sendKeys("elenium")

//                .doubleClick().keyDown(Keys.)
//                .sendKeys("c")
//                .keyUp(Keys.COMMAND)
//                .sendKeys(Keys.ARROW_RIGHT)
//                .keyDown(Keys.COMMAND)
//                .sendKeys()




                //IMPORTANT NOTES ABOUT KEYS ::

               //  Keys.ENTER Or Keys.Return
               //Keys.Arrow right/left/up/down



    driver.get("https://text-compare.com/");
    driver.manage().window().maximize();
    WebElement text1=driver.findElement(By.name("text1"));
    WebElement text2=driver.findElement(By.name("text2"));

    Actions actions = new Actions(driver);
    actions.moveToElement(text1).click().keyDown(Keys.SHIFT).sendKeys("G").keyUp(Keys.SHIFT).sendKeys("ood ").keyDown(Keys.SHIFT)
            .sendKeys("B").keyUp(Keys.SHIFT).sendKeys("ye ").keyDown(Keys.SHIFT).sendKeys("K").keyUp(Keys.SHIFT).
            sendKeys("eys").
            keyDown(Keys.COMMAND).sendKeys("A").keyUp(Keys.COMMAND).moveToElement(text2).click().keyDown(Keys.COMMAND).sendKeys("V").keyUp(Keys.COMMAND).perform();




    }

}
