package com.epam.wizzair.helper;

import com.epam.wizzair.bean.*;
import com.epam.wizzair.page.util.BaggageCabinOptions;
import com.epam.wizzair.page.util.BaggageCheckedOptions;

import java.io.InputStream;
import java.util.Properties;


public class Creator {


    private static Properties bean = new Properties();



    public static void setPropertyFile(String fileName) {

        InputStream is = Config.class.getResourceAsStream("/" + fileName + ".properties");

        {

            try{
                bean.load(is);

            } catch (Exception e){
                System.out.println("Error reading from property file");

            }
        }



    }


    public static Login getLogin() {

        Login login = new Login();
        login.setLogin(bean.getProperty("login"));
        login.setPassword(bean.getProperty("password"));

        return login;

    }



    public static FlightData getFlightData() {

        FlightData flightData = new FlightData();
        flightData.setOrigin(bean.getProperty("origin"));
        flightData.setDestination(bean.getProperty("destination"));
        flightData.setDepDate(Integer.parseInt(bean.getProperty("depDate")));
        flightData.setRetDate(Integer.parseInt(bean.getProperty("retDate")));

        return flightData;

    }

    public static CreditCardData getCreditCardDate() {
        CreditCardData creditCardData = new CreditCardData();

        creditCardData.setCardNumber(bean.getProperty("cardNumber"));
        creditCardData.setCardHolder(bean.getProperty("cardHolder"));
        creditCardData.setSecCode(Integer.parseInt(bean.getProperty("secCode")));

        return creditCardData;

    }

    public static BillingDetailsPersonal getBillingDetailsPersonal() {

        BillingDetailsPersonal billingDetailsPersonal = new BillingDetailsPersonal();

        billingDetailsPersonal.setFirstName(bean.getProperty("firstName"));
        billingDetailsPersonal.setSecondName(bean.getProperty("secondName"));
        billingDetailsPersonal.setEmail(bean.getProperty("email"));
        billingDetailsPersonal.setAddress(bean.getProperty("address"));
        billingDetailsPersonal.setCity(bean.getProperty("city"));
        billingDetailsPersonal.setPhone(bean.getProperty("phone"));
        billingDetailsPersonal.setPostIndex(bean.getProperty("postIndex"));
        billingDetailsPersonal.setCountryIndex(bean.getProperty("countryIndex"));
        billingDetailsPersonal.setCountry(bean.getProperty("country"));

        return billingDetailsPersonal;


    }


    public static Baggage getBaggage() {

        Baggage baggage = new Baggage();

        baggage.setCabinBaggage(BaggageCabinOptions.valueOf(bean.getProperty("cabinBaggage")));
        baggage.setCheckedBaggage(BaggageCheckedOptions.valueOf(bean.getProperty("checkedBaggage")));
        baggage.setSportEquipment(Boolean.parseBoolean(bean.getProperty("isSportEquipment")));

        return baggage;

    }


}
