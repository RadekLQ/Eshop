package be.vdab.dao;

import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.Order;

import java.util.List;

public interface OrderDao {

    List<Order> findOrdersFromCustomers(Customer customer); /* implemented */

    void saveOrder(Order order); /* implemented */

    void deleteOrder(Order order); /* -*implemented*- */

    void updateOrder(Order order); /* -*implemented*- */

}
