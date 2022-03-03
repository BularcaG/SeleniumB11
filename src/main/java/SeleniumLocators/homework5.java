package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
Here is your Homework By tomorrow's class. TASK: CREATING AN ACCOUNT FOR AMAZON:
1-NAVIGATE TO THE WEBSITE https://www.amazon.com/
2_Click Hello, Sign in Button
3-Click Create your amazon account button
4-Fill the information and click Continue Button
5-If there is an error or message. Validate it, if not then you completed the task
TASK 2:Creating an account for nopcommerce and validation
1-NAVIGATE TO THE WEBSITE https://demo.nopcommerce.com/
2-Click Register
3-Fill the information
4-Newsletter box should be left unclicked
5-Click Register
6-Validate “Your registration completed”
7-Click Continue

 */
public class homework5 {

    @Test
    public void validatepassword(){
        WebDriver driver=new ChromeDriver();
//        driver.get("https://www.amazon.com/");
//        driver.manage().window().maximize();
//        WebElement signin=driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
//        signin.click();
//        WebElement createaccount=driver.findElement(By.xpath("//a[@id='createAccountSubmit']"));
//        createaccount.click();
//        WebElement name=driver.findElement(By.name("customerName"));
//        name.sendKeys("GIGI");
//        WebElement email=driver.findElement(By.id("ap_email"));
//        email.sendKeys("fdhfdsfsd@gmail.com");
//        WebElement password=driver.findElement(By.xpath("//input[@id='ap_password']"));
//        password.sendKeys("Napoleon123!");
//        WebElement passwordcheck=driver.findElement(By.name("passwordCheck"));
//        passwordcheck.sendKeys("Napoleon123!");
//        driver.findElement(By.xpath("//input[@id='continue']")).click();
//        driver.close();

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        WebElement register=driver.findElement(By.className("ico-register"));
        register.click();
        driver.findElement(By.xpath("//input[@value='M']")).click();
        driver.findElement(By.id("FirstName")).sendKeys("George");
        driver.findElement(By.id("LastName")).sendKeys("Black");
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("27");
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("March");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("2004");
        driver.findElement(By.id("Email")).sendKeys("hsdkassdsd@yahoo.com");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        WebElement password=driver.findElement(By.xpath("//input[@id='Password']"));
        WebElement confirmPAssword= driver.findElement(By.xpath("//input[@name='ConfirmPassword']"));
        password.sendKeys("jbhfutyklhjv");
        confirmPAssword.sendKeys("jbhfutyklhjv");
      //  driver.findElement(By.xpath("//button[@id='register-button']")).click();
//        if(driver.findElement(By.xpath("//div[@class='result']")).getText().equals("Your registration completed"))
//            System.out.println("ALL GOOD !");
//        else System.out.println("NOT GOOD!");
       // driver.findElement(By.xpath("//a[@class='button-1 register-continue-button']")).click();
        Assert.assertEquals(password.getText(),confirmPAssword.getText(),"NOT OK !");



        }



}
