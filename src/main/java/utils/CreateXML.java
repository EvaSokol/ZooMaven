package utils;

import java.io.File;
import java.util.LinkedList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import animals.Animal;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
/**
 * Created by Eva Sokolyanakaya on 19.10.2015.
 * XML file creator.
 */
public class CreateXML {
    public CreateXML() {
        xmlWriter();
    }

    void xmlWriter(){
        String fileName = "src\\main\\resources\\utils\\my_xml.xml";
        String filepath = "src\\main\\resources\\utils\\my_animals.txt";
        LinkedList<Animal> animalList = DataFile.getAnimalList(filepath) ;

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("zoo");
            doc.appendChild(rootElement);

            for (Animal animal : animalList) {

                Element staff = doc.createElement("animal");
                rootElement.appendChild(staff);

                Attr type = doc.createAttribute("type");
                type.setValue(animal.getType().toString());
                staff.setAttributeNode(type);

                Attr age = doc.createAttribute("age");
                StringBuilder sbAge = new StringBuilder();
                sbAge.append(animal.getAge());
                String strAge = sbAge.toString();
                age.setValue(strAge);
                staff.setAttributeNode(age);

                Attr height = doc.createAttribute("height");
                StringBuilder sbHeight = new StringBuilder();
                sbHeight.append(animal.getHeight());
                String strHeight = sbHeight.toString();
                height.setValue(strHeight);
                staff.setAttributeNode(height);

                Attr color = doc.createAttribute("color");
                color.setValue(animal.getColor().toString());
                staff.setAttributeNode(color);

                Attr name = doc.createAttribute("name");
                name.setValue(animal.getName().toString());
                staff.setAttributeNode(name);

                Attr sex = doc.createAttribute("sex");
                sex.setValue(animal.getSex().toString());
                staff.setAttributeNode(sex);
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(fileName));
//            StreamResult result = new StreamResult(new File("C:\\file.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

        }

        catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }

    }
}
