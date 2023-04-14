package com.classmanagement.entity;

public class UserWithName {
    private Integer id;
    private String account;
    private Integer role;
    private String name;

    public UserWithName() {
    }

    public UserWithName(Integer id, String account, Integer role, String name) {
        this.id = id;
        this.account = account;
        this.role = role;
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserWithName{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", role=" + role +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserWithName(User user, String name) {
        this.id = user.getId();
        this.account = user.getAccount();
        this.role = user.getRole();
        this.name = name;
    }
}
