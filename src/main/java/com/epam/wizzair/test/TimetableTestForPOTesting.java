package com.epam.wizzair.test;

import com.epam.wizzair.page.impl.MainPage;
import com.epam.wizzair.page.impl.SearchResult;
import com.epam.wizzair.page.impl.TimetablePage;
import com.epam.wizzair.step.impl.TimeTableSteps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.wizzair.driver.DriverSingleton.quit;

/**
 * Created by Nadzeya_Parkhimovich on 13-Mar-17.
 */
public class TimetableTestForPOTesting {

    private TimeTableSteps steps;
    private String origin = "Vilnius";
    private String destination = "Tel-Aviv";

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        MainPage mainPage = new MainPage();
        mainPage.openPage();
    }

    @Test
    public void timetableTest() throws InterruptedException {
        steps.openTimetablePage();
        steps.findFlight(origin, destination);
        Thread.sleep(5000);
        steps.findFlightInSearchPage();
        Assert.assertEquals(steps.getFirstFlightPriceInSearch(), steps.getFirstFlightPrice());
        Assert.assertEquals(steps.getSummaryPriceInSearch(),steps.getSummaryPrice());
    }

    @AfterMethod
    public void close() {
        quit();
    }
}
