package be.vdab.dao.impl;

import be.vdab.dao.ProductDao;
import be.vdab.entiteiten.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private final List<Product> products = new ArrayList<Product>();


    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public void initShopItems() {
    }

    @Override
    public List<Product> findProducts(String productname) {
        return null;
    }
}
