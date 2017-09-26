package be.vdab.entiteiten;

import java.util.Comparator;

public abstract class User implements Comparable<User> {
    private int userId;
    private String name;
    private String firstname;
    private String email;
    private String address;

    public User() {
    }

    public User(int userId, String name, String firstname, String email, String address) {
        this.userId = userId;
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.address = address;
    }

    public static Comparator<User> sortBasedOnUserId() {
        return Comparator.comparing(User::getUserId);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s %s %s %s %s",
                userId, "Name:", name, "First name:", firstname, "E-mail: ", email, "Address:", address);
    }

    @Override
    public int compareTo(User o) {
        return this.userId - o.userId;
    }
}
