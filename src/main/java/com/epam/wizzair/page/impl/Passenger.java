package com.epam.wizzair.page.impl;

import com.epam.wizzair.page.IPassenger;
import com.epam.wizzair.page.exception.ElementNotActiveException;
import com.epam.wizzair.page.util.BaggageCabinOptions;
import com.epam.wizzair.page.util.BaggageCheckedOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dzmitry_Sankouski on 06-Mar-17.
 */
public class Passenger implements IPassenger {

    //locators
    @FindBy(xpath = "//*[@id=\"passenger-baggages-outbound-0\"]")
    WebElement depContainer;

    @FindBy(xpath = "//*[@id=\"passenger-baggages-return-0\"]")
    WebElement retContainer;

    @FindBy(xpath = "//*[@id=\"booking-flow-step-passengers\"]/div[1]/form")
    WebElement passengerForm;

//    @FindBy(xpath = "//*[@id=\"passenger-baggages-outbound-0\"]/div[2]/div[1]/div/div/div[1]")
//    WebElement depBaggageCheckInContainer;


//-----------------------checkin baggage radio buttons
    By baggageNoneRB = By.xpath("//*[@id=\"passenger-0-outbound-checked-in-baggage-switch-option0\"]");
    By baggageLightRB = By.xpath("//*[@id=\"passenger-0-outbound-checked-in-baggage-switch-option1\"]");
    By baggageHeavyRB = By.xpath("//*[@id=\"passenger-0-outbound-checked-in-baggage-switch-option2\"]");

//-----------------------cabin baggage radio buttons
    By baggageSmallRB = By.xpath("//*[@id=\"passenger-0-outbound-cabin-baggage-switch-option0\"]");
    By baggageLargeRB = By.xpath("//*[@id=\"passenger-0-outbound-cabin-baggage-switch-option1\"]");

    //--------------------sport equipment buttons
    By SportEquipment = By.xpath("//div[3]/div[1]/div[1]/div/div/div[2]/label");

    //---------------------seat selection button
    By seatSelection = By.xpath("//div[3]/div[2]/div/div/div/div/div/button");


//    @FindBy(xpath = "//*[@id=\"passenger-0-outbound-checked-in-baggage-switch-option0\"]")
//    WebElement baggageNoneRB; //RB - radio button
//
//    @FindBy(xpath = "//*[@id=\"passenger-0-outbound-checked-in-baggage-switch-option1\"]")
//    WebElement baggageLightRB; //RB - radio button
//
//    @FindBy(xpath = "//*[@id=\"passenger-0-outbound-checked-in-baggage-switch-option2\"]")
//    WebElement baggageHeavyRB; //RB - radio button

    public Passenger setCheckedInBaggage(BaggageCheckedOptions depOption) {
        switch (depOption){
            case NONE:
                depContainer.findElement(baggageNoneRB).click();
                break;
            case LIGHT:
                depContainer.findElement(baggageLightRB).click();
                break;
            case HEAVY:
                depContainer.findElement(baggageHeavyRB).click();
        }

        return this;
    }

    public Passenger setCheckedInBaggage(BaggageCheckedOptions depOption, BaggageCheckedOptions retOption) {
        setCheckedInBaggage(depOption); // setting departure options

        switch (depOption){
            case NONE:
                retContainer.findElement(baggageNoneRB).click();
                break;
            case LIGHT:
                retContainer.findElement(baggageLightRB).click();
                break;
            case HEAVY:
                retContainer.findElement(baggageHeavyRB).click();
        }
        return this;
    }

    public Passenger setCabinBaggage(BaggageCabinOptions depOption) {

        switch (depOption){
            case SMALL:
                depContainer.findElement(baggageSmallRB).click();
                break;
            case LARGE:
                depContainer.findElement(baggageLargeRB).click();
                break;
        }

        return this;
    }

    public Passenger setCabinBaggage(BaggageCabinOptions depOption, BaggageCabinOptions retOption) {
        setCabinBaggage(depOption);// setting departure options

        switch (depOption){
            case SMALL:
                retContainer.findElement(baggageSmallRB).click();
                break;
            case LARGE:
                retContainer.findElement(baggageLargeRB).click();
                break;
        }

        return this;
    }

    public Passenger setSportEquipment(boolean isDepEnabled) {

        if (isDepEnabled = true){
            //Todo check if button already enabled
        }

        return this;
    }

    public Passenger setSportEquipment(boolean isDepEnabled, boolean isRetEnabled) {


        return this;
    }


    public Passenger setCheckInMethod(boolean isDepOnline, boolean isRetOnline) {
        return this;
    }

    public Passenger setCheckInMethod(boolean isDepOnline) {
        return this;
    }

    public void gotoDepSeatSelection() {
        depContainer.findElement(seatSelection).click();
    }

    public void gotoRetSeatSelection() {
        retContainer.findElement(seatSelection).click();
    }

    public void confirm() throws ElementNotActiveException{

    }
}
