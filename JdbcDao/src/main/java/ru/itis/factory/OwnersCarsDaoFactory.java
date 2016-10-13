package ru.itis.factory;

import ru.itis.dao.CarsDao;
import ru.itis.dao.OwnersDao;

import java.util.Properties;

/**
 * Created by KFU-user on 12.10.2016.
 */
public class OwnersCarsDaoFactory {

    private static OwnersCarsDaoFactory instanse;
    private CarsDao carsDao;
    private OwnersDao ownersDao;
    private Properties properties;

    public OwnersCarsDaoFactory() {
        properties = new Properties();

    }
}
