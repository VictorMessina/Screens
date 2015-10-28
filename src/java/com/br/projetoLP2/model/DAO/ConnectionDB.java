package com.br.projetoLP2.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 31449530
 */
public class ConnectionDB {

    private static String driver = "org.apache.derby.jdbc.ClientDriver";
    private static String protocolo = "jdbc:derby:";
    private static String dominio = "//localhost:1527/";
    private static String db = "projetoLP2_DB";
    private static String userDB = "victor";
    private static String pwd = "123";
    private static Connection conn = null; // faz o link de conexao com o DB

    // metodo de conexao com o banco de dados
    public static Connection getInstance() {
        if (conn == null) {
            try {
                //cria instacia do driver
                Class.forName(driver).newInstance();

                //estabelece conexao
                conn = DriverManager.getConnection(protocolo + dominio + db, userDB, pwd);

            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                ex.printStackTrace();
            }
        }
        return conn;
    }
}
