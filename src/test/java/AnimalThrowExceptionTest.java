import com.example.Animal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AnimalThrowExceptionTest {
    private Animal animal;

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void AnimalThrowExceptionTest() {
        String invalidInput = "Другое";
        String expectedText = "Неизвестный вид животного, используйте значение Травоядное или Хищник";

        try {
            animal.getFood(invalidInput);
            throw new AssertionError("ОШИБКА: Для '" + invalidInput + "' должно быть исключение!");

        } catch (Exception e) {
            Assert.assertEquals(expectedText, e.getMessage());
            System.out.println("Исключение: " + e.getMessage());
        }
    }
}


