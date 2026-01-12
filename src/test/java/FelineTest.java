import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;


public class FelineTest {
    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

        @Test
        public void getFamilyAssertEqualsTestTrue() {
            String expectedValue = "Кошачьи";
            String actualValue = feline.getFamily();
        System.out.println("\nТестирование метода getFamily:");
        System.out.println("Фактическое значение: " + actualValue
                + ". Ожидаемое значение: " + expectedValue);
        Assert.assertEquals("Значения не совпадают", expectedValue, actualValue);
        }

        @Test
        public void getKittensTestWithDefaultValue() {
            int expectedCount = 1;
            int actualCount = feline.getKittens();
            System.out.println("\nТестирование метода getKittens с дефолтным значением (1):");
            System.out.println("Фактическое значение: " + actualCount
                    + ". Ожидаемое значение: " + expectedCount);
            Assert.assertEquals("Значения getKittens не совпадают",
                    expectedCount, actualCount);
        }

        @Test
        public void eatMeatAssertEqualsTestTrus() throws Exception {
            List<String> expectedValue = List.of("Животные", "Птицы", "Рыба");
            List<String> actualValues = feline.eatMeat();
            System.out.println("\nТестирование метода eatMeat");
            System.out.println("Фактическое значение: " + actualValues
                    + ". Ожидаемое значение: " + expectedValue);
            Assert.assertEquals("Значения eatMeat не совпадают",
                    expectedValue, actualValues);
        }
}
