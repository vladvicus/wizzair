package com.epam.wizzair.step;

import com.epam.wizzair.page.SelectSeatPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StepsForSelectSeatPage {

    SelectSeatPage selectSeatPage = new SelectSeatPage();
    private final Logger logger = LogManager.getRootLogger();

    public StepsForSelectSeatPage selectSeatWizzAir()
    {
        selectSeatPage.selectRandomAvailableSeat();
//        return selectSeatPage.getSelectedSeatName();
        return this;
    }

    public void selectSeatWizzAir(String seat){
//        selectSeatPage.
    }

    /*public boolean isSelectedSeatEnable()
    {
        SelectSeatPage selectSeatPage = new SelectSeatPage(driver);
        return selectSeatPage.isSeatEnable()
    }*/

    public PassengerSteps continueFromSeats() {
        SelectSeatPage seatPage = new SelectSeatPage();
        seatPage.continueOrigin();
        seatPage.continueReturn();
        return new PassengerSteps();

    }

}
