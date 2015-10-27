import animals.Animal;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import utils.Actions;
import utils.DataFile;
import utils.GetXmlData;

import java.util.LinkedList;

/**
 * Created by Eva on 20.10.2015.
 */
public class CheckXmlTest {

    String filepath;
    String xmlFile;
    LinkedList<Animal> fileAnimalList;
    LinkedList<Animal> xmlAnimalList;
    LinkedList<String> fileAnimalNames;
    LinkedList<String> xmlAnimalNames;

    @BeforeClass
    public void Preparations() {
        filepath = "src\\main\\resources\\utils\\my_animals.txt";
        fileAnimalList = DataFile.getAnimalList(filepath);
        fileAnimalNames = new LinkedList<>();
        fileAnimalList.forEach(animal -> fileAnimalNames.add(animal.getName()));

        xmlFile = "src\\main\\resources\\utils\\my_xml.xml";
        GetXmlData xmlData = new GetXmlData();
        xmlAnimalNames = new LinkedList<>();
        xmlAnimalList= xmlData.getAnimalList(xmlFile);
        xmlAnimalList.forEach(animal -> xmlAnimalNames.add(animal.getName()));

    }

    @Test
    public void CompareLists() {

        Assertion assertion = new Assertion();

        assertion.assertEquals(xmlAnimalNames.containsAll(fileAnimalNames), true);
    }
}
