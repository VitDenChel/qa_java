import com.example.Animal;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.fail;

public class FelineTest {

    @Test
    public void shouldGetFamilyPositiveTest() {
        Feline feline = new Feline();
        String actual = feline.getFamily();
        String expected = "Кошачьи";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetFamilyNegativeTest() {
        Feline feline = new Feline();
        String actual = feline.getFamily();
        String expected = "Кошачьии";
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void getKittensShouldReturnKittensPositiveTest() {
        Feline feline = new Feline();
        int actual = feline.getKittens();
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getKittensShouldReturnKittensNegativeTest() {
        Feline feline = new Feline();
        int actual = feline.getKittens();
        int expected = 3;
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void getFoodPositiveTest() throws Exception {
        Feline feline = new Feline();
        List<String> actual = feline.eatMeat();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFoodNegativeTest() throws Exception {
        Feline feline = new Feline();
        List<String> actual = feline.eatMeat();
        List<String> expected = List.of("Животные и", "Птицы", "Рыба");
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void GetFoodTest() throws Exception {{
        try {
            Animal animal = new Animal();
            animal.getFood("Хищникк");
            fail();
        } catch (Exception exception) {
            System.out.println("Неизвестный вид животного, используйте значение Травоядное или Хищник");
        }
    }}}

