package com.epam.wizzair.step.impl;

import com.epam.wizzair.bean.Baggage;
import com.epam.wizzair.bean.PassengerData;
import com.epam.wizzair.page.IPassenger;
import com.epam.wizzair.page.exception.ElementNotActiveException;
import com.epam.wizzair.page.impl.InfoColumnPage;
import com.epam.wizzair.page.impl.Passenger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.wizzair.step.util.Util.fillNonMentionedWithDefaults;
import static com.epam.wizzair.step.util.Util.parseAndFill;

/**
 * Created by Dzmitry_Sankouski on 10-Mar-17.
 */
public class PassengerSteps {
    IPassenger passengerPO = new Passenger();

    public PassengerSteps fillPassenger(PassengerData data) {
        passengerPO.setCabinBaggage(data.getDepBaggage().getCabinBaggage(), data.getRetBaggage().getCabinBaggage());
        passengerPO.setCheckedInBaggage(data.getDepBaggage().getCheckedBaggage(), data.getRetBaggage().getCheckedBaggage());
        passengerPO.setSportEquipment(data.getDepBaggage().isSportEquipment(), data.getRetBaggage().isSportEquipment());
        passengerPO.setCheckInMethod(data.getDepCheckinMethod(), data.getRetCheckinMethod());
        return this;
    } // todo how to know if return flight enabled?

    public PassengerSteps fillBaggage(Baggage baggage) {

        passengerPO.setCabinBaggage(baggage.getCabinBaggage());
        passengerPO.setCheckedInBaggage(baggage.getCheckedBaggage());
        passengerPO.setSportEquipment(baggage.isSportEquipment());
        return new PassengerSteps();

    }

    public StepsForSelectSeatPage gotoDepSeatSelection() {
        passengerPO.gotoDepSeatSelection();
        return new StepsForSelectSeatPage();
    }

    public StepsForSelectSeatPage gotoRetSeatSelection() {
        passengerPO.gotoRetSeatSelection();
        return new StepsForSelectSeatPage();
    }

    public StepsForServicesPage submit() {
        try {
            passengerPO.submit();
        } catch (ElementNotActiveException e) {
            //todo throw steps layer exception
        }
        return new StepsForServicesPage();
    }


    public StepsForSelectSeatPage submitAndGoToSeatSelection() {
        try {
            passengerPO.submit();
        } catch (ElementNotActiveException e) {
            //todo throw steps layer exception
        }
        return new StepsForSelectSeatPage();

    }

    /**The goal of this method is to read raw flight data from web page and restore assosiated bean,
     * which was used to fill Passengers page, so it is possible to
     * compare actual and expected data*/
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
        String[] rawBookingData = InfoColumnPage.getInstance().getDepPassengerRawData();//getting raw data from page
        for (int i = 0; i < rawBookingData.length; i++) {
            parseAndFill(rawBookingData[i], result, true); //true stands for departure
        }//parsing raw data and filling bean for departure
        rawBookingData = InfoColumnPage.getInstance().getDepPassengerRawData();
        for (int i = 0; i < rawBookingData.length; i++) {
            parseAndFill(rawBookingData[i], result, false); //false stands for return
        }
        fillNonMentionedWithDefaults(result);//filling non mentioned values in page with its default values

        return result;
    }


}
