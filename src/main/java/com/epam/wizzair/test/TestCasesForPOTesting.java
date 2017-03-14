package com.epam.wizzair.test;

import com.epam.wizzair.bean.FlightData;
import com.epam.wizzair.helper.Creator;
import com.epam.wizzair.page.impl.MainPage;
import com.epam.wizzair.page.impl.RejectPaymentPage;
import com.epam.wizzair.step.impl.*;
import junit.framework.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.epam.wizzair.driver.DriverSingleton.quit;
import static org.testng.Assert.assertEquals;


public class TestCasesForPOTesting {


    MainPage mainPage = new MainPage();
    StepsForMainPage stepsForMainPage = new StepsForMainPage();


//    private String origin = "Vilnius";
//    private String destination = "Tel-Aviv";
//    private int departureDay = 22;
//    private int returnDay = 28;
    MainPageStepsForPOTesting mainPageTest = new MainPageStepsForPOTesting();

    @BeforeTest
    public void setup(){

        mainPage.openPage();

    }


    @Test
    public void flitsSum() throws InterruptedException {
        mainPageTest.signIn().loginWizzAir(Creator.getLogin());
        //mainPageTest.findFlight(origin, destination, departureDay, returnDay);
        stepsForMainPage.findFlight(new FlightData());
        Assert.assertEquals(mainPageTest.getTwoFlightPrices(), mainPageTest.getFlightSumFromLeftWindow());
    }




    @Test

    public void payForBooking() {
        String bean = "bean";
        Creator.setPropertyFile(bean);
        MainPageStepsForPOTesting.getRidOfStickBar();
        stepsForMainPage.signIn().loginWizzAir(Creator.getLogin());
        stepsForMainPage.findFlight(Creator.getFlightData()).pickExactFlights().submit().fillPassenger(Creator.getPassengerDate()).submitAndGoToSeatSelection()
                .continueFromSeats().submit().submit().continueToNextPage().fillBillingDetails(Creator.getBillingDetailsPersonal())
                .fillCreditCard(Creator.getCreditCardDate()).submit();
        RejectPaymentPage rejectPaymentPage = new RejectPaymentPage();
        String message = rejectPaymentPage.getRejectMessage();
        assertEquals(message, "It seems your bank rejected the payment.");

    }







    @AfterTest
    public void tearDown(){
        quit();
    }


}
