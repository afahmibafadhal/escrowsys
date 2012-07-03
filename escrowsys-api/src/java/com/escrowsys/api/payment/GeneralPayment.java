/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.escrowsys.api.payment;

import com.core.escrowsys.helper.TransactionHelper;
import com.helper.escrowsys.log.escrowLog;
import com.helper.escrowsys.request.GeneralPaymentReq;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.owasp.esapi.ESAPI;

/**
 *
 * @author kuuga
 */
public class GeneralPayment extends HttpServlet {

    private String paramMerchantCode="MERCHANTCODE";
    private String paramAmount="AMOUNT";
    private String paramCartDetail="CARTDETAIL";
    private String paramSecretKey="SECRETKEY";
    private String paramPaymentChannel="PAYMENTCHANNEL";
    private String paramInvoiceNo="INVOICENO";
    private String paramMasterMerchantCode="MASTERMERCHANTCODE";
    private String paramPaymentMethod="PAYMENTMETHOD";

    private String merchantCode;
    private String amount;
    private String cartDetail;
    private String secretKey;
    private String paymentChannel;
    private String invoiceNo;
    private String masterMerchantCode;
    private String paymentMethod;
    
    protected escrowLog log=escrowLog.getLogger(getClass().getName());
    protected TransactionHelper transHelper;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ESAPI.httpUtilities().setCurrentHTTP(request, response);
        HttpServletRequest req=ESAPI.httpUtilities().getCurrentRequest();
        HttpServletResponse resp=ESAPI.httpUtilities().getCurrentResponse();
        transHelper=new TransactionHelper();
        transHelper.setGeneralPaymentReq(new GeneralPaymentReq());
        try {
            merchantCode=req.getParameter(paramMerchantCode);
            amount=req.getParameter(paramAmount);
            cartDetail=req.getParameter(paramCartDetail);
            secretKey=req.getParameter(paramSecretKey);
            paymentChannel=req.getParameter(paramPaymentChannel);
            invoiceNo=req.getParameter(paramInvoiceNo);
            masterMerchantCode=req.getParameter(paramMasterMerchantCode);
            paymentMethod=req.getParameter(paramPaymentMethod);

            
            log.info("==========================================================");
            log.info(": : : INCOMING REQUEST FROM MERCHANT FOR PAYMENT:.");
            log.info("==========================================================");
            log.info(": : : MERCHANTCODE                    ["+merchantCode+"]");
            log.info(": : : AMOUNT                          ["+amount+"]");
            log.info(": : : CARTDETAIL                      ["+cartDetail+"]");
            log.info(": : : SECRETKEY                       ["+secretKey+"]");
            log.info(": : : PAYMENTCHANNEL                  ["+paymentChannel+"]");
            log.info(": : : INVOICENO                       ["+invoiceNo+"]");
            log.info(": : : MASTERMERCHANTCODE              ["+masterMerchantCode+"]");
            log.info(": : : PAYMENTMETHOD                   ["+paymentMethod+"]");
            log.info("==========================================================");

            if(merchantCode==null||merchantCode.trim().equalsIgnoreCase("")){
                log.info(": : : ERROR, PARAM [%s] null OR empty, PLEASE CHECK",paramMerchantCode);

            }else if(amount==null||amount.trim().equalsIgnoreCase("")){
                log.info(": : : ERROR, PARAM [%s] null OR empty, PLEASE CHECK",paramAmount);

            }else if(cartDetail==null||cartDetail.trim().equalsIgnoreCase("")){
                log.info(": : : ERROR, PARAM [%s] null OR empty, PLEASE CHECK",paramCartDetail);

            }else if(secretKey==null||secretKey.trim().equalsIgnoreCase("")){
                log.info(": : : ERROR, PARAM [%s] null OR empty, PLEASE CHECK",paramSecretKey);

            }else if(paymentChannel==null||paymentChannel.trim().equalsIgnoreCase("")){
                log.info(": : : ERROR, PARAM [%s] null OR empty, PLEASE CHECK",paramPaymentChannel);

            }else if(invoiceNo==null||invoiceNo.trim().equalsIgnoreCase("")){
                log.info(": : : ERROR, PARAM [%s] null OR empty, PLEASE CHECK",paramInvoiceNo);

            }else if(masterMerchantCode==null||masterMerchantCode.trim().equalsIgnoreCase("")){
                log.info(": : : ERROR, PARAM [%s] null OR empty, PLEASE CHECK",paramMasterMerchantCode);

            }else if(paymentMethod==null||paymentMethod.trim().equalsIgnoreCase("")){
                log.info(": : : ERROR, PARAM [%s] null OR empty, PLEASE CHECK",paramPaymentMethod);

            }else{
                log.info(": : : PARAM COMPLETE, NOW CHECKING ALL THE CODE:.");


            }
            
        }catch(Throwable e){
            e.printStackTrace();
        } finally {
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
