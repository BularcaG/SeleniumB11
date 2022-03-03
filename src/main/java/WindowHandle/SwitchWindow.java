package WindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class SwitchWindow {
    @Test

    public void practice1(){
        // it is failing because my driver it still pointing to the last tab
        // it throws the no such element exception

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver =new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/windows");
//        WebElement click=driver.findElement(By.xpath("//a[.='Click Here']"));
//        click.click();
//
//        WebElement header=driver.findElement(By.xpath("//h3[.='New Window']"));
//        header.click();

    }
    @Test

    public void practiceREal(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        System.out.println(driver.getWindowHandle());
        WebElement click=driver.findElement(By.xpath("//a[.='Click Here']"));
        click.click();

       // WebElement header=driver.findElement(By.xpath("//h3[.='New Window']"));
        System.out.println(driver.getWindowHandles());
        String mainPageID=driver.getWindowHandle(); //123
        Set<String> allPagesID=driver.getWindowHandles();

        //this implementation for only 2 tabs

        for(String id:allPagesID){
            //System.out.println(id);
            if(!id.equals(mainPageID)){
                driver.switchTo().window(id);
            }

        }



    }

    @Test
    public void Task(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.findElement(By.id("newTabBtn")).click();
//        Set<String> allids=driver.getWindowHandles();
        String id=driver.getWindowHandle();
//
//        for(String ids:allids){
//            //System.out.println(id);
//            if(!ids.equals(id)){
//                driver.switchTo().window(ids);
//            }
//
//
//        }
        BrowserUtils.switch2Tabs(driver,id);
        System.out.println(driver.getWindowHandle());
        WebElement testbutton=driver.findElement(By.id("confirmBox"));
        testbutton.click();



    }

}
