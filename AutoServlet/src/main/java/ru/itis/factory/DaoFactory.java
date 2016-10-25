package ru.itis.factory;

import ru.itis.dao.CarDao;
import ru.itis.dao.OwnerDao;
import ru.itis.models.Owners;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by Span on 23.10.2016.
 */
public class DaoFactory {
    private static DaoFactory instace;
    private Properties properties;
    private OwnerDao ownerDao;
    private CarDao carDao;

    private DaoFactory(){
        try {

            properties = new Properties();
            properties.load(new FileInputStream("C:\\Users\\Span\\Desktop\\JavaItis\\AutoServlet\\src\\main\\resources\\dao.properties"));

            Class clazzOwner = Class.forName(properties.getProperty("ownerDao.class"));
            Constructor constructorOwner = clazzOwner.getConstructor(Connection.class);
            ownerDao = (OwnerDao) constructorOwner.newInstance(ConnectionFactory.getInstance().getConnection());

            Class clazzCar = Class.forName(properties.getProperty("carDao.class"));
            Constructor constructorCar = clazzCar.getConstructor(Connection.class);
            carDao = (CarDao) constructorCar.newInstance(ConnectionFactory.getInstance().getConnection());


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    static {
        instace = new DaoFactory();
    }

    public static DaoFactory getInstace() {
        return instace;
    }

    public OwnerDao getOwnerDao() {
        return ownerDao;
    }

    public CarDao getCarDao() {
        return carDao;
    }
}
