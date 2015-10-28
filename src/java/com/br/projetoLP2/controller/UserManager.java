package com.br.projetoLP2.controller;

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
}
