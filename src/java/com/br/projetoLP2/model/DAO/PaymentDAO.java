package com.br.projetoLP2.model.DAO;

import com.br.projetoLP2.model.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor Messina TIA: 31449530, Leticia Garcia TIA: 31402836 , Filippi Di Pipi TIA: 31438938
 */
public class PaymentDAO implements GenericDAO<Payment> {

    private Connection conn;

    public PaymentDAO() {
        conn = ConnectionDB.getInstance();
    }

    @Override
    public boolean insert(Payment payment) {
        boolean resp = false;

        String sql = "insert into Payment_ (numberCard,total,paymentDate,status) values (?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, payment.getNumberCard());
            ps.setDouble(2, payment.getTotal());
            java.sql.Date sqlDate = new java.sql.Date(payment.getPaymentDate().getTime());
            ps.setDate(3,sqlDate);
            ps.setString(4, payment.getStatus());

            int resposta = ps.executeUpdate();

            if (resposta == 0) {
                System.out.println("Não foi possivel criar o pagamneto");
            } else {
                System.out.println(" Pagamento registrado");
                resp = true;
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public List<Payment> read() {
        List<Payment> payments = new ArrayList<>();

        String sql = "select * from Payment_";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Payment payment = new Payment();
                
                payment.setId_payment(rs.getInt("id_Payment")); // parametro da tabela do DB
                payment.setNumberCard(rs.getString("numberCard")); // parametro da tabela do DB
                payment.setTotal(rs.getDouble("total"));
                payment.setPaymentDate(rs.getDate("paymentDate"));
                payment.setStatus(rs.getString("status"));
                
                payments.add(payment);
            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return payments;
    }
    public Payment readByID(int idPayment) {
        Payment payment = new Payment();

        String sql = "select * from Payment_ where id_Payment=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, idPayment);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                payment.setId_payment(rs.getInt("id_Payment")); // parametro da tabela do DB
                payment.setNumberCard(rs.getString("numberCard")); // parametro da tabela do DB
                payment.setTotal(rs.getDouble("total"));
                payment.setPaymentDate(rs.getDate("paymentDate"));
                payment.setStatus(rs.getString("status"));
            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return payment;
    }

    @Override
    public boolean update(Payment payment) {
        boolean resp = false;

        String sql = "update Payment_ set numberCard=?,total=?,paymentDate=?,status=? where id_Payment=?";

        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, payment.getNumberCard());
            ps.setDouble(2, payment.getTotal());
            ps.setDate(3, new java.sql.Date(payment.getPaymentDate().getTime()));
            ps.setString(4, payment.getStatus());
            ps.setInt(5, payment.getId_payment());

            int resposta = ps.executeUpdate();

            if (resposta == 0) {
                System.out.println("Falha ao atualizar os dados do pagamento");
            } else {
                System.out.println("Dados do pagamento atualizados com sucesso");
                resp = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public boolean delete(Payment payment) {
        boolean resp = false;

        String sql = "delete from Payment_ where id_Payment=?";

        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, payment.getId_payment());
            int resposta = ps.executeUpdate();

            if (resposta == 0) {
                System.out.println("Não foi possivel excluir o pagamento");
            } else {
                System.out.println("Pagamento excluido com sucesso");
                resp = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

}
