package ru.itis.factory;

import ru.itis.dao.CarsDao;
import ru.itis.dao.OwnersDao;
import ru.itis.services.CarService;
import ru.itis.services.OwnerService;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Properties;

/**
 * Created by Span on 13.10.2016.
 */
public class ServiceFactory {
    private static ServiceFactory instance;
    private Properties properties;
    private OwnerService ownerService;
    private CarService carService;

    private ServiceFactory() {
        this.properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\KFU-user\\Desktop\\JavaItis\\JdbcDao\\src\\main\\resources\\service.properties"));

            Class clazzOwnerService = Class.forName(properties.getProperty("ownerService.class"));
            Constructor constructorOwner = clazzOwnerService.getConstructor(OwnersDao.class);
            ownerService = (OwnerService)constructorOwner.newInstance(DaoFactory.getInstance().getOwnersDao());

            Class clazzCarService = Class.forName(properties.getProperty("carService.class"));
            Constructor constructorCar = clazzCarService.getConstructor(CarsDao.class);
            carService = (CarService)constructorCar.newInstance(DaoFactory.getInstance().getCarsDao());

        } catch (Exception e) {
            System.out.println("File not found!");
            throw new IllegalArgumentException();
        }

    }
    static {
        instance = new ServiceFactory();
    }

    public static ServiceFactory getInstance(){
        return instance;
    }

    public OwnerService getOwnersService(){
        return ownerService;
    }

    public CarService getCarService(){
        return carService;
    }

}
