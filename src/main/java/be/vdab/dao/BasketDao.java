package be.vdab.dao;

import be.vdab.entiteiten.Basket;
import be.vdab.entiteiten.Product;

public interface BasketDao {

    void saveOrUpdateBasket(Product product); /*(Basket basket) -not implemented- */

    void addProductToBasket(Product product);

    void removeProductFromBasket(Product product);

    Basket getBasket();  /* -not implemented- */

    void clearBasket(); /* -not implemented- */


}
