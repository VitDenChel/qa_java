import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

public class FelineParameterizedTest {

    @RunWith(Parameterized.class)
    public static class ParameterizedTest {

        private final String animalKind;
        private final List<String> expected;

        public ParameterizedTest(String animalKind,  List<String> expected) {
            this.animalKind = animalKind;
            this.expected =  expected;
        }

        @Parameterized.Parameters
        public static Object[][] getFoodTest() {
            return new Object[][]{
                    {"Травоядное", List.of("Трава", "Различные растения")},
                    {"Хищник", List.of("Животные", "Птицы", "Рыба")},
            };

        }

        @Test
        public void GetHaveFoodPositiveTest() throws Exception {
            {
                Animal animal = new Animal();
                List<String> actual = animal.getFood(animalKind);
                Assert.assertEquals(List.of(expected), List.of(actual));
            }
        }

    }}