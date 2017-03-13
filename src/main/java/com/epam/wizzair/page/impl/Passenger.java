package com.epam.wizzair.page.impl;

import com.epam.wizzair.page.IPassenger;
import com.epam.wizzair.page.exception.ElementNotActiveException;
import com.epam.wizzair.page.util.BaggageCabinOptions;
import com.epam.wizzair.page.util.BaggageCheckedOptions;
import com.epam.wizzair.page.util.CheckInMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dzmitry_Sankouski on 06-Mar-17.
 */
public class Passenger extends AbstractPage implements IPassenger {

    //locators
    @FindBy(xpath = "//*[@id=\"passenger-baggages-outbound-0\"]")
    WebElement depContainer;

    @FindBy(xpath = "//*[@id=\"passenger-baggages-return-0\"]")
    WebElement retContainer;

    @FindBy(xpath = "//*[@id=\"booking-flow-step-passengers\"]/div[1]/form")
    WebElement passengerForm;

    @FindBy(id = "passengers-continue-btn")
    WebElement nextPage;



//    @FindBy(xpath = "//*[@id=\"passenger-baggages-outbound-0\"]/div[2]/div[1]/div/div/div[1]")
//    WebElement depBaggageCheckInContainer;





    //--------------------sport equipment buttons
    By SportEquipment = By.xpath("//div[3]/div[1]/div[1]/div/div/div[2]/label");

    //---------------------seat selection button
    By seatSelection = By.xpath("//div[3]/div[2]/div/div/div/div/div/button");

    //-----------------------checkin baggage radio buttons
    //By baggageNoneRB = By.xpath("//*[@id=\"passenger-0-outbound-checked-in-baggage-switch-option0\"]");
    By baggageNoneRB = By.xpath("//p[contains(@class, 'baggage-switcher__switch__price') and text() = 'None']");
//    @FindBy(xpath = "//*[@id=\"passenger-0-outbound-checked-in-baggage-switch-option1\"]")
//            private WebElement baggageLightRB;
    By baggageLightRB = By.xpath("//*[@id=\"passenger-0-outbound-checked-in-baggage-switch-option1\"]");
    By baggageHeavyRB = By.xpath("//*[@id=\"passenger-0-outbound-checked-in-baggage-switch-option2\"]");
//    @FindBy(xpath = "//*[@id=\"passenger-0-outbound-checked-in-baggage-switch-option2\"]")
//            private WebElement baggageHeavyRB;


    //Actions actions = new Actions(getDriver());


    public Passenger() {

    }

    public Passenger setCheckedInBaggage(BaggageCheckedOptions depOption) {
        switch (depOption){
            case NONE:
                depContainer.findElement(baggageNoneRB).click();
                break;
            case LIGHT:
                depContainer.findElement(baggageLightRB).click();
                //actions.moveToElement(baggageLightRB).click();
                break;
            case HEAVY:
                depContainer.findElement(baggageHeavyRB).click();
                //actions.moveToElement(baggageHeavyRB).click();
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
                //actions.moveToElement(baggageLightRB).click();
                break;
            case HEAVY:
                retContainer.findElement(baggageHeavyRB).click();
                //actions.moveToElement(baggageHeavyRB).click();
        }
        return this;
    }

    //-----------------------cabin baggage radio buttons
    //By baggageSmallRB = By.xpath("//*[@id=\"passenger-0-outbound-cabin-baggage-switch-option0\"]");
    By baggageSmallRB = By.xpath("//p[contains(@class, 'baggage-switcher__switch__weight') and text() = 'Small']");
    By baggageLargeRB = By.xpath("//*[@id=\"passenger-0-outbound-cabin-baggage-switch-option1\"]");
//    @FindBy(xpath = "//*[@id=\"passenger-0-outbound-cabin-baggage-switch-option1\"]")
//    private WebElement baggageLargeRB;

    public Passenger setCabinBaggage(BaggageCabinOptions depOption) {

        switch (depOption){
            case SMALL:
                depContainer.findElement(baggageSmallRB).click();
                break;
            case LARGE:
                depContainer.findElement(baggageLargeRB).click();
                //actions.moveToElement(baggageLargeRB).click();
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
                //actions.moveToElement(baggageLargeRB).click();
                break;
        }

        return this;
    }

    //Sport Equipment locators
    By sportEquipmentBtn = By.xpath("//div[@class=\"booking-flow__passengers__sports-equipment-switch__button\"]");//todo refactor locator
    WebElement sportEquipmentDepBtn;
    WebElement sportEquipmentRetBtn;

    //this locators home is sportEquipmentBtn
    By input = By.xpath("//input[1]");
    By labelEn = By.xpath("//label[1]/span[@class=\"button button--medium button--filled\"]");
    By labelDis = By.xpath("//label[1]/class=\"button button--medium button--outlined button--breakable\"");
    //-----------------------------------


    public boolean isDepSportEquipmentEn() {
        sportEquipmentDepBtn = depContainer.findElement(sportEquipmentBtn);
        boolean result;
        result = sportEquipmentDepBtn.findElement(labelEn).getAttribute("style").isEmpty();
        return result;
    }

    public boolean isRetSportEquipmentEn() {
        sportEquipmentRetBtn = retContainer.findElement(sportEquipmentBtn);
        boolean result;
        result = sportEquipmentRetBtn.findElement(labelEn).getAttribute("style").isEmpty();
        return result;
    }

    public Passenger setSportEquipment(boolean isDepEnabled) {
        setSportEquipment(isDepEnabled, false);
        return this;
    }

    public Passenger setSportEquipment(boolean isDepEnabled, boolean isRetEnabled) {

        boolean actualDepState = isDepSportEquipmentEn();

        if (isDepEnabled^actualDepState){ // if actual XOR expected = true then click
            sportEquipmentDepBtn.click();
        }

        boolean actualRetState = isRetSportEquipmentEn();
        if (isRetSportEquipmentEn()^actualRetState){ // if actual XOR expected = true then click
            sportEquipmentRetBtn.click();
        }
        return this;
    }



    By online = By.xpath("//div[3]/div[1]/div[2]/div/div/div/label[1]");
    By airport = By.xpath("//div[3]/div[1]/div[2]/div/div/div/label[2]");
    public Passenger setCheckInMethod(CheckInMethod depMethod, CheckInMethod retMethod) {

        switch (retMethod){
            case ONLINE:
                retContainer.findElement(online).click();
                break;
            case AIRPORT:
                retContainer.findElement(airport).click();
                break;
        }

        return this;
    }

    public Passenger setCheckInMethod(CheckInMethod depMethod) {

        switch (depMethod){
            case ONLINE:
                depContainer.findElement(online).click();
                break;
            case AIRPORT:
                depContainer.findElement(airport).click();
                break;
        }

        return this;
    }

    public void gotoDepSeatSelection() {
        depContainer.findElement(seatSelection).click();
    }

    public void gotoRetSeatSelection() {
        retContainer.findElement(seatSelection).click();
    }

    public void submit() {nextPage.click();}


    public void confirm() throws ElementNotActiveException{

    }

    @Override
    public void openPage(){

    }
}
