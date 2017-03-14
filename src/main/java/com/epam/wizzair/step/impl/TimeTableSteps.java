package com.epam.wizzair.step.impl;

import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.page.impl.MainPage;
import com.epam.wizzair.page.impl.SearchResult;
import com.epam.wizzair.page.impl.TimetablePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Nadzeya_Parkhimovich on 13-Mar-17.
 */
public class TimeTableSteps {

    private static String firstFlightPrice;
    private static String secondFlightPrice;
    private static String summaryPrice;

    private static String firstFlightPriceInSearch;
    private static String secondFlightPriceInSearch;
    private static String summaryPriceInSearch;

    public static void openTimetablePage() {
        MainPage mainPage = new MainPage();
        mainPage.openPage();
        mainPage.stickyBarClose();
        mainPage.servicesClick();
        mainPage.timetableClick();

    }

    public static void findFlight(String origin, String destination) {
        TimetablePage timetablePage = new TimetablePage();
        timetablePage.fillOrigin(origin);
        timetablePage.fillDestination(destination);
        timetablePage.search();
        timetablePage.chooseFirstFlight();
        firstFlightPrice = timetablePage.getFirstFlightPrice();
        summaryPrice = timetablePage.getSummaryPrice();
        timetablePage.startBooking();
    }

    public static void findFlightInSearchPage() {
        SearchResult searchResult = new SearchResult();
        firstFlightPriceInSearch = searchResult.chooseFirstFlight();
        summaryPriceInSearch = searchResult.getTotalPrice();
    }

    public static String getFirstFlightPrice() {
        return firstFlightPrice;
    }

    public static String getSummaryPrice() {
        return summaryPrice;
    }

    public static String getFirstFlightPriceInSearch() {
        return firstFlightPriceInSearch;
    }

    public static String getSummaryPriceInSearch() {
        return summaryPriceInSearch;
    }

    public static String getSecondFlightPrice() {
        return secondFlightPrice;
    }

    public static String getSecondFlightPriceInSearch() {
        return secondFlightPriceInSearch;
    }
}
