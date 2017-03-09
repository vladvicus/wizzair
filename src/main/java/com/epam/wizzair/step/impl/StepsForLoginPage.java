package com.epam.steps;

import com.epam.pages.LoginPage;
import com.epam.pages.MainPage;
import com.epam.pages.SelectSeatPage;
import org.openqa.selenium.WebDriver;
import com.epam.driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StepsForLoginPage {

    private WebDriver driver;

    private final Logger logger = LogManager.getRootLogger();

    public void initBrowser()
    {
        driver = DriverSingleton.getDriver();
    }

    public void closeDriver()
    {
        driver.quit();
    }

    public void loginWizzAir(String email, String password)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.openSignInForm();
        loginPage.login(email, password);
    }




}
