import animals.Animal;
import utils.Actions;
import utils.CreateXML;
import utils.DataFile;
import utils.GetXmlData;

import java.util.Comparator;
import java.util.LinkedList;

public class Run {

    public static void main(String[] args) {

        String filepath = "src\\main\\resources\\utils\\my_animals.txt";

        LinkedList<Animal> animalList = DataFile.getAnimalList(filepath);

        animalList.sort(new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return 0;
            }
        });

//        String xmlFile = "src\\main\\resources\\utils\\my_xml.xml";
//
//        GetXmlData xmlData = new GetXmlData();
//        LinkedList<Animal> xmlAnimalList = xmlData.getAnimalList(xmlFile);
//        Actions.printAnimalList(xmlAnimalList);

//        CreateXML xml = new CreateXML();

//        System.out.println("There are " + DataFile.getAnimalCount() + " animals total in the list.");
//
//        allAnimalPresentation(animalList); //A little story about every animal
//
//        animalList.forEach(animal -> Actions.getAllParameters(animal)); //Print list of all animal parameters
//
//        animalList.forEach(animal -> animal.getAnimalDescription()); //get descriptions for each animal
//
//        Actions.getAbilities(animalList.get(2)); // get list of abilities for some animal

//        sortByAge(animalList);

//        Actions.printAnimalList(Actions.getSingleAnimals(animalList)); //print list of all single animals
//
//        removeSingleAnimals(animalList);
//
//        Actions.printOldestAnimals(animalList); //print list of animals with max age
//
//        System.out.println("-----------");
//
//        Actions.PrintAnimalList(Actions.getAllThisType(animalList, "parrot")); //print list of specified type animals wolf/parrot/lion

    }

    private static void removeSingleAnimals(LinkedList<Animal> animalList) {
        Actions.PrintAnimalList(animalList); // Print list of all animals: type - name - sex - age
        System.out.println("-----------");
        LinkedList<Animal> singleAnimalList = Actions.getSingleAnimals(animalList);
        animalList.removeAll(singleAnimalList);
        System.out.println("Next single animals are removed:");
        Actions.printAnimalList(singleAnimalList);
        System.out.println("-----------");
        Actions.PrintAnimalList(animalList); // Print list of animals left in the list
    }

    private static void sortByAge(LinkedList<Animal> animalList) {
        Actions.PrintAnimalList(animalList); // Print list of all animals: type - name - sex - age
        System.out.println("-----------");
        Actions.SortByAge(animalList); //Sort min -> max
        Actions.PrintAnimalList(animalList); // Sorted list
    }

    static void allAnimalPresentation(LinkedList<Animal> animal_list) {
        animal_list.forEach(animal -> Actions.oneAnimalPresentation(animal));
    }

}
