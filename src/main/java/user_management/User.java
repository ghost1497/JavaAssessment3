package user_management;

import user_management.security.Password;

public class User {
    private String email;
    private int id;
    private String name;
    private Password password;

    public User(String email, int id, String name, String password) {
        this.email = email;
        this.id = id;
        this.name = name;
        Password pass = new Password(password);
        this.password = pass;
    }
    public User(String email, int id, String name, Password password) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Password pass = new Password(password);
        this.password = pass;
    }

    public void setPassword(Password password){
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("%-10s - %s", name, email);
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        if(name.equals(user.getName()) && email.equals(user.getEmail()) && id == user.getId()){
            return true;
        }
        return false;
    }
}
