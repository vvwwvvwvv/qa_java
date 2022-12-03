package liontests;
import com.example.Feline;
import com.example.Lion;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionDoesHaveManeParamTest {
    @Parameterized.Parameter()
    public String sex;
    @Parameterized.Parameter(1)
    public boolean expected;
    Predator feline = new Feline();
    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Parameterized.Parameters(name = "sex: {0}, expected: {1}")
    public static  Object[][] params(){
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }
    @Test
    //Проверяем, что метод doesHaveMane ставит правильный флаг при указании пола животного
    public void lionDoesHaveManeCheck() throws Exception{
        Lion lion = new Lion(feline, sex);
        Assert.assertEquals(expected, lion.doesHaveMane());
    }
}