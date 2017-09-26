package be.vdab.dao.impl;

import be.vdab.dao.OrderDao;
import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.Order;

import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public List<Order> findOrdersFromCustomers(Customer customer) {
        return null;
    }

    @Override
    public void saveOrder(Order order) {
    }
}
