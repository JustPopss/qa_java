import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {

    @Mock
    private Feline felineMock;
    private Lion lion;

    @Test
    public void lionSexMaleTest() throws Exception {
        lion = new Lion(felineMock, "Самец");
        Assert.assertTrue(lion.doesHaveMane());
    }

    @Test
    public void lionSexFemaleTest() throws Exception {
        lion = new Lion(felineMock, "Самка");
        Assert.assertFalse(lion.doesHaveMane());
    }

    @Test
    public void lionThrowExceptionText() {
        String invalidInput = "Другое";
        String expectedText = "Используйте допустимые значения пола животного - самец или самка";

        try {
            lion = new Lion(felineMock, invalidInput);
            throw new AssertionError("ОШИБКА: Для '" + invalidInput + "' должно быть исключение!");

        } catch (Exception e) {
            Assert.assertEquals(expectedText, e.getMessage());
            System.out.println("Исключение: " + e.getMessage());
        }
    }

    @Test
    public void getKittensAssertEqualsTestTrue() throws Exception {
        int expectedValue = 7;

        Mockito.when(felineMock.getKittens()).thenReturn(expectedValue);
        lion = new Lion(felineMock, "Самец");
        int actualValue = lion.getKittens();

        Assert.assertEquals(expectedValue, actualValue);

        System.out.println("\nТестирование метода getKittens с установленным " +
                "возвратом значения (7): \nФактическое значение: " + actualValue
                + ". \nОжидаемое значение: " + expectedValue + ".");
    }

    @Test
    public void getKittensVerifyTimesOneTest() throws Exception {
        lion = new Lion(felineMock, "Самец");
        lion.getKittens();
        Mockito.verify(felineMock, Mockito.times(1)).getKittens();
    }

    @Test
    public void getFoodAssertEqualsTestTrue() throws Exception{
        List<String> expectedValues = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(expectedValues);
        lion = new Lion(felineMock, "Самец");

        List<String> actualValues = lion.getFood();
        Mockito.verify(felineMock, Mockito.times(1)).getFood("Хищник");
        Assert.assertEquals(expectedValues, actualValues);
        System.out.println("Фактическое значение: " + actualValues
                + ".\nОжидаемое значение: " + expectedValues);

    }
}


