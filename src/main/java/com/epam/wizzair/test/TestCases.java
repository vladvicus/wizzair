package com.epam.wizzair.test;

import com.epam.wizzair.page.impl.MainPage;
import com.epam.wizzair.page.impl.RejectPaymentPage;
import com.epam.wizzair.step.impl.MainPageSteps;
import junit.framework.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.epam.wizzair.driver.DriverSingleton.getDriver;
import static com.epam.wizzair.driver.DriverSingleton.quit;
import static org.testng.Assert.assertEquals;


public class TestCases{



    private String origin = "Vilnius";
    private String destination = "Tel-Aviv";
    private int departureDay = 22;
    private int returnDay = 28;
    MainPageSteps mainPage = new MainPageSteps();

    @BeforeTest
    public void setup(){
        //open(Config.url());
        MainPage mainPage = new MainPage();
        mainPage.openPage();


    }



    @Test
    public void flitsSum() throws InterruptedException {
        mainPage.findFlight(origin, destination, departureDay, returnDay);
        Assert.assertEquals(mainPage.getTwoFlightPrices(), mainPage.getFlightSumFromLeftWindow());
    }

    @Test

    public void pay() throws InterruptedException {


        MainPageSteps.getRidOfStickBar();
        mainPage.signIn().loginWizzAir("tatester@12storage.com", "qwerty12345");
        mainPage.findFlight(origin, destination, departureDay, returnDay);
        MainPageSteps.getFlights();
        MainPageSteps.choosePassengerEquipment();
        MainPageSteps.continueFromSeats();
        MainPageSteps.continueFromServicesPage();
        MainPageSteps.declineWiz();
        MainPageSteps.enterPayment();
        RejectPaymentPage rejectPaymentPage = new RejectPaymentPage();
        String message = rejectPaymentPage.getRejectMessage();
        assertEquals(message, "It seems your bank rejected the payment.");

    }



    @AfterTest
    public void tearDown(){
        quit();
    }


}
