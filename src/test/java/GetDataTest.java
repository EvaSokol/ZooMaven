import animals.Animal;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import utils.Actions;
import utils.DataFile;

import java.util.LinkedList;

/**
 * Created by Eva Sokolyanskaya on 16/10/2015.
 * First test to check TestNG works correctly.
 * Test to check if animals correctly got from file.
 */
public class GetDataTest {

    String filepath = "src\\main\\resources\\utils\\my_animals.txt";

    @Test
    public void PrintAnimals() {
        LinkedList<Animal> animalList = DataFile.getAnimalList(filepath);
        Actions.printAnimalList(animalList);
        Assert.assertEquals(DataFile.getAnimalCount(), animalList.size());
    }
}
