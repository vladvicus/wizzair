package com.epam.wizzair.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//form[@name='login-form']//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//form[@name='login-form']//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//form[@name='login-form']//button[@type='submit']")
    private WebElement submitSingInButton;

    public MainPage login(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submitSingInButton.click();
        return new MainPage();
    }

}
