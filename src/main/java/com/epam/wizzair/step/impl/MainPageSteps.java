package com.epam.wizzair.step.impl;

import com.epam.wizzair.page.impl.*;
import com.epam.wizzair.page.util.BaggageCabinOptions;
import com.epam.wizzair.page.util.BaggageCheckedOptions;
import com.epam.wizzair.page.util.CheckInMethod;


public class MainPageSteps {




    public static void findFlight(String origin, String destination, int departureDay, int returnDay) throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.fillOrigin(origin);
        mainPage.fillDestination(destination);
        mainPage.fillDepartureDate(departureDay);
        mainPage.fillReturnDate(returnDay);
        mainPage.search();
    }

    public static String getTwoFlightPrices() {
        SearchResult searchResult = new SearchResult();
        String firstFlightPrice = searchResult.chooseFirstFlight().substring(1);
        String secondFlightPrice = searchResult.chooseSecondFlight().substring(1);
        double sum = Double.parseDouble(firstFlightPrice) + Double.parseDouble(secondFlightPrice);
        return (sum + "").substring(0,6);
    }

    public static String getFlightSumFromLeftWindow() {
        SearchResult searchResult = new SearchResult();
        String s = searchResult.getTotalPrice().substring(1);
        return s;
    }

    public static void signIn() {
        MainPage mainPage = new MainPage();
        mainPage.signIn();
    }


    public static void login() {

        LoginPage loginPage = new LoginPage();
        loginPage.login("tatester@12storage.com", "qwerty12345");

    }





    public static void continueFromServicesPage() {
        ServicesPage servicesPage = new ServicesPage();
        servicesPage.continueToNextPage();
    }



    public static void enterPayment() {

        PaymentPage paymentPage = new PaymentPage();
        paymentPage.setStreet("AnyStreet");
        paymentPage.setCity("Minsk");
        paymentPage.setPostcode("111111");
        paymentPage.chooseCountryFromMenu();
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
