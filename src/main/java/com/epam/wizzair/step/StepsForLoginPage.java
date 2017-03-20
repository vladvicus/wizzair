package com.epam.wizzair.step;


import com.epam.wizzair.bean.Login;
import com.epam.wizzair.page.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StepsForLoginPage {

    private final Logger logger = LogManager.getRootLogger();

    public StepsForMainPage loginWizzAir(Login login)
    {
        LoginPage loginPage = new LoginPage();
//        loginPage.openPage();
//        loginPage.openSignInForm();
        loginPage.login(login.getLogin(), login.getPassword());
        return new StepsForMainPage();
    }

}
