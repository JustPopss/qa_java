import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CatTests {

    @Mock
    private Feline felineMock;
    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(felineMock);
    }

    @Test
    public void getSoundAssertEqaulsTestTrue() {
        String expectedValue = "Мяу";
        String actualValue = cat.getSound();

        System.out.println("\nТестирование метода getSound: \nФактическое значение: " + actualValue
                + ". \nОжидаемое значение: " + expectedValue + ".");
        Assert.assertEquals("Кот должен говорить: Мяу!", expectedValue, actualValue);
    }

    @Test
    public void getFoodAssertEqualsTestTrue() throws Exception {
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.eatMeat()).thenReturn(expectedList);
        List<String> actualList = cat.getFood();

        Assert.assertEquals(expectedList, actualList);

        System.out.println("\nТестирование метода getFoodAssertEqualsTestTrue: \nФактическое значение: " + actualList
                + ". \nОжидаемое значение: " + expectedList + ".");
    }

    @Test
    public void eatMeatVerifyTimesOneTest() throws Exception {
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.eatMeat()).thenReturn(expectedList);
        cat.getFood();
        verify(felineMock, times(1)).eatMeat();
    }
}

