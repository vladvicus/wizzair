package com.epam.wizzair.bean;

import com.epam.wizzair.page.util.PassengerSetting;

/**
 * Created by Dzmitry_Sankouski on 03-Mar-17.
 */
public class FlightData {
    String origin;
    String destination;
    int depDate;
    int retDate;
    PassengerSetting passenger;
    int numberOfPassengers;

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

    @Override
    public String toString() {
        return "FlightData{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", depDate=" + depDate +
                ", retDate=" + retDate +
                ", passenger=" + passenger +
                ", numberOfPassengers=" + numberOfPassengers +
                '}';
    }
}
