package com.epam.wizzair.step;

import com.epam.wizzair.page.MainPage;
import com.epam.wizzair.page.SearchResult;
import com.epam.wizzair.page.TimetablePage;

/**
 * Created by Nadzeya_Parkhimovich on 13-Mar-17.
 */
public class TimeTableSteps {

    private String firstFlightPrice;
    private String secondFlightPrice;
    private String summaryPrice;

    private String firstFlightPriceInSearch;
    private String secondFlightPriceInSearch;
    private String summaryPriceInSearch;

    public TimeTableSteps openTimetablePage() {
        MainPage mainPage = new MainPage();
        mainPage.openPage();
        mainPage.stickyBarClose();
        mainPage.servicesClick();
        mainPage.timetableClick();

        return this;
    }

    public TimeTableSteps findFlight(String origin, String destination) {
        TimetablePage timetablePage = new TimetablePage();
        timetablePage.fillOrigin(origin);
        timetablePage.fillDestination(destination);
        timetablePage.search();
        timetablePage.chooseFirstFlight();
        firstFlightPrice = timetablePage.getFirstFlightPrice();
        summaryPrice = timetablePage.getSummaryPrice();
        timetablePage.startBooking();
        return this;
    }

    public TimeTableSteps findFlightInSearchPage() {
        SearchResult searchResult = new SearchResult();
        firstFlightPriceInSearch = searchResult.chooseFirstFlight();
        summaryPriceInSearch = searchResult.getTotalPrice();
        return this;
    }

    public String getFirstFlightPrice() {
        return firstFlightPrice;
    }

    public String getSummaryPrice() {
        return summaryPrice;
    }

    public String getFirstFlightPriceInSearch() {
        return firstFlightPriceInSearch;
    }

    public String getSummaryPriceInSearch() {
        return summaryPriceInSearch;
    }

    public String getSecondFlightPrice() {
        return secondFlightPrice;
    }

    public String getSecondFlightPriceInSearch() {
        return secondFlightPriceInSearch;
    }
}
