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

    public Access() {
        this.id_Access = -1;
        this.userName = "anonimo";
        this.password = "1234567";
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

    @Override
    public String toString() {
        return "Access{" + "id_Access=" + id_Access
                + ", userName=" + userName
                + ", password=" + password + '}';
    }
}
