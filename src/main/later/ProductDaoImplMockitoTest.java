package be.vdab.dao.impl;

import be.vdab.entiteiten.Product;
import be.vdab.entiteiten.User;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Fields;
import org.mockito.runners.MockitoJUnitRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//https://dzone.com/articles/mockito-basic-example-using-jdbc
@RunWith(MockitoJUnitRunner.class)
class ProductDaoImplMockitoTest {

    @Mock
    private DataSource mockDataSource;

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStmnt;

    @Mock
    private ResultSet mockResultSet;
    private Product product;

    public ProductDaoImplMockitoTest() {
    }


    @BeforeEach
    public void setUp() throws Exception {
        assertNotNull(mockDataSource);
        when(mockDataSource.getConnection()).thenReturn(mockConnection);
        when(mockDataSource.getConnection(anyString(), anyString())).thenReturn(mockConnection);
        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStmnt);
        doNothing().when(mockConnection).commit();
        when(mockPreparedStmnt.execute()).thenReturn(Boolean.TRUE);
        when(mockPreparedStmnt.getGeneratedKeys()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(Boolean.TRUE, Boolean.FALSE);

        product = new Product();
        product.setProductId(1);
        product.setProductname("product123");
        product.setPrice(1.0);
        product.setStock(1);

        when(mockResultSet.first()).thenReturn(true);
        when(mockResultSet.getInt(1)).thenReturn(1);
        when(mockResultSet.getString(2)).thenReturn(product.getProductname());
        when(mockResultSet.getDouble(3)).thenReturn(product.getPrice());
        when(mockResultSet.getInt(4)).thenReturn(product.getStock());
        when(mockPreparedStmnt.executeQuery()).thenReturn(mockResultSet);
    }

    @AfterEach
    void tearDown() {
        product = null;
        mockDataSource = null;
        mockConnection = null;
        mockPreparedStmnt = null;
        mockResultSet = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullCreateThrowsException() {
        new ProductDaoImpl(mockDataSource).findProducts(null);
    }

    @Test
    void findProducts() {
        new ProductDaoImpl(mockDataSource).findProducts("product123");
    }

}