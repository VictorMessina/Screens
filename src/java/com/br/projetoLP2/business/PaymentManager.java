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
 * @author 31449530
 */
public class PaymentManager {
    
     public static int insert(Payment payment) {
        PaymentDAO paymentDAO = new PaymentDAO();
       
        boolean inserted = paymentDAO.insert(payment);

        if (inserted) {
            System.out.println("Account " + payment.getId_payment()+ " inserted ");
            return 1;
        }
        return -5;
    }
    
}
