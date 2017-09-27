package be.vdab.dao;

import be.vdab.entiteiten.User;
import be.vdab.entiteiten.Order;

import java.util.List;

public interface OrderDao {

    List<Order> findOrdersFromCustomers(User user); /* implemented */

    void saveOrder(Order order); /* implemented */

    void deleteOrder(Order order); /* -*implemented*- */

    void updateOrder(Order order); /* -*implemented*- */

}
