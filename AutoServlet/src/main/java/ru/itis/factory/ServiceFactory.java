package ru.itis.factory;

import ru.itis.dao.CarDao;
import ru.itis.dao.OwnerDao;
import ru.itis.services.CarService;
import ru.itis.services.OwnerService;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * Created by Span on 24.10.2016.
 */
public class ServiceFactory {
    private static ServiceFactory instance;
    private Properties properties;
    private OwnerService ownerService;
    private CarService carService;

    private ServiceFactory(){
        try {

            properties = new Properties();
            properties.load(new FileInputStream("C:\\Users\\Span\\Desktop\\JavaItis\\AutoServlet\\src\\main\\resources\\service.properties"));

            Class clazzOwner = Class.forName(properties.getProperty("ownerService.class"));
            Constructor constructorOwner = clazzOwner.getConstructor(OwnerDao.class);
            ownerService = (OwnerService)constructorOwner.newInstance(DaoFactory.getInstace().getOwnerDao());

            Class clazzCar = Class.forName(properties.getProperty("carService.class"));
            Constructor constructorCar = clazzCar.getConstructor(CarDao.class);
            carService = (CarService)constructorCar.newInstance(DaoFactory.getInstace().getCarDao());

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

    static  {
        instance = new ServiceFactory();
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public OwnerService getOwnerService() {
        return ownerService;
    }

    public CarService getCarService() {
        return carService;
    }
}
