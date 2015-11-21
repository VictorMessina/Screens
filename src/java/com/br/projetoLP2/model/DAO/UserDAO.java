package com.br.projetoLP2.model.DAO;


import com.br.projetoLP2.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor Messina TIA: 31449530, Leticia Garcia TIA: 31402836 , Filippi Di Pipi TIA: 31438938
 */
public class UserDAO implements GenericDAO<User> {

    private Connection conn;

    public UserDAO() {
        conn = ConnectionDB.getInstance();
    }

    @Override
    public boolean insert(User user){
        boolean resp = false;

        String sql = "insert into User_ (owner,email,cpf,bday,userType) values (?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getOwner());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCpf());
            java.sql.Date sqlDate = new java.sql.Date(user.getBday().getTime());
            ps.setDate(4,sqlDate);
            ps.setInt(5, user.getUserType());

            int resposta = ps.executeUpdate();

            if (resposta == 0) {
                System.out.println("Não foi possivel registar sua conta");
            } else {
                System.out.println("Registrado com sucesso");
                resp = true;
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    @Override
    public List<User> read() {
        List<User> users = new ArrayList<>();

        String sql = "select * from USER_";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                
                user.setId_User(rs.getInt("id_user")); // parametro da tabela do DB
                user.setOwner(rs.getString("owner")); // parametro da tabela do DB
                user.setEmail(rs.getString("email"));
                user.setCpf(rs.getString("cpf"));
                user.setBday(rs.getDate("bday"));
                user.setUserType(rs.getInt("userType"));
                
                users.add(user);
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
                user.setBday(rs.getDate("bday"));
                user.setUserType(rs.getInt("userType"));

            }
            //5-fecha a conexao com o DB e com o PerparedStatement
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    public User readByID(int idUser) {
        User user = new User();
        //2 - criar String SQL
        String sql = "Select * from User_ where id_User=?";
        try {
            //2a - criar o preparedStatement
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idUser);

            //3- executa a query 
            ResultSet rs = ps.executeQuery(); // retorna um objeto do tipo resultSet (grande objeto, 
            // mapa de registros do banco)

            //4 - mostrar os resultados do resutSet
            while (rs.next()) {
                user.setId_User(rs.getInt("id_User"));
                user.setOwner(rs.getString("owner"));
                user.setEmail(rs.getString("email"));
                user.setCpf(rs.getString("cpf"));
                user.setBday(rs.getDate("bday"));
                user.setUserType(rs.getInt("userType"));

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

        String sql = "update User_ set owner=?,email=?,cpf=?,bday=?,userType=? where id_user=?";

        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, user.getOwner());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCpf());
            ps.setDate(4, new java.sql.Date(user.getBday().getTime()));
            ps.setInt(5,user.getUserType());
            ps.setInt(6, user.getId_User());

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