package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*

Navigate to "https://www.saucedemo.com/"
Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Validate current url is
"https://www.saucedemo.com/inventory.html"
 */
public class Homework4 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement name=driver.findElement(By.xpath("//input[@data-test='username']"));
        name.sendKeys("standard_user");
        WebElement password=driver.findElement(By.xpath("//input[@data-test='password']"));
        password.sendKeys("secret_sauce");
        WebElement login=driver.findElement(By.xpath("//input[@data-test='login-button']"));
        login.click();
        String currenturl=driver.getCurrentUrl();
        String expected="https://www.saucedemo.com/inventory.html";
        if(currenturl.equals(expected)) System.out.println("ALL GOOD !");
        else System.out.println("NOT GOOD !");
        driver.close();





    }
}
