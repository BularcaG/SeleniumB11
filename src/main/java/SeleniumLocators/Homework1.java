package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework1 {
    public static void main(String[] args) throws InterruptedException {
        /*

        Navigate to "https://demoqa.com/text-box"
Enter your full name, email, current and permanent address
Click submit button.
Validate that all of your information is displayed and
matching correctly.
TIPS:Think about if conditions.
Example:
Name:David
Email: david@gmail.com
Current Address :Random Address
Permananet Address : different address
         */

        WebDriver driver= new ChromeDriver();

        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        WebElement name=driver.findElement(By.id("userName"));
        name.sendKeys("Bularca Gheorghe");
        WebElement email=driver.findElement(By.id("userEmail"));
        email.sendKeys("George@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("1234 n elm st,chicago,il,60646");
        driver.findElement(By.id("permanentAddress")).sendKeys("4321 w devon ave,chicago,il,60543");
       // driver.findElement(By.id("submit")).click(); it didn't work because

        WebElement button= driver.findElement(By.xpath("//button[@id='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        Thread.sleep(500);

        button.click();

//        name=driver.findElement(By.id("userName"));
//        System.out.println(name.getText());




      //  WebElement name1=driver.findElement(By.id("name"));

        WebElement subName=driver.findElement(By.xpath("//p[@id='name']"));

        WebElement name1 =driver.findElement(By.xpath("//input[@id='userName'] "));

     //   System.out.println(subName.getText());
       // System.out.println(name1.getText());


//
        if(subName.getText().contains("Bularca Gheorghe")) System.out.println("name OK");
        else System.out.println("name not ok");

        WebElement subEmail=driver.findElement(By.xpath("//p[@id='email']"));

        if(subEmail.getText().contains("George@gmail.com")) System.out.println("E-mail ok");
        else System.out.println("E-mail not ok");

        WebElement subCurrent=driver.findElement(By.xpath("//p[@id='currentAddress']"));

        if(subCurrent.getText().contains("1234 n elm st,chicago,il,60646"))
            System.out.println("currend address ok");
        else System.out.println("current address not ok");


//
        if(driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText().contains("4321 w devon ave,chicago,il,60543"))
            System.out.println("Permanent address ok");
        else System.out.println("Permanent address not ok");


    if(driver.findElement(By.xpath("//input[@id='userName']")).getText().equals("Bularca Gheorghe")) System.out.println("true");
        else System.out.println("false");



    }
}
