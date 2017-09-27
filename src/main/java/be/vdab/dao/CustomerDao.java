package be.vdab.dao;

import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.User;

public interface CustomerDao {

    Customer findCustomer(String name, String firstname, String username); /* implemented  */

    User findByLoginAndUsername(String username, String password); /* implemented */

    void updateCustomer(User user); /* -*not implemented*- */

    void deleteCustomer(User user); /* -*not implemented*- */
}
