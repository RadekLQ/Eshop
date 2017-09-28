package be.vdab.dao.impl;

import static org.mockito.Mockito.*;
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
    private ResultSet rs;

    private User user;
    private Customer customer;

    @BeforeEach
    public void setUp() throws Exception {
        assertNotNull(ds);
        when(c.prepareStatement(any(String.class))).thenReturn(stmt);
        when(ds.getConnection()).thenReturn(c);

        user = new User();
        user.setUserId(1);
        user.setUsername("user123");
        user.setPassword("password123");

        when(rs.first()).thenReturn(true);
        when(rs.getInt(1)).thenReturn(1);
        when(rs.getString(2)).thenReturn(user.getUsername());
        when(rs.getString(3)).thenReturn(user.getPassword());

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findCustomer() {
    }

    @Test
    void findByLoginAndUsername() {
    }

}