package be.vdab.dao.impl;

import be.vdab.dao.BasketDao;
import be.vdab.entiteiten.Basket;
import be.vdab.entiteiten.Product;


public class BasketDaoImpl implements BasketDao {

    private Basket basket = new Basket();

    @Override
    public void saveOrUpdateBasket(Basket basket) {

    }

    @Override
    public void addProductToBasket(Product product) {
        basket.addToBasket(product);
    }

    @Override
    public void removeProductFromBasket(Product product) {
        basket.removeFromBasket(product);
    }

    @Override
    public Basket getBasket() {
        return basket;
    }

    @Override
    public void clearBasket() {
        basket.getProducten().clear();
    }

}
