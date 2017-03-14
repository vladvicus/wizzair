package com.epam.wizzair.step.impl;

import com.epam.wizzair.bean.FlightData;
import com.epam.wizzair.page.impl.MainPage;
import com.epam.wizzair.page.impl.SearchResult;

/**
 * Created by Dzmitry_Sankouski on 13-Mar-17.
 */
public class StepsForMainPage {

    MainPage mainPage = new MainPage();

    public StepsForMainPage init(){//opens main page
        mainPage.openPage();
        return this;
    }

    public StepsForSearchResult findFlight(FlightData data){


        mainPage.stickyBarClose();
        mainPage.fillOrigin(data.getOrigin());
        mainPage.fillDestination(data.getDestination());
        mainPage.fillDepartureDate(data.getDepDate());//todo refactor deprecated methods
        mainPage.fillReturnDate(data.getRetDate());
        mainPage.search();
        return new StepsForSearchResult();
    }

    public String getTwoFlightPrices() {
        SearchResult searchResult = new SearchResult();

        String firstFlightPrice = searchResult.chooseFirstFlight().substring(2);
        String secondFlightPrice = searchResult.chooseSecondFlight().substring(2);

        double sum = Double.parseDouble(firstFlightPrice) + Double.parseDouble(secondFlightPrice);
        return (sum + "").substring(0,6);
    }

    public String getFlightSumFromLeftWindow() {
        SearchResult searchResult = new SearchResult();

        String s = searchResult.getTotalPrice().substring(2);
        return s;
    }

    public StepsForLoginPage signIn() {
        mainPage.signIn();
        return new StepsForLoginPage();
    }

}
