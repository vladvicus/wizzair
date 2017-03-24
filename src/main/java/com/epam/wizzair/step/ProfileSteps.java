package com.epam.wizzair.step;

import com.epam.wizzair.bean.Baggage;
import com.epam.wizzair.bean.PassengerData;
import com.epam.wizzair.page.FlightInfoPage;
import com.epam.wizzair.page.ProfilePage;

import java.util.Set;

import static com.epam.wizzair.step.util.Util.parseAndFillPassenger;
import static com.epam.wizzair.step.util.Util.parseAndFillPassengerName;

/**
 * Created by Dzmitry_Sankouski on 24-Mar-17.
 */
public class ProfileSteps {
        ProfilePage profilePage = new ProfilePage();
        FlightInfoPage info = profilePage.gotoFlightInfo();

    public PassengerData getPassengerData() {
        PassengerData passenger = new PassengerData();
        passenger.setDepBaggage(new Baggage());
        passenger.setRetBaggage(new Baggage());//creating bean for filling data in


        parseAndFillPassengerName(passenger, info.getPassengerFullName());

        Set<String> rawPassengerData = info.getDepartureBaggageRawData();
        for (String s :
                rawPassengerData) {
            parseAndFillPassenger(s, passenger, true); // true stands for departure
        }

        rawPassengerData = info.getReturnBaggageRawData();
        for (String s :
                rawPassengerData) {
            parseAndFillPassenger(s, passenger, false); // false stands for return
        }


        return passenger;
    }

    public int getFligthsCount(){
        return info.getFlightsCount();
    }

//    public int getDepartureDate(){
//
//    }
}
