package TESTNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class PracticeWithRealWebsiteRealUserStory {

    @Test
    public void validationOfAscendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar=driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        Thread.sleep(1000);
        WebElement options= driver.findElement(By.xpath("//a[.='Options']"));
        Thread.sleep(1000);
        options.click();
        List<WebElement> allOptions=driver.findElements(By.ByName.xpath("//tbody/tr/td[2]"));

        Set<String> actualOptionsOrder=new LinkedHashSet<>();//it accepts insertion order
        Set<String> expectedOptionsOrder=new TreeSet<>();

        for(WebElement option:allOptions){
            actualOptionsOrder.add(option.getText().trim());
            expectedOptionsOrder.add(option.getText().trim());
        }
        System.out.println(actualOptionsOrder);
        System.out.println(expectedOptionsOrder);
        Assert.assertEquals(actualOptionsOrder,expectedOptionsOrder);

        WebElement optionNameButton=driver.findElement(By.xpath("//a[.='Option Name']"));
        optionNameButton.click();

        List<WebElement> descendingAllOptions=driver.findElements(By.ByName.xpath("//tbody/tr/td[2]"));

        List<String> actualDescendingOrder=new LinkedList<>();
        List<String> expectedDescendingOrder=new ArrayList<>();

        for(int i=0;i<descendingAllOptions.size();i++){

            actualDescendingOrder.add(descendingAllOptions.get(i).getText().trim());
            expectedDescendingOrder.add(descendingAllOptions.get(i).getText().trim());
            Collections.sort(expectedDescendingOrder);
            Collections.reverse(expectedDescendingOrder);

        }
        Assert.assertEquals(actualDescendingOrder,expectedDescendingOrder);
    }
    @Test
    public void validationOfDescendingOrder() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar=driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        Thread.sleep(1000);
        WebElement options= driver.findElement(By.xpath("//a[.='Options']"));
        Thread.sleep(1000);
        options.click();


        WebElement sortButton=driver.findElement(By.xpath("//a[.='Sort Order']"));
        Thread.sleep(1000);
        sortButton.click();
        Thread.sleep(1000);

        List<WebElement> allSortOptions=driver.findElements(By.xpath("//tbody/tr/td[3]"));

        List<Integer> actualElements=new LinkedList<>();
        List<Integer> expectedElements=new ArrayList<>();

        for(int i=0;i<allSortOptions.size();i++){

            actualElements.add(Integer.parseInt(allSortOptions.get(i).getText()));
            expectedElements.add(Integer.parseInt(allSortOptions.get(i).getText()));
            Collections.sort(expectedElements);
            Collections.reverse(expectedElements);
            Assert.assertEquals(actualElements,expectedElements);

        }

        sortButton=driver.findElement(By.xpath("//a[.='Sort Order']"));
        sortButton.click();

        List<WebElement> ascendingOptions=driver.findElements(By.xpath("//tbody/tr/td[3]"));

        Set<String> actual=new LinkedHashSet<>();
        Set<String> expected=new TreeSet<>();

        for(int i=0;i<ascendingOptions.size();i++){
            actual.add(ascendingOptions.get(i).getText().trim());
            expected.add(ascendingOptions.get(i).getText().trim());
        }
        System.out.println(actual);
        System.out.println(expected);
        Assert.assertEquals(actual,expected);

}

@Test

    public void testingtest() throws InterruptedException {

    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.get("https://demo.opencart.com/admin/");
    driver.manage().window().maximize();
    WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
    loginButton.click();
    WebElement catalogBar=driver.findElement(By.id("menu-catalog"));
    catalogBar.click();
    Thread.sleep(1000);
    WebElement options= driver.findElement(By.xpath("//a[.='Options']"));
    Thread.sleep(1000);
    options.click();


    WebElement sortButton=driver.findElement(By.xpath("//a[.='Sort Order']"));
    Thread.sleep(1000);
    sortButton.click();
    sortButton=driver.findElement(By.xpath("//a[.='Sort Order']"));
    sortButton.click();

    List<WebElement> ascendingOptions=driver.findElements(By.xpath("//tbody/tr/td[3]"));

    Set<String> actual=new LinkedHashSet<>();
    Set<String> expected=new TreeSet<>();

    for(int i=0;i<ascendingOptions.size();i++){
        actual.add(ascendingOptions.get(i).getText().trim());
        expected.add(ascendingOptions.get(i).getText().trim());
    }

    System.out.println(actual);
    System.out.println(expected);
    Assert.assertEquals(actual,expected);

}
    }