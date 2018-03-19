package user_management;

import user_management.security.UserAuthenticationFailedException;
import user_management.validation.EmailNotAvailableException;
import user_management.validation.InvalidEmailException;
import user_management.validation.PasswordTooSimpleException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        for (User user : userArrayList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User findByEmail(String email) {
        for (User user : userArrayList) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public User attemptLogin(String email, String password) throws UserAuthenticationFailedException {
        for (User user : userArrayList) {
            if (user.getEmail().equals(email) &&  user.getPassword().matches(password)) {
                return user;
            }
        }
        throw new UserAuthenticationFailedException();
    }

    public int createUser(String name, String email, String password) throws EmailNotAvailableException, InvalidEmailException, PasswordTooSimpleException {
        Pattern domainP = Pattern.compile("[@]+[a-z]*");
        Matcher domainM = domainP.matcher(email);
        Pattern tld = Pattern.compile("[\\.]+[a-z]*");
        Matcher tldM = tld.matcher(email);
        Pattern nonWord = Pattern.compile("([a-z]|[0-9])*+[@]+([a-z]|[0-9])*+[\\.]+([a-z]|[0-9])*");
        Matcher nonWordM = nonWord.matcher(email);
        for (User user : userArrayList) {
            if (user.getPassword().equals(email)) {
                throw new EmailNotAvailableException();
            }
        }
        if (email.equals("") || !domainM.find() || !tldM.find() || !nonWordM.matches()) {
            throw new InvalidEmailException();
        }

        Pattern noNum = Pattern.compile("[0-9]");
        Matcher noNumM = noNum.matcher(password);
        Pattern specChar = Pattern.compile("[!@#$%^&*()<>?]");
        Matcher specCharM = specChar.matcher(password);
        if (password.length() < 8 || password.equals(password.toLowerCase()) || password.equals(password.toUpperCase()) || !noNumM.find() || !specCharM.find()) {
            throw new PasswordTooSimpleException();
        }
        int id = userArrayList.get(userArrayList.size()-1).getId() + 1;
        new User(id, name, email, password);

        return id;
    }

    public int size() {
        int count = 0;
        for(User user : userArrayList){
            count++;
        }
        return count;
    }
}
