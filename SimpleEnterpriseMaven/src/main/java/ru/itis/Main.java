package ru.itis;

import ru.itis.dao.UsersDao;
import ru.itis.dao.UsersDaoFileBasedImpl;
import ru.itis.models.User;
import ru.itis.service.SimpleUsersService;
import ru.itis.service.SimpleUsersServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UsersDao usersDao = new UsersDaoFileBasedImpl("C:\\Users\\Span\\Desktop\\JavaItis" +
                "\\SimpleEnterpriseMaven\\users.txt");


        System.out.println(usersDao.get(2).getName());
        SimpleUsersService service = new SimpleUsersServiceImpl(usersDao);

//        UsersDao user1;
//        user1.save();

        System.out.println(service.isRegistered("Marsel", "qwerty008"));
    }
}
