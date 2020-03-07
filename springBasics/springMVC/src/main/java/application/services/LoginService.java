package application.services;

public class LoginService {
    public static boolean isValid(String login, String password)
    {
        String static_login = "andrew";
        String static_pass = "andrew";

        return login.equals(static_login) & password.equals(static_pass);
    }
}
