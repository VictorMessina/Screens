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
 * @author 31449530
 */
public class PaymentDAO implements GenericDAO<Payment> {

    private Connection conn;

    public PaymentDAO(Connection conn) {
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
            ps.setString(3, payment.getPaymentDate());
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
                int id_Payment = rs.getInt("id_Payment");
                String numberCard = rs.getString("numberCard");
                double total = rs.getDouble("total");
                String paymentDate = rs.getString("paymentDate");
                String status = rs.getString("status");
                Payment payment = new Payment(id_Payment, numberCard, total, paymentDate, status);
                payments.add(payment);
            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return payments;
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
            ps.setString(3, payment.getPaymentDate());
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
