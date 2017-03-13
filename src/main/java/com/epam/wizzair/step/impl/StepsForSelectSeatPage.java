package com.epam.wizzair.step.impl;

import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.page.impl.SelectSeatPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class StepsForSelectSeatPage {

    SelectSeatPage selectSeatPage = new SelectSeatPage();
    private final Logger logger = LogManager.getRootLogger();

    public String selectSeatWizzAir()
    {
        selectSeatPage.selectRandomAvailableSeat();
        return selectSeatPage.getSelectedSeatName();
    }

    public void selectSeatWizzAir(String seat){
//        selectSeatPage.
    }

    /*public boolean isSelectedSeatEnable()
    {
        SelectSeatPage selectSeatPage = new SelectSeatPage(driver);
        return selectSeatPage.isSeatEnable()
    }*/

}
