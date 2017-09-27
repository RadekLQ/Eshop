package be.vdab.dao;

import be.vdab.entiteiten.User;
import be.vdab.entiteiten.Customer;

public interface CustomerDao {

    Customer findCustomer(String name, String firstname, String username); /* not implemented  */

    User findByLoginAndUsername(String username, String password); /* not implemented */

    void updateCustomer(User user); /* -*not implemented*- */

    void deleteCustomer(User user); /* -*not implemented*- */
}
