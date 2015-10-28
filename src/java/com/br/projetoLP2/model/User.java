package com.br.projetoLP2.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 31402836
 */
public class User implements Serializable {

    private int id_User;
    private String owner;
    private String email;
    private String cpf;
    private Date bday;
    private int userType;
    private Access access;
    private Account account;

    public User() {
        this.id_User = -1;
        this.owner = "anonimo";
        this.email = "anonimo@anonimo.com";
        this.cpf = "00000000000";
        this.bday= new Date();
        this.userType= -1;
        this.access = null;
        this.account=null;
    }

    public User(int id_User, String owner, String email, String cpf,Date bday, int userType) {
        this.id_User = id_User;
        this.owner = owner;
        this.email = email;
        this.cpf = cpf;
        this.bday=bday;
        this.userType = userType;
    }

    public User(String owner, String email, String cpf,Date bday,int userType) {
        this.id_User = -1;
        this.owner = owner;
        this.email = email;
        this.cpf = cpf;
        this.bday=bday;
        this.userType=userType;
    }

    public User(int id_User, String owner, String email, String cpf,Date bday,int userType, Access access, Account account) {
        this.id_User = id_User;
        this.owner = owner;
        this.email = email;
        this.cpf = cpf;
        this.bday=bday;
        this.userType=userType;
        this.access = access;
        this.account = account;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBday() {
        return bday;
    }

    public void setBday(Date bday) {
        this.bday = bday;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" + "id_User=" + id_User + ", owner=" + owner + 
                ", email=" + email + ", cpf=" + cpf + 
                ", bday=" + bday + 
                ", userType=" + userType + '}';
    }
}