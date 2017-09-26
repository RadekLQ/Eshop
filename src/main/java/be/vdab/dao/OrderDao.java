package be.vdab.dao;

import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.Order;

import java.util.List;

public interface OrderDao {

    List<Order> findOrdersFromCustomers(Customer customer);

    void saveOrder(Order order);

}
