package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Task2 {
    @Test

    public void task2(){


        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://demoqa.com/droppable");
        WebElement drageble=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropere=driver.findElement(By.xpath("//div[@id='droppable']"));

        Actions actions=new Actions(driver);
        actions.dragAndDrop(drageble,dropere).perform();

        WebElement accept=driver.findElement(By.id("droppableExample-tab-accept"));
        accept.click();
        WebElement draggable2=driver.findElement(By.id("acceptable"));
        WebElement draggable3=driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        dropere=driver.findElement(By.xpath("//div[@id='droppable' and @class='drop-box ui-droppable']"));
        actions.clickAndHold(draggable3).moveToElement(dropere).release().build().perform();

        String cssValue= dropere.getCssValue("background-color");
        System.out.println(cssValue);

        actions.clickAndHold(draggable2).moveToElement(dropere).release().build().perform();
         cssValue= dropere.getCssValue("background-color");

        System.out.println(cssValue);

    }
}
