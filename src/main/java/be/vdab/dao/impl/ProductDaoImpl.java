package be.vdab.dao.impl;

import be.vdab.dao.ProductDao;
import be.vdab.entiteiten.Product;
import com.google.common.collect.Lists;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProductDaoImpl implements ProductDao {

    private static final String SELECT_SQL = "SELECT idProduct,name,price,stock FROM product;";
    private static final Logger LOGGER = Logger.getLogger(ProductDaoImpl.class);

    private static final String KOLOM_IDPRODUCT = "idProduct";
    private static final String KOLOM_NAME = "name";
    private static final String KOLOM_PRICE = "price";
    private static final String KOLOM_STOCK = "stock";
    private List<Product> products;

    public ProductDaoImpl() {
        products = Lists.newArrayList();
    }

    @Override
    public List<Product> findProducts(String productname) {
        addToList(SELECT_SQL + " WHERE name = '" + productname + "';");
        return products;
    }

    @Override
    public void deleteProduct(Product product) {
        String sql = "DELETE product (idProduct,name,price,stock) VALUES(?,?,?,?);";

        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, product.getProductId());
            stmt.setString(2, product.getProductname());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getStock());

            int result = stmt.executeUpdate();

            LOGGER.debug(result + " deleted a product from products");

        } catch (SQLException e) {
            LOGGER.error("Could nog connect to database: " + e);
        }
    }

    @Override
    public void updateProduct(Product product) {
        String sql = "INSERT INTO product (idProduct,name,price,stock) VALUES(?,?,?,?);";

        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, product.getProductId());
            stmt.setString(2, product.getProductname());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getStock());

            int result = stmt.executeUpdate();

            LOGGER.debug(result + " updated a product from products");

        } catch (SQLException e) {
            LOGGER.error("Could nog connect to database: " + e);
        }
    }

    public void addProduct(Product product) {

        String sql = "INSERT INTO product (idProduct,name,price,stock) VALUES(?,?,?,?);";

        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, product.getProductId());
            stmt.setString(2, product.getProductname());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getStock());

            int result = stmt.executeUpdate();

            LOGGER.debug(result + " added a new product to products");

        } catch (SQLException e) {
            LOGGER.error("Could nog connect to database: " + e);
        }
    }

    private Connection getConnection() throws SQLException {
        Properties prop = new Properties();
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            prop.load(classloader.getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(prop.getProperty("jdbc.url"),
                prop.getProperty("jdbc.user"), prop.getProperty("jdbc.password"));
    }

    private void addToList(String sql) {

        products = new ArrayList<>();

        try (Connection con = getConnection(); Statement stmt = con.createStatement()) {

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int productId = rs.getInt(KOLOM_IDPRODUCT);
                String productname = rs.getString(KOLOM_NAME);
                double price = rs.getDouble(KOLOM_PRICE);
                int stock = rs.getInt(KOLOM_STOCK);

                products.add(new Product(productId, productname, price, stock));
            }

        } catch (SQLException e) {
            LOGGER.error("Could nog connect to database: " + e);
        }
    }
}
