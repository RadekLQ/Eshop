package be.vdab.utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class getConnection {

    public static final String URL = "jdbc:mysql://localhost:3306/eshop?useSSL=false";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "Lizak13";

    public static Connection getConnection() throws SQLException {
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

    public static Connection Connection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}

