/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.helper.escrowsys.request;

/**
 *
 * @author kuuga
 */
public class GeneralPaymentReq {

    private String merchantCode;
    private String amount;
    private String cartDetail;
    private String secretKey;
    private String paymentChannel;
    private String invoiceNo;
    private String masterMerchantCode;
    private String paymentMethod;

    public GeneralPaymentReq() {
    }

    

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCartDetail() {
        return cartDetail;
    }

    public void setCartDetail(String cartDetail) {
        this.cartDetail = cartDetail;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getMasterMerchantCode() {
        return masterMerchantCode;
    }

    public void setMasterMerchantCode(String masterMerchantCode) {
        this.masterMerchantCode = masterMerchantCode;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }



}
