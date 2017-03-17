package com.epam.wizzair.bean;

/**
 * Created by Dzmitry_Sankouski on 13-Mar-17.
 */
public class BillingDetailsPersonal {
    String firstName;
    String secondName;
    String email;
    String address;
    String city;
    String phone;
    String postIndex;
    String countryIndex;
    String country;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(String postIndex) {
        this.postIndex = postIndex;
    }

    public String getCountryIndex() {return countryIndex;}

    public void setCountryIndex(String countryIndex) {this.countryIndex = countryIndex;}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "BillingDetailsPersonal{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", postIndex='" + postIndex + '\'' +
                ", countryIndex='" + countryIndex + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
