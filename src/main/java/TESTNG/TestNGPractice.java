package TESTNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNGPractice {

    @Test
    public void Practice(){

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        WebElement menu=driver.findElement(By.id("nav-hamburger-menu"));
        menu.click();
        WebElement bestsellers=driver.findElement(By.xpath("//a[@href='/gp/bestsellers/?ref_=nav_em_cs_bestsellers_0_1_1_2']"));
        bestsellers.click();

        WebElement list=driver.findElement(By.xpath("//div[@role='group']"));
        System.out.println(list.getText());

        if(list.getText().contains("Baby")){

            System.out.println(list.getAttribute("Baby"));

        }




    }


}
