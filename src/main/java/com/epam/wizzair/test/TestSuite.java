package com.epam.wizzair.test;

import com.epam.wizzair.bean.*;
import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.helper.Creator;
import com.epam.wizzair.step.impl.StepsForMainPage;
import com.epam.wizzair.step.impl.StepsForSearchResult;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by Dzmitry_Sankouski on 13-Mar-17.
 */
public class TestSuite {
    StepsForMainPage mainSteps = new StepsForMainPage();

//----------TestCase id=2
    @Test
    public void summingTwoFlights(){
        FlightData flightData = Creator.getFlightData();

        StepsForSearchResult result;
        result = mainSteps.init()
                .findFlight(flightData)
                .pickExactFlights();
        Assert.assertEquals(result.getTwoFlightPrices(), result.getFlightSumFromLeftWindow());
    }

    //----------TestCase id=4
    @Test
    public void baggageCheck(){
        FlightData flightData = Creator.getFlightData();

        PassengerData passengerData = new PassengerData();

//        Baggage depBaggage = new Baggage();
//        depBaggage.setCabinBaggage(BaggageCabinOptions.LARGE);
//        depBaggage.setCheckedBaggage(BaggageCheckedOptions.LIGHT);
//        depBaggage.setSportEquipment(true);
//
//        Baggage retBaggage = new Baggage();
//
//        depBaggage.setCabinBaggage(BaggageCabinOptions.LARGE);
//        depBaggage.setCheckedBaggage(BaggageCheckedOptions.LIGHT);
//        depBaggage.setSportEquipment(true);
//
//        passengerData.setDepBaggage(depBaggage);
//        passengerData.setRetBaggage(retBaggage);
//        passengerData.setDepCheckinMethod(CheckInMethod.AIRPORT);
//        passengerData.setRetCheckinMethod(CheckInMethod.AIRPORT);
//        passengerData.setMaleGender(true);
//        passengerData.setName("khsdfge");
//        passengerData.setSurName("uiuijk");
//        //todo retirieve this obj from somewhere twickable

        passengerData = Creator.getPassengerData();

        StepsForSearchResult result;
        mainSteps.init().closePopUps()
                .findFlight(flightData)
                .pickExactFlights().submit()
                .fillPassenger(passengerData)

        ;
//        Assert.assertEquals(result.getTwoFlightPrices(), result.getFlightSumFromLeftWindow());
    }//todo complete Info column Page, & finish asserts

    //----------TestCase id=5
    @Test
    public void bookingWrongCard(){
        FlightData flightData = Creator.getFlightData();
        PassengerData passengerData = Creator.getPassengerData();
        BillingDetailsPersonal billingDetails = Creator.getBillingDetailsPersonal();
        CreditCardData creditCard = Creator.getCreditCardData();
//        Baggage depBaggage = new Baggage();
//        depBaggage.setCabinBaggage(BaggageCabinOptions.LARGE);
//        depBaggage.setCheckedBaggage(BaggageCheckedOptions.LIGHT);
//        depBaggage.setSportEquipment(true);
//
//        Baggage retBaggage = new Baggage();
//
//        depBaggage.setCabinBaggage(BaggageCabinOptions.LARGE);
//        depBaggage.setCheckedBaggage(BaggageCheckedOptions.LIGHT);
//        depBaggage.setSportEquipment(true);
//
//        passengerData.setDepBaggage(depBaggage);
//        passengerData.setRetBaggage(retBaggage);
//        passengerData.setDepCheckinMethod(CheckInMethod.AIRPORT);
//        passengerData.setRetCheckinMethod(CheckInMethod.AIRPORT);
//        passengerData.setMaleGender(true);
//        passengerData.setName("khsdfge");
//        passengerData.setSurName("uiuijk");
//        //todo retirieve this obj from somewhere twickable


        StepsForSearchResult result;
        mainSteps.init().closePopUps()
                .findFlight(flightData)
                .pickExactFlights().submit()
                .fillPassenger(passengerData)
                .fillBaggage(passengerData.getDepBaggage())
                .gotoDepSeatSelection()
                .selectSeatWizzAir().continueFromSeats()
                .gotoRetSeatSelection()
                .selectSeatWizzAir().continueFromSeats()
                .submit()
                .submit()
                .continueToNextPage()
                .fillBillingDetails(billingDetails)
                .fillCreditCard(creditCard)

        ;
//        Assert.assertEquals(result.getTwoFlightPrices(), result.getFlightSumFromLeftWindow());
    }

    @AfterClass
    public void closeResources(){
        DriverSingleton.quit();
    }

}
