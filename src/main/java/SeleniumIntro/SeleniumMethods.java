package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();

        // driver.navigate().to();--> navigates to the page

        // INTERVIEW QUESTIONS :
        // WHAT IS THE DIFFERENCE BETWEEN driver.get and driver.navigate().to();?
        // WHAT IS THE DIFFERENCE BETWEEN driver.quit and driver.close?
        driver.navigate().to("https://www.amazon.com/");
     //   driver.quit();
       // driver.close();
        //Thread.sleep(3000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        //driver.getPageSource()--> it gives the html source of the page
        //System.out.println(driver.getPageSource());

        driver.navigate().to("https://www.techtorialacademy.com/");//techtorial
       // Thread.sleep(3000);
        driver.navigate().back();//amazon
      //  Thread.sleep(3000);
        driver.navigate().forward();//techtorial
     //   Thread.sleep(3000);
        driver.navigate().refresh();//refresh

        driver.close();

    }
}
