/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;


import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;

import com.paypal.base.rest.PayPalRESTException;
import dto.BillDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author buikh
 */
public class PaymentService {
    private static final String CLIENT_ID = "Ae5b6RWMBfAMDlSIuLzrAR4ZgQM9sIZTG-k-Ry8eazD-ZwhKwnK2h3pLHUkT-eyBYnTpV8vTQ2TrSZ5J";
    private static final String CLIENT_SECRET = "EANaIu8RGRRoUmswQ4hCr0YHv0JglxcwfoyT52mcjIFLuRewq9f2DvjPkiCChsnsM4TQEWIc3X-J9OVd";
    private static final String MODE = "sandbox";
    
    public String authorizePayment(BillDTO bill) throws PayPalRESTException{
        Payer payer = getPayerInformation();
        RedirectUrls redirectUrls =  getRedirectURLs();
        List<Transaction> listTransaction = getTransactionInformation(bill);
        
        Payment requestPayement = new Payment();
        requestPayement.setTransactions(listTransaction)
                .setRedirectUrls(redirectUrls)
                .setPayer(payer)
                .setIntent("authorize");
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        Payment approvePayment = requestPayement.create(apiContext);
        
        System.out.println(approvePayment);
        
        return getApprovedLink(approvePayment);
    }
    
    private String getApprovedLink(Payment approvePayment){
        List<Links> links = approvePayment.getLinks();  
        String approvalLink = null;
        
        for (Links link : links) {
            if(link.getRel().equalsIgnoreCase("approval_url")){
                approvalLink = link.getHref();
            }
        }
        
        return approvalLink;
    }
    
    private List<Transaction> getTransactionInformation(BillDTO bill){
        Details detail = new Details();
        detail.setSubtotal(bill.getTotal());
        detail.setTax("0");
        detail.setShipping("0");
        
        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal(bill.getTotal());
        amount.setDetails(detail);
        
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription(bill.getRoomId());
        
        ItemList itemList = new ItemList();
        List<Item> items = new ArrayList<Item>();
        
        Item item = new Item();
        item.setCurrency("USD")
                .setName(" Room no " + bill.getRoomId())
                .setPrice(bill.getTotal())
                .setQuantity("1");
        items.add(item);
        itemList.setItems(items);
        transaction.setItemList(itemList);
        
        List<Transaction> listTransaction = new ArrayList<Transaction>();
        listTransaction.add(transaction);
        
        return listTransaction;
    }
    
    public Payment getPaymentDetails(String paymentId) throws PayPalRESTException{
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        return Payment.get(apiContext, paymentId);
    }
    
    private RedirectUrls getRedirectURLs(){
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:8080/HostelManagementSystem/cancelPayment.jsp");
        redirectUrls.setReturnUrl("http://localhost:8080/HostelManagementSystem/ReviewPaymentController");
        return redirectUrls;
    }
    
    private Payer getPayerInformation(){
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");
        
        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName("Khoi")
                .setLastName("Nguyen")
                .setEmail("nguyenbkse15144@fpt.edu.vn");
        
        payer.setPayerInfo(payerInfo);
        return payer;
    }
}
