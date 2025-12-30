import com.example.Animal;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.List;

@RunWith(Parameterized.class)
public class AnimalParameterizedAnimalKindTest {

    Animal animal = new Animal();
    private String animalKind;
    private List<String> expectedValues;

    public AnimalParameterizedAnimalKindTest(String animalKind, List<String> expectedValues) {
        this.animalKind = animalKind;
        this.expectedValues = expectedValues;
    }

    @Parameterized.Parameters(name = "Вид животного: {0}, рацион: {1} " +
            "\n фактическое: {1}")
    public static Object[][] values() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        };
    }

    @Test
    public void AnimalKindWithDifferentValuesTest() throws Exception {
        List<String> actualValues = animal.getFood(animalKind);
        Assert.assertEquals(expectedValues, actualValues);
        System.out.println("\nТестирование метода getFood со значением " +
                animalKind + ":\nФактическое значение: " +
                actualValues + ". \nОжидаемое значение: " + expectedValues + ".");

    }
}