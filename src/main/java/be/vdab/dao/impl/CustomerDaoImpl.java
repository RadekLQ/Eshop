package be.vdab.dao.impl;

import be.vdab.dao.CustomerDao;
import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.User;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class CustomerDaoImpl implements CustomerDao {

    @Override
    public Customer findCustomer(String name, String firstname, String username) {

        String sql = "Select * from customer where Name = ? and firstname = ? and username = ?";

        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, firstname);
            stmt.setString(3, username);

            ResultSet rs = stmt.executeQuery();

            int customerId = 0;
            String password = "";
            String address = "";
            String email = "";

            if (rs.next()) {

                customerId = rs.getInt("customerId");
                password = rs.getString("Password");
                address = rs.getString("DeliveryAdress");
                email = rs.getString("E-mail");

            }

            return new Customer(username, password, customerId, name, firstname, address, email);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public User findByLoginAndUsername(String username, String password) {

        String sql = "Select * from customer where Username = ? and Password = ?";


        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);


            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new User(rs.getInt("customerId"), rs.getString("Username"), rs.getString("Password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateCustomer(User user) {

    }

    @Override
    public void deleteCustomer(User user) {

    }

    private Connection getConnection() throws SQLException {
        Properties prop = new Properties();
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            prop.load(classloader.getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(prop.getProperty("jdbc.url"),
                prop.getProperty("jdbc.user"), prop.getProperty("jdbc.password"));
    }
}
