package com.epam.wizzair.step.impl;

import com.epam.wizzair.bean.PassengerData;
import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.page.IPassenger;
import com.epam.wizzair.page.exception.ElementNotActiveException;
import com.epam.wizzair.page.impl.Passenger;
import com.epam.wizzair.page.impl.SelectSeatPage;
import com.epam.wizzair.page.impl.ServicesPage;

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
    } // todo how to know if return flight enabled?

    public StepsForSelectSeatPage gotoDepSeatSelection(){
        passengerPO.gotoDepSeatSelection();
        return new StepsForSelectSeatPage();
    }

    public StepsForSelectSeatPage gotoRetSeatSelection(){
        passengerPO.gotoRetSeatSelection();
        return new StepsForSelectSeatPage();
    }

    public ServicesPage submit(){
        try {
            passengerPO.submit();
        } catch (ElementNotActiveException e) {
            //todo throw steps layer exception
        }
        return new ServicesPage();
    }


}
