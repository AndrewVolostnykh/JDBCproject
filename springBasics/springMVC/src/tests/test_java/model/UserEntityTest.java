package test_java.model;

import application.model.Entities.User;
import application.model.UserDao;
import org.junit.Test;

public class UserEntityTest {

    @Test
    public void persistingTest()
    {
        User user = new User("21312","Volostnykh",3666,"asdqweqweasd","asdaqweqwesd");
        UserDao userDao = new UserDao();

        userDao.persist(user);
    }



}
