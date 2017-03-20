package com.epam.wizzair.step;

import com.epam.wizzair.page.SearchResult;

public class StepsForSearchResult {

    private SearchResult searchResult = new SearchResult();
    private static int priceMinusCurrencySign = 2;

    /* This methods will be used soon :)
    public StepsForSearchResult pickExactDepFlight(){
        searchResult.chooseFirstFlight();
        return this;
    }

    public StepsForSearchResult pickExactRetFlight(){
        searchResult.chooseSecondFlight();
        return this;
    }*/

    public StepsForSearchResult pickExactFlights(){
        searchResult.chooseFirstFlight();
        searchResult.chooseSecondFlight();
        return this;
    }

    public PassengerSteps submit(){
        searchResult.continueToNextPage();
        return new PassengerSteps();
    }

    public String getTwoFlightPrices() {
        String firstFlightPrice = searchResult.chooseFirstFlight().substring(priceMinusCurrencySign);
        String secondFlightPrice = searchResult.chooseSecondFlight().substring(priceMinusCurrencySign);
        double sum = Double.parseDouble(firstFlightPrice) + Double.parseDouble(secondFlightPrice);
        return (sum + "");
    }

    public String getFlightSumFromLeftWindow() {
        return searchResult.getTotalPrice().substring(priceMinusCurrencySign);
    }
}

