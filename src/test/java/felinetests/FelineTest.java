package felinetests;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
public class FelineTest {
    Feline feline = new Feline();
    @Test
    //Проверяем, что метод getFamily возвращает нужное значение
    public void getFamilyReturnFelineFamily(){
        String typeOfPredator = "Кошачьи";
        Assert.assertEquals(typeOfPredator, feline.getFamily());
    }
    @Test
    //ПРоверяем, что метод GetKittens без параметра возвращает 1
    public void felineGetKittensCheck(){
        int kittensCount = 1;
        Assert.assertEquals(kittensCount, feline.getKittens());
    }
    @Test
    //Проверяем, что метод возвращает список для Хищника
    public void eatMeatReturnPredatorFood() throws Exception {
        List<String> felineFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(felineFood, feline.eatMeat());
    }
}