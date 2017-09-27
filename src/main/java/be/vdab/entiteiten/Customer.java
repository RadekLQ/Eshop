package be.vdab.entiteiten;

import java.util.Comparator;

public class Customer extends User implements Comparable<Customer> {
    private int customerId;
    private String name;
    private String firstname;
    private String email;
    private String address;

    public Customer(String username, String password) {
        super(username, password);
    }

    public Customer(String username, String password, int customerId, String name, String firstname, String email, String address) {
        super(username, password);
        this.customerId = customerId;
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.address = address;
    }

    public static Comparator<Customer> sortBasedOnUserId() {
        return Comparator.comparing(Customer::getCustomerId);
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
                customerId, "Name:", name, "First name:", firstname, "E-mail: ", email, "Address:", address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return name.equals(customer.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int compareTo(Customer o) {
        return this.customerId - o.customerId;
    }
}
