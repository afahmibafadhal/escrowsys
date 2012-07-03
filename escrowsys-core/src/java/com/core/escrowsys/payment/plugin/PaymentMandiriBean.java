/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core.escrowsys.payment.plugin;

import com.core.escrowsys.helper.TransactionHelper;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kuuga
 */
@Stateless
public class PaymentMandiriBean implements PaymentMandiriLocal {

    @PersistenceContext(unitName = "ESCROWSYS")
    protected EntityManager em;

    @Resource
    SessionContext context;

    public TransactionHelper doInitPayment(TransactionHelper transHelper) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public TransactionHelper doPayment(TransactionHelper transHelper) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public TransactionHelper doReversal(TransactionHelper transHelper) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public TransactionHelper doInquiry(TransactionHelper transHelper) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public TransactionHelper doSettlement(TransactionHelper transHelper) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
 
}
