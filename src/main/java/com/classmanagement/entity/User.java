package com.classmanagement.entity;

public class User {
    private Integer id;
    private String account;
    private String password;
    private Integer role;

    public User(String account, String password, Integer role) {
        this.account = account;
        this.password = password;
        this.role = role;
    }

    public User(Integer id, String account, String password, Integer role) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
