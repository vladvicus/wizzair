package com.epam.wizzair.bean;

/**
 * Created by Dzmitry_Sankouski on 13-Mar-17.
 */
public class BillingDetailsCompany extends BillingDetailsPersonal {
    private String companyName;
    private String companyTaxNumber;

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

    @Override
    public String toString() {
        return "BillingDetailsCompany{" +
                "companyName='" + companyName + '\'' +
                ", companyTaxNumber='" + companyTaxNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        BillingDetailsCompany that = (BillingDetailsCompany) o;

        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        return companyTaxNumber != null ? companyTaxNumber.equals(that.companyTaxNumber) : that.companyTaxNumber == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (companyTaxNumber != null ? companyTaxNumber.hashCode() : 0);
        return result;
    }
}
