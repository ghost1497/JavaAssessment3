package parsing_json;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class ElementCollectionInitializer {
    public static ElementCollection generate() {

        Gson gson = new Gson();
        try {
            Element[] elements = gson.fromJson(new FileReader("/Users/frankierodriguez/Dev/JavaAssessment3/src/main/resources/periodic_table.json"), Element[].class);
            ElementCollection elementCollection = new ElementCollection();
            elementCollection.addAll(Arrays.asList(elements));
//            System.out.println(elementCollection.findByAtomicNumber(5).getName());
            return elementCollection;
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        return null;
    }
}
