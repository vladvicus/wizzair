package com.epam.wizzair.step.impl;


import com.epam.wizzair.page.impl.SearchResult;

/**
 * Created by Dzmitry_Sankouski on 13-Mar-17.
 */
public class StepsForSearchResult {

    SearchResult result = new SearchResult();

    public StepsForSearchResult pickExactDepFlight(){
        result.chooseFirstFlight();

        return this;
    }

    public StepsForSearchResult pickExactRetFlight(){
        result.chooseSecondFlight();

        return this;
    }

    public StepsForSearchResult pickExactFlights(){
        result.chooseFirstFlight();
        result.chooseSecondFlight();
        return this;
    }


    public PassengerSteps submit(){
        result.continueToNextPage();
        return new PassengerSteps();
    }

    //---------control methods
    public String getTwoFlightPrices() {

        String firstFlightPrice = result.chooseFirstFlight().substring(2);
        String secondFlightPrice = result.chooseSecondFlight().substring(2);

        double sum = Double.parseDouble(firstFlightPrice) + Double.parseDouble(secondFlightPrice);
        return (sum + "").substring(0,6);
    }

    public String getFlightSumFromLeftWindow() {

        String s = result.getTotalPrice().substring(2);
        return s;
    }
}

