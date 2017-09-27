package be.vdab.dao.impl;

import be.vdab.dao.OrderDao;
import be.vdab.entiteiten.User;
import be.vdab.entiteiten.Order;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class OrderDaoImpl implements OrderDao {

    private static final String SELECT_SQL = "SELECT idOrder,paymentMethod,orderTotal,dateOrder,cusomerId,eshopId " +
            "FROM eshop.`order`;";
    private static final Logger LOGGER = Logger.getLogger(OrderDaoImpl.class);

    private static final String KOLOM_IDORDER = "idOrder";
    private static final String KOLOM_PAYMENTMETHOD = "paymentMethod";
    private static final String KOLOM_ORDERTOTAL = "orderTotal";
    private static final String KOLOM_DATE = "dateOrder";
    private static final String KOLOM_CUSTOMERID = "cusomerId";
    private static final String KOLOM_ESHOPID = "eshopId";


    private List<Order> orders;

    @Override
    public List<Order> findOrdersFromCustomers(User user) {
        addToList(SELECT_SQL + " WHERE user = '" + user + "';");
        return orders;
    }

    @Override
    public void saveOrder(Order order) {

        String sql = "INSERT INTO order (idOrder,paymentMethod,orderTotal,dateOrder,cusomerId,eshopId) VALUES(?,?,?,?,?,?);";

        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, order.getOrderId());
            stmt.setString(2, order.getPaymentMethod());
            stmt.setInt(3, order.getOrderTotal());
            stmt.setDate(4, (java.sql.Date) order.getDate());
            stmt.setInt(5, order.getCustomerId());
            stmt.setInt(6, order.getEshopId());

            int result = stmt.executeUpdate();

            LOGGER.debug(result + " save an order from e-shop");

        } catch (SQLException e) {
            LOGGER.error("Could nog connect to database: " + e);
        }
    }

    @Override
    public void deleteOrder(Order order) {
        String sql = "DELETE order (idOrder,paymentMethod,orderTotal,dateOrder,cusomerId,eshopId) VALUES(?,?,?,?,?,?);";

        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, order.getOrderId());
            stmt.setString(2, order.getPaymentMethod());
            stmt.setInt(3, order.getOrderTotal());
            stmt.setDate(4, (java.sql.Date) order.getDate());
            stmt.setInt(5, order.getCustomerId());
            stmt.setInt(6, order.getEshopId());

            int result = stmt.executeUpdate();

            LOGGER.debug(result + " save an order from e-shop");

        } catch (SQLException e) {
            LOGGER.error("Could nog connect to database: " + e);
        }
    }

    @Override
    public void updateOrder(Order order) {

        String sql = "UPDATE order (idOrder,paymentMethod,orderTotal,dateOrder,cusomerId,eshopId) VALUES(?,?,?,?,?,?);";

        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, order.getOrderId());
            stmt.setString(2, order.getPaymentMethod());
            stmt.setInt(3, order.getOrderTotal());
            stmt.setDate(4, (java.sql.Date) order.getDate());
            stmt.setInt(5, order.getCustomerId());
            stmt.setInt(6, order.getEshopId());

            int result = stmt.executeUpdate();

            LOGGER.debug(result + " save an order from e-shop");

        } catch (SQLException e) {
            LOGGER.error("Could nog connect to database: " + e);
        }
    }

    private Connection getConnection() throws SQLException {
        Properties prop = new Properties();
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            prop.load(classloader.getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(prop.getProperty("jdbc.url"), prop.getProperty("jdbc.user"),
                prop.getProperty("jdbc.password"));
    }

    private void addToList(String sql) {

        orders = new ArrayList<>();

        try (Connection con = getConnection(); Statement stmt = con.createStatement()) {

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int orderId = rs.getInt(KOLOM_IDORDER);
                String paymentMethod = rs.getString(KOLOM_PAYMENTMETHOD);
                int orderTotal = rs.getInt(KOLOM_ORDERTOTAL);
                Date date = rs.getDate(KOLOM_DATE);
                int customerId = rs.getInt(KOLOM_CUSTOMERID);
                int eshopId = rs.getInt(KOLOM_ESHOPID);

                orders.add(new Order(orderId, paymentMethod, orderTotal, date, customerId, eshopId));
            }

        } catch (SQLException e) {
            LOGGER.error("Could nog connect to database: " + e);
        }
    }
}
