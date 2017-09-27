package be.vdab.dao;

import be.vdab.entiteiten.Shop;

import java.util.List;

public interface ShopDao {

    List<Shop> listAllShops(); /* implemented */

    void deleteShop(Shop shop); /* -*implemented*- */

    void saveOrUpdateShop(Shop shop); /* -*implemented*- */

}
