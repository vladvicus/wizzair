package com.epam.wizzair.step;

import com.epam.wizzair.bean.LoginData;
import com.epam.wizzair.page.LoginPage;

public class StepsForLoginPage {

    public StepsForMainPage loginWizzAir(LoginData loginData) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(loginData.getLogin(), loginData.getPassword());
        return new StepsForMainPage();
    }
}
