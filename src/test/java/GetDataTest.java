import animals.Animal;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import utils.Actions;
import utils.DataFile;

import java.util.LinkedList;

/**
 * Created by esokolyanskaya on 16/10/2015.
 */
public class GetDataTest {

    @Test
    public void PrintAnimals() {
        LinkedList<Animal> animalList = DataFile.getAnimalList();
        Actions.printAnimalList(animalList);
        Assert.assertEquals(DataFile.getAnimalCount(), animalList.size());
    }
}
