package ru.itis.factory;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by KFU-user on 13.10.2016.
 */
public class ConnectionFactory {

    private Properties properties;
    private static ConnectionFactory instance;
    private Connection connection;


    private ConnectionFactory(){
        this.properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\KFU-user\\Desktop\\JavaItis\\JdbcDao\\src\\main\\resources\\connection.properties"));
            String URL = properties.getProperty("jdbc.url");
            String login = properties.getProperty("jdbc.login");
            String password = properties.getProperty("jdbc.password");
            String driver = properties.getProperty("jdbc.driver");

            Class.forName(driver);
            connection = DriverManager.getConnection(URL, login, password);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    static {
        instance = new ConnectionFactory();
    }

    public static ConnectionFactory getInstance(){
        return instance;
    }

    public Connection getConnection(){
        return this.connection;
    }


}
