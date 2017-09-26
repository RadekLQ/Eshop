package be.vdab.dao.impl;

import be.vdab.dao.BasketDao;
import be.vdab.entiteiten.Basket;
import be.vdab.entiteiten.Product;
import com.google.common.collect.Lists;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class BasketDaoImpl implements BasketDao {

    private static final String SELECT_SQL = "SELECT idProduct,name,price,stock FROM product;";
    private static final Logger LOGGER = Logger.getLogger(BasketDaoImpl.class);

    private static final String KOLOM_IDPRODUCT = "productId";
    private static final String KOLOM_NAME = "name";
    private static final String KOLOM_PRICE = "price";
    private static final String KOLOM_STOCK = "stock";

    private List<Product> producten;

    public BasketDaoImpl() {
        producten = Lists.newArrayList();
    }



    @Override
    public void saveOrUpdateBasket(Basket basket) {
        producten.addAll(producten);
    }

    @Override
    public void addProductToBasket(Product product) {
        String sql = "INSERT INTO product (productId, name, price, stock) VALUES(?,?,?,?);";

        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, product.getProductId());
            stmt.setString(2, product.getProductname());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getStock());

            int result = stmt.executeUpdate();

            LOGGER.debug(result + " product added to basket");

        } catch (SQLException e) {
            LOGGER.error("Could nog connect to database: " + e);
        }
    }

    @Override
    public void removeProductFromBasket(Product product) {
        String sql = "DELETE product (productId, name, price, stock) VALUES(?,?,?,?);";

        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, product.getProductId());
            stmt.setString(2, product.getProductname());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getStock());

            int result = stmt.executeUpdate();

            LOGGER.debug(result + " product added to basket");

        } catch (SQLException e) {
            LOGGER.error("Could nog connect to database: " + e);
        }
    }

    @Override
    public Basket getBasket() {
        addToList(SELECT_SQL);
        return null;
    }

    public List<Product> listOfAllItemsInBasket() {
        addToList(SELECT_SQL);
        return producten;
    }

    @Override
    public void clearBasket() {
        addToList(SELECT_SQL + "");
    }

    private Connection getConnection() throws SQLException {
        Properties prop = new Properties();
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            prop.load(classloader.getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(prop.getProperty("jdbc.url"), prop.getProperty("jdbc.user"), prop.getProperty("jdbc.password"));
    }

    private void addToList(String sql) {

        producten = new ArrayList<>();

        try (Connection con = getConnection(); Statement stmt = con.createStatement()) {

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int ProductId = rs.getInt(KOLOM_IDPRODUCT);
                String name = rs.getString(KOLOM_NAME);
                double price = rs.getDouble(KOLOM_PRICE);
                int stock = rs.getInt(KOLOM_STOCK);

                producten.add(new Product(ProductId, name, price, stock));
            }

        } catch (SQLException e) {
            LOGGER.error("Could nog connect to database: " + e);
        }
    }


}
