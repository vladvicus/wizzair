package com.epam.wizzair.step;

import com.epam.wizzair.page.MapPage;

/**
 * Created by Nadzeya_Parkhimovich on 21-Mar-17.
 */
public class StepsForMapPage {

    private String origin;
    private String destination;

    private MapPage mapPage = new MapPage();

    public StepsForMapPage chooseRoute() {
        mapPage.chooseFirstCity().chooseSecondCity();
        origin = mapPage.getOriginName();
        destination = mapPage.getDestinationName();
        return this;
    }

    public TimeTableSteps searchFromMap() {
        mapPage.search();
        return new TimeTableSteps();
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }
}
