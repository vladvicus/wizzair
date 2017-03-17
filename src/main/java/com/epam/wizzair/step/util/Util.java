package com.epam.wizzair.step.util;

import com.epam.wizzair.bean.PassengerData;
import com.epam.wizzair.page.util.BaggageCabinOptions;
import com.epam.wizzair.page.util.BaggageCheckedOptions;
import com.epam.wizzair.page.util.CheckInMethod;

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

    public static void parseAndFill(String s, PassengerData result, boolean isDepSection){
        if(s.contains("checked-in bag")){
            Pattern pattern = Pattern.compile("[lightheavynoneLHN]{4,5}");
            Matcher matcher = pattern.matcher(s);
            matcher.find();

            if (isDepSection){
                result.getDepBaggage().setCheckedBaggage(BaggageCheckedOptions.valueOf(matcher.group(0).toUpperCase()));
            } else {
                result.getRetBaggage().setCheckedBaggage(BaggageCheckedOptions.valueOf(matcher.group(0).toUpperCase()));
            }
            return;
        } if (s.contains("cabin bag")){
            Pattern pattern = Pattern.compile("[smalllargeSL]{5}");
            Matcher matcher = pattern.matcher(s);
            matcher.find();

            if (isDepSection){
                result.getDepBaggage().setCabinBaggage(BaggageCabinOptions.valueOf(matcher.group(0).toUpperCase()));
            } else {
                result.getRetBaggage().setCabinBaggage(BaggageCabinOptions.valueOf(matcher.group(0).toUpperCase()));
            }
            return;
        } if (s.contains("Sports equipment")){
            if(isDepSection){
                result.getDepBaggage().setSportEquipment(true);
            }else {
                result.getRetBaggage().setSportEquipment(true);
            }
            return;
        } if (s.contains("check-in")){
            Pattern pattern = Pattern.compile("[onlineairportOA]{6,7}");
            Matcher matcher = pattern.matcher(s);
            matcher.find();
            if (isDepSection){
                result.setDepCheckinMethod(CheckInMethod.valueOf(matcher.group(0).toUpperCase()));
            } else {
                result.setRetCheckinMethod(CheckInMethod.valueOf(matcher.group(0).toUpperCase()));
            }
            return;
        }
    }

}
