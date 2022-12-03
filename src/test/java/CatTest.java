import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;

public class CatTest {
    Feline feline = new Feline();
    @Test
    //Метод возвращает нужный звук
    public void catGetSoundTest(){
        Cat cat = new Cat(feline);
        String Meow = "Мяу";
        Assert.assertEquals(Meow, cat.getSound());
    }
    @Test
    //Проверяем, что метод getFood вызывает eatMeat
    public void catGetFoodCallPredatorEatMeat() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline,Mockito.times(1)).eatMeat();
    }
    @Test
    //Проверяем, что метод getFood возвращает список пищи хищника
    public void catGetFoodPredatorList() throws Exception {
        List<String> catFood = List.of("Животные", "Птицы", "Рыба");
        Cat cat = new Cat(feline);
        Assert.assertEquals(catFood, cat.getFood());
    }
}