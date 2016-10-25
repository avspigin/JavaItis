package ru.itis.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Span on 23.10.2016.
 */
public class ConnectionFactory {
    private static ConnectionFactory instance;
    private Connection connection;
    private Properties properties;

    private ConnectionFactory(){
        this.properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\Span\\Desktop\\JavaItis\\AutoServlet\\src\\main\\resources\\connection.properties"));
            String URL = properties.getProperty("jdbc.url");
            String login = properties.getProperty("jdbc.login");
            String password = properties.getProperty("jdbc.password");
            String driver = properties.getProperty("jdbc.driver");

            Class.forName(driver);
            connection = DriverManager.getConnection(URL, login, password);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static {
        instance = new ConnectionFactory();
    }

    public static ConnectionFactory getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
