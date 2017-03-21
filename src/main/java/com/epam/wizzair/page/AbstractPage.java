package com.epam.wizzair.page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.epam.wizzair.driver.DriverSingleton.getDriver;


public abstract class AbstractPage {

    protected WebDriver driver;

    protected AbstractPage() {
        PageFactory.initElements(getDriver(), this);
    }

}
