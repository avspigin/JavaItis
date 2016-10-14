package ru.itis.factory;

import ru.itis.dao.CarsDao;
import ru.itis.dao.OwnersDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by KFU-user on 12.10.2016.
 */
public class DaoFactory {

    private static DaoFactory instance;
    private CarsDao carsDao;
    private OwnersDao ownersDao;
    private Properties properties;

    private DaoFactory() {
        this.properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\KFU-user\\Desktop\\JavaItis\\JdbcDao\\src\\main\\resources\\dao.properties"));

            Class classOwners = Class.forName(properties.getProperty("ownersDao.class"));
            Constructor constructorOwners = classOwners.getConstructor(Connection.class);
            ownersDao = (OwnersDao) constructorOwners.newInstance(ConnectionFactory.getInstance().getConnection());

            Class classCars = Class.forName(properties.getProperty("carsDao.class"));
            Constructor constructorCars = classCars.getConstructor(Connection.class);
            carsDao = (CarsDao) constructorCars.newInstance(ConnectionFactory.getInstance().getConnection());

        } catch (Exception e) {
            System.out.println("File not found!");
            throw new IllegalArgumentException();
        }

    }

    static {
        instance = new DaoFactory();
    }

    public static DaoFactory getInstance(){
        return instance;
    }

    public OwnersDao getOwnersDao(){
        return this.ownersDao;
    }

    public CarsDao getCarsDao(){
        return this.carsDao;
    }
}
