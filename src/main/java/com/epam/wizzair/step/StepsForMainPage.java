package com.epam.wizzair.step;

import com.epam.wizzair.bean.FlightData;
import com.epam.wizzair.page.MainPage;

public class StepsForMainPage {

    private MainPage mainPage = new MainPage();

    public StepsForMainPage openPage(){
        mainPage.openPage();
        return this;
    }

    public void closeWindow(){
        mainPage.closeWindow();
    }

    public StepsForMainPage closePopUps(){
        mainPage.stickyBarClose();
        return this;
    }

    public TimeTableSteps openTimeTable(){
//        mainPage.servicesClick();
        mainPage.timetableClick();
        return new TimeTableSteps();
    }

    public StepsForSearchResult findFlight(FlightData data){
        mainPage.fillOrigin(data.getOrigin());
        mainPage.fillDestination(data.getDestination());
        mainPage.fillDepartureDate(data.getDepDate());
        mainPage.fillReturnDate(data.getRetDate());
        mainPage.setPassenger(data.getPassenger(),data.getNumberOfPassengers());
        mainPage.search();
        return new StepsForSearchResult();
    }

    public StepsForLoginPage signIn() {
        mainPage.signIn();
        return new StepsForLoginPage();
    }

    public StepsForMapPage openMap() {
        mainPage.servicesClick().mapClick();
        return new StepsForMapPage();
    }

}
