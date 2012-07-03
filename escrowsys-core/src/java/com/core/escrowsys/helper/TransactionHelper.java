/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core.escrowsys.helper;

import com.escrowsys.db.dto.MasterMerchant;
import com.escrowsys.db.dto.MasterMerchantFormula;
import com.escrowsys.db.dto.PaymentChannel;
import com.escrowsys.db.dto.PaymentFormula;
import com.escrowsys.db.dto.Transactions;
import com.helper.escrowsys.request.GeneralPaymentReq;
import com.helper.escrowsys.request.InitiatePaymentRequest;

/**
 *
 * @author kuuga
 */
public class TransactionHelper {
    private Transactions transactions;
    private PaymentChannel paymentChannel;
    private PaymentFormula paymentFormula;
    private MasterMerchant masterMerchant;
    private MasterMerchantFormula masterMerchantFormula;
    private InitiatePaymentRequest initiatePaymentRequest;
    private GeneralPaymentReq generalPaymentReq;

    public TransactionHelper() {
    }
    

    /**
     * @return the transactions
     */
    public Transactions getTransactions() {
        return transactions;
    }

    /**
     * @param transactions the transactions to set
     */
    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
    }

    /**
     * @return the paymentChannel
     */
    public PaymentChannel getPaymentChannel() {
        return paymentChannel;
    }

    /**
     * @param paymentChannel the paymentChannel to set
     */
    public void setPaymentChannel(PaymentChannel paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    /**
     * @return the paymentFormula
     */
    public PaymentFormula getPaymentFormula() {
        return paymentFormula;
    }

    /**
     * @param paymentFormula the paymentFormula to set
     */
    public void setPaymentFormula(PaymentFormula paymentFormula) {
        this.paymentFormula = paymentFormula;
    }

    /**
     * @return the masterMerchant
     */
    public MasterMerchant getMasterMerchant() {
        return masterMerchant;
    }

    /**
     * @param masterMerchant the masterMerchant to set
     */
    public void setMasterMerchant(MasterMerchant masterMerchant) {
        this.masterMerchant = masterMerchant;
    }

    /**
     * @return the masterMerchantFormula
     */
    public MasterMerchantFormula getMasterMerchantFormula() {
        return masterMerchantFormula;
    }

    /**
     * @param masterMerchantFormula the masterMerchantFormula to set
     */
    public void setMasterMerchantFormula(MasterMerchantFormula masterMerchantFormula) {
        this.masterMerchantFormula = masterMerchantFormula;
    }

    /**
     * @return the initiatePaymentRequest
     */
    public InitiatePaymentRequest getInitiatePaymentRequest() {
        return initiatePaymentRequest;
    }

    /**
     * @param initiatePaymentRequest the initiatePaymentRequest to set
     */
    public void setInitiatePaymentRequest(InitiatePaymentRequest initiatePaymentRequest) {
        this.initiatePaymentRequest = initiatePaymentRequest;
    }

    /**
     * @return the generalPaymentReq
     */
    public GeneralPaymentReq getGeneralPaymentReq() {
        return generalPaymentReq;
    }

    /**
     * @param generalPaymentReq the generalPaymentReq to set
     */
    public void setGeneralPaymentReq(GeneralPaymentReq generalPaymentReq) {
        this.generalPaymentReq = generalPaymentReq;
    }

    

    

    


}
