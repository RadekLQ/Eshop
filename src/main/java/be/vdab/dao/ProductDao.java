package be.vdab.dao;

import be.vdab.entiteiten.Product;

import java.util.List;

public interface ProductDao {

    List<Product> findProducts(String productname); /* -implemented- */

    void deleteProduct(Product product); /* -implemented- */

    void updateProduct(Product product); /* -implemented- */
}
