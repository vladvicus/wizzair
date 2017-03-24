package com.epam.wizzair.step;

import com.epam.wizzair.bean.Baggage;
import com.epam.wizzair.bean.PassengerData;
import com.epam.wizzair.page.InfoColumnPage;
import com.epam.wizzair.page.Passenger;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.wizzair.step.util.Util.fillNonMentionedWithDefaults;
import static com.epam.wizzair.step.util.Util.parseAndFillPassenger;

/**
 * Created by Dzmitry_Sankouski on 10-Mar-17.
 */
public class PassengerSteps {
    private Passenger passenger = new Passenger();

    public PassengerSteps fillPassenger(PassengerData data) {
        passenger.setCabinBaggage(data.getDepBaggage().getCabinBaggage(), data.getRetBaggage().getCabinBaggage());
        passenger.setCheckedInBaggage(data.getDepBaggage().getCheckedBaggage(), data.getRetBaggage().getCheckedBaggage());
        passenger.setSportEquipment(data.getDepBaggage().isSportEquipment(), data.getRetBaggage().isSportEquipment());
        passenger.setCheckInMethod(data.getDepCheckinMethod(), data.getRetCheckinMethod());
        return this;
    } // todo how to know if return flight enabled?

    public PassengerSteps fillBaggage(Baggage baggage) {
        passenger.setCabinBaggage(baggage.getCabinBaggage());
        passenger.setCheckedInBaggage(baggage.getCheckedBaggage());
        passenger.setSportEquipment(baggage.isSportEquipment());
        return new PassengerSteps();
    }

    public StepsForSelectSeatPage gotoDepSeatSelection() {
        passenger.gotoDepartureSeatSelection();
        return new StepsForSelectSeatPage();
    }

    public StepsForSelectSeatPage gotoRetSeatSelection() {
        passenger.gotoReturnSeatSelection();
        return new StepsForSelectSeatPage();
    }

    public StepsForServicesPage submit() {
        passenger.submit();
        return new StepsForServicesPage();
    }

    public StepsForSelectSeatPage submitAndGoToSeatSelection() {
        passenger.submit();
        return new StepsForSelectSeatPage();

    }

//     The goal of this method is to read raw flight data from web page and restore assosiated bean,
//     which was used to fill Passengers page, so it is possible to
//     compare actual and expected data

    public PassengerData getInfoColumnData() {
        PassengerData result = new PassengerData();
        result.setDepBaggage(new Baggage());
        result.setRetBaggage(new Baggage());//creating bean for filling data in
        String fullName = InfoColumnPage.getInstance().getPassengerFullName();
        Pattern pattern = Pattern.compile("(\\S+)\\s+(\\S+)"); //name validity pattern
        Matcher matcher = pattern.matcher(fullName);
        if (matcher.matches()) {
            result.setName(matcher.group(2));
            result.setSurName(matcher.group(1));
        }
        Set<String> rawBookingData = InfoColumnPage.getInstance().getDepPassengerRawData();//getting raw data from page
        for (String s :
                rawBookingData) {
            parseAndFillPassenger(s, result, true); //true stands for departure
        }//parsing raw data and filling bean for departure
        rawBookingData = InfoColumnPage.getInstance().getRetPassengerRawData();
        for (String s :
                rawBookingData) {
            parseAndFillPassenger(s, result, false); //true stands for departure
        }//parsing raw data and filling bean for return
        fillNonMentionedWithDefaults(result);//filling non mentioned values in page with its default values

        return result;
    }


}
