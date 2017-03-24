package com.epam.wizzair.step.util;

import com.epam.wizzair.bean.PassengerData;
import com.epam.wizzair.bean.enumeration.BaggageCabinOptions;
import com.epam.wizzair.bean.enumeration.BaggageCheckedOptions;
import com.epam.wizzair.bean.enumeration.CheckInMethod;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dzmitry_Sankouski on 17-Mar-17.
 */
public class Util {

    public static void fillNonMentionedWithDefaults(PassengerData result) {
        if(result.getDepBaggage().getCheckedBaggage() == null){
            result.getDepBaggage().setCheckedBaggage(BaggageCheckedOptions.NONE);
        }

//        if (result.getDepBaggage().isSportEquipment() == null)//todo smthng about it
        if (result.getRetBaggage().getCheckedBaggage() == null){
            result.getRetBaggage().setCheckedBaggage(BaggageCheckedOptions.NONE);
        }

    }

    public static void parseAndFillPassenger(String s, PassengerData result, boolean isDepSection){
        if(s.contains("checked-in bag")){
            fillCheckedBaggage(s, result, isDepSection);
            return;
        } if (s.contains("cabin bag")){
            fillCabinBaggage(s, result, isDepSection);
            return;
        } if (s.contains("Sports equipment")){
            fillSportEquipment(result, isDepSection);
            return;
        } if (s.contains("check-in")){
            fillCheckInMethod(s, result, isDepSection);
            return;
        }
    }

    private static void fillCheckInMethod(String s, PassengerData result, boolean isDepSection) {
        Pattern pattern = Pattern.compile("[onlineairportOA]{6,7}");//pattern for searching checkIn method
        Matcher matcher = pattern.matcher(s);
        matcher.find();
        if (isDepSection){
            result.setDepCheckinMethod(CheckInMethod.valueOf(matcher.group(0).toUpperCase()));
        } else {
            result.setRetCheckinMethod(CheckInMethod.valueOf(matcher.group(0).toUpperCase()));
        }
    }

    private static void fillSportEquipment(PassengerData result, boolean isDepSection) {
        if(isDepSection){
            result.getDepBaggage().setSportEquipment(true);
        }else {
            result.getRetBaggage().setSportEquipment(true);
        }
    }

    private static void fillCabinBaggage(String s, PassengerData result, boolean isDepSection) {
        Pattern pattern = Pattern.compile("[smalllargeSL]{5}");//pattern for searching baggage type
        Matcher matcher = pattern.matcher(s);
        matcher.find();

        if (isDepSection){
            result.getDepBaggage().setCabinBaggage(BaggageCabinOptions.valueOf(matcher.group(0).toUpperCase()));
        } else {
            result.getRetBaggage().setCabinBaggage(BaggageCabinOptions.valueOf(matcher.group(0).toUpperCase()));
        }
    }

    private static void fillCheckedBaggage(String s, PassengerData result, boolean isDepSection) {
        Pattern pattern = Pattern.compile("[lightheavynoneLHN]{4,5}");//pattern for searching baggage type
        Matcher matcher = pattern.matcher(s);
        matcher.find();

        if (isDepSection){
            result.getDepBaggage().setCheckedBaggage(BaggageCheckedOptions.valueOf(matcher.group(0).toUpperCase()));
        } else {
            result.getRetBaggage().setCheckedBaggage(BaggageCheckedOptions.valueOf(matcher.group(0).toUpperCase()));
        }
    }


}
