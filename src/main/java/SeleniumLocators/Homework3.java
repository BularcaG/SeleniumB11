package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework3 {

    /*
    Navigate to "https://www.saucedemo.com/"
Enter username "Java"
Enter password "Selenium"
Click Login button
Validate "Epic sadface: Username and password do not
match any user in this service" message
TIPS:to be able to see this message you need to first see this
message then try to inspect it. (it means at least run one time
with the username and password you provided above to see
the message then inspect the message.*be careful with it is
fully copied or not
     */

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        WebElement name=driver.findElement(By.xpath("//input[@id='user-name']"));
        name.sendKeys("Java");
        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");
        WebElement login=driver.findElement(By.xpath("//input[@id='login-button']"));
        login.click();

        WebElement error=driver.findElement(By.xpath("//h3[@data-test='error']"));
        String expected="Epic sadface: Username and password do not match any user in this service";
        if(error.getText().equals(expected)) System.out.println("All good");
        else System.out.println("NOT good !");
        driver.close();




    }
}
