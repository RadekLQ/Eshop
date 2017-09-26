package be.vdab.entiteiten;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!productId.equals(product.productId)) return false;
        if (!productname.equals(product.productname)) return false;
        if (!price.equals(product.price)) return false;
        return stock.equals(product.stock);
    }

    @Override
    public int hashCode() {
        int result = productId.hashCode();
        result = 31 * result + productname.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + stock.hashCode();
        return result;
    }


    @Override
    public String toString() {
        return String.format(
                "%-15d Product name: %-15s Price: %-15s Stock: %5dml",
                productId,  productname, price,  stock);
    }

    @Override
    public int compareTo(Product o) {
        return this.productId - o.productId;
    }
}

