package be.vdab.dao;

import be.vdab.entiteiten.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private final List<Product> products = new ArrayList<Product>();

    public ProductDao() {
        this.initShopItems();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void initShopItems() {

    }


}
