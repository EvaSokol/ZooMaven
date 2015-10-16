import animals.Animal;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DataFile;
import utils.Actions;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Eva on 16.10.2015.
 */
public class SortByAgeTest {

    private String filepath = "src\\main\\resources\\utils\\my_animals.txt";

    @Test
    public void sortByAgeTEst() {
        LinkedList<Animal> animalList = DataFile.getAnimalList(filepath);
        Actions.SortByAge(animalList);
        int size = animalList.size();
        int[] resultArray = new int[size];
        for (int i=0; i<size; i++) {
            resultArray[i] = animalList.get(i).getAge();
        }
        int[] chechkArray = {1,1,2,3,4,4,4,4,5,5,5};
        Assert.assertEquals(resultArray, chechkArray);


    }
}
