package com.br.projetoLP2.business;

import com.br.projetoLP2.model.Access;
import com.br.projetoLP2.model.DAO.AccessDAO;

/**
 *
 * @author Victor Messina TIA: 31449530, Leticia Garcia TIA: 31402836 , Filippi Di Pipi TIA: 31438938
 */
public class AccessManager {

    private static Access access = null;

    public static int insert(Access access, String password2) {
        AccessDAO accessDAO = new AccessDAO();

        if (accessDAO.readByUserName(access.getUserName()).getId_Access() != -1) {
            System.out.println("ERROR: Username already exist");
            return -3;
        }

        if (access.getPassword().equals(password2)) {
            boolean inserted = accessDAO.insert(access);
            if (inserted) {
                System.out.println("User " + access.getUserName() + " inserted ");
                return 1;
            } else {
                System.out.println("ERROR: user not inserted");
                return -5;
            }
        } else {
            System.out.println("ERROR: password doesn't match");
            return -4;
        }
    }

    /**
     *
     * @param userName userName
     * @param password password
     * @return -1-> User not found
     * @return -2-> Wrong password
     * @return 1-> user authorizad
     */
    public static int authorize(String userName, String password) {
        int auth;
        AccessDAO accessDAO = new AccessDAO();
        access = accessDAO.readByUserName(userName);

        if (access.getId_Access() == -1) {
            System.out.println("ERRO: User not found");
            auth = -1;
        } else if (!access.getPassword().equals(password)) {
            System.out.println("ERRO: Wrong password");
            auth = -2;
        } else {
            auth = 1;
        }
        return auth;
    }
    
    public static int updateUserName (int idAccess, String userName){
        
        AccessDAO accessDAO = new AccessDAO();
        Access accesss = accessDAO.readByID(idAccess);
        
        if(accesss!=null){
            accesss.setUserName(userName);
            
            boolean updateUserName = accessDAO.update(accesss);
            
            if(updateUserName){
                System.out.println("userName updated");
                return 1;
            }
        }
        return -5;
    }
    
    public static int updatePassword (int idAccess, String password){
        
        AccessDAO accessDAO = new AccessDAO();
        Access accesss = accessDAO.readByID(idAccess);
        
        if(accesss!=null){
            accesss.setPassword(password);
            
            boolean updatePassword = accessDAO.update(accesss);
            
            if(updatePassword){
                System.out.println("Password updated");
                return 1;
            }
        }
        return -5;
    }
        
    public static Access getAccess() {
        return access;
    }

    public static void setAccess(Access access) {
        AccessManager.access = access;
    }
}