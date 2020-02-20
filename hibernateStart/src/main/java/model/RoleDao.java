package model;

import java.util.Set;

// class have mapped  in role.cfg.xml
public class RoleDao {
    private Long id;
    private String title;

    private Set<UserDao> users;

    public RoleDao(){ }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<UserDao> getUsers() {
        return users;
    }

    public void setUsers(Set<UserDao> users) {
        this.users = users;
    }
}
