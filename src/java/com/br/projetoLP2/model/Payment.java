package com.br.projetoLP2.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 31402836
 */
public class Payment implements Serializable {

    private int id_payment;
    private String numberCard;
    private double total;
    private Date paymentDate;
    private String status;
    
    public Payment (){
        this.id_payment=-1;
        this.numberCard="xxxxxxxxxxxxxxxx";
        this.total= 0.0;
        this.paymentDate = null;
        this.status = "sem status";
    }

    public Payment(int id_payment, String numberCard, double total, Date paymentDate, String status) {
        this.id_payment = id_payment;
        this.numberCard = numberCard;
        this.total = total;
        this.paymentDate = paymentDate;
        this.status = status;
    }

    public Payment(String numberCard, double total, Date paymentDate, String status) {
        this.numberCard = numberCard;
        this.total = total;
        this.paymentDate = paymentDate;
        this.status = status;
    }

    public int getId_payment() {
        return id_payment;
    }

    public void setId_payment(int id_payment) {
        this.id_payment = id_payment;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double calculaValor() {
        return total;
    }

    @Override
    public String toString() {
        return "Payment{" + "id_payment=" + id_payment
                + ", numberCard=" + numberCard + ", total=" + total
                + ", paymentDate=" + paymentDate + ", status=" + status + '}';
    }
}