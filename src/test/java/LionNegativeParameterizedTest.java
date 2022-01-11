import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


@RunWith(Parameterized.class)
public class LionNegativeParameterizedTest {
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    Feline feline;


    private final String sex;
    private final boolean expected;

    public LionNegativeParameterizedTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getSex() {
        return new Object[][]{
                {"Самец", false},
                {"Самка", true},
        };
    }

    @Test
    public void getHaveManeNegativeTest() throws Exception {
        {
            Lion lion = new Lion (feline, sex);
            boolean actual = lion.doesHaveMane();
            Assert.assertNotEquals(expected, actual);
        }
    }
}
