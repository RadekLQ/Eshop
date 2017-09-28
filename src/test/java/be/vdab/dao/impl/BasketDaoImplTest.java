package be.vdab.dao.impl;

import be.vdab.dao.BasketDao;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

class BasketDaoImplTest {

    private BasketDao basket = new BasketDaoImpl();

    @Test
    void saveOrUpdateBasket() {
    }

    @Test
    void addProductToBasket() {
    }

    @Test
    void removeProductFromBasket() {
    }

    @Test
    void getBasket() {
    }

    @Test
    void clearBasket() {
        basket.clearBasket();
        assertThat(basket.getBasket().getProducten()).isEmpty();
    }

}