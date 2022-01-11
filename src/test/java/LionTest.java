import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;



@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void shouldLionGetKittensText() throws Exception {
        int expectedNumber = 3;
        Mockito.when(feline.getKittens()).thenReturn(expectedNumber);
        Lion lion = new Lion(feline, "Самка");
        int actualNumber = lion.getKittens();
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void shouldLionGetFood() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        Assert.assertEquals(expected, actual);
    }

    @Test

    public void shouldMaleLionHasManeTest() throws Exception {
        Lion lion = new Lion (feline, "Самец");
        boolean actual = lion.doesHaveMane();
        boolean expected = true;
        Assert.assertEquals(expected, actual);
    }

    @Test

    public void shouldFemaleLionHasNotManeTest() throws Exception {
        Lion lion = new Lion (feline, "Самка");
        boolean actual = lion.doesHaveMane();
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionTest() throws Exception  {
        Lion lion = new Lion (feline, "Невалидное значение");
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", actual);
    }


    @Rule
    public ExpectedException expectedEx =  ExpectedException.none();
    @Test
    public void shouldExceptionMessageTest() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("Используйте допустимые значения пола животного - самей или самка");
        Lion lion = new Lion(feline, "Невалидное значение");
        lion.doesHaveMane();
    }
}




