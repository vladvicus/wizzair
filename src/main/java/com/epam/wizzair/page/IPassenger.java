package com.epam.wizzair.page;

import com.epam.wizzair.page.exception.ElementNotActiveException;
import com.epam.wizzair.page.impl.Passenger;
import com.epam.wizzair.page.util.BaggageCabinOptions;
import com.epam.wizzair.page.util.BaggageCheckedOptions;

/**
 * Created by Dzmitry_Sankouski on 06-Mar-17.
 */
public interface IPassenger {

    public Passenger setCheckedInBaggage(BaggageCheckedOptions depOption);

    public Passenger setCheckedInBaggage(BaggageCheckedOptions depOption, BaggageCheckedOptions retOption);

    public Passenger setCabinBaggage(BaggageCabinOptions depOption);

    public Passenger setCabinBaggage(BaggageCabinOptions depOption, BaggageCabinOptions retOption);

    public Passenger setSportEquipment(boolean isDepEnabled, boolean isRetEnabled);

    public Passenger setSportEquipment(boolean isDepEnabled);

    public Passenger setCheckInMethod(boolean isDepOnline, boolean isRetOnline);

    public Passenger setCheckInMethod(boolean isDepOnline);

    public void gotoDepSeatSelection();

    public void gotoRetSeatSelection();

    public void confirm() throws ElementNotActiveException;

}
