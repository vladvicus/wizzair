package com.epam.wizzair.step.impl;


import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.page.impl.LoginPage;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StepsForLoginPage {

    private final Logger logger = LogManager.getRootLogger();

    public void loginWizzAir(String email, String password)
    {
        LoginPage loginPage = new LoginPage();
//        loginPage.openPage();
//        loginPage.openSignInForm();
        loginPage.login(email, password);
    }

}
