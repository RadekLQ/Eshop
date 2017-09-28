package be.vdab.entiteiten;

import java.util.Comparator;

public class User implements Comparable<User> {
    private int userId;
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    public User(int userId, String username, String password) {
        setUserId(userId);
        setUsername(username);
        setPassword(password);
    }

    public static Comparator<User> sortBasedOnUserId() {
        return Comparator.comparing(User::getUserId);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        if (userId >= 0) {
            this.userId = userId;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username != null && !username.isEmpty()) {
            this.username = username;
        } else {
            throw new IllegalArgumentException("Username input is invalid.");
        }


    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null && !password.isEmpty()) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Password input is invalid.");
        }
    }

    @Override
    public String toString() {
        return "User{" +
                ", username='" + username +
                ", password='" + password +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (!username.equals(user.username)) return false;
        return password.equals(user.password);
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public int compareTo(User o) {
        return this.userId - o.getUserId();
    }
}

