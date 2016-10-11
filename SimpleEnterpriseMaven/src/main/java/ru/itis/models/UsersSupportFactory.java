package ru.itis.models;

import ru.itis.dao.UsersDao;
import ru.itis.service.SimpleUsersService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Span on 11.10.2016.
 */
public class UsersSupportFactory {

    private static UsersSupportFactory instance;
    private Properties properties;
    private UsersDao usersDao;

    private SimpleUsersService simpleUsers;


    public UsersSupportFactory() {
        try {
            properties.load(new FileInputStream("C:\\Users\\Span\\Desktop\\JavaItis\\SimpleEnterpriseMaven\\src\\main\\resources\\dao.properties"));
            String userDaoClass = properties.getProperty("usersDao.class");
            String simpleUsersClass = properties.getProperty("simpleUsers.class");

            this.usersDao = (UsersDao) Class.forName(userDaoClass).newInstance();
            this.simpleUsers = (SimpleUsersService) Class.forName(simpleUsersClass).newInstance();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    static {
        instance = new UsersSupportFactory();
    }

    public UsersDao getUsersDao(){
        return usersDao;
    }

    public SimpleUsersService getSimpleUsers(){
        return simpleUsers;
    }

    public static UsersSupportFactory getInstance() {
        return instance;
    }
}
