package be.vdab.dao.impl;

import be.vdab.dao.ShopDao;
import be.vdab.entiteiten.Shop;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ShopDaoImplTest {

    @Test
    void listAllShops() {

        List<Shop> shops;
        ShopDao shopLijst = new ShopDaoImpl();
        shops = shopLijst.listAllShops();
        assertThat(1).isEqualTo(shops.get(0).getShopId());
    }

}