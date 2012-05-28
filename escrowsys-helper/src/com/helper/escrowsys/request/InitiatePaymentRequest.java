/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.helper.escrowsys.request;

/**
 *
 * @author kuuga
 */
public class InitiatePaymentRequest {

    private String transactionDate;
    private String merchantCode;
    private String masterMerchantCode;
    private String basket;
    private String paymentChannel;
    private String customerName;
    private String customerCardNo;
    private String customerEmail;
    private String customerCity;
    private String customerRegion;
    private String customerCountry;
    private String customerPhoneNo;
    private String customerPostalCode;
    private String paymentAmount;

    public InitiatePaymentRequest() {
    }

    

    /**
     * @return the transactionDate
     */
    public String getTransactionDate() {
        return transactionDate;
    }

    /**
     * @param transactionDate the transactionDate to set
     */
    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    /**
     * @return the merchantCode
     */
    public String getMerchantCode() {
        return merchantCode;
    }

    /**
     * @param merchantCode the merchantCode to set
     */
    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    /**
     * @return the masterMerchantCode
     */
    public String getMasterMerchantCode() {
        return masterMerchantCode;
    }

    /**
     * @param masterMerchantCode the masterMerchantCode to set
     */
    public void setMasterMerchantCode(String masterMerchantCode) {
        this.masterMerchantCode = masterMerchantCode;
    }

    /**
     * @return the basket
     */
    public String getBasket() {
        return basket;
    }

    /**
     * @param basket the basket to set
     */
    public void setBasket(String basket) {
        this.basket = basket;
    }

    /**
     * @return the paymentChannel
     */
    public String getPaymentChannel() {
        return paymentChannel;
    }

    /**
     * @param paymentChannel the paymentChannel to set
     */
    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the customerCardNo
     */
    public String getCustomerCardNo() {
        return customerCardNo;
    }

    /**
     * @param customerCardNo the customerCardNo to set
     */
    public void setCustomerCardNo(String customerCardNo) {
        this.customerCardNo = customerCardNo;
    }

    /**
     * @return the customerEmail
     */
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * @param customerEmail the customerEmail to set
     */
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    /**
     * @return the customerCity
     */
    public String getCustomerCity() {
        return customerCity;
    }

    /**
     * @param customerCity the customerCity to set
     */
    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    /**
     * @return the customerRegion
     */
    public String getCustomerRegion() {
        return customerRegion;
    }

    /**
     * @param customerRegion the customerRegion to set
     */
    public void setCustomerRegion(String customerRegion) {
        this.customerRegion = customerRegion;
    }

    /**
     * @return the customerCountry
     */
    public String getCustomerCountry() {
        return customerCountry;
    }

    /**
     * @param customerCountry the customerCountry to set
     */
    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    /**
     * @return the customerPhoneNo
     */
    public String getCustomerPhoneNo() {
        return customerPhoneNo;
    }

    /**
     * @param customerPhoneNo the customerPhoneNo to set
     */
    public void setCustomerPhoneNo(String customerPhoneNo) {
        this.customerPhoneNo = customerPhoneNo;
    }

    /**
     * @return the customerPostalCode
     */
    public String getCustomerPostalCode() {
        return customerPostalCode;
    }

    /**
     * @param customerPostalCode the customerPostalCode to set
     */
    public void setCustomerPostalCode(String customerPostalCode) {
        this.customerPostalCode = customerPostalCode;
    }

    /**
     * @return the paymentAmount
     */
    public String getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * @param paymentAmount the paymentAmount to set
     */
    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    



}
