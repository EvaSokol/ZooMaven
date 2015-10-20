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

    String filepath = "src\\main\\resources\\utils\\my_animals.txt";
    String xmlFile = "src\\main\\resources\\utils\\my_xml.xml";
    LinkedList<Animal> fileAnimalList;
    LinkedList<Animal> xmlAnimalList;

    @BeforeClass
    public void Preparations() {
        fileAnimalList = DataFile.getAnimalList(filepath);
        GetXmlData xmlData = new GetXmlData();
        xmlAnimalList= xmlData.getAnimalList(xmlFile);
    }

    @Test
    public void CompareLists() {

        Assertion assertion = new Assertion();

        assertion.assertEquals(fileAnimalList, xmlAnimalList);
    }
}
