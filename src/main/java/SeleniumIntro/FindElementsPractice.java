package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Locale;

public class FindElementsPractice {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.yahoo.com/");

        driver.manage().window().maximize();
        driver.findElement(By.id("root_2")).click();

        List<WebElement> header = driver.findElements(By.xpath("//h3"));

        for(int i=0;i< header.size();i++){
            if(header.get(i).getText().toUpperCase().contains("COVID")) {
                System.out.println(header.get(i).getText());
                System.out.println("=========");

            }
        }


    }
}
