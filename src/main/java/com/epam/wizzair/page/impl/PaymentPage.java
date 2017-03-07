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

    @FindBy (xpath = "//div[@class=\"name gutter-bottom\"]/input[@placeholder=\"First name\"]")
    private WebElement billingFirstName;

    @FindBy(xpath = "//div[@class=\"name gutter-bottom\"]/input[@placeholder=\"Last name\"]")
    private WebElement billingLastName;

    @FindBy (xpath = "//div[@class=\"input input--with-icon\"]/input[@placeholder=\"E-mail\"]")
    private WebElement billingEmail;

    @FindBy(css = "[placeholder=\"Street\"")
    private WebElement billingStreet;

    @FindBy(css = "[placeholder=\"City\"")
    private WebElement billingCity;

    @FindBy (css = "[placeholder=\"Phone number\"")
    private WebElement billingPhone;

    @FindBy (css = "[placeholder=\"Postcode\"")
    private WebElement billingPostcode;

    @FindBy (css = "[data-test=\"booking-payment-billing-country\"")
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



    public PaymentPage setFirstName(String firstName) {

        billingFirstName.click();
        billingFirstName.sendKeys(firstName);
        return this;

    }

    public PaymentPage setLastName(String lastName) {
        billingLastName.click();
        billingLastName.sendKeys(lastName);
        return this;
    }

    public PaymentPage setEmail(String mail) {
        billingEmail.click();
        billingEmail.sendKeys(mail);
        return this;
    }

    public PaymentPage setStreet(String street) {
        billingStreet.click();
        billingStreet.sendKeys(street);
        return this;
    }

    public PaymentPage setCity(String city) {

        billingCity.click();
        billingCity.sendKeys(city);
        return this;

    }

    public PaymentPage setPhone(String phone) {

        billingPhone.click();
        billingPhone.sendKeys(phone);
        return this;
    }

    public PaymentPage setPostcode(String postcode) {

        billingPostcode.click();
        billingPostcode.sendKeys(postcode);
        return this;

    }



    public PaymentPage setCardNumber(String number) {

        cardNumber.click();
        cardNumber.sendKeys(number);
        return this;


    }

    public PaymentPage setCardName(String name) {

        cardName.click();
        cardName.sendKeys(name);
        return this;

    }

    public PaymentPage setCardCvv(String cvv) {

        cardCvv.click();
        cardCvv.sendKeys(cvv);
        return this;

    }

    public PaymentPage acceptPolicy() {

        conditionsCheckbox.click();
        return this;

    }


    public PaymentPage chooseCountryFromMenu() {

        Actions builder = new Actions(getDriver());
        builder.moveToElement(menuCountry);
        builder.click(menuCountry).perform();
        builder.moveToElement(country); //this may not work correctly; needs to be scrolled to the element
        builder.click(country).perform();
        return this;

    }

    public PaymentPage chooseCurrency() {

        currency.click();
        return this;

    }

    public PaymentPage confirmPayment() {

        confirmPaymentButton.click();
        return this;

    }










}
