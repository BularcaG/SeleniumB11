package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/*
Navigate to "https://demoqa.com/radio-button"
Click Yes radio button
Validate text  is : You have selected Yes
Click Impressive radio button
Validate text is : You have selected Impressive
TIPS: be careful about your xpath if you have any issue with
getting the text.
 */
public class Homework2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");

//        WebElement yes1 = driver.findElement(By.id("yesRadio"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",yes1);
//        Thread.sleep(500);
//
//        WebElement message=driver.findElement(By.xpath("//p[@class='mt-3']"));
//        if(message.getText().contains("You have selected Yes")) System.out.println(" YES ALL GOOD !");
//        else System.out.println(" YES NOT GOOD !");
//
//        WebElement impressive= driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",impressive);
//        Thread.sleep(500);
//
//
//
//        WebElement message2=driver.findElement(By.xpath("//p[@class='mt-3']"));
//      //  System.out.println(message2.getText());
//        if(message2.getText().equals("You have selected Impressive")) System.out.println(" IMPRESSIVE ALL GOOD");
//        else System.out.println(" IMPRESSIVE NOT GOOD !");
//
//       // driver.close();


        List<WebElement> radio=driver.findElements(By.xpath("//div/input"));

        for(WebElement element:radio){

            if(!element.isSelected()) {

                ((JavascriptExecutor) driver).executeScript("arguments[0].click()",element);
                Thread.sleep(500);

                System.out.println("Done");

            }
            }
        }








    }

