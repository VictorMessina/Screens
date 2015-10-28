package com.br.projetoLP2.model;

import java.io.Serializable;

/**
 *
 * @author 31449530
 */
public class Order implements Serializable {

    private int id_Order;
    private String dateOrder;
    private String status;

    public Order(int id_Order, String dateOrder, String status) {
        this.id_Order = id_Order;
        this.dateOrder = dateOrder;
        this.status = status;
    }

    public Order(String dateOrder, String status) {
        this.dateOrder = dateOrder;
        this.status = status;
    }

    public int getId_Order() {
        return id_Order;
    }

    public void setId_Order(int id_Order) {
        this.id_Order = id_Order;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" + "id_Order=" + id_Order
                + ", dateOrder=" + dateOrder
                + ", status=" + status + '}';
    }
}
