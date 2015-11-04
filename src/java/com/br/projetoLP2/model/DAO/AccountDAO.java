package com.br.projetoLP2.model.DAO;

import com.br.projetoLP2.model.Account;
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
public class AccountDAO implements GenericDAO<Account> {

    private Connection conn;

    public AccountDAO() {
        conn = ConnectionDB.getInstance();
    }

    @Override
    public boolean insert(Account account) {
        boolean resp = false;

        String sql = "insert into Account_ (amount,types) values (?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, account.getAmount());
            ps.setString(2, account.getTypes());

            int resposta = ps.executeUpdate();

            if (resposta == 0) {
                System.out.println("Não foi possivel registar sua conta");
            } else {
                System.out.println("Conta registrada com sucesso");
                resp = true;
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public List<Account> read() {
        List<Account> accounts = new ArrayList<>();

        String sql = "select * from Account_";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id_Account = rs.getInt("id_Account");
                int amount = rs.getInt("amount");
                String types = rs.getString("types");
                Account account = new Account(id_Account, amount, types);
                accounts.add(account);
            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return accounts;
    }

    @Override
    public boolean update(Account account) {
        boolean resp = false;

        String sql = "update Account_ set amount=?,types=? where id_Account=?";

        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, account.getAmount());
            ps.setString(2, account.getTypes());
            ps.setInt(3, account.getId_Account());

            int resposta = ps.executeUpdate();

            if (resposta == 0) {
                System.out.println("Falha ao atualizar os dados da conta");
            } else {
                System.out.println("Dados da conta atualizados com sucesso");
                resp = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public boolean delete(Account account) {
        boolean resp = false;

        String sql = "delete from Account_ where id_Account=?";

        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, account.getId_Account());
            int resposta = ps.executeUpdate();

            if (resposta == 0) {
                System.out.println("Não foi possivel excluir a conta indicada");
            } else {
                System.out.println("Conta excluida com sucesso");
                resp = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }
}