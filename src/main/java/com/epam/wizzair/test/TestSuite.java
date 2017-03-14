package com.epam.wizzair.test;

import com.epam.wizzair.bean.FlightData;
import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.page.impl.MainPage;
import com.epam.wizzair.step.impl.StepsForMainPage;
import com.epam.wizzair.step.impl.StepsForSearchResult;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Dzmitry_Sankouski on 13-Mar-17.
 */
public class TestSuite {
    StepsForMainPage mainSteps = new StepsForMainPage();


    @Test
    public void summingTwoFlights(){
        FlightData flightData = new FlightData();

        flightData.setDepDate(22);
        flightData.setRetDate(28);
        flightData.setOrigin("Vilnius");
        flightData.setDestination("Tel-Aviv");
        //todo retirieve this obj from somewhere twickable

        StepsForSearchResult result;
        result = mainSteps.init()
                .findFlight(flightData)
                .pickExactFlights();
        Assert.assertEquals(result.getTwoFlightPrices(), result.getFlightSumFromLeftWindow());
    }

    @AfterClass
    public void closeResources(){
        DriverSingleton.quit();
    }

}
