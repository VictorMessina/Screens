package com.br.projetoLP2.model;

import java.io.Serializable;

/**
 *
 * @author 31449530
 */
public class Account implements Serializable {

    private int id_Account;
    private int amount;
    private String types;

    public Account(int id_Account, int amount, String types) {
        this.id_Account = id_Account;
        this.amount = amount;
        this.types = types;
    }

    public Account(int amount, String types) {
        this.id_Account = -1;
        this.amount = amount;
        this.types = types;
    }

    public Account() {
        this.id_Account = -1;
        this.amount = -1;
        this.types = "not type";
    }

    public int getId_Account() {
        return id_Account;
    }

    public void setId_Account(int id_Account) {
        this.id_Account = id_Account;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "Account{" + "id_Account=" + id_Account
                + ", amount=" + amount + '}';
    }
}