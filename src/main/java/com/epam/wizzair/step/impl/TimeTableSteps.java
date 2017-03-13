package com.epam.wizzair.step.impl;

import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.page.impl.MainPage;
import com.epam.wizzair.page.impl.TimetablePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Nadzeya_Parkhimovich on 13-Mar-17.
 */
public class TimeTableSteps {
    private WebDriver driver;

    public void initBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void openTimetablePage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.servicesClick();
        mainPage.timetableClick();

    }

    public void findFlight(String origin, String destination) {
        TimetablePage timetablePage = new TimetablePage(driver);
        timetablePage.fillOrigin(origin);
        timetablePage.fillDestination(destination);
        timetablePage.search();
    }
}
