package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {
        // STEP1 : WE NEED TO DEFINE THE CHROME DRIVER INTO THE PROJECT AS A PROPERTY

        System.setProperty("webdriver.chrome.driver","chromedriver");

        //STEP 2 : WE NEED TO INSTANCIATE(DECLARE) OUR DRIVER.

        WebDriver driver=new ChromeDriver();

        // NOTE: driver is a reference name.Webdriver-->interface
        //new chromeDriver() ---> new Object
        //INTERVIEW QUESTION: WHERE DO YOU USE POLYMORPHYSM IN YOU TESTING FRAMEWORK?
        //I USE IT TO INSTANCIATE MY DRIVER LIKe ex: Webdriver=new ChromeDriver();

        //INTERVIEW QUESTION:
        //CAN YOU INTANCIATE YOUR DRIVER LIKE Webdriver driver= new WebDriver(); NO cannot create object from interface

        //FIRST METHOD:
        //GET();

        driver.get("https://www.techtorialacademy.com/");

        //getTitle() --> methods get the title of the page

        String title=driver.getTitle();
        System.out.println(title);
        if(title.equals("Home Page - Techtorial")) System.out.println("Test passed");
        else System.out.println("Test failed");

        String actual=driver.getCurrentUrl();
        String expected="https://www.techtorialacademy.com/";
        if(actual.equals(expected)) System.out.println("URL Passed");
        else System.out.println("URL failed");

    }


}
