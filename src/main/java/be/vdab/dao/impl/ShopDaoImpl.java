package be.vdab.dao.impl;

import be.vdab.dao.ShopDao;
import be.vdab.entiteiten.Shop;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ShopDaoImpl implements ShopDao {

    private static final String SELECT_SQL = "SELECT idEshop,Info,address FROM eshop;";
    private static final Logger LOGGER = Logger.getLogger(ShopDaoImpl.class);

    private static final String KOLOM_ESHOPID = "idEshop";
    private static final String KOLOM_INFO = "info";
    private static final String KOLOM_ADDRESS = "address";

    private List<Shop> shops;

    @Override
    public List<Shop> listAllShops() {
        addToList(SELECT_SQL);
        return shops;
    }

    public void addShop(Shop shop) {

        String sql = "INSERT INTO eshop (idEshop, info, address) VALUES(?,?,?);";

        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, shop.getShopId());
            stmt.setString(2, shop.getInfo());
            stmt.setString(3, shop.getAddress());

            int result = stmt.executeUpdate();

            LOGGER.debug(result + " added a new e-shop to e-shops");

        } catch (SQLException e) {
            LOGGER.error("Could nog connect to database: " + e);
        }
    }

    private Connection getConnection() throws SQLException {
        Properties prop = new Properties();
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            prop.load(classloader.getResourceAsStream("src/main/later/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(prop.getProperty("jdbc.url"), prop.getProperty("jdbc.user"),
                prop.getProperty("jdbc.password"));
    }

    private void addToList(String sql) {

        shops = new ArrayList<>();

        try (Connection con = getConnection(); Statement stmt = con.createStatement()) {

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int shopId = rs.getInt(KOLOM_ESHOPID);
                String info = rs.getString(KOLOM_INFO);
                String address = rs.getString(KOLOM_ADDRESS);

                shops.add(new Shop(shopId, info, address));
            }

        } catch (SQLException e) {
            LOGGER.error("Could nog connect to database: " + e);
        }
    }
}
