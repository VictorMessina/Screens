package com.br.projetoLP2.model.DAO;

import com.br.projetoLP2.model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 31402836
 */
public class OrderDAO implements GenericDAO<Order> {

    private Connection conn;

    public OrderDAO() {
        conn = ConnectionDB.getInstance();
    }

    @Override
    public boolean insert(Order order) {
        boolean resp = false;

        String sql = "insert into Order_ (dateOrder, status) values (?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, order.getDateOrder());
            ps.setString(2, order.getStatus());

            int resposta = ps.executeUpdate();

            if (resposta == 0) {
                System.out.println("Não foi possivel registar seu pedido");
            } else {
                System.out.println("Pedido registrado com sucesso");
                resp = true;
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public List<Order> read() {
        List<Order> orders = new ArrayList<>();

        String sql = "select * from Order_";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id_Order = rs.getInt("id_Order");
                String dataOrder = rs.getString("dateOrder");
                String status = rs.getString("status");
                Order order = new Order(id_Order, dataOrder, status);
                orders.add(order);
            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return orders;
    }

    @Override
    public boolean update(Order order) {
        boolean resp = false;

        String sql = "update Order_ set dateOrder=?,status=? where id_Order=?";

        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, order.getDateOrder());
            ps.setString(2, order.getStatus());
            ps.setInt(3, order.getId_Order());

            int resposta = ps.executeUpdate();

            if (resposta == 0) {
                System.out.println("Falha ao atualizar o pedido");
            } else {
                System.out.println("Pedido atualizado com sucesso");
                resp = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public boolean delete(Order order) {
        boolean resp = false;

        String sql = "delete from Order_ where id_Order=?";

        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, order.getId_Order());
            int resposta = ps.executeUpdate();

            if (resposta == 0) {
                System.out.println("Não foi possivel excluir o pedido");
            } else {
                System.out.println("Pedido excluido com sucesso");
                resp = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

}
