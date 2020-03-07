package test_java.model;

import application.model.Entities.User;
import application.model.UserDao;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class UserEntityTest {

    @Test
    public void persistingTest()
    {
        User user = new User("21312","Volostnykh",3666,"asdqweqweasd","asdaqweqwesd");
        UserDao userDao = new UserDao();

        userDao.persist(user);
    }

    @Test
    public void getUserByLoginTest()
    {
        UserDao userDao = new UserDao();
        User user = userDao.getUserByLogin("qweqweqwe", "qweqweqwe");
        assertNotNull(user);

        System.out.println(user.getAge());
        System.out.println(user.getId());
    }

}
