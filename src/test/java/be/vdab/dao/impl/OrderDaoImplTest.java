package be.vdab.dao.impl;

import be.vdab.dao.CustomerDao;
import be.vdab.dao.OrderDao;
import be.vdab.entiteiten.Order;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderDaoImplTest {
    @Test
    public void findOrdersFromCustomers() {
        List orders = Lists.newArrayList();
        CustomerDao customerDao = new CustomerDaoImpl();

        OrderDao order = new OrderDaoImpl();

        assertThat(1).isEqualTo(order.findOrdersFromCustomers(customerDao.findCustomer("Armani", "Giorgio", "user123")).get(0).getOrderId());
    }

    @Test
    public void saveOrder() {
        Date date = Date.valueOf("2017-09-28");
        Order order = new Order(1, "Visa GOLD", 20, date, 1, 1);
        OrderDao orderDao = new OrderDaoImpl();

        orderDao.saveOrder(order);
    }
}
