package com.epam.wizzair.step.impl;

import com.epam.wizzair.bean.Baggage;
import com.epam.wizzair.bean.PassengerData;
import com.epam.wizzair.page.IPassenger;
import com.epam.wizzair.page.exception.ElementNotActiveException;
import com.epam.wizzair.page.impl.Passenger;

/**
 * Created by Dzmitry_Sankouski on 10-Mar-17.
 */
public class PassengerSteps {
    IPassenger passengerPO = new Passenger();

    public PassengerSteps fillPassenger(PassengerData data){
        passengerPO.setCabinBaggage(data.getDepBaggage().getCabinBaggage(), data.getRetBaggage().getCabinBaggage());
        passengerPO.setCheckedInBaggage(data.getDepBaggage().getCheckedBaggage(), data.getRetBaggage().getCheckedBaggage());
        passengerPO.setSportEquipment(data.getDepBaggage().isSportEquipment(), data.getRetBaggage().isSportEquipment());
        passengerPO.setCheckInMethod(data.getDepCheckinMethod(), data.getRetCheckinMethod());
        return  this;
    }

    public PassengerSteps fillBaggage(Baggage baggage) {

        passengerPO.setCabinBaggage(baggage.getCabinBaggage());
        passengerPO.setCheckedInBaggage(baggage.getCheckedBaggage());
        passengerPO.setSportEquipment(baggage.isSportEquipment());
        return new PassengerSteps();

    }

    public StepsForSelectSeatPage gotoDepSeatSelection(){
        passengerPO.gotoDepSeatSelection();
        return new StepsForSelectSeatPage();
    }

    public StepsForSelectSeatPage gotoRetSeatSelection(){
        passengerPO.gotoRetSeatSelection();
        return new StepsForSelectSeatPage();
    }

    public StepsForServicesPage submit(){
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


}
