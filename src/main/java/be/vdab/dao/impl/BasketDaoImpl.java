package be.vdab.dao.impl;

import be.vdab.dao.BasketDao;
import be.vdab.entiteiten.Basket;
import be.vdab.entiteiten.Product;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;
import java.util.Properties;


public class BasketDaoImpl implements BasketDao {

    private static final String SELECT_SQL = "SELECT idProduct,name,price,stock FROM product;";
    private static final Logger LOGGER = Logger.getLogger(BasketDaoImpl.class);

    private static final String KOLOM_IDPRODUCT = "productId";
    private static final String KOLOM_NAME= "name";
    private static final String KOLOM_PRICE = "price";
    private static final String KOLOM_STOCK = "stock";

    private List<Product> producten;

    public BasketDaoImpl() {
        producten = Lists.newArrayList();
    }

    @Override
    public void addProductToBasket(Product product) {
        String sql = "INSERT INTO product (productId, name, price, stock) VALUES(?,?,?,?);";

        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, product.getProductNummer());
            stmt.setString(2, product.getMerk());
            stmt.setString(3, product.getNaam());
            stmt.setDouble(4, product.getPrijs());
            stmt.setInt(5, product.getVolume());
            stmt.setInt(6, getTypeId(product));

            int result = stmt.executeUpdate();

            LOGGER.debug(result + " toegevoegd aan de tabel product");

        } catch (SQLException e) {
            LOGGER.error("Could nog connect to database: " + e);
        }
    }

    @Override
    public void saveOrUpdateBasket(Basket basket) {
        producten.addAll(producten);
    }



    @Override
    public void removeProductFromBasket(Product product) {
        producten.add(product);
    }

    @Override
    public Basket getBasket() {
        return null;

    }

    @Override
    public void clearBasket() {
        producten.clear();
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
}
