package be.vdab.entiteiten;

import java.util.List;

public class Basket {

    private float amount;
    private List<Product> producten;

    public Basket() {
    }

    public Basket( List<Product> producten, int amount) {
        this.amount = amount;

    }

    public void addToBasket(Product product){
        producten.add(product);
    }

    public void removeFromBasket(Product product){
        producten.remove(product);
    }

    public List<Product> getProducten() {
        return producten;
    }
}
