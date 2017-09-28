package be.vdab.dao.impl;

import be.vdab.entiteiten.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import javax.sql.DataSource;
import org.mockito.Mock;



import java.util.Comparator;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class ProductDaoImplTest {

    @InjectMocks
    private ProductDaoImpl productDao;

    private List<Product> products;
    private Product product;

    @Mock
    private DataSource mockDataSource;


    @Before
    public void init() {
        product = new Product();
        product.setProductId(1);
        product.setProductname("product123");
        product.setPrice(1.0);
        product.setStock(1);
    }

    @Test
    void findProducts() {
        new ProductDaoImpl(mockDataSource).findProducts("product123");

    }

}