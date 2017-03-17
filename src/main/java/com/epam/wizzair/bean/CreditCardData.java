package com.epam.wizzair.bean;

import java.util.Currency;
import java.util.Date;

/**
 * Created by Dzmitry_Sankouski on 13-Mar-17.
 */
public class CreditCardData {

    String cardNumber;
    String cardHolder;
    int secCode;
    Date expireDate;
    Currency currency;

    public CreditCardData() {

    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public int getSecCode() {
        return secCode;
    }

    public void setSecCode(int secCode) {
        this.secCode = secCode;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "CreditCardData{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardHolder='" + cardHolder + '\'' +
                ", secCode=" + secCode +
                ", expireDate=" + expireDate +
                ", currency=" + currency +
                '}';
    }
}
