package jm.task.core.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Util {
    private final static String connectionUrl;
    private final static String userName;
    private final static String password;
    private final static String mySQLDriver;

    static {
        Properties properties = loadPropertiesFromFile("db.properties");
        connectionUrl = properties.getProperty("db.url");
        userName = properties.getProperty("db.username");
        password = properties.getProperty("db.password");
        mySQLDriver = properties.getProperty("db.driver");
    }

    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName(mySQLDriver);
        return DriverManager.getConnection(connectionUrl, userName, password);
    }

    public static Properties loadPropertiesFromFile(String pathName) {
        Properties properties = new Properties();
        try (InputStream input = Util.class.getClassLoader().getResourceAsStream(pathName)) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
