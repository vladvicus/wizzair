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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PassengerData that = (PassengerData) o;

        if (isMaleGender != that.isMaleGender) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surName != null ? !surName.equals(that.surName) : that.surName != null) return false;
        if (depCheckinMethod != that.depCheckinMethod) return false;
        if (retCheckinMethod != that.retCheckinMethod) return false;
        if (depBaggage != null ? !depBaggage.equals(that.depBaggage) : that.depBaggage != null) return false;
        return retBaggage != null ? retBaggage.equals(that.retBaggage) : that.retBaggage == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surName != null ? surName.hashCode() : 0);
        result = 31 * result + (isMaleGender ? 1 : 0);
        result = 31 * result + (depCheckinMethod != null ? depCheckinMethod.hashCode() : 0);
        result = 31 * result + (retCheckinMethod != null ? retCheckinMethod.hashCode() : 0);
        result = 31 * result + (depBaggage != null ? depBaggage.hashCode() : 0);
        result = 31 * result + (retBaggage != null ? retBaggage.hashCode() : 0);
        return result;
    }

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
