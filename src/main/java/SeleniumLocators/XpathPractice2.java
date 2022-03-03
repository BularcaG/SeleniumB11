package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathPractice2 {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement element = driver.findElement(By.xpath("//h3"));
        System.out.println(element.getText());
        WebElement element2 = driver.findElement(By.xpath("//h4[@class='subheader']"));
        System.out.println(element2.getText());
        WebElement element3 = driver.findElement(By.xpath("h3"));

        //Contains : it works with text !!!

        //tagname[contains(text(),'HorizantalLine']//  60%

        WebElement element4=driver.findElement(By.xpath("//h3[contains(text(),'Horizontal Slider')]"));


        //Text : It works with text as well.This is for simplier than contain methodIt looks for the exact text

       // h3[.='text]    !!!!!!!






    }
}
