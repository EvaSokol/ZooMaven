package utils;

import animals.Animal;
import animals.Fly;
import animals.Jump;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by Eva on 12.10.2015.
 */
public class Actions {
    public static void printAnimalList(LinkedList<Animal> animalList) {
        for (Animal animal: animalList)
            System.out.println(animal.getType() + " " + animal.getSex() + " " + animal.getName());
         }

    private static ArrayList<String> getTypes() {
        HashSet<String> types = DataFile.getTypeSet();
        ArrayList<String> arrTypes = new ArrayList<>();
        types.forEach(type -> arrTypes.add(type));
        return arrTypes;
    }

    private static void init(ArrayList<Animal>[][] pairAnimals, int typesCount){

        for (int i=0; i<typesCount; i++) {
            pairAnimals[i] = new ArrayList[2];
            pairAnimals[i][0] = new ArrayList<>();
            pairAnimals[i][1] = new ArrayList<>();
        }
    }

    private static void sortToPairs(LinkedList<Animal> animalList, ArrayList<Animal>[][] pairAnimals, ArrayList<String> arrTypes) {
        int index;

        for (Animal animal : animalList) {
            String type = animal.getType();
            index = arrTypes.indexOf(type);
            if (animal.getSex().equalsIgnoreCase("male")) {
                pairAnimals[index][0].add(animal);
            }
            else if (animal.getSex().equalsIgnoreCase("female"))
                pairAnimals[index][1].add(animal);
        }
    }

    public static LinkedList<Animal> getSingleAnimals(LinkedList<Animal> animalList) {

        ArrayList<String> arrTypes = getTypes();

        int typesCount = arrTypes.size();

        ArrayList<Animal>[][] pairAnimals = new ArrayList[typesCount][2];
        init(pairAnimals, typesCount);

        sortToPairs(animalList, pairAnimals, arrTypes);

        return extractSingleAnimals(pairAnimals);
    }

    private static LinkedList<Animal> extractSingleAnimals(ArrayList<Animal>[][] pairAnimals) {
        LinkedList<Animal> singleAnimals = new LinkedList<>();
        int singles;

        for (ArrayList<Animal>[] one_type : pairAnimals) {
            singles = one_type[0].size() - one_type[1].size();
            if (singles > 0) {
                while (singles>0){
                    singleAnimals.add(one_type[0].get(singles - 1));
                    singles --;
                }
            }
            else if (singles < 0) {
                while (singles < 0) {
                    singleAnimals.add(one_type[1].get(Math.abs(singles) - 1));
                    singles ++;
                }
            }
        }
        return singleAnimals;
    }

    public static void printOldestAnimals(LinkedList<Animal> animalList) {
        int max_age = 0;
        LinkedList<Animal> oldAnimals = new LinkedList<>();
        for (Animal animal : animalList) {
            if (animal.getAge() == max_age)
                oldAnimals.add(animal);
            else if (animal.getAge() > max_age) {
                oldAnimals.clear();
                oldAnimals.add(animal);
                max_age = animal.getAge();
            }
        }
        System.out.println("Max age is " + max_age);
        oldAnimals.forEach(animal -> System.out.println(animal.getName()));
    }

    public static void getAbilities(Animal animal) {
        if (animal instanceof Jump) System.out.println("Jumping");
        if (animal instanceof Fly) System.out.println("Flying");

    }

    public static void getAllParameters(Animal animal) {
        System.out.println(animal.getClass());
        System.out.println(animal.getName());
        System.out.println(animal.getColor());
        System.out.println(animal.getAge());
        System.out.println(animal.getHeight());
        System.out.println(animal.getSex());
    }

    public static void oneAnimalPresentation(Animal animal) {
        // print: "Some new animals.Animal came here..."
        animal.newAnimal();

        System.out.println("Oh, it's " + animal.getName() + "!!!");

        // print: animals.Animal moved for few steps
        animal.move((int) (Math.random() * 5) + 2);

        if (!animal.getSex().contains("female"))
            System.out.println("He said:");
        else
            System.out.println("She said:");

        // he sad about his abilities
        if (animal instanceof Jump) ((Jump) animal).jump();
        if (animal instanceof Fly) ((Fly) animal).fly();

        if (!animal.getSex().contains("female"))
            System.out.println("And he left saying only...");
        else
            System.out.println("And she left saying only...");
        animal.voice();


    }

    public static void PrintAnimalList(LinkedList<Animal> animalList) {
        animalList.forEach(animal -> animal.getAnimalData());
    }

    public static void SortByAge(LinkedList<Animal> animalList) {
        animalList.sort((o1, o2) -> o1.getAge() - o2.getAge());
    }

    public static LinkedList<Animal> getAllThisTypeOld(LinkedList<Animal> animalList, String type) {
        LinkedList<Animal> thisTypeAnimals= new LinkedList<>();
        for (Animal animal : animalList)
            if (animal.getType().equalsIgnoreCase(type))
                thisTypeAnimals.add(animal);
        return thisTypeAnimals;
    }

    public static LinkedList<Animal> getAllThisType(LinkedList<Animal> animalList, String type) {
        HashMap<String, LinkedList<Animal>> map = convertToMap(animalList);
        return map.get(type.toLowerCase());
    }

    private static HashMap<String, LinkedList<Animal>> convertToMap(LinkedList<Animal> animalList) {
        HashMap<String, LinkedList<Animal>> map = new HashMap<String, LinkedList<Animal>>();
        utils.DataFile.getTypeSet().forEach(type -> map.put(type.toLowerCase(), new LinkedList<Animal>()));
        animalList.forEach(animal -> map.get(animal.getType().toLowerCase()).add(animal));
        return map;
    }
}
