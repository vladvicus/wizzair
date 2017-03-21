package com.epam.wizzair.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

import static com.epam.wizzair.driver.DriverSingleton.getDriver;

public class SelectSeatPage extends AbstractPage {

    private WebDriverWait wait = new WebDriverWait(getDriver(), 5, 1000);

    /*@FindBy(xpath = "//form[@name='seat-selection']//a[text()='Continue']")
    private WebElement continueButton;*/

    /*@FindBy(xpath = "//form[@name ='seat-selection']//button[@class = 'button button--medium button--filled' and text()='Continue' and @type = 'button']")
    private WebElement seatOriginContinue;

    @FindBy(xpath = "//form[@name ='seat-selection']//button[@class = 'button button--medium button--filled' and text()='Continue' and @type = 'submit']")
    private WebElement seatReturnContinue;*/
    //all available seats in the plane

    @FindBy(xpath = "//div[@id='booking-flow-step-seat-selection']//input[not(@disabled)]/..")
    private List<WebElement> availableSeatsForclick;

    @FindBy(xpath = "//div[@id='booking-flow-step-seat-selection']//input[not(@disabled)]")
    private List<WebElement> availableSeatsForSearch;

    @FindBy(className = "booking-flow__seat-selection-flight__passenger__seat-designator")
    private WebElement selectedSeatNumber;

    @FindBy(xpath ="//a[@data-test='seat-selection-abort-x']")
    private WebElement closePageButton;

    @FindBy(xpath ="//a[text()='Save']")
    private WebElement saveResultButton;

    public String getSelectedSeatNumber() {
        return selectedSeatNumber.getText();
    }

    public boolean isSeatEnable(String seatNumber){
        for (WebElement seat: availableSeatsForSearch){
            if(seat.getAttribute("value").equals(seatNumber)){
                return true;
            }
        }
        return false;
    }

    public SelectSeatPage selectRandomAvailableSeat(){
        getRandomAvailableSeat().click();
        return this;
    }

    public SelectSeatPage clickClosePageButton(){
        closePageButton.click();
        return this;
    }

    public Passenger clickSaveResultButton(){
        saveResultButton.click();
        return new Passenger();
    }

    //selected random seat
    private WebElement getRandomAvailableSeat(){
        return availableSeatsForclick.get(getRandomNumber(getNumberOfAvailableSeats()));
    }

    //random number in the available range
    private int getRandomNumber(int numberOfSeats) {
        Random rnd = new Random();
        return rnd.nextInt(numberOfSeats) + 1;
    }

    //number of available seats in the plane
    private int getNumberOfAvailableSeats(){
        return availableSeatsForclick.size();
    }

    /*public SelectSeatPage continueOrigin() {
        seatOriginContinue.click();
        return this;
    }


    public SelectSeatPage continueReturn() {
        wait.until(ExpectedConditions.elementToBeClickable(seatReturnContinue));
        seatReturnContinue.click();
        return this;
    }*/

}
