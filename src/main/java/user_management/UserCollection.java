package user_management;

import parsing_json.Element;
import user_management.security.UserAuthenticationFailedException;
import user_management.validation.EmailNotAvailableException;

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

    public User attemptLogin(String email, String password) throws UserAuthenticationFailedException{
        for(User user : userArrayList){
            if(user.getEmail().equals(email) && user.getPassword().equals(password) && user.getPassword().matches(password)){
                return user;
            }
        }
        throw new UserAuthenticationFailedException();
    }

    public int createUser(String name, String email, String password) {
        for(User user : userArrayList){
        if(user.getPassword().equals(email)){
            throw new EmailNotAvailableException();
        }
        return 0;
    }
}
