package com.epam.wizzair.step;

import com.epam.wizzair.page.SelectSeatPage;

public class StepsForSelectSeatPage {

    private SelectSeatPage selectSeatPage = new SelectSeatPage();
    private String selectedSeatNumber;

    public PassengerSteps selectSeatWizzAir()
    {
        selectSeatPage.selectRandomAvailableSeat();
        selectedSeatNumber = selectSeatPage.getSelectedSeatNumber();
        selectSeatPage.clickClosePageButton();
        selectSeatPage.clickSaveResultButton();
        return new PassengerSteps();
    }

    public String getSelectedSeatNumber(){
        return selectedSeatNumber;
    }

    public boolean isSelectedSeatEnable(String seatNumber)
    {
        return selectSeatPage.isSeatEnable(seatNumber);
    }

   /* public PassengerSteps continueFromSeats() {
        SelectSeatPage seatPage = new SelectSeatPage();
        seatPage.continueOrigin();
        seatPage.continueReturn();
        return new PassengerSteps();
    }*/

}
