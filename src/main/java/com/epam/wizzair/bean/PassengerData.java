package com.epam.wizzair.bean;

import com.epam.wizzair.page.util.CheckInMethod;

/**
 * Created by Dzmitry_Sankouski on 10-Mar-17.
 */
public class PassengerData {
    String name;
    String surName;
    boolean isMaleGender;
    CheckInMethod depCheckinMethod;
    CheckInMethod retCheckinMethod;
    Baggage depBaggage;
    Baggage retBaggage;

    public PassengerData(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public boolean isMaleGender() {
        return isMaleGender;
    }

    public void setMaleGender(boolean maleGender) {
        isMaleGender = maleGender;
    }

    public CheckInMethod getDepCheckinMethod() {
        return depCheckinMethod;
    }

    public void setDepCheckinMethod(CheckInMethod depCheckinMethod) {
        this.depCheckinMethod = depCheckinMethod;
    }

    public CheckInMethod getRetCheckinMethod() {
        return retCheckinMethod;
    }

    public void setRetCheckinMethod(CheckInMethod retCheckinMethod) {
        this.retCheckinMethod = retCheckinMethod;
    }

    public Baggage getDepBaggage() {
        return depBaggage;
    }

    public void setDepBaggage(Baggage depBaggage) {
        this.depBaggage = depBaggage;
    }

    public Baggage getRetBaggage() {
        return retBaggage;
    }

    public void setRetBaggage(Baggage retBaggage) {
        this.retBaggage = retBaggage;
    }



    //todo equals&hashcode&toString


    @Override
    public String toString() {
        return "PassengerData{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", isMaleGender=" + isMaleGender +
                ", depCheckinMethod=" + depCheckinMethod +
                ", retCheckinMethod=" + retCheckinMethod +
                ", depBaggage=" + depBaggage +
                ", retBaggage=" + retBaggage +
                '}';
    }
}
