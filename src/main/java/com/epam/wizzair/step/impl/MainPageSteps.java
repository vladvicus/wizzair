package com.epam.wizzair.step.impl;

import com.epam.wizzair.page.impl.*;
import com.epam.wizzair.page.util.BaggageCabinOptions;
import com.epam.wizzair.page.util.BaggageCheckedOptions;
import com.epam.wizzair.page.util.CheckInMethod;


public class MainPageSteps {
    MainPage mainPage = new MainPage();


    public StepsForSearchResult findFlight(String origin, String destination, int departureDay, int returnDay) throws InterruptedException {

        mainPage.stickyBarClose();
        mainPage.fillOrigin(origin);
        mainPage.fillDestination(destination);
        mainPage.fillDepartureDate(departureDay);
        mainPage.fillReturnDate(returnDay);
        mainPage.search();
        return new StepsForSearchResult();
    }

    public String getTwoFlightPrices() {
        SearchResult searchResult = new SearchResult();

        String firstFlightPrice = searchResult.chooseFirstFlight().substring(2);
        String secondFlightPrice = searchResult.chooseSecondFlight().substring(2);

        double sum = Double.parseDouble(firstFlightPrice) + Double.parseDouble(secondFlightPrice);
        return (sum + "").substring(0,6);
    }

    public String getFlightSumFromLeftWindow() {
        SearchResult searchResult = new SearchResult();

        String s = searchResult.getTotalPrice().substring(2);
        return s;
    }

    public StepsForLoginPage signIn() {
        mainPage.signIn();
        return new StepsForLoginPage();
    }




    //todo delete this testing stuff

    public static void continueFromServicesPage() {
        ServicesPage servicesPage = new ServicesPage();
        servicesPage.continueToNextPage();
    }


    public static void enterPayment() {

        PaymentPage paymentPage = new PaymentPage();
        paymentPage.setStreet("AnyStreet");
        paymentPage.setCity("Minsk");
        paymentPage.setPostcode("111111");
//        paymentPage.chooseCountryFromMenu();
        paymentPage.setCardNumber("4954-5913-5717-8298");
        paymentPage.setCardName("Tester");
        paymentPage.setCardCvv("512");
        paymentPage.acceptPolicy();
        paymentPage.confirmPayment();

    }




    public static void getFlights() {
        SearchResult searchResult = new SearchResult();
        searchResult.chooseFirstFlight();
        searchResult.chooseSecondFlight();
        searchResult.continueToNextPage();
    }



    public static void declineWiz() {
        WizzDiscountPage wizzDiscountPage = new WizzDiscountPage();
        wizzDiscountPage.declineOffer();
    }



    public static void getRidOfStickBar() {
        MainPage mainPage = new MainPage();
        mainPage.stickyBarClose();
    }

    public static void continueFromSeats() {
        SelectSeatPage seatPage = new SelectSeatPage();
        seatPage.continueOrigin();
        seatPage.continueReturn();


    }

    public static void choosePassengerEquipment() {
        Passenger passenger = new Passenger();

        passenger.setCheckedInBaggage(BaggageCheckedOptions.NONE);

        passenger.setCabinBaggage(BaggageCabinOptions.SMALL);

        passenger.setSportEquipment(true);

        passenger.setCheckInMethod(CheckInMethod.ONLINE);
        passenger.submit();
    }



}
