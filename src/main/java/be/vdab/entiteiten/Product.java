package be.vdab.entiteiten;

import java.util.Comparator;

public class Product implements Comparable<Product> {
    private Integer productId;
    private String productname;
    private Double price;
    private Integer stock;

    public Product() {
    }

    public Product(Integer productId, String productname, Double price, Integer stock) {
        this.productId = productId;
        this.productname = productname;
        this.price = price;
        this.stock = stock;
    }

    public static Comparator<Product> sortBasedOnProductName() {
        return Comparator.comparing(Product::getProductname);
    }

    public static Comparator<Product> sortBasedOnProductId() {
        return Comparator.comparing(Product::getProductId);
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format(
                "%-15d Product name: %-15s Price: %-15s Stock: %5dpcs",
                productId, productname, price, stock);
    }

    @Override
    public int compareTo(Product o) {
        return this.productId - o.productId;
    }
}

