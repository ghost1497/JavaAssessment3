package user_management;

import user_management.security.Password;

public class User {
    private String email;
    private int id;
    private String name;
    private String password;

    public User(String email, int id, String name, String password) {
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

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
