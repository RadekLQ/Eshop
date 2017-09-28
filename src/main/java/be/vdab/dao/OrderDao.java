package be.vdab.dao;

import be.vdab.entiteiten.Order;
import be.vdab.entiteiten.User;

import java.util.List;

public interface OrderDao {

    List<Order> findOrdersFromCustomers(User user);

    void saveOrder(Order order);
}
