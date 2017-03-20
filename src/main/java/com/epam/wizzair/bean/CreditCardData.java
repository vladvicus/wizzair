package com.epam.wizzair.bean;

import java.util.Currency;
import java.util.Date;

/**
 * Created by Dzmitry_Sankouski on 13-Mar-17.
 */
public class CreditCardData {

    private String cardNumber;
    private String cardHolder;
    private int secCode;
    private Date expireDate;
    private Currency currency;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreditCardData that = (CreditCardData) o;

        if (secCode != that.secCode) return false;
        if (cardNumber != null ? !cardNumber.equals(that.cardNumber) : that.cardNumber != null) return false;
        if (cardHolder != null ? !cardHolder.equals(that.cardHolder) : that.cardHolder != null) return false;
        if (expireDate != null ? !expireDate.equals(that.expireDate) : that.expireDate != null) return false;
        return currency != null ? currency.equals(that.currency) : that.currency == null;
    }

    @Override
    public int hashCode() {
        int result = cardNumber != null ? cardNumber.hashCode() : 0;
        result = 31 * result + (cardHolder != null ? cardHolder.hashCode() : 0);
        result = 31 * result + secCode;
        result = 31 * result + (expireDate != null ? expireDate.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }
}
