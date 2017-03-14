package com.epam.wizzair.step.impl;

import com.epam.wizzair.page.impl.SelectSeatPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    public static PassengerSteps continueFromSeats() {
        SelectSeatPage seatPage = new SelectSeatPage();
        seatPage.continueOrigin();
        seatPage.continueReturn();
        return new PassengerSteps();

    }

}
