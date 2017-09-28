package be.vdab.entiteiten;

import java.util.HashMap;
import java.util.Map;

public class Basket {

    private Map<Product, Double> producten = new HashMap<>();

    public Basket() {
    }

    public void addToBasket(Product product, double amount) {
        producten.put(product, amount);
    }

    public void removeFromBasket(Product product) {
        producten.remove(product);
    }

    public Map<Product, Double> getProducten() {
        return producten;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Basket basket = (Basket) o;

        return getProducten() != null ? getProducten().equals(basket.getProducten()) : basket.getProducten() == null;
    }

    @Override
    public int hashCode() {
        return getProducten() != null ? getProducten().hashCode() : 0;
    }
}
