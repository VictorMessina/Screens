package com.br.projetoLP2.business;

import com.br.projetoLP2.model.Access;
import com.br.projetoLP2.model.Account;
import com.br.projetoLP2.model.DAO.AccessDAO;
import com.br.projetoLP2.model.DAO.AccountDAO;
import com.br.projetoLP2.model.DAO.PaymentDAO;
import com.br.projetoLP2.model.DAO.UserDAO;
import com.br.projetoLP2.model.Payment;
import com.br.projetoLP2.model.User;
import java.util.Date;

/**
 *
 * @author Victor Messina TIA: 31449530, Leticia Garcia TIA: 31402836 , Filippi Di Pipi TIA: 31438938
 */
public class UserManager {

    public static int insert(User user) {
        UserDAO userDAO = new UserDAO();

        if (userDAO.readByOwner(user.getOwner()).getId_User() != -1) {
            System.out.println("ERROR: Owner already exist");
            return -3;
        } else {
            boolean inserted = userDAO.insert(user);
            if (inserted) {
                System.out.println("User " + user.getOwner() + " inserted ");
                return 1;
            }
        }
        return -5;
    }

    public static boolean validaCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais 
        if (CPF.equals("00000000000") || CPF.equals("11111111111")
                || CPF.equals("22222222222")
                || CPF.equals("33333333333")
                || CPF.equals("44444444444")
                || CPF.equals("55555555555")
                || CPF.equals("66666666666")
                || CPF.equals("77777777777")
                || CPF.equals("88888888888")
                || CPF.equals("99999999999")
                || (CPF.length() != 11) || (CPF.isEmpty())) {
            return false;
        } else {
            return true;
        }
    }

    public static int deleteUser(int idUser) {
        if (idUser < 0) {
            return -50;
        }

        AccessDAO accessDAO = new AccessDAO();
        UserDAO userDAO = new UserDAO();
        AccountDAO accountDAO = new AccountDAO();
        PaymentDAO paymentDAO = new PaymentDAO();

        Access access = accessDAO.readByID(idUser);

        Account account = access.getAccount();

        Payment payment = access.getPayment();

        User user = access.getUser();

        boolean delete = accountDAO.delete(account);
        boolean delete1 = paymentDAO.delete(payment);
        boolean delete2 = accessDAO.delete(access);
        boolean delete3 = userDAO.delete(user);

        if (!delete) {
            System.out.println("delete falhou");
            return -10;
        } else if (!delete1) {
            System.out.println("delete 1 falhou");
            return -20;
        } else if (!delete2) {
            System.out.println("delete 2 falhou");
            return -30;
        } else if (!delete3) {
            System.out.println("delete 3 falhou");
            return -40;
        } else {
            System.out.println("User " + access.getUser().getOwner() + " deleted");
            return 1;
        }
    }

    public static int updateOwner(int idUser, String owner) {
        UserDAO userDAO = new UserDAO();

        User user = userDAO.readByID(idUser);

        if (user != null) {
            user.setOwner(owner);
            boolean updateOwner = userDAO.update(user);
            if (updateOwner) {
                System.out.println("Owner updated");
                return 1;
            }
        }
        return -5;
    }

    public static int updateEmail(int idUser, String email) {
        UserDAO userDAO = new UserDAO();

        User user = userDAO.readByID(idUser);

        if (user != null) {
            user.setEmail(email);
            boolean updateEmail = userDAO.update(user);
            if (updateEmail) {
                System.out.println("Email updated");
                return 1;
            }
        }
        return -5;
    }

    public static int updateCPF(int idUser, String cpf) {
        UserDAO userDAO = new UserDAO();

        User user = userDAO.readByID(idUser);

        if (user != null) {

            if (validaCPF(cpf)) {
                user.setCpf(cpf);
                boolean updateCPF = userDAO.update(user);
                if (updateCPF) {
                    System.out.println("CPF updated");
                    return 1;
                }
            }
        }
        return -5;
    }

    public static int updateDate(int idUser, Date bday) {
        UserDAO userDAO = new UserDAO();

        User user = userDAO.readByID(idUser);

        if (user != null) {
            user.setBday(bday);
            boolean updateDate = userDAO.update(user);

            if (updateDate) {
                System.out.println("Date updated");
                return 1;
            }
        }
        return -5;
    }

    public static int updateUserType(int idUser, int userType) {
        UserDAO userDAO = new UserDAO();

        User user = userDAO.readByID(idUser);

        if (user != null) {
            user.setUserType(userType);
            boolean updateUserType = userDAO.update(user);

            if (updateUserType) {
                System.out.println("UserType updated");
                return 1;
            }
        }
        return -5;
    }
}
