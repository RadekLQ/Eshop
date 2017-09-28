package be.vdab.dao.impl;

import be.vdab.dao.CustomerDao;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CustomerDaoImplTest {

    @Before
    public void init(){
    }

    @Test
    public void findCustomer() {
        CustomerDao customerDao = new CustomerDaoImpl();
        assertThat("Armani").isEqualTo(customerDao.findCustomer("Armani", "Giorgio", "user123").getName());
        assertThat("user123").isEqualTo(customerDao.findCustomer("Armani", "Giorgio", "user123").getUsername());
        assertThat("Giorgio").isEqualTo(customerDao.findCustomer("Armani", "Giorgio", "user123").getFirstname());
    }

    @Test
    public void findByLoginAndUsername() {
        CustomerDao customerDao = new CustomerDaoImpl();
        assertThat("user123").isEqualTo(customerDao.findByLoginAndUsername("user123", "password123").getUsername());
        assertThat("password123").isEqualTo(customerDao.findByLoginAndUsername("user123", "password123").getPassword());
    }
}