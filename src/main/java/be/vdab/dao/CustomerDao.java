package be.vdab.dao;

import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.User;

public interface CustomerDao {

    public Customer findCustomer(String name, String firstname, String username);

    public User findByLoginAndUsername(String username, String password);
}
