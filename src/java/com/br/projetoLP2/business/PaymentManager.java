/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projetoLP2.business;

import com.br.projetoLP2.model.DAO.PaymentDAO;
import com.br.projetoLP2.model.Payment;

/**
 *
 * @author Victor Messina TIA: 31449530, Leticia Garcia TIA: 31402836 , Filippi Di Pipi TIA: 31438938
 */
public class PaymentManager {

    public static int insert(Payment payment) {
        PaymentDAO paymentDAO = new PaymentDAO();

        boolean inserted = paymentDAO.insert(payment);

        if (inserted) {
            System.out.println("Payment inserted ");
            return 1;
        }
        return -5;
    }

    public static boolean validaNumberCard(String numberCard) {
        if (numberCard.equals("0000000000000000")
                || numberCard.equals("1111111111111111")
                || numberCard.equals("2222222222222222")
                || numberCard.equals("3333333333333333")
                || numberCard.equals("4444444444444444")
                || numberCard.equals("5555555555555555")
                || numberCard.equals("6666666666666666")
                || numberCard.equals("7777777777777777")
                || numberCard.equals("8888888888888888")
                || numberCard.equals("9999999999999999")
                || numberCard.length() != 16 || numberCard.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public static int updateNumberCard(int idPaymant, String numberCard) {
        PaymentDAO paymentDAO = new PaymentDAO();

        Payment payment = paymentDAO.readByID(idPaymant);

        if (payment != null) {

            if (validaNumberCard(numberCard)) {

                payment.setNumberCard(numberCard);
                boolean updateNumberCard = paymentDAO.update(payment);

                if (updateNumberCard) {
                    System.out.println("NumberCard updated");
                    return 1;
                }
            }
        }
        return -5;
    }

    public static int updateStatus(int idPaymant) {
        PaymentDAO paymentDAO = new PaymentDAO();

        Payment payment = paymentDAO.readByID(idPaymant);
        
        if(payment==null){
            return -5;
        }

        else{
            
            if (payment.getStatus().equals("pago")) {
                payment.setStatus("em aberto");
                boolean updateStatus = paymentDAO.update(payment);

                if (updateStatus) {
                    System.out.println("Status updated");
                    return 1;
                }
            } 
            
            else{
                
                payment.setStatus("pago");
                boolean updateStatus = paymentDAO.update(payment);

                if (updateStatus) {
                    System.out.println("Status updated");
                    return 1;
                }
            }
        }
        return -5;
    }

    public static int updateStatusUser(int idPaymant) {
        PaymentDAO paymentDAO = new PaymentDAO();

        Payment payment = paymentDAO.readByID(idPaymant);
        
        if(payment==null){
            return -5;
        }

        else {
            payment.setStatus("pago");
            boolean updateStatus = paymentDAO.update(payment);

            if (updateStatus) {
                System.out.println("Status updated");
                return 1;
            }
        }
        return -5;
    }
}
