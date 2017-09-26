package be.vdab.entiteiten;

public class Product {
    private Integer idProduct;
    private String name;
    private Double price;
    private Integer stock;

    public Product() {
    }

    public Product(Integer idProduct, String name, Double price, Integer stock) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        if (!idProduct.equals(product.idProduct)) return false;
        if (!name.equals(product.name)) return false;
        if (!price.equals(product.price)) return false;
        return stock.equals(product.stock);
    }

    @Override
    public int hashCode() {
        int result = idProduct.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + stock.hashCode();
        return result;
    }
}
