package com.epam.wizzair.test;

import com.epam.wizzair.bean.FlightData;
import com.epam.wizzair.page.impl.MainPage;
import com.epam.wizzair.step.impl.StepsForMainPage;
import org.testng.annotations.Test;

/**
 * Created by Dzmitry_Sankouski on 13-Mar-17.
 */
public class TestSuite {
    StepsForMainPage mainSteps = new StepsForMainPage();

    @Test
    public void summingTwoFlights(FlightData flightData){
        mainSteps.init()
                .findFlight(flightData);

    }

}
