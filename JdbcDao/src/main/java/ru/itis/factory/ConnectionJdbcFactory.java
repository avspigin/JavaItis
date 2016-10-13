package ru.itis.factory;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by KFU-user on 13.10.2016.
 */
public class ConnectionJdbcFactory {

    private Properties properties;
    private static ConnectionJdbcFactory instanse;
    private Connection connection;


    private ConnectionJdbcFactory(){
        this.properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\KFU-user\\Desktop\\JavaItis\\JdbcDao\\src\\main\\resources\\connection.properties"));
    }

    static {
        instanse = new ConnectionJdbcFactory();
    }


}
