package TESTNG;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("Before Suite");
        //You can use to setup your Chrome Browser properties
        //(delete cookies...)
    }
    @BeforeTest

    public void BeforeTest(){
        System.out.println("BeforeTest");
        //You can use to launch your browser
    }
    @BeforeClass
    public void beforeclass(){
        System.out.println("before class");
        //You can navigate to website
    }

    @BeforeMethod
    public void beforeMEthod(){
        System.out.println("Before Method");
        // You can use it to login the page
    }
    @Test
    public void test1 (){

        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
        //YOU CAN TAKE A SCREENSHOT FOR FAILED TEST ANNOTATIONS
        //DRIVER.quit();
    }

    @AfterClass
    public void afterClass(){
        System.out.println("after class");
    }

    @AfterTest
    public void AfterTest(){
        System.out.println("After Test");
    }
    @AfterSuite
    public void AfterSuite(){
        System.out.println("After suite");
    }
}
