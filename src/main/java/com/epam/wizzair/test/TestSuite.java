package com.epam.wizzair.test;

import com.epam.wizzair.bean.*;
import com.epam.wizzair.helper.TestData;
import com.epam.wizzair.page.exception.NotSignedException;
import com.epam.wizzair.step.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class TestSuite {
    private StepsForMainPage mainSteps;
    private static String testDataWithInfant = "testDataWithInfant";
    private static String timetable = "testDataForTimetable";
    private static String wrongReturnData = "testDataWithWrongReturnData";

    @BeforeMethod
    public void createSteps() {
        mainSteps = new StepsForMainPage();
    }

    @AfterMethod
    public void closeWindow() {
        mainSteps.closeWindow();
    }

    @Test(description = "id=1")
    public void timetableFlightPriceEqualsFlightPriceInSearch() {
        TestData.setPropertyFile(timetable);
        FlightData flightData = TestData.getFlightData();
        TimeTableSteps flight = mainSteps.openPage().closePopUps()
                .openTimeTable()
                .findFlight(flightData.getOrigin(), flightData.getDestination())
                .findFlightInSearchPage();
        assertEquals(flight.getFirstFlightPrice(), flight.getFirstFlightPriceInSearch());
    }

    @Test(description = "id=2")
    public void checkSumDirectAndReturnFlightPrices() {
        FlightData flightData = TestData.getFlightData();
        mainSteps.openPage().signIn().loginWizzAir(TestData.getLogin());
        StepsForSearchResult flight = mainSteps
                .findFlight(flightData)
                .pickExactFlights();
        assertEquals(flight.getTwoFlightPrices(), flight.getFlightSumFromLeftWindow());
    }

    @Test(description = "id=3")
    public void checkAirportsFromMapPage() {
        StepsForMapPage stepsForMapPage = mainSteps.openPage().closePopUps().openMap();
        stepsForMapPage.chooseRoute();
        String[] origin = stepsForMapPage.getOrigin().split(" ");
        String[] destination = stepsForMapPage.getDestination().split(" ");
        String route = stepsForMapPage.searchFromMap().getTextFromAddressField();
        Assert.assertTrue(route.contains(origin[0]));
        Assert.assertTrue(route.contains(destination[0]));
    }

    @Test(description = "id=4")
    public void selectedBaggageEqualsExpectedBaggage() {
        FlightData flightData = TestData.getFlightData();
        PassengerData expectedPassengerData;
        expectedPassengerData = TestData.getPassengerData();
        mainSteps.openPage().closePopUps()
                .signIn().loginWizzAir(TestData.getLogin());
        PassengerData actualPassengerData = mainSteps.findFlight(flightData)
                .pickExactFlights().submit()
                .fillPassenger(expectedPassengerData)
                .getInfoColumnData();
        assertEquals(actualPassengerData, expectedPassengerData);
    }

    @Test(enabled = true, description = "id=5")
    public void bookingWithWrongCard() throws Exception {
        FlightData flightData = TestData.getFlightData();
        PassengerData expectedPassengerData = TestData.getPassengerData();
        BillingDetailsPersonal billingDetails = TestData.getBillingDetailsPersonal();
        CreditCardData creditCard = TestData.getCreditCardData();
        StepsForSearchResult result;

        mainSteps.openPage().closePopUps()
                .signIn()
                .loginWizzAir(TestData.getLogin())
                .findFlight(flightData)
                .pickExactFlights().submit()
                .fillPassenger(expectedPassengerData)
                .fillBaggage(expectedPassengerData.getDepBaggage())
                .gotoDepSeatSelection()
                .selectSeatWizzAir()
                .gotoRetSeatSelection()
                .selectSeatWizzAir()
                .submit()
                .submitServices()
                .continueToNextPage()
                .fillBillingDetails(billingDetails)
                .fillCreditCard(creditCard)
                .confirmPayment();

        StepsForMainPage controlSession = new StepsForMainPage();

        PassengerData actualPassengerData = controlSession
                .openPage()
                .gotoProfile()
                .getPassengerData();
        controlSession.closeWindow();
        Assert.assertEquals(expectedPassengerData, actualPassengerData);
    }

    @Test(description = "id=6")
    public void selectedSeatIsNotMoreAvailable() {
        FlightData flightData = TestData.getFlightData();
        PassengerData passengerData = TestData.getPassengerData();
        mainSteps.openPage().closePopUps().signIn().loginWizzAir(TestData.getLogin());
        StepsForSelectSeatPage departureSeat = mainSteps
                .findFlight(flightData)
                .pickExactFlights().submit()
                .fillPassenger(passengerData)
                .fillBaggage(passengerData.getDepBaggage())
                .gotoDepSeatSelection();

        departureSeat
                .selectSeatWizzAir()
                .gotoRetSeatSelection()
                .selectSeatWizzAir()
                .submit()
                .submitServices()
                .continueToNextPage()
                .fillBillingDetails(TestData.getBillingDetailsPersonal())
                .fillCreditCard(TestData.getCreditCardData());
        StepsForMainPage mainPageSteps = new StepsForMainPage();

        boolean isSeatEnable = mainPageSteps.openPage().closePopUps()
                .findFlight(flightData)
                .pickExactFlights().submit()
                .fillPassenger(passengerData)
                .fillBaggage(passengerData.getDepBaggage())
                .gotoDepSeatSelection().isSelectedSeatEnable(departureSeat.getSelectedSeatNumber());
        assertFalse(isSeatEnable);
        mainPageSteps.closeWindow();
    }

    @Test(description = "id=7")
    public void twoTicketsOnOnePerson() throws NotSignedException {
        mainSteps.openPage()
                .closePopUps()
                .signIn()
                .loginWizzAir(TestData.getLogin())
                .findFlight(TestData.getFlightData())
                .pickExactFlights()
                .submit()
                .fillBaggage(TestData.getPassengerData().getDepBaggage())
                .fillPassenger(TestData.getPassengerData())
                .gotoDepSeatSelection()
                .selectSeatWizzAir()
                .gotoRetSeatSelection()
                .selectSeatWizzAir()
                .submit()
                .submitServices()
                .continueToNextPage()
                .fillBillingDetails(TestData.getBillingDetailsPersonal())
                .fillCreditCard(TestData.getCreditCardData())
                .confirmPayment();

        StepsForMainPage newBooking = new StepsForMainPage();
        newBooking.openPage()
                .closePopUps()
                .findFlight(TestData.getFlightData())
                .pickExactFlights()
                .submit()
                .fillPassenger(TestData.getPassengerData())
                .fillBaggage(TestData.getPassengerData().getDepBaggage())
                .gotoDepSeatSelection()
                .selectSeatWizzAir()
                .gotoRetSeatSelection()
                .selectSeatWizzAir()
                .submit()
                .submitServices()
                .continueToNextPage()
                .fillBillingDetails(TestData.getBillingDetailsPersonal())
                .fillCreditCard(TestData.getCreditCardData())
                .confirmPayment();

        StepsForMainPage controlSession= new StepsForMainPage();
        ProfileSteps profileSteps = controlSession.openPage()
                .gotoProfile();

        Assert.assertEquals(profileSteps.getFligthsCount(), 1, ">1 tickets were booked one one person at the same time");

        newBooking.closeWindow(); //todo assertions
        controlSession.closeWindow();
    }

    @Test(description = "id=8")
    public void flightPriceWithInfantEqualsPriceWithoutInfant() {
        FlightData flightDataWithoutInfant = TestData.getFlightData();
        String flightWithoutInfant = mainSteps.openPage().closePopUps()
                .findFlight(flightDataWithoutInfant).pickExactFlights()
                .getFlightSumFromLeftWindow();
        TestData.setPropertyFile(testDataWithInfant);
        FlightData flightDataWithInfant = TestData.getFlightData();
        StepsForMainPage newMainSteps = new StepsForMainPage();
        String flightWithInfant = newMainSteps.openPage()
                .findFlight(flightDataWithInfant)
                .pickExactFlights().getFlightSumFromLeftWindow();
        newMainSteps.closeWindow();
        assertEquals(flightWithoutInfant, flightWithInfant);
    }


    @Test(description = "id=9")
    public void bookWrongFlight() {
        TestData.setPropertyFile(wrongReturnData);
        FlightData flightData = TestData.getFlightData();
        boolean isButtonEnabled = mainSteps.openPage().openTimeTable()
                .findBothFlights(flightData.getOrigin(), flightData.getDestination())
                .pickExactDepFlight().pickWrongFlight(flightData.getRetDate()).isButtonEnabled();

        assertFalse(isButtonEnabled);
    }

    @Test(description = "id=10")
    public void checkFlightSumWithAndWithoutLogin() {
        FlightData flightData = TestData.getFlightData();
        LoginData loginData = TestData.getLogin();
        String sumWithoutLogin = mainSteps.openPage().closePopUps()
                .findFlight(flightData).pickExactFlights()
                .getFlightSumFromLeftWindow();
        StepsForMainPage newMainSteps = new StepsForMainPage();
        String sumWithLogin = newMainSteps.openPage().closePopUps().signIn()
                .loginWizzAir(loginData).findFlight(flightData)
                .pickExactFlights().getFlightSumFromLeftWindow();
        assertEquals(sumWithoutLogin, sumWithLogin);
    }

}
