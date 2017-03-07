package com.epam.wizzair.page.impl;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.epam.wizzair.driver.DriverSingleton.getDriver;

public class PaymentPage extends AbstractPage {


    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {

    }

    @FindBy (css = "[class=\"input first valid dirty modified touched\"")
    private WebElement billingFirstName;

    @FindBy(css = "[class=\"input last valid dirty modified touched\"")
    private WebElement billingLastName;

    @FindBy (css = "[class=\"input valid dirty modified touched\"")
    private WebElement billingEmail;

    @FindBy(css = "[data-test=\"booking-payment-billing-address\"")
    private WebElement billingStreet;

    @FindBy(css = "[data-test=\"booking-payment-billing-city\"")
    private WebElement billingCity;

    @FindBy (css = "[data-test=\"booking-payment-billing-phone\"")
    private WebElement billingPhone;

    @FindBy (css = "[data-test=\"booking-payment-billing-zipcode\"")
    private WebElement billingPostcode;

    @FindBy (css = "[class=\"dropdown__select invalid pristine touched\"")
    private WebElement menuCountry;

    @FindBy (xpath="//option[contains(@value, 'BY') and text() = 'Belarus']")
    private WebElement country;

    @FindBy (id = "booking-payment-cardnumber")
    private WebElement cardNumber;

    @FindBy (id = "booking-payment-cardholdername")
    private WebElement cardName;

    @FindBy (id = "booking-payment-cardcvv")
    private WebElement cardCvv;

    @FindBy (css = "span[for=\"general-conditions-checkbox\"]")
    private WebElement conditionsCheckbox;

    @FindBy (css = "[for=\"payment-currency\"")
    private WebElement currency;

    @FindBy (id = "payment-continue-btn")
    private WebElement confirmPaymentButton;



    public void setFirstName(String firstName) {

        billingFirstName.click();
        billingFirstName.sendKeys(firstName);

    }

    public void setLastName(String lastName) {
        billingLastName.click();
        billingLastName.sendKeys(lastName);
    }

    public void setEmail(String mail) {
        billingEmail.click();
        billingEmail.sendKeys(mail);
    }

    public void setStreet(String street) {
        billingStreet.click();
        billingStreet.sendKeys(street);
    }

    public void setCity(String city) {

        billingCity.click();
        billingCity.sendKeys(city);

    }

    public void setPhone(String phone) {

        billingPhone.click();
        billingPhone.sendKeys(phone);
    }

    public void setPostcode(String postcode) {

        billingPostcode.click();
        billingPostcode.sendKeys(postcode);

    }



    public void setCardNumber(String number) {

        cardNumber.click();
        cardNumber.sendKeys(number);


    }

    public void setCardName(String name) {

        cardName.click();
        cardName.sendKeys(name);

    }

    public void setCardCvv(String cvv) {

        cardCvv.click();
        cardCvv.sendKeys(cvv);

    }

    public void acceptPolicy() {

        conditionsCheckbox.click();

    }


    public void chooseCountryFromMenu() {

        Actions builder = new Actions(getDriver());
        builder.moveToElement(menuCountry);
        builder.moveToElement(country);
        builder.click(country).perform();

    }

    public void chooseCurrency() {

        currency.click();

    }

    public void confirmPayment() {

        confirmPaymentButton.click();

    }










}
