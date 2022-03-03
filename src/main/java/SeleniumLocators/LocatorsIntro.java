package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    public static void main(String[] args) {




        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/gheorghebularca/Desktop/Techtorial%20(2).html");


       // getText-gives you the text
        WebElement header = driver.findElement(By.id("techtorial1"));

        String actualText=header.getText();  //from the system
        String expectedText="Techtorial Academy";           //from the business requirement

        if(actualText.equals(expectedText)) System.out.println("Passed");
        else System.out.println("failed");

        WebElement p=driver.findElement(By.id("details2"));

        System.out.println(p.getText());

        //LOCATOR CLASS

        WebElement tools=driver.findElement(By.className("group_checkbox"));
        System.out.println(tools.getText());


        //LOCATOR : NAME

        WebElement firstName=driver.findElement(By.name("firstName"));
        firstName.sendKeys("George");

        WebElement lastname=driver.findElement(By.name("lastName"));
        lastname.sendKeys("Bularca");

        WebElement phone=driver.findElement(By.name("phone"));
        phone.sendKeys("87984573");

        WebElement mail=driver.findElement(By.name("userName"));
        mail.sendKeys("g@gmail.com");


        // .click();

        WebElement click=driver.findElement(By.id("cond4"));
        click.click();
        WebElement click2=driver.findElement(By.id("cond3"));
        click2.click();

        // isDisplayed
        // is
        System.out.println(click2.isDisplayed()); //true
        System.out.println(click2.isSelected());  //true
        click2.click();
        System.out.println(click2.isSelected()); //false

        WebElement click3=driver.findElement(By.id("cond1"));
        click3.click();






    }
}
