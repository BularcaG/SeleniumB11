package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ActionClassMethods {

    @Test
    public void ContexClick(){  // Right click

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement contextMenu=driver.findElement(By.partialLinkText("Context"));
        contextMenu.click();
        WebElement box= driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);
        // !!! IMPORTANT !!!
        //ACTION CLASS YOU MUST USE PERFORM AT THE END
        actions.contextClick(box).perform();
    }
    @Test

    public void hoverOver() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement hover=driver.findElement(By.linkText("Hovers"));
        hover.click();
        Actions actions=new Actions(driver);
        List<WebElement> names=driver.findElements(By.tagName("h5"));
        List<WebElement> pictures=driver.findElements(By.xpath("//div[@class='figure']//img"));
        List<String> expectedNames= Arrays.asList("name: user1","name: user2","name: user3");
        for(int i=0;i<names.size();i++){
            Thread.sleep(2000);
            actions.moveToElement(pictures.get(i)).perform();

            Assert.assertEquals(BrowserUtils.getText(names.get(i)),expectedNames.get(i));
            System.out.println( BrowserUtils.getText(names.get(i)));
        }


    }

    @Test
    public void doubleClick(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();
        WebElement doubleClickButton=driver.findElement(By.tagName("button"));
        Actions actions=new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();

//        WebElement rightClick=driver.findElement(By.xpath("//span[.='right click me']"));
//        actions.contextClick(rightClick).perform();





    }

@Test

    public void dragAndDrop() throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();
        WebElement draggeble=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement box=driver.findElement(By.xpath("//div[@class='test2']"));
        String actualmessage=BrowserUtils.getText(box);
        String expectedMessage="... Or here.";
        Assert.assertEquals(actualmessage,expectedMessage);
        Actions actions=new Actions(driver);



        for(int i=0;i<5;i++) {
            actions.click().sendKeys(Keys.ARROW_DOWN).perform();  //scrolling down
        }


        Thread.sleep(1000);
        WebElement acceptcookies=driver.findElement(By.id("onetrust-accept-btn-handler"));
        Thread.sleep(3000);
        acceptcookies.click();


        Thread.sleep(1000);
        actions.dragAndDrop(draggeble,box).perform();
        Thread.sleep(1000);
        box=driver.findElement(By.xpath("//div[@class='test2']"));
        String actualAfterDragandDrop=BrowserUtils.getText(box);
        String expected="You did great!";
        Assert.assertEquals(actualAfterDragandDrop,expected);

        String cssValue= box.getCssValue("background-color");
        String expectedCssValue="rgba(238, 111, 11, 1)";
        Assert.assertEquals(cssValue,expectedCssValue);

    }

    @Test
    public void actionKeys(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement bluebox=driver.findElement(By.className("//div[@class='test1']"));
        String actualmessage=BrowserUtils.getText(bluebox);
        String expectedmessage="Drag the small circle here ...";
        Assert.assertEquals(actualmessage,expectedmessage);
        WebElement draggeble=driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(draggeble).moveToElement(bluebox).release().build().perform();

    }


    @Test

    public void MoveByOffSet(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        driver.manage().window().maximize();
        WebElement slider=driver.findElement(By.xpath("//input"));
        Actions actions=new Actions(driver);
        // x means horizontal
        // y means vertical
        actions.clickAndHold(slider).moveByOffset(-30,0).perform();


    }

    @Test

    public void slider(){  //thhis is shortcut for testing slider

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        driver.manage().window().maximize();
        WebElement slider=driver.findElement(By.xpath("//input"));
        WebElement range=driver.findElement(By.id("range"));
        String myrange="5";

        while(!range.getText().equals(myrange)){
            slider.sendKeys(Keys.ARROW_RIGHT);

        }
    }

}
