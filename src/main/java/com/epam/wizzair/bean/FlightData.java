package com.epam.wizzair.bean;

import com.epam.wizzair.bean.enumeration.PassengerSetting;

/**
 * Created by Dzmitry_Sankouski on 03-Mar-17.
 */
public class FlightData {
    private String origin;
    private String destination;
    private int depDate;
    private int retDate;
    private PassengerSetting passenger;
    private int numberOfPassengers;
    private String month;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDepDate() {
        return depDate;
    }

    public void setDepDate(int depDate) {
        this.depDate = depDate;
    }

    public int getRetDate() {
        return retDate;
    }

    public void setRetDate(int retDate) {
        this.retDate = retDate;
    }

    public PassengerSetting getPassenger() {return passenger;}

    public void setPassenger(PassengerSetting passenger) {this.passenger=passenger;}

    public int getNumberOfPassengers() {return numberOfPassengers;}

    public void setNumberOfPassengers(int numberOfPassengers) {this.numberOfPassengers=numberOfPassengers;}

    public String getMonth() {return month;}

    public void setMonth(String month) {this.month = month;}

    @Override
    public String toString() {
        return "FlightData{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", depDate=" + depDate +
                ", retDate=" + retDate +
                ", passenger=" + passenger +
                ", numberOfPassengers=" + numberOfPassengers +
                ", month=" + month +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightData that = (FlightData) o;

        if (depDate != that.depDate) return false;
        if (retDate != that.retDate) return false;
        if (numberOfPassengers != that.numberOfPassengers) return false;
        if (origin != null ? !origin.equals(that.origin) : that.origin != null) return false;
        if (destination != null ? !destination.equals(that.destination) : that.destination != null) return false;
        if (month != null ? !month.equals(that.month) : that.month != null) return false;
        return passenger == that.passenger;
    }

    @Override
    public int hashCode() {
        int result = origin != null ? origin.hashCode() : 0;
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + depDate;
        result = 31 * result + retDate;
        result = 31 * result + (passenger != null ? passenger.hashCode() : 0);
        result = 31 * result + numberOfPassengers;
        result = 31 * result + (month!= null ? month.hashCode() : 0);
        return result;
    }
}
