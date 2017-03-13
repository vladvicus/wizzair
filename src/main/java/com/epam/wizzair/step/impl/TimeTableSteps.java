package com.epam.wizzair.step.impl;

import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.page.impl.MainPage;
import com.epam.wizzair.page.impl.TimetablePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Nadzeya_Parkhimovich on 13-Mar-17.
 */
public class TimeTableSteps {

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
    }
}
