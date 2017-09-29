package be.vdab.utilities;

import java.sql.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {

    //JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/eshop";

    //Database credentials
    static final String USER = "root";
    static final String PASS = "Lizak123";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);) {
            System.out.println("Connect to DB OK");
        } catch (Exception ex) {
            System.out.println("Oops, something went wrong!");
            ex.printStackTrace(System.err);
        }
    }
}
