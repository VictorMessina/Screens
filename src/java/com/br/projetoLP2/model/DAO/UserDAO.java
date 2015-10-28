package com.br.projetoLP2.model.DAO;

import com.br.projetoLP2.model.Access;
import com.br.projetoLP2.model.Account;
import com.br.projetoLP2.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 31449530
 */
public class UserDAO implements GenericDAO<User> {

    private Connection conn;

    public UserDAO() {
        conn = ConnectionDB.getInstance();
    }


    /*public User readByUsername(String username) {
        User user = null;
        //2 - criar String SQL
        String sql = "select * from USER_ inner join Access_ on User_.id_User = ACCESS_.ID_ACCESS join Account_ on USER_.ID_USER = Account_.ID_ACCOUNT WHERE Access_.USERNAME=?";
        try {
            //2a - criar o preparedStatement
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            //3- executa a query 
            ResultSet rs = ps.executeQuery(); // retorna um objeto do tipo resultSet (grande objeto, 
            // mapa de registros do banco)

            //4 - mostrar os resultados do resutSet
            while (rs.next()) {
                int id_User = rs.getInt("id_User");
                String owner = rs.getString("owner");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");

                int id_Access = rs.getInt("id_Access");
                username = rs.getString("username");
                String password = rs.getString("password");

                int id_Account = rs.getInt("id_Account");
                double amount = rs.getDouble("amount");
                String types = rs.getString("types");
                
                user = new User(id_User, owner, email, cpf, new Access(id_Access, username, password), new Account(id_Account, amount, types));

            }
            //5-fecha a conexao com o DB e com o PerparedStatement
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    */
    @Override
    public boolean insert(User user) {
        boolean resp = false;

        String sql = "insert into User_ (owner,email,cpf) values (?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getOwner());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCpf());

            int resposta = ps.executeUpdate();

            if (resposta == 0) {
                System.out.println("Não foi possivel registar sua conta");
            } else {
                System.out.println("Registrado com sucesso");
                resp = true;
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public List<User> read() {
        List<User> users = new ArrayList<>();

        String sql = "select * from USER_ inner join Access_ on User_.id_User = ACCESS_.ID_ACCESS join Account_ on USER_.ID_USER = Account_.ID_ACCOUNT;";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id_User = rs.getInt("id_User");
                String owner = rs.getString("owner");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");

                int id_Access = rs.getInt("id_Access)");
                String username = rs.getString("username");
                String password = rs.getString("password");

                int id_Account = rs.getInt("id_Account");
                double amount = rs.getDouble("amount");
                String types = rs.getString("types");
                User u = new User(id_User, owner, email, cpf, new Access(id_Access, username, password), new Account(id_Account, amount, types));
                users.add(u);
            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    // pra criar usuario novo
    public User readByOwner(String owner) {
        User user = new User();
        //2 - criar String SQL
        String sql = "Select * from User_ where owner=?";
        try {
            //2a - criar o preparedStatement
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, owner);

            //3- executa a query 
            ResultSet rs = ps.executeQuery(); // retorna um objeto do tipo resultSet (grande objeto, 
            // mapa de registros do banco)

            //4 - mostrar os resultados do resutSet
            while (rs.next()) {
                user.setId_User(rs.getInt("id_User"));
                user.setOwner(rs.getString("owner"));
                user.setEmail(rs.getString("email"));
                user.setCpf(rs.getString("cpf"));

            }
            //5-fecha a conexao com o DB e com o PerparedStatement
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean update(User user) {
        boolean resp = false;

        String sql = "update User_ set owner=?,email=?,cpf=? where id_user=?";

        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, user.getOwner());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCpf());
            ps.setInt(4, user.getId_User());

            int resposta = ps.executeUpdate();

            if (resposta == 0) {
                System.out.println("Falha ao atualizar os dados do usuario");
            } else {
                System.out.println("Dados do usuario atualizados com sucesso");
                resp = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public boolean delete(User user) {
        boolean resp = false;

        String sql = "delete from User_ where id_User=?";

        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, user.getId_User());
            int resposta = ps.executeUpdate();

            if (resposta == 0) {
                System.out.println("Não foi possivel excluir o usuario indicado");
            } else {
                System.out.println("Usuario excluido com sucesso");
                resp = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }
}
