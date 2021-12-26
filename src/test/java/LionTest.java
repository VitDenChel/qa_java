import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static junit.framework.TestCase.fail;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void shouldLionGetKittensText() {
        int expectedNumber = 3;
        Mockito.when(feline.getKittens()).thenReturn(expectedNumber);
        Lion lion = new Lion(feline);
        int actualNumber = lion.getKittens();
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void shouldLionGetFood() throws Exception {
        Lion lion = new Lion(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        Assert.assertEquals(expected, actual);
    }

    @Test

    public void shouldMaleLionHasManeTest() throws Exception {
        Lion lion = new Lion("Самец");
        boolean actual = lion.doesHaveMane();
        boolean expected = true;
        Assert.assertEquals(expected, actual);
    }

    @Test

    public void shouldFemaleLionHasNotManeTest() throws Exception {
        Lion lion = new Lion("Самка");
        boolean actual = lion.doesHaveMane();
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void DoesHaveManeExceptionTest() throws Exception {{

        try {
            Lion lion = new Lion("Самецк");
            lion.doesHaveMane();
            fail();
        } catch (Exception exception) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());

        }
    }}

    public class LionParameterizedTest {

        @RunWith(Parameterized.class)
        public class ParameterizedTest {
            @Before
            public void setUp() {
                MockitoAnnotations.openMocks(this);
            }

            private final String sex;
            private final boolean expected;

            public ParameterizedTest (String sex, boolean expected) {
                this.sex = sex;
                this.expected = expected;
            }
            @Parameterized.Parameters
            public  Object[][] getSex() {
                return new Object[][]{
                        {"Самец", true},
                        {"Самка", false},
                };

            }
            @Test
            public void GetHaveManePositiveTest() throws Exception {{
                Lion lion = new Lion(sex);
                boolean actual = lion.doesHaveMane();
                Assert.assertEquals(expected, actual);
            }
            }
        }
    }

    class LionTestNegativeTest {

        @RunWith(Parameterized.class)
        public  class LionTestParameterized {

            private final String sex;
            private final boolean expected;

            public LionTestParameterized (String sex, boolean expected) {
                this.sex = sex;
                this.expected = expected;
            }
            @Parameterized.Parameters
            public  Object[][] getSex() {
                return new Object[][]{
                        {"Самец", false},
                        {"Самка", true},
                };
            }
            @Test
            public void GetHaveManeNegativeTest() throws Exception {{
                Lion lion = new Lion(sex);
                boolean actual = lion.doesHaveMane();
                Assert.assertNotEquals(expected, actual);
            }
            }
        }
    }
}




