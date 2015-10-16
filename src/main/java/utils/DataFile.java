package utils;

import animals.Animal;
import animals.Lion;
import animals.Parrot;
import animals.Wolf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;


public class DataFile {

    private static String filepath = "src\\main\\resources\\utils\\my_animals.txt";
    private static LinkedList<Animal> animalList;
    private static int animalCount = 0;
    private static HashSet<String> typeSet = new HashSet<>();
    private static DataFile dataFile;

    private DataFile() {}

    public static LinkedList<Animal> getAnimalList() {
        if (dataFile == null)
            dataFile = new DataFile();
            animalList = initAnimalList();
        return animalList;
    }

    private static LinkedList<Animal> initAnimalList() {
        String animal_type;
        LinkedList<String[]> data_list = getArrayData();
        LinkedList<Animal> AnimalList = new LinkedList<>();

        for (String[] line : data_list) {
            animal_type = line[0];
            typeSet.add(animal_type);
            if (animal_type.equalsIgnoreCase("Wolf"))
                AnimalList.add(new Wolf(
                        line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]),
                        line[3], line[4], line[5]));
            else if (animal_type.equalsIgnoreCase("Parrot"))
                AnimalList.add(new Parrot(
                        line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]),
                        line[3], line[4], line[5]));
            else if (animal_type.equalsIgnoreCase("Lion"))
                AnimalList.add(new Lion(
                        line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]),
                        line[3], line[4], line[5]));
            else
                System.out.println(line[0] + " " + "Nevedoma zverushka");
        }
        animalCount = AnimalList.size();
        return AnimalList;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    private static ArrayList<String> ReadFile(){
        ArrayList<String> stringBuffer = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.add(line);
                }
        } catch (IOException e) {
            e.printStackTrace();}

        return stringBuffer;
    }

    private static LinkedList<String[]> getArrayData() {
        //get data from file to string
        ArrayList<String> stringBuffer = ReadFile();
        stringBuffer.remove(0); //remove first service string

        LinkedList<String[]> animal_list = new LinkedList<String[]>();
        Iterator<String> iterator = stringBuffer.iterator();
        String[] temp_string_array;
        String temp_string;
        while (iterator.hasNext()) {
            temp_string = iterator.next();
            temp_string_array = temp_string.split(",");
            animal_list.add(temp_string_array);
        }
        return animal_list;
    }

    public static HashSet<String> getTypeSet() {
        return typeSet;
    }

}
