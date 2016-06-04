package com.eclinic;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {

    private static Connection connection;

    private DbConnection() {
    }

    public static Connection getConnection() {
        if (connection != null){
            return connection;
        }
        try {
            Properties prop = new Properties();
            InputStream inputStream = new FileInputStream("src/main/resources/db.properties");
            prop.load(inputStream);
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
