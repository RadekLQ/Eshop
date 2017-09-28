package be.vdab.dao.impl;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;

import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class CustomerDaoImplMockitoTest {

    @Mock
    private DataSource ds;

    @Mock
    private Connection c;

    @Mock
    private PreparedStatement stmt;

    @Mock
    private ResultSet rs1, rs2;

    private User user;
    private Customer customer;

    @BeforeEach
    public void setUp() throws Exception {
        assertNotNull(ds);
        when(c.prepareStatement(any(String.class))).thenReturn(stmt);
        when(ds.getConnection()).thenReturn(c);

        user = new User();
        user.setUserId(1);
        user.setUsername("User123");
        user.setPassword("Password123");

        when(rs1.first()).thenReturn(true);
        when(rs1.getInt(1)).thenReturn(1);
        when(rs1.getString(2)).thenReturn(user.getUsername());
        when(rs1.getString(3)).thenReturn(user.getPassword());

        customer = new Customer();
        customer.setCustomerId(1);
        customer.setName("Name123");
        customer.setFirstname("Firstname123");
        customer.setUsername("Username123");

        when(rs2.first()).thenReturn(true);
        when(rs2.getInt(1)).thenReturn(1);
        when(rs2.getString(2)).thenReturn(customer.getName());
        when(rs2.getString(3)).thenReturn(customer.getFirstname());
        when(rs2.getString(4)).thenReturn(customer.getUsername());
    }

    @Test
    void findCustomer() throws Exception {
        Customer dao = new Customer(ds);
        /*...*/
    }

    @Test
    void findByLoginAndUsername() {
    }

    @AfterEach
    void tearDown() {
        user = null;
        customer = null;
        ds = null;
        c = null;
        stmt = null;
        rs1= null;
        rs2 = null;
    }
}