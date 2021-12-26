import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;


    @Test

    public void getFoodCatTest() throws Exception {
        Cat cat = new Cat(feline);
        // List<String> actual = feline.getFood("Хищник");
        List<String> actual = feline.eatMeat();
        List<String> expected = cat.getFood();
        Assert.assertEquals(expected, actual);
    }

    @Test

    public  void getSoundShouldReturnSound() throws Exception {
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        String expected =  "Мяу";
        Assert.assertEquals(expected, actual);
    }





}