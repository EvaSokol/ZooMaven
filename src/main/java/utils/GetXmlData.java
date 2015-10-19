package utils;

import animals.Animal;
import java.util.LinkedList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import animals.Lion;
import animals.Parrot;
import animals.Wolf;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

/**
 * Created by Eva Sokolyanskaya on 19.10.2015.
 * Method to read data from XML file
 */
public class GetXmlData {

    LinkedList<Animal> animalList = new LinkedList<>();

    public void makeList(String filePath) {
        try {
            File XmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(XmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            NodeList zooList = doc.getElementsByTagName("animal");
            int age, height;
            String color, name, sex, type;

            for (int temp = 0; temp < zooList.getLength(); temp++) {

                Node nNode = zooList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    age = Integer.parseInt(eElement.getAttribute("age"));
                    height = Integer.parseInt(eElement.getAttribute("height"));
                    color = eElement.getAttribute("color");
                    name = eElement.getAttribute("name");
                    sex = eElement.getAttribute("sex");
                    type = eElement.getAttribute("type");

                    if (type.equalsIgnoreCase("Wolf"))
                        animalList.add(new Wolf(type, age, height, color, name, sex));
                    else if (type.equalsIgnoreCase("Parrot"))
                        animalList.add(new Parrot(type, age, height, color, name, sex));
                    else if (type.equalsIgnoreCase("Lion"))
                        animalList.add(new Lion(type, age, height, color, name, sex));
                    else
                        System.out.println(type + " " + "Nevedoma zverushka");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LinkedList<Animal> getAnimalList(String filePath) {
        makeList(filePath);
        return animalList;
    }
}
