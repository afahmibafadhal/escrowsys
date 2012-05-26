/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.escrowsys.db.dto;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author kuuga
 */
@Entity
@Table(name="payment_channel"
    ,schema="public"
)
@SequenceGenerator(name = "seq_payment_channel_id_name", sequenceName = "seq_payment_channel_id", allocationSize = 1)
public class PaymentChannel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_payment_channel_id_name")
    @Column(name="payment_channel_id", unique=true, nullable=false)
    private Long paymentChannelId;
    @Column(name = "payment_channel_name")
    private String paymentChannelName;
    @Column(name = "payment_channel_status")
    private Boolean paymentChannelStatus;
    @Column(name = "payment_channel_jndi_proc")
    private String paymentChannelJndiProc;
    @Column(name = "payment_channel_pg_code")
    private String paymentChannelPgCode;
    @Column(name = "payment_channel_pg_additional_code_1")
    private String paymentChannelPgAdditionalCode1;
    @Column(name = "payment_channel_pg_additional_code_2")
    private String paymentChannelPgAdditionalCode2;
    @Column(name = "payment_channel_pg_additional_code_3")
    private String paymentChannelPgAdditionalCode3;
    @Column(name = "payment_channel_redirect_url_1")
    private String paymentChannelRedirectUrl1;
    @Column(name = "payment_channel_redirect_url_2")
    private String paymentChannelRedirectUrl2;
    @Column(name = "payment_channel_redirect_url_3")
    private String paymentChannelRedirectUrl3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentChannelId", fetch = FetchType.LAZY)
    private Set<PaymentFormula> paymentFormulaCollection;

    public PaymentChannel() {
    }

    public PaymentChannel(Long paymentChannelId) {
        this.paymentChannelId = paymentChannelId;
    }

    public Long getPaymentChannelId() {
        return paymentChannelId;
    }

    public void setPaymentChannelId(Long paymentChannelId) {
        this.paymentChannelId = paymentChannelId;
    }

    public String getPaymentChannelName() {
        return paymentChannelName;
    }

    public void setPaymentChannelName(String paymentChannelName) {
        this.paymentChannelName = paymentChannelName;
    }

    public Boolean getPaymentChannelStatus() {
        return paymentChannelStatus;
    }

    public void setPaymentChannelStatus(Boolean paymentChannelStatus) {
        this.paymentChannelStatus = paymentChannelStatus;
    }

    public String getPaymentChannelJndiProc() {
        return paymentChannelJndiProc;
    }

    public void setPaymentChannelJndiProc(String paymentChannelJndiProc) {
        this.paymentChannelJndiProc = paymentChannelJndiProc;
    }

    public String getPaymentChannelPgCode() {
        return paymentChannelPgCode;
    }

    public void setPaymentChannelPgCode(String paymentChannelPgCode) {
        this.paymentChannelPgCode = paymentChannelPgCode;
    }

    public String getPaymentChannelPgAdditionalCode1() {
        return paymentChannelPgAdditionalCode1;
    }

    public void setPaymentChannelPgAdditionalCode1(String paymentChannelPgAdditionalCode1) {
        this.paymentChannelPgAdditionalCode1 = paymentChannelPgAdditionalCode1;
    }

    public String getPaymentChannelPgAdditionalCode2() {
        return paymentChannelPgAdditionalCode2;
    }

    public void setPaymentChannelPgAdditionalCode2(String paymentChannelPgAdditionalCode2) {
        this.paymentChannelPgAdditionalCode2 = paymentChannelPgAdditionalCode2;
    }

    public String getPaymentChannelPgAdditionalCode3() {
        return paymentChannelPgAdditionalCode3;
    }

    public void setPaymentChannelPgAdditionalCode3(String paymentChannelPgAdditionalCode3) {
        this.paymentChannelPgAdditionalCode3 = paymentChannelPgAdditionalCode3;
    }

    public String getPaymentChannelRedirectUrl1() {
        return paymentChannelRedirectUrl1;
    }

    public void setPaymentChannelRedirectUrl1(String paymentChannelRedirectUrl1) {
        this.paymentChannelRedirectUrl1 = paymentChannelRedirectUrl1;
    }

    public String getPaymentChannelRedirectUrl2() {
        return paymentChannelRedirectUrl2;
    }

    public void setPaymentChannelRedirectUrl2(String paymentChannelRedirectUrl2) {
        this.paymentChannelRedirectUrl2 = paymentChannelRedirectUrl2;
    }

    public String getPaymentChannelRedirectUrl3() {
        return paymentChannelRedirectUrl3;
    }

    public void setPaymentChannelRedirectUrl3(String paymentChannelRedirectUrl3) {
        this.paymentChannelRedirectUrl3 = paymentChannelRedirectUrl3;
    }

    public Set<PaymentFormula> getPaymentFormulaCollection() {
        return paymentFormulaCollection;
    }

    public void setPaymentFormulaCollection(Set<PaymentFormula> paymentFormulaCollection) {
        this.paymentFormulaCollection = paymentFormulaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentChannelId != null ? paymentChannelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentChannel)) {
            return false;
        }
        PaymentChannel other = (PaymentChannel) object;
        if ((this.paymentChannelId == null && other.paymentChannelId != null) || (this.paymentChannelId != null && !this.paymentChannelId.equals(other.paymentChannelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.escrowsys.db.dto.PaymentChannel[paymentChannelId=" + paymentChannelId + "]";
    }

}
