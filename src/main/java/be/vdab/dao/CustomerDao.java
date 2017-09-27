package be.vdab.dao;

import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.User;

public interface CustomerDao {

    Customer findCustomer(String name, String firstname); /* not implemented  String username*/

    User findByLoginAndUsername(String username, String password); /* not implemented */

    void updateShop(Customer customer); /* -*not implemented*- */

    void deleteCustomer(Customer customer); /* -*not implemented*- */
}
