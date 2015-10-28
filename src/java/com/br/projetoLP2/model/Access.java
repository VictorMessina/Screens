package com.br.projetoLP2.model;

import java.io.Serializable;

/**
 *
 * @author 31449530
 */
public class Access implements Serializable {

    private int id_Access;
    private String userName;
    private String password;
    private User user;
    private Account account;

    public Access() {
        this.id_Access = -1;
        this.userName = "anonimo";
        this.password = "1234567";
        this.account = null;
        this.user = null;
    }

    public Access(int id_Access, String userName, String password) {
        this.id_Access = id_Access;
        this.userName = userName;
        this.password = password;
    }

    public Access(String userName, String password) {
        this.id_Access = -1;
        this.userName = userName;
        this.password = password;
    }

    public int getId_Access() {
        return id_Access;
    }

    public void setId_Access(int id_Access) {
        this.id_Access = id_Access;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Access{" + "id_Access=" + id_Access
                + ", userName=" + userName
                + ", password=" + password + '}';
    }
}
