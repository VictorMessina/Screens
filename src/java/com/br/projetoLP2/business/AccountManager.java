package com.br.projetoLP2.business;

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

         int result = -1;
         
        if (types.equals("Diamond")) {
            result = 40;
        } else if (types.equals("Gold")) {
            result = 30;
            
        } else {
            result = 20;
        }
            account = new Account(result, types);

        boolean inserted = accountDAO.insert(account);
        

        if (inserted) {
            System.out.println("Account " + account.getTypes() + " inserted ");
        }
            return result;
    }
}
