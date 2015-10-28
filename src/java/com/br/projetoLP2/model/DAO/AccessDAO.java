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
public class AccessDAO implements GenericDAO<Access> {

    private Connection conn;

    public AccessDAO() {
        conn = ConnectionDB.getInstance();
    }

    @Override
    public boolean insert(Access access) {
        boolean resp = false;

        String sql = "insert into Access_ (userName,password) values (?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, access.getUserName());
            ps.setString(2, access.getPassword());

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
    public List<Access> read() {
        List<Access> accesslist = new ArrayList<>();
        Access access = new Access();
        String sql = "select*from Access_ inner join User_ on Access_.id_Access = User_.id_User join Account_ on Access_.id_Access = Account_.id_Account";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                access.setId_Access(rs.getInt("id_Access"));
                access.setUserName(rs.getString("username"));
                access.setPassword(rs.getString("password"));
                
                User user = new User();
                
                user.setId_User(rs.getInt("id_user")); // parametro da tabela do DB
                user.setOwner(rs.getString("owner")); // parametro da tabela do DB
                user.setEmail(rs.getString("email"));
                user.setCpf(rs.getString("cpf"));
                user.setBday(rs.getDate("bday"));
                user.setUserType(rs.getInt("userType"));
                
                Account account = new Account();
                
                account.setId_Account(rs.getInt("id_Account"));
                account.setAmount(rs.getDouble("amount"));
                account.setTypes(rs.getString("types"));
                
                access.setUser(user);
                access.setAccount(account);
                
                accesslist.add(access);
            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return accesslist;
    }

    public Access readByUserName(String userName) {
        Access access = new Access();

        String sql = "select*from Access_ inner join User_ on Access_.id_Access = User_.id_User join Account_ on Access_.id_Access = Account_.id_Account where userName=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userName);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                access.setId_Access(rs.getInt("id_Access"));
                access.setUserName(rs.getString("username"));
                access.setPassword(rs.getString("password"));
                
                User user = new User();
                
                user.setId_User(rs.getInt("id_user")); // parametro da tabela do DB
                user.setOwner(rs.getString("owner")); // parametro da tabela do DB
                user.setEmail(rs.getString("email"));
                user.setCpf(rs.getString("cpf"));
                user.setBday(rs.getDate("bday"));
                user.setUserType(rs.getInt("userType"));
                
                Account account = new Account();
                
                account.setId_Account(rs.getInt("id_Account"));
                account.setAmount(rs.getDouble("amount"));
                account.setTypes(rs.getString("types"));
                access.setUser(user);
                access.setAccount(account);
            }

            ps.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return access;
    }

    @Override
    public boolean update(Access access) {
        boolean resp = false;

        String sql = "update Access_ set userName=?,password=? where id_Access=?";

        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, access.getUserName());
            ps.setString(2, access.getPassword());
            ps.setInt(3, access.getId_Access());

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
    public boolean delete(Access access) {
        boolean resp = false;

        String sql = "delete from Access_ where id_Access=?";

        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, access.getId_Access());
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
