package com.epam.wizzair.bean;

/**
 * Created by Dzmitry_Sankouski on 13-Mar-17.
 */
public class BillingDetailsCompany extends BillingDetailsPersonal {
    String companyName;
    String companyTaxNumber;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyTaxNumber() {
        return companyTaxNumber;
    }

    public void setCompanyTaxNumber(String companyTaxNumber) {
        this.companyTaxNumber = companyTaxNumber;
    }
}
