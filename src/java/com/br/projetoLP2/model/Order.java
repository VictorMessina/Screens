package com.br.projetoLP2.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 31449530
 */
public class Order implements Serializable {

    private int id_Order;
    private Date dateOrder;
    private String status;

    public Order(){
        this.id_Order=-1;
        this.dateOrder = new Date();
        this.status="sem status";
    }
    
    public Order(int id_Order, Date dateOrder, String status) {
        this.id_Order = id_Order;
        this.dateOrder = dateOrder;
        this.status = status;
    }

    public Order(Date dateOrder, String status) {
        this.dateOrder = dateOrder;
        this.status = status;
    }

    public int getId_Order() {
        return id_Order;
    }

    public void setId_Order(int id_Order) {
        this.id_Order = id_Order;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
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
