package be.vdab.dao.impl;

import be.vdab.dao.OrderDao;
import be.vdab.entiteiten.Order;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class OrderDaoImplMockiotTest {

    @Mock
    private DataSource ds;

    @Mock
    private Connection c;

    @Mock
    private PreparedStatement stmt;

    @Mock
    private ResultSet rs1, rs2;

    private Order order;
    private OrderDao orderDao;

    @BeforeEach
    public void setUp() throws Exception {
        assertNotNull(ds);
        when(c.prepareStatement(any(String.class))).thenReturn(stmt);
        when(ds.getConnection()).thenReturn(c);

//        this.orderId = orderId;
//        this.paymentMethod = paymentMethod;
//        this.orderTotal = orderTotal;
//        this.date = date;
//        this.customerId = customerId;
//        this.eshopId = eshopId;

        order = new Order();
        order.setOrderId(1);
        order.setPaymentMethod("");
        order.setOrderTotal(1);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findOrdersFromCustomers() {
    }

    @Test
    void saveOrder() {
    }

    @Test
    void deleteOrder() {
    }

    @Test
    void updateOrder() {
    }

}