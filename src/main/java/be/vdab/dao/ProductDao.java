package be.vdab.dao;

import be.vdab.entiteiten.Product;

import java.util.List;

public interface ProductDao {

    public List<Product> getProducts();

    public void initShopItems();

    List<Product> findProducts(String productname);
}
