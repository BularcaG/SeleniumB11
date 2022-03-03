package SeleniumIntro;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
//  Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//            3. Maximize or set size of browser window.
//4. Get Title of page and validate it.
//4. Get URL of current page and validate it.
//            5. Close browser.
 */
public class RealTestCaseExample {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver= new ChromeDriver();

         driver.get( "https://www.godaddy.com/");
         String current=driver.getTitle();
         String expected="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
         driver.manage().window().maximize();
         if(current.equals(expected)) System.out.println("Title ok");
         else System.out.println("Title not ok");

         String currentURL=driver.getCurrentUrl();
         if(currentURL.equals("https://www.godaddy.com/")) System.out.println("URL good");
         else System.out.println("URL not good");
         driver.close();



    }
}
