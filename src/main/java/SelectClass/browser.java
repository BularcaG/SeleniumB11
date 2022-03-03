package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class browser {
    @Test
    public void browser1() {
        WebDriverManager.chromedriver().setup ();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        driver.manage().window().maximize();
        WebElement trip = driver.findElement(By.xpath("//input[@value='oneway']"));
        trip.click();
        WebElement passenger = driver.findElement(By.name("passCount"));
        BrowserUtils.selectBy(passenger, "2", "value");
        WebElement departingFrom = driver.findElement(By.name("fromPort"));
        BrowserUtils.selectBy(departingFrom, "Paris", "text");
        WebElement frommonth = driver.findElement(By.name("fromMonth"));
        BrowserUtils.selectBy(frommonth, "7", "index");
        WebElement fromday = driver.findElement(By.name("fromDay"));
        BrowserUtils.selectBy(fromday, "13", "value");
        WebElement arrivingIn = driver.findElement(By.name("toPort"));
        BrowserUtils.selectBy(arrivingIn, "Sydney", "text");
        WebElement tomonth = driver.findElement(By.name("toMonth"));
        BrowserUtils.selectBy(tomonth, "9", "index");
        WebElement toDay = driver.findElement(By.name("toDay"));
        BrowserUtils.selectBy(toDay, "3", "value");
        WebElement Services = driver.findElement(By.xpath("//input[@value='First']"));
        Services.click();
        WebElement airlines = driver.findElement(By.name("airline"));
        Select airline = new Select(airlines);
        List<WebElement> allairlines = airline.getOptions();
        List<String> actualAirlines = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        List<String> expectedairlines = new ArrayList<>();
        for (WebElement line : allairlines) {
            expectedairlines.add(line.getText().trim());
        }
        Assert.assertEquals(actualAirlines, expectedairlines);
        WebElement continueButton = driver.findElement(By.name("findFlights"));
        continueButton.click();
        WebElement message = driver.findElement(By.xpath("//font[@face='Arial, Helvetica, sans-serif']//font[@size='4']"));
        String actual = message.getText().trim();
        String expected = "After flight finder - No Seats Available";
        Assert.assertEquals(actual, expected);
    }
}
