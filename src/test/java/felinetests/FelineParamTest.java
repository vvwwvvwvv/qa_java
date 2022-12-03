package felinetests;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FelineParamTest {
    @Parameterized.Parameter()
    public int kittensCount;
    @Parameterized.Parameter(1)
    public int expected;
    @Parameterized.Parameters(name = "kittensCount: {0}, expected: {1}")
    public static  Object[][] params(){
        return new Object[][]{
                {0, 0},
                {1, 1},
                {2, 2}
        };
    }
    @Test
    //Проверяем, что логика метода GetKittens с параметром возвращает правильное значение
    public void felineGetKittensWithParameterReturnRightValue(){
        Feline feline = new Feline();
        Assert.assertEquals(expected, feline.getKittens(kittensCount));
    }
}