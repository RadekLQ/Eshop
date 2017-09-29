package be.vdab.dao.impl;

import be.vdab.dao.OrderDao;
import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.Order;
import com.google.common.collect.Lists;

import java.sql.*;
import java.util.List;

import static be.vdab.utilities.GetConnection.getConnection;

public class OrderDaoImpl implements OrderDao {

    @Override
    public List<Order> findOrdersFromCustomers(Customer customer) {

        List<Order> orders = Lists.newArrayList();

        String sql = "SELECT * FROM eshop.`order` where cusomerId=?;";
        try (Connection connecion = getConnection(); PreparedStatement stmt = connecion.prepareStatement(sql)) {
            stmt.setInt(1, customer.getCustomerId());

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt(1);
                String paymentMethod = rs.getString(2);
                int orderTotal = rs.getInt(3);
                Date orderDate = rs.getDate(4);
                int cusomerId = rs.getInt(5);
                int eshopId = rs.getInt(6);

                orders.add(new Order(orderId, paymentMethod, orderTotal, orderDate, cusomerId, eshopId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    @Override
    public void saveOrder(Order order) {

        String sql = "INSERT INTO eshop.`order` (idOrder,paymentMethod,orderTotal,dateOrder,cusomerId,eshopId) VALUES(?,?,?,?,?,?);";

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, order.getOrderId());
            stmt.setString(2, order.getPaymentMethod());
            stmt.setInt(3, order.getOrderTotal());
            stmt.setDate(4, order.getDate());
            stmt.setInt(5, order.getCustomerId());
            stmt.setInt(6, order.getEshopId());

            int result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
