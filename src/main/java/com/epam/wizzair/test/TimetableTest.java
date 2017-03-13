package com.epam.wizzair.test;

import com.epam.wizzair.step.impl.TimeTableSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Nadzeya_Parkhimovich on 13-Mar-17.
 */
public class TimetableTest {

    private TimeTableSteps steps;
    private String origin = "Vilnius";
    private String destination = "Tel-Aviv";

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new TimeTableSteps();
        steps.initBrowser();
    }

    @Test
    public void timetableTest() throws InterruptedException {
        steps.openTimetablePage();
        steps.findFlight(origin, destination);
        Thread.sleep(3000);

    }

    @AfterMethod
    public void close() {
        steps.closeBrowser();
    }
}
