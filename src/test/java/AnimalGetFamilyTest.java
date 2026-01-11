import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;

public class AnimalGetFamilyTest {


    @Test
    public void animalGetFamilyAssertEqualsTestTrue() {
    Animal animal = new Animal();

    String expectedText = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    String actualText = animal.getFamily();

        Assert.assertEquals(expectedText,actualText);
        System.out.println("\nТестирование метода getFamily: \nФактическое значение: "
                + actualText + ". \nОжидаемое значение: " + expectedText + ".");
    }
}
