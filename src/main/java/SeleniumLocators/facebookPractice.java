package SeleniumLocators;
/*
    Facebook Sign up:
Scenario:
Open a Chrome browser.
Navigate to "http://www.fb.com"
Verify that the page is redirected to "http://www.facebook.com", by getting the current URL. (use Assertion)
Verify that there is a "Create an account" section on the page.
Fill in the text boxes: First Name, Surname, Mobile Number or email address, "Re-enter mobile number", new password.
Update the date of birth in the drop-down.
Select gender.
Click on "Create an account".
Verify that the account is not created.

 */

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class facebookPractice {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");
        WebElement signup=driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        signup.click();

        Thread.sleep(1000);

        WebElement name= driver.findElement(By.xpath("//input[@name='firstname']"));
        name.sendKeys("Gheorghe");

//        WebElement email= driver.findElement(By.name("reg_email__"));
//        name.sendKeys("Gheorghe");
//
//        WebElement name= driver.findElement(By.xpath("//input[@name='firstname']"));
//        name.sendKeys("Gheorghe");
//
//        WebElement name= driver.findElement(By.xpath("//input[@name='firstname']"));
//        name.sendKeys("Gheorghe");
        WebElement gender=driver.findElement(By.xpath("//input[@name='sex' and @value='2']")); // !!! AND!!!!
        gender.click();



    }
}
