package model;

import javax.persistence.*;
import java.util.Set;

// Class have mapped in user.cfg.xml
public class UserDao {
    private long id;
    private String name;
    private String surname;
    private int age;

    private RoleDao role;

    private UserActivationDao activation;

    public UserDao(){}

    public UserDao(long id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRole(RoleDao role)
    {
        this.role = role;
    }

    public RoleDao getRole() {
        return role;
    }

    public UserActivationDao getActivation() {
        return activation;
    }

    public void setActivation(UserActivationDao activation) {
        this.activation = activation;
    }

}
