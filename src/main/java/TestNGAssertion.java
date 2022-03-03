import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {


    //create one method that takes 2 parameters and return the multiplication of these numbers

    public double multi(double number1 ,double number2){
        return number1*number2;
    }

    @Test
    public void validate(){
     double actualresult=multi(5,6);
     double expectedresult=30;


     Assert.assertEquals(actualresult,expectedresult,"my numbers are 5,6");
                            //message shows if it fails



    }

    public double division(double number1,double number2){
        if(number1>=number2) return number1/number2;
        else return number2/number1;
    }

    public double substraction(double number1,double number2){
        if(number1>=number2) return number1-number2;
        else return number2-number1;
    }

    @Test

    public void validate2(){

        double actualResult=division(8,2);
        double expectedResult=4;
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void validate3(){
        double actualResult=substraction(50,30);
        double expectedResult=20;
        Assert.assertEquals(actualResult,expectedResult);
    }
}
