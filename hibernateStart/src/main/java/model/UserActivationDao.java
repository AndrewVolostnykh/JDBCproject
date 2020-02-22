package model;

public class UserActivationDao {
    private int id;
    private String activationCode;

    private UserDao user;

    public UserActivationDao() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public UserDao getUser() {
        return user;
    }

    public void setUser(UserDao user) {
        this.user = user;
    }
}
