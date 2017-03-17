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
    public String toString() {
        return "Baggage{" +
                "cabinBaggage=" + cabinBaggage +
                ", checkedBaggage=" + checkedBaggage +
                ", isSportEquipment=" + isSportEquipment +
                '}';
    }
}
