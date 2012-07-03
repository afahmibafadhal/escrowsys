/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core.escrowsys.base;

import com.core.escrowsys.helper.TransactionHelper;

/**
 *
 * @author kuuga
 */
public interface BasePayment {

    public TransactionHelper doInitPayment(TransactionHelper transHelper);
    public TransactionHelper doPayment(TransactionHelper transHelper);
    public TransactionHelper doReversal(TransactionHelper transHelper);
    public TransactionHelper doInquiry(TransactionHelper transHelper);
    public TransactionHelper doSettlement(TransactionHelper transHelper);
    

}
