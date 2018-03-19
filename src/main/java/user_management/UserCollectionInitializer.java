package user_management;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class UserCollectionInitializer {
    public static UserCollection generate() {
        Gson gson = new Gson();
        try {
            User[] users = gson.fromJson(new FileReader("/Users/frankierodriguez/Dev/JavaAssessment3/src/main/resources/users.json"), User[].class);
            UserCollection userCollection = new UserCollection();
            userCollection.addAll(Arrays.asList(users));
            return userCollection;
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return null;
    }
}
