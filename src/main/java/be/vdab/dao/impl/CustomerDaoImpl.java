package be.vdab.dao.impl;

import be.vdab.dao.CustomerDao;
import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static be.vdab.utilities.getConnection.getConnection;


public class CustomerDaoImpl implements CustomerDao {

    private static final Logger LOGGER = Logger.getLogger(ProductDaoImpl.class);
    private Customer customer;
    private User user;

    @Override
    public Customer findCustomer(String name, String firstname, String username) {

        String sql = "Select * from customer where name = ? and firstname = ? and username = ?;";

        try (Connection c = getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, firstname);
            stmt.setString(3, username);


            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    customer = new Customer(rs.getInt("idUser"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getInt("idCustomer"),
                            rs.getString("name"),
                            rs.getString("firstName"),
                            rs.getString("eMail"),
                            rs.getString("deliveryAdress"));
                }
            }

        } catch (SQLException e) {
            LOGGER.error("customer not found in database" + e);
        }
        return customer;
    }

    @Override
    public User findByLoginAndUsername(String username, String password) {

        String sql = "Select * from customer where username = ? and password = ?;";

        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(rs.getInt("idUser"), rs.getString("username"), rs.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}