package ru.itis;

import org.junit.Before;
import org.junit.Test;
import ru.itis.dao.UsersDaoFileBasedImpl;
import ru.itis.models.User;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by admin on 06.10.2016.
 */
public class UsersDaoFileBasedImplTest {

    private UsersDaoFileBasedImpl usersDao;

    @Test
    public void get(){
        Boolean expected = "Marsel".equals(usersDao.get(1).getName());
        assertTrue(expected);
    }

    @Test
    public void save(){
        usersDao.save(new User(6, "Ivan", "qwert1", 23));

        Boolean expected = "Ivan".equals(usersDao.get(6).getName());
        assertTrue(expected);
    }

    @Test
    public void delete(){
        usersDao.delete(6);

        Boolean expected = "Ivan".equals(usersDao.get(6).getName());
        assertFalse(expected);
    }


    @Before
    public void setUp() throws Exception {
//        usersDao = new UsersDaoFileBasedImpl("C:\\Users\\Span\\Desktop\\JavaItis\\" +
//                "SimpleEnterpriseMaven\\users.txt");
    }

    @Test
    public void getAll() throws Exception {
        List<User> registeredUsers = usersDao.getAll();
        int i = 0;
    }

}