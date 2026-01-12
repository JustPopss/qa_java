import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FelineParameterizedKittensTest {


    Feline feline = new Feline();
    private int expectedCount;
    private int actualCount;

    public FelineParameterizedKittensTest(int expectedCount, int actualCount) {
        this.expectedCount = expectedCount;
        this.actualCount = actualCount;
    }

    @Parameterized.Parameters(name = "Количество котят, ожидаемое: {0} " +
            "\n фактическое: {1}")
    public static Object[][] values() {
        return new Object[][]{
                {0, 0},
                {1, 1},
                {503, 503},
                {2147483646, 2147483646},
                {2147483647, 2147483647}
        };
    }
    @Test
    public void getKittensTestWithSettingValue() {
        Assert.assertEquals(feline.getKittens(expectedCount), actualCount);
    }

}