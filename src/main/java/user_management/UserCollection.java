package user_management;

import parsing_json.Element;

import java.util.ArrayList;
import java.util.List;

public class UserCollection {
    private ArrayList<User> userArrayList = new ArrayList<>();

    public void add(User u) {
        userArrayList.add(u);
    }

    public User get(int index) {
        return userArrayList.get(index);
    }

    public void addAll(List<User> users) {
        for (User user : users) {
            userArrayList.add(user);
        }
    }

    public User findById(int id) {
        for(User user : userArrayList){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User findByEmail(String email) {
        for(User user : userArrayList){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public User attemptLogin(String email, String password) {
        return null;
    }

    public int createUser(String name, String email, String password) {
        return 0;
    }
}
