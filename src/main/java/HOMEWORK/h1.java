package HOMEWORK;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class h1 {
    /*

    Navigate to
"http://uitestpractice.com/Students/Select#"
Validate India is selected by default on drop down
box
Validate the size of the Drop down box is 4
Validate the values for Drop down box are :
          India
United States of America
China
England
          Select the China with index number
Select the England with value
Select the United States with visible text
     */

    @Test
    public void TestCase1(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://uitestpractice.com/Students/Select#");
        WebElement menu=driver.findElement(By.id("countriesSingle"));
        Select select =new Select(menu);
        String actual=select.getFirstSelectedOption().getText();
        String expected="India";
        Assert.assertEquals(actual,expected);
       // select.selectByValue("china");

        List<WebElement> allOptions =select.getOptions();
        int actualnr=allOptions.size();
        int expectednr=4;
        Assert.assertEquals(actualnr,expectednr);
        List<String> itemValidation=new ArrayList<>();
        itemValidation.add("India");
        itemValidation.add("United states of America");
        itemValidation.add("China");
        itemValidation.add("England");
        for(int i=0;i< allOptions.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allOptions.get(i)),itemValidation.get(i));
        }

        BrowserUtils.selectBy(menu,"2","index");
        System.out.println(select.getFirstSelectedOption().getText());
        BrowserUtils.selectBy(menu,"england","value");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByVisibleText("United states of America");
        System.out.println(select.getFirstSelectedOption().getText());
    }

    @Test
    /*
    Navigate to Navigate to
"http://uitestpractice.com/Students/Select#"
Validate the values for Multiple Select are :
          India
United States of America
China
England
          Select China and England
Validate "China England" is displayed
Deselect all the countries
Select All the countries
Validate "India United states of America China
England" is
displayed
Deselect the China with index number
Deselect the England with value
     */

    public void TestCase2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://uitestpractice.com/Students/Select#");
        WebElement menu=driver.findElement(By.id("countriesMultiple"));
        Select select=new Select(menu);
        List<WebElement> allOptions=select.getOptions();
        List<String> all=new ArrayList<>();
        all.add("India");
        all.add("United states of America");
        all.add("China");
        all.add("England");
        for (int i=0;i< allOptions.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allOptions.get(i)),all.get(i));
        }
        BrowserUtils.selectBy(menu,"china","value");
        BrowserUtils.selectBy(menu,"england","value");
        select.deselectAll();
        Thread.sleep(1000);
        for (int i=0;i< allOptions.size();i++){
            select.selectByIndex(i);
        }
        for(int i=0;i< allOptions.size();i++){
            Assert.assertTrue(allOptions.get(i).isDisplayed()&&allOptions.get(i).isSelected());
        }
        select.deselectByIndex(2);
        select.deselectByValue("england");
    }
    @Test
    /*
    Navigate to "https://www.cars.com/"
Select "Certified Cars" from drop down
Select "Toyota" from All Makes
Select "Corolla" from drop down
Select max price is "$30000"
Select 40 miles from drop down box
Insert 60018 as zip code
Click search button
Validate title has Certified Used
Validate "Certified Used Toyota Corolla for Sale" is
displayed

Validate 40 miles selected in dropdown once you click
search button
Validate Certified Pre-Owned selected in radio button
Validate Toyota is selected in checkbox
Validate Corolla is selected in drop down
     */

    public void TestCase3() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.cars.com/");
        Actions actions=new Actions(driver);

        WebElement carsMenu=driver.findElement(By.id("make-model-search-stocktype"));

        BrowserUtils.selectBy(carsMenu,"cpo","value");
        //Thread.sleep(5000);
        WebElement cars=driver.findElement(By.xpath("//select[@data-activitykey='make']"));
        BrowserUtils.selectBy(cars,"Toyota","text");
       // Thread.sleep(2000);
        WebElement model=driver.findElement(By.xpath("//select[@data-activitykey='model']"));
        BrowserUtils.selectBy(model,"Corolla","text");
        WebElement price=driver.findElement(By.id("make-model-max-price"));
        BrowserUtils.selectBy(price,"30000","value");
        WebElement distance=driver.findElement(By.id("make-model-maximum-distance"));
        BrowserUtils.selectBy(distance,"40","value");
        Thread.sleep(2000);
        WebElement zip=driver.findElement(By.xpath("//input[@data-activitykey='zip' and @id='make-model-zip']"));
        zip.clear();
      //  actions.moveToElement(zip).sendKeys("60018").perform();
        zip.sendKeys("60018");
        Thread.sleep(3000);
        WebElement search=driver.findElement(By.xpath("//div[@class='sds-field-group sds-field-group--melded sds-home-search__bymake']//button[@type='submit']"));
        search.click();
        String actualTitle=driver.getTitle();
        String expectedTitle="Certified used";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        WebElement certified=driver.findElement(By.xpath("//h1[.='Certified used Toyota Corolla for sale']"));
        String actualText= certified.getText();
        String expectedText="Certified used Toyota Corolla for sale";
        Assert.assertEquals(actualText,expectedText);


        WebElement mileDropDown=driver.findElement(By.xpath("//select[@id='location-distance']"));
        Select select2=new Select(mileDropDown);
        String actualselected=select2.getFirstSelectedOption().getText();
        String expectedselected="40 miles";
        Assert.assertEquals(actualselected,expectedselected);
        WebElement car=driver.findElement(By.xpath("//select[@id='make_select']"));
        Select select3=new Select(car);
        String actualResult=select3.getFirstSelectedOption().getText();
        String expectedResult="Toyota";
        Assert.assertEquals(actualResult,expectedResult);
        WebElement toyotaCorolla =driver.findElement(By.xpath("//input[@id='model_toyota-corolla']"));
        Assert.assertTrue(toyotaCorolla.isSelected());
    }

    @Test

    /*
    Navigate to "https://www.cars.com/"
Select "Certified Cars" from drop down
Select "Lexus" from All Makes
Select "ES 350" from drop down
Select max price is "$50000"
Select 50 miles from drop down box
Insert 60016 as zip code
Click search button
Get count of all the cars which is displayed on first
page
Validate count of the cars is not more than 20

Get all car names in first page
Validate All car names has "Lexus ES 350"
Get the Mile distance from zip code for every car
Validate mile distance is no more than 50mil in first page
Select Sort By --> Price:Highest in drop down
Validate highest price is not more than $50000
     */

    public void TestCase4() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.cars.com/");
        WebElement carsMenu=driver.findElement(By.id("make-model-search-stocktype"));
        BrowserUtils.selectBy(carsMenu,"cpo","value");
        WebElement cars=driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(cars,"audi","value");
        Thread.sleep(2000);
        WebElement models=driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(models,"A6","text");
        WebElement price=driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        BrowserUtils.selectBy(price,"50000","value");
        WebElement miles=driver.findElement(By.id("make-model-maximum-distance"));
        BrowserUtils.selectBy(miles,"50","value");
        WebElement zipcode=driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipcode.clear();
        zipcode.sendKeys("60016");
        WebElement search=driver.findElement(By.xpath("//div[@class='sds-field-group sds-field-group--melded sds-home-search__bymake']//button[@type='submit']"));
        search.click();
        WebElement itemnr=driver.findElement(By.id("pagination-dropdown"));

        List<WebElement> elements=driver.findElements(By.xpath("//a[@class='vehicle-card-link js-gallery-click-link']"));
        Assert.assertTrue(elements.size()<20);
        Thread.sleep(2000);

        WebElement a4=driver.findElement(By.xpath("//input[@id='model_audi-a4']"));
       // BrowserUtils.scrollWithJS(driver,a4);
        BrowserUtils.clickWithJS(driver,a4);
        Thread.sleep(5000);
        List<WebElement>all=driver.findElements(By.xpath("//a[@class='vehicle-card-link js-gallery-click-link']"));
        System.out.println(all.size());

        for(int i=0;i<all.size();i++){
            Assert.assertTrue(all.get(i).getText().contains("Audi A4")||all.get(i).getText().contains("Audi A6"));
            //Thread.sleep(2000);
        }


        Thread.sleep(2000);
        List<WebElement>allMiles=driver.findElements(By.xpath("//div[@class='vehicle-details']/*[last()]"));
        Thread.sleep(3000);
        System.out.println(allMiles.size());
        for(int j=0;j<allMiles.size();j++){
            BrowserUtils.scrollWithJS(driver, all.get(j));
            System.out.println(allMiles.get(j).getText());
            Thread.sleep(2000);
            if(allMiles.get(j).isDisplayed())
            Assert.assertTrue(Integer.parseInt(allMiles.get(j).getText().substring(2))<50);

        }

    }
}
