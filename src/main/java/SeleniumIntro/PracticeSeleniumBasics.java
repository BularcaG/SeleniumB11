package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeSeleniumBasics {

    //go to 3 websites.Get the title,current url,go back and forward and refresh

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");

        WebDriver driver=new ChromeDriver();

        driver.navigate().to("https://www.etsy.com/");
        String etsytitle=driver.getTitle();
        String etsyURL=driver.getCurrentUrl();
        driver.get("https://www.typesy.com/type/courses");
        driver.get("https://www.lexus.com/?pdsrch=SEM:700000001228668:GOOGLE:71700000012692989:58700000833691251:p8855989817:433283717272&bknode=Brand_Lexus_Exact&ds_rl=1246750&ds_rl=1251882&gclid=EAIaIQobChMIoZf47qrp9QIVYgp9Ch1nhwnmEAAYASAAEgLhV_D_BwE&gclsrc=aw.ds");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        System.out.println(driver.getTitle());
        driver.close();



    }
}
