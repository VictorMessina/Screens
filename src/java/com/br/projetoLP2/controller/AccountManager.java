package com.br.projetoLP2.controller;

import com.br.projetoLP2.model.DAO.AccountDAO;
import com.br.projetoLP2.model.Account;

/**
 *
 * @author 31449530
 */
public class AccountManager {

    public static int insert(String types) {
        AccountDAO accountDAO = new AccountDAO();
        Account account;

        if (types.equals("Diamond")) {
            account = new Account(40, types);
        } else if (types.equals("Gold")) {
            account = new Account(30, types);
        } else {
            account = new Account(20, types);
        }

        boolean inserted = accountDAO.insert(account);

        if (inserted) {
            System.out.println("Account " + account.getTypes() + " inserted ");
            return 1;
        }
        return -5;
    }
}
