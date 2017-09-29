package be.vdab.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectDBpropertiesFile {
    public static void main(String[] args) {
        Properties props = new Properties();

        try {
            FileInputStream fis = new FileInputStream("application.properties");
            props.load(fis);
            fis.close();

            //load the Driver Class
            String driver = props.getProperty("jdbc.driver");
            if (driver != null) {
                Class.forName(driver);
            }

            //create the connection now
            String url = props.getProperty("jdbc.url");
            String username = props.getProperty("jdbc.username");
            String password = props.getProperty("jdbc.password");
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Connect to DB OK");
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            System.out.println("Oops, something went wrong!");
            ex.printStackTrace(System.err);
        }
    }
}
