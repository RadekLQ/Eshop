package be.vdab.dao;

import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.User;

public interface CustomerDao {

    Customer findCustomer(String name, String firstname, String username);

    User findByLoginAndUsername(String username, String password);
}
