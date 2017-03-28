package com.epam.wizzair.page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.wizzair.driver.DriverSingleton.getDriver;


public abstract class AbstractPage {

    protected WebDriverWait wait = new WebDriverWait(getDriver(), 5, 1000);
    protected WebDriver driver;

    protected AbstractPage() {
        PageFactory.initElements(getDriver(), this);
    }

}
