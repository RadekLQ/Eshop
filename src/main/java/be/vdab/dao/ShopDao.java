package be.vdab.dao;

import be.vdab.entiteiten.Shop;

import java.util.List;

public interface ShopDao {

    List<Shop> listAllShops();

    void deleteShopFromShops(Shop shop);

    void updateShopFromShops(Shop shop);

}
