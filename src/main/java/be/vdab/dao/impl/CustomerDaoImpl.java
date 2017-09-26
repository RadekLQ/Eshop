package be.vdab.dao.impl;

import be.vdab.dao.CustomerDao;
import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.User;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CustomerDaoImpl implements CustomerDao {

    private static final String SELECT_SQL = "SELECT idCustomer,name,firstName,eMail,deliveryAdress FROM customer;;";
    private static final Logger LOGGER = Logger.getLogger(CustomerDaoImpl.class);

    private static final String KOLOM_IDCUSTOMER = "idCustomer";
    private static final String KOLOM_NAME = "name";
    private static final String KOLOM_FIRSTNAME = "firstName";
    private static final String KOLOM_EMAIL = "eMail";
    private static final String KOLOM_ADDRESS = "deliveryAdress";

    private List<Customer> customers;

    @Override
    public Customer findCustomer(String name, String firstname) {
        return null;
    }

    @Override
    public User findByLoginAndUsername(String username, String password) {
        return null;
    }



    private Connection getConnection() throws SQLException {
        Properties prop = new Properties();
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            prop.load(classloader.getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(prop.getProperty("jdbc.url"), prop.getProperty("jdbc.user"), prop.getProperty("jdbc.password"));
    }

    private void addToList(String sql) {

        customers = new ArrayList<>();

        try (Connection con = getConnection(); Statement stmt = con.createStatement()) {

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int userId = rs.getInt(KOLOM_IDCUSTOMER);
                String name = rs.getString(KOLOM_NAME);
                String firstname = rs.getString(KOLOM_FIRSTNAME);
                String email = rs.getString(KOLOM_EMAIL);
                String address = rs.getString(KOLOM_ADDRESS);

                customers.add(new Customer(userId, name, firstname, email, address));
            }

        } catch (SQLException e) {
            LOGGER.error("Could nog connect to database: " + e);
        }
    }
}
