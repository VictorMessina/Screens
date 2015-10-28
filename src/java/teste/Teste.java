package teste;

import com.br.projetoLP2.model.DAO.UserDAO;
import com.br.projetoLP2.model.User;

/**
 *
 * @author 31449530
 */
public class Teste {
    
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        //User user = dao.readByUsername("lucas");
        User user3 = dao.readByOwner("victor");
        
        System.out.println("Nome: " + user3);
    }
    
}
