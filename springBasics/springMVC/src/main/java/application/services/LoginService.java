package application.services;

import application.model.Entities.User;
import application.model.UserDao;

public class LoginService {
    public static User login(String login, String password)
    {
        UserDao userDao = new UserDao();
        User user;
        user = userDao.getUserByLogin(login, password);

        if(user != null)
            if(user.getPassword().equals(password))
                return user;

        return null;
    }
}
