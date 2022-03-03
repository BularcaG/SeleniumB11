package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectPracticeWithRealEx {



    @Test

    public void validationTripButton(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement oneway=driver.findElement(By.xpath("//input[@value='oneway']"));
        oneway.click();

        Assert.assertTrue(oneway.isDisplayed()); //it must be true to pass the assertion
        Assert.assertTrue(oneway.isSelected());
//
        WebElement roundtrip=driver.findElement(By.xpath("//input[@value='roundtrip']"));
        Assert.assertTrue(roundtrip.isDisplayed()); //it must be true to pass the assertion
        Assert.assertFalse(roundtrip.isSelected());
    }


    @Test
    public void SelectMethods(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement oneway=driver.findElement(By.xpath("//input[@value='oneway']"));
        oneway.click();
        WebElement passengers=driver.findElement(By.name("passCount"));
        Select passenger=new Select(passengers);
        passenger.selectByIndex(1);
        passenger.selectByValue("4");
        passenger.selectByVisibleText("3");

        WebElement departfrom=driver.findElement(By.name("fromPort"));
        Select depart=new Select(departfrom);
        passenger.selectByIndex(3);
       // passenger.selectByValue("London ");
        //passenger.selectByVisibleText("New York");
        WebElement month=driver.findElement(By.name("fromMonth"));
        Select monthselect=new Select(month);
        monthselect.selectByIndex(4);
        monthselect.selectByValue("2");

    }

    @Test

    public void testing(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement fromday1=driver.findElement(By.name("fromDay"));
        Select fromdaysel=new Select(fromday1);
        fromdaysel.selectByIndex(4);
        fromdaysel.selectByValue("2");

        WebElement toMonth=driver.findElement(By.name("toMonth"));
        Select month=new Select(toMonth);
        fromdaysel.selectByIndex(4);
        fromdaysel.selectByValue("7");


        WebElement toDay=driver.findElement(By.name("toDay"));
        Select toDays=new Select(toDay);
        toDays.selectByIndex(7);
        toDays.selectByValue("8");

        WebElement airline=driver.findElement(By.name("airline"));
        Select airelineselect=new Select(airline);
        airelineselect.selectByIndex(2);
       // airelineselect.selectByValue("9");

        WebElement button=driver.findElement(By.xpath("//input[@type='image']"));
        button.click();
        WebElement message=driver.findElement(By.xpath("//font[@size='4']"));
        String actualmessage=message.getText();
        String expectedmessage="After flight finder - No Seats Available";
        Assert.assertEquals(actualmessage,expectedmessage);
    }
}
