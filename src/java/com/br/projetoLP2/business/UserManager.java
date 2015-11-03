package com.br.projetoLP2.business;

import com.br.projetoLP2.model.DAO.UserDAO;
import com.br.projetoLP2.model.User;

/**
 *
 * @author 31449530
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
    
    public static boolean validaCPF(String CPF){
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
        }
        else{
            return true;
        }
    }
}