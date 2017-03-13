package com.epam.wizzair.bean;

import java.util.Date;

/**
 * Created by Dzmitry_Sankouski on 03-Mar-17.
 */
public class FlightData {
    String origin;
    String destination;
    Date depDate;
    Date retDate;

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

    public Date getDepDate() {
        return depDate;
    }

    public void setDepDate(Date depDate) {
        this.depDate = depDate;
    }

    public Date getRetDate() {
        return retDate;
    }

    public void setRetDate(Date retDate) {
        this.retDate = retDate;
    }
}
