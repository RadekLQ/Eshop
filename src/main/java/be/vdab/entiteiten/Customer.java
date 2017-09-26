package be.vdab.entiteiten;

public class Customer extends User {
    private String username;
    private String password;

    public Customer() {
    }

    public Customer(int userId, String name, String firstname, String email, String address) {
        super(userId, name, firstname, email, address);
    }

    public Customer(int userId, String name, String firstname, String email, String address, String username, String password) {
        super(userId, name, firstname, email, address);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return super.toString() + "/t" + "Username:" + username + "Password:" + password;
    }
}
