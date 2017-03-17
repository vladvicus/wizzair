package com.epam.wizzair.bean;

import com.epam.wizzair.page.util.BaggageCabinOptions;
import com.epam.wizzair.page.util.BaggageCheckedOptions;

/**
 * Created by Dzmitry_Sankouski on 10-Mar-17.
 */
public class Baggage {
    BaggageCabinOptions cabinBaggage;
    BaggageCheckedOptions checkedBaggage;
    boolean isSportEquipment;

    public Baggage(){

    }

    public BaggageCabinOptions getCabinBaggage() {
        return cabinBaggage;
    }

    public void setCabinBaggage(BaggageCabinOptions cabinBaggage) {
        this.cabinBaggage = cabinBaggage;
    }

    public BaggageCheckedOptions getCheckedBaggage() {
        return checkedBaggage;
    }

    public void setCheckedBaggage(BaggageCheckedOptions checkedBaggage) {
        this.checkedBaggage = checkedBaggage;
    }

    public boolean isSportEquipment() {
        return isSportEquipment;
    }

    public void setSportEquipment(boolean sportEquipment) {
        isSportEquipment = sportEquipment;
    }

    //todo equals&hashcode&toString


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Baggage baggage = (Baggage) o;

        if (isSportEquipment != baggage.isSportEquipment) return false;
        if (cabinBaggage != baggage.cabinBaggage) return false;
        return checkedBaggage == baggage.checkedBaggage;

    }

    @Override
    public int hashCode() {
        int result = cabinBaggage != null ? cabinBaggage.hashCode() : 0;
        result = 31 * result + (checkedBaggage != null ? checkedBaggage.hashCode() : 0);
        result = 31 * result + (isSportEquipment ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Baggage{" +
                "cabinBaggage=" + cabinBaggage +
                ", checkedBaggage=" + checkedBaggage +
                ", isSportEquipment=" + isSportEquipment +
                '}';
    }
}
