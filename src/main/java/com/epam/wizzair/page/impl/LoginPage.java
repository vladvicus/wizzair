package com.epam.wizzair.page.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {

    }

    @FindBy(xpath = "//*[@id=\"login-modal\"]/form/div/div/input[@placeholder=\"E-mail\"]")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"login-modal\"]/form/div/div/input[@placeholder=\"Password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(@class, 'button button--medium button--filled') and text() = 'Sign in']")
    private WebElement signIn;

    public LoginPage enterLogin(String login) {

        loginField.click();
        loginField.sendKeys(login);
        return this;

    }

    public LoginPage enterPassword(String password) {

        passwordField.click();
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage submit() {

        signIn.click();
        return this;
    }

    public void waitForLogin() {
        ExpectedConditions.visibilityOf(loginField);
    }


}
