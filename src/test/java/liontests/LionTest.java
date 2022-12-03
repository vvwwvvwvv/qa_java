package liontests;

import com.example.Feline;
import com.example.Lion;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Predator feline;
    @Test
    //Проверяем работу метода getKittens без параметра
    public void lionGetKittensCheck() throws Exception {
        int kittensCount = 1;
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion(feline, "Самец");
        Assert.assertEquals(kittensCount, lion.getKittens());
    }
    @Test
    //Проверка обработки исключения
    public void lionExceptionIsRunning() {
        String exceptionExpectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        Exception trowException = Assert.assertThrows(Exception.class,() -> new Lion(feline, "Неизвестно"));
        Assert.assertEquals(trowException.getMessage(), exceptionExpectedMessage);
    }
    @Test
    //Проверяем, что метод getFood вызывает обращение к методу eatMeat
    public void lionGetFoodCallPredatorEatMeat() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        lion.getFood();
        Mockito.verify(feline,Mockito.times(1)).eatMeat();
    }
    @Test
    //Проверяем, что метод getFood обращается к списку пищи хищника
    public void lionGetFoodPredatorList() throws Exception {
        Predator feline = new Feline();
        List<String> lionFood = List.of("Животные", "Птицы", "Рыба");
        Lion lion = new Lion(feline, "Самка");
        Assert.assertEquals(lionFood, lion.getFood());
    }
}