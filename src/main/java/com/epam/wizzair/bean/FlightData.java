package com.epam.wizzair.bean;

/**
 * Created by Dzmitry_Sankouski on 03-Mar-17.
 */
public class FlightData {
    String origin;
    String destination;
    int depDate;
    int retDate;

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
}
