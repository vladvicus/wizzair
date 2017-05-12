package com.epam.wizzair.page;

import com.epam.wizzair.bean.enumeration.BaggageCabinOptions;
import com.epam.wizzair.bean.enumeration.BaggageCheckedOptions;
import com.epam.wizzair.bean.enumeration.CheckInMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dzmitry_Sankouski on 06-Mar-17.
 */
public class Passenger extends AbstractPage {

    @FindBy(xpath = "//*[@id='passenger-baggages-outbound-0']")
    private WebElement departureContainer;

    @FindBy(xpath = "//*[@id='passenger-baggages-return-0']")
    private WebElement returnContainer;

    @FindBy(xpath = "//form[@name='passengers-form']")
    private WebElement passengerForm;

    @FindBy(id = "passengers-continue-btn")
    private WebElement nextPage;

    //---------------------seat selection buttons
    private By selectSeatButton = By.xpath(".//button[text()='Select seat']");

    //-----------------------checkin baggage radio buttons
    private By baggageNoneRB = By.xpath("//*[@id='passenger-0-outbound-checked-in-baggage-switch-option0']/following-sibling::label");
    private By baggageLightRB = By.xpath("//*[@id='passenger-0-outbound-checked-in-baggage-switch-option1']/following-sibling::label");
    private By baggageHeavyRB = By.xpath("//*[@id='passenger-0-outbound-checked-in-baggage-switch-option2']/following-sibling::label");


    public Passenger setCheckedInBaggage(BaggageCheckedOptions depOption) {
        switch (depOption){
            case NONE:
                departureContainer.findElement(baggageNoneRB).click();
                break;
            case LIGHT:
                departureContainer.findElement(baggageLightRB).click();
                break;
            case HEAVY:
                departureContainer.findElement(baggageHeavyRB).click();
        }
        return this;
    }

    public Passenger setCheckedInBaggage(BaggageCheckedOptions depOption, BaggageCheckedOptions retOption) {
        setCheckedInBaggage(depOption); // setting departure options

        switch (depOption){
            case NONE:
                returnContainer.findElement(baggageNoneRB).click();
                break;
            case LIGHT:
                returnContainer.findElement(baggageLightRB).click();

                break;
            case HEAVY:
                returnContainer.findElement(baggageHeavyRB).click();
        }
        return this;
    }

    //-----------------------cabin baggage radio buttons

    private By baggageSmallRB = By.xpath("//*[@id='passenger-0-outbound-cabin-baggage-switch-option0']/following-sibling::label");
    private By baggageLargeRB = By.xpath("//*[@id='passenger-0-outbound-cabin-baggage-switch-option1']/following-sibling::label");


    public Passenger setCabinBaggage(BaggageCabinOptions depOption) {
        switch (depOption){
            case SMALL:
                departureContainer.findElement(baggageSmallRB).click();
                break;
            case LARGE:
                departureContainer.findElement(baggageLargeRB).click();
                break;
        }
        return this;
    }

    public Passenger setCabinBaggage(BaggageCabinOptions depOption, BaggageCabinOptions retOption) {
        setCabinBaggage(depOption);// setting departure options

        switch (depOption){
            case SMALL:
                returnContainer.findElement(baggageSmallRB).click();
                break;
            case LARGE:
                returnContainer.findElement(baggageLargeRB).click();
                break;
        }
        return this;
    }

    //Sport Equipment locators
    private By sportEquipmentBtn = By.cssSelector("[class='nowrap'");
    private WebElement sportEquipmentDepBtn;
    private WebElement sportEquipmentRetBtn;

    //this locators home is sportEquipmentBtn
    private By input = By.xpath("//input[1]");
    private By labelEn = By.xpath("//label[1]/span[@class='button button--medium button--filled']");
    private By labelDis = By.xpath("//label[1]/class='button button--medium button--outlined button--breakable'");
    //-----------------------------------

    public boolean isDepSportEquipmentEn() {
        sportEquipmentDepBtn = departureContainer.findElement(sportEquipmentBtn);
        boolean result;
        result = sportEquipmentDepBtn.findElement(labelEn).getAttribute("style").isEmpty();
        return result;
    }

    public boolean isRetSportEquipmentEn() {
        sportEquipmentRetBtn = returnContainer.findElement(sportEquipmentBtn);
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

    private By online = By.xpath("//p[@class='option' and text()='Online']");
    private By airport = By.xpath("//p[@class='option' and text()='Airport']");
    public Passenger setCheckInMethod(CheckInMethod depMethod, CheckInMethod retMethod) {

        switch (retMethod){
            case ONLINE:
                returnContainer.findElement(online).click();
                break;
            case AIRPORT:
                returnContainer.findElement(airport).click();
                break;
        }
        return this;
    }

    public Passenger setCheckInMethod(CheckInMethod depMethod) {
        switch (depMethod){
            case ONLINE:
                departureContainer.findElement(online).click();
                break;
            case AIRPORT:
                departureContainer.findElement(airport).click();
                break;
        }
        return this;
    }

    public void gotoDepartureSeatSelection() {
        departureContainer.findElement(selectSeatButton).click();
    }

    public void gotoReturnSeatSelection() {
        returnContainer.findElement(selectSeatButton).click();
    }

    public void submit() {nextPage.click();}


    public void confirm(){
    }

}
