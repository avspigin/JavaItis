package ru.itis;

import ru.itis.dao.UsersDao;
import ru.itis.dao.UsersDaoFileBasedImpl;
import ru.itis.models.User;
import ru.itis.models.UsersSupportFactory;
import ru.itis.service.SimpleUsersService;
import ru.itis.service.SimpleUsersServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
       /* UsersDao usersDao = new UsersDaoFileBasedImpl();


//        System.out.println(usersDao.get(2).getName());
        SimpleUsersService service = new SimpleUsersServiceImpl(usersDao);
        usersDao.get(2);
        User user = new User(5, "Yu", "qqw", 34);
        usersDao.save(user);

        System.out.println(service.isRegistered("Marsel", "qwerty008"));*/

        UsersDao usersDao = UsersSupportFactory.getInstance().getUsersDao();
        SimpleUsersService simpleUsersService = UsersSupportFactory.getInstance().getSimpleUsers();

//        System.out.println(usersDao.get(1).getName());
<<<<<<< HEAD
//        usersDao.save(new User(7, "Lana", "qwer2", 34));
        usersDao.get(7).getName();
        System.out.println(usersDao.get(1).getName());
=======
        usersDao.save(new User(7, "Lana", "qwer2", 34));
//        usersDao.get(7);
>>>>>>> 11d21d7580491eec4dae0f61a91d74d4811c0afa

    }
}
