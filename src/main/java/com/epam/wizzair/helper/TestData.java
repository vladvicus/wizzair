package com.epam.wizzair.helper;

import com.epam.wizzair.bean.*;
import com.epam.wizzair.bean.enumeration.BaggageCabinOptions;
import com.epam.wizzair.bean.enumeration.BaggageCheckedOptions;
import com.epam.wizzair.bean.enumeration.CheckInMethod;
import com.epam.wizzair.bean.enumeration.PassengerSetting;

import java.io.InputStream;
import java.util.Properties;


public class TestData {


    private static Properties bean = new Properties();
    static {
        InputStream is = DriverConfig.class.getResourceAsStream("/testDataWithoutInfant.properties");
        try{
            bean.load(is);
        } catch (Exception e){
            System.out.println("Error reading from property file");// todo logging
        }
    } // default openPage block


    public static void setPropertyFile(String fileName) {
        InputStream is = DriverConfig.class.getResourceAsStream("/" + fileName + ".properties");
        {
            try{
                bean.load(is);
            } catch (Exception e){
                System.out.println("Error reading from property file");// todo logging
            }
        }
    }

    public static LoginData getLogin() {
        LoginData loginData = new LoginData();
        loginData.setLogin(bean.getProperty("login"));
        loginData.setPassword(bean.getProperty("password"));
        return loginData;
    }

    public static FlightData getFlightData() {
        FlightData flightData = new FlightData();
        flightData.setOrigin(bean.getProperty("origin"));
        flightData.setDestination(bean.getProperty("destination"));
        flightData.setDepDate(Integer.parseInt(bean.getProperty("depDate")));
        flightData.setRetDate(Integer.parseInt(bean.getProperty("retDate")));
        flightData.setPassenger(PassengerSetting.valueOf(bean.getProperty("passenger")));
        flightData.setNumberOfPassengers(Integer.parseInt(bean.getProperty("numberOfPassengers")));
        flightData.setMonth(bean.getProperty("month"));
        return flightData;
    }

    public static CreditCardData getCreditCardData() {
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

    public static PassengerData getPassengerData() {
        PassengerData passengerData = new PassengerData();
        passengerData.setName(bean.getProperty("name"));
        passengerData.setSurName(bean.getProperty("surname"));
        passengerData.setDepBaggage(getBaggage());
        passengerData.setRetBaggage(getBaggage());
        passengerData.setDepCheckinMethod(CheckInMethod.valueOf(bean.getProperty("retCheckinMethod")));
        passengerData.setRetCheckinMethod(CheckInMethod.valueOf(bean.getProperty("depCheckinMethod")));
        return passengerData;
    }


}
