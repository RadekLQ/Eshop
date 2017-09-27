package be.vdab.dao;

import be.vdab.entiteiten.Basket;
import be.vdab.entiteiten.Product;

public interface BasketDao {

    void saveOrUpdateBasket(Basket basket); /* implemented */

    void addProductToBasket(Product product); /* implemented */

    void removeProductFromBasket(Product product); /* implemented */

    Basket getBasket();  /* implemented */

    void clearBasket(); /* implemented */


}
