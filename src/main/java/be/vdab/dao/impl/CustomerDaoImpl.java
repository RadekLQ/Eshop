package be.vdab.dao.impl;

import be.vdab.dao.CustomerDao;
import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.User;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public Customer findCustomer(String name, String firstname, String username) {
        return null;
    }

    @Override
    public User findByLoginAndUsername(String username, String password) {
        return null;
    }
}
