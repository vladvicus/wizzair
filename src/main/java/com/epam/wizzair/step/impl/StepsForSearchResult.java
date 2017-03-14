package com.epam.wizzair.step.impl;


import com.epam.wizzair.page.impl.SearchResult;

/**
 * Created by Dzmitry_Sankouski on 13-Mar-17.
 */
public class StepsForSearchResult {

    public StepsForSearchResult getFlights() {

        SearchResult searchResult = new SearchResult();

      searchResult.chooseFirstFlight();
      searchResult.chooseSecondFlight();

        return this;
    }

    public PassengerSteps submit() {
        SearchResult searchResult = new SearchResult();
        searchResult.continueToNextPage();
        return new PassengerSteps();


    }




}
