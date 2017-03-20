package com.epam.wizzair.step;

import com.epam.wizzair.bean.BillingDetailsPersonal;
import com.epam.wizzair.bean.CreditCardData;
import com.epam.wizzair.page.PaymentPage;

/**
 * Created by Dzmitry_Sankouski on 13-Mar-17.
 */
public class StepsForPaymentPage {
    PaymentPage  paymentPage = new PaymentPage();

    public StepsForPaymentPage fillCreditCard(CreditCardData data){
        paymentPage.setCardName(data.getCardHolder())
            .setCardNumber(data.getCardNumber())
            .setCardCvv(String.valueOf(data.getSecCode()))
        ;


        return this;
    }

    public StepsForPaymentPage fillBillingDetails(BillingDetailsPersonal data){

        paymentPage.setFirstName(data.getFirstName())
                .setLastName(data.getSecondName())
                .setEmail(data.getEmail())
                .setStreet(data.getAddress())
                .setCity(data.getCity())
                .setPhone(data.getPhone())
                .setPostcode(data.getPostIndex());

        return  this;

    }

    public void submit(){
        paymentPage.acceptPolicy()
                .confirmPayment();
    }

}
