package be.vdab.dao.impl;

import be.vdab.dao.BasketDao;
import be.vdab.entiteiten.Product;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class BasketDaoImplTest {

    private BasketDao basket = new BasketDaoImpl();

    private ArrayList<Product> products = Lists.newArrayList(
            new Product(1, "item1", 131.12, 1),
            new Product(2, "item2", 123.01, 2),
            new Product(3, "item3", 164.12, 3),
            new Product(4, "item4", 554.21, 4),
            new Product(5, "item5", 154.12, 5),
            new Product(6, "item1", 131.12, 6),
            new Product(7, "item2", 123.01, 7)
    );

    @Before
    public void init() {
        for(Product product : products) {
            basket.addProductToBasket(product, 7);
        }
    }

    @Test
    void saveOrUpdateBasket() {
        BasketDao basket = new BasketDaoImpl();
        basket.saveOrUpdateBasket(basket.getBasket());
        assertThat(basket).isInstanceOf(BasketDaoImpl.class);
        assertThat(basket).isInstanceOfAny(BasketDaoImpl.class);
        assertThat(basket.getBasket().getProducten()).hasSize(7);
        assertThat(basket).isNotNull();
        assertThat(basket.getBasket().getProducten()).containsKey(new Product(7, "item2", 123.01, 7));
        }

    @Test
    void addProductToBasket() {
        Product product = new Product(8, "item1", 131.12, 6);
        basket.addProductToBasket(product, 1);
        assertThat(basket.getBasket().getProducten()).hasSize(8);
        assertThat(basket.getBasket().getProducten())
                .containsKeys(new Product(8, "item1", 131.12, 6));
    }

    @Test
    void removeProductFromBasket() {
        basket.removeProductFromBasket(new Product(8, "item1", 131.12, 6));
        assertThat(basket.getBasket().getProducten()).hasSize(7);
        assertThat(basket.getBasket().getProducten()).doesNotContainKey(new Product(8, "item1", 131.12, 6));
    }

    @Test
    void getBasket() {
        assertThat(basket.getBasket().getProducten()).hasSize(7);


    }

    @Test
    void clearBasket() {
        basket.clearBasket();
        assertThat(basket.getBasket().getProducten()).isEmpty();
        assertThat(basket.getBasket().getProducten()).doesNotContainKey(new Product(8, "item1", 131.12, 6));
    }
}