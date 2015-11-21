package com.br.projetoLP2.business;

import com.br.projetoLP2.model.DAO.AccountDAO;
import com.br.projetoLP2.model.Account;
import com.br.projetoLP2.model.DAO.PaymentDAO;
import com.br.projetoLP2.model.Payment;

/**
 *
 * @author Victor Messina TIA: 31449530, Leticia Garcia TIA: 31402836 , Filippi Di Pipi TIA: 31438938
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
            return result;
        } else {
            result = -1;
        }
        return result;
    }

    public static int updateAccount(int idAccount, String types) {
        AccountDAO accountDAO = new AccountDAO();
        Account account = accountDAO.readByID(idAccount);
        PaymentDAO paymentDAO = new PaymentDAO();
        Payment payment = paymentDAO.readByID(idAccount);

        if (account != null && payment != null) {

            if (types.equals("Diamond")) {
                account.setTypes(types);
                account.setAmount(40);
                payment.setTotal(40.0);
            } else if (types.equals("Gold")) {
                account.setTypes(types);
                account.setAmount(30);
                payment.setTotal(30.0);
                
            } else {
                account.setTypes(types);
                account.setAmount(20);
                payment.setTotal(20.0);
            }
        }

        boolean updateAccount = accountDAO.update(account);
        boolean updateTotal = paymentDAO.update(payment);

        if (updateAccount && updateTotal) {
            System.out.println("Account updated");
            return 1;
        }
        return -5;
    }

}
