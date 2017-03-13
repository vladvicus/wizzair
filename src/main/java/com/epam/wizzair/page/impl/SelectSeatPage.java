package com.epam.wizzair.page.impl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static com.epam.wizzair.driver.DriverSingleton.getDriver;

public class SelectSeatPage extends AbstractPage {

    public SelectSeatPage(){

    }

    @Override
    public void openPage() {

    }

    private WebDriverWait wait = new WebDriverWait(getDriver(), 5, 1000);

    //можно //a[text()='Continue']
    @FindBy(xpath = "//form[@name='seat-selection']//a[text()='Continue']")
    private WebElement continueButton;

   /* //first row seats (6 elements)
    @FindBy(xpath = "//div[@class='seat-map__group__row seat-map__group__row--1']//input")
    private WebElement[] firstRowSeats;*/


    //all seats in the plane (180 elements)
    @FindBy(xpath = "//div[@class='booking-flow__seat-map__map seat-map seat-map--selected-" +
            "group-false booking-flow__seat-map__map--320 seat-map--320']//input")
    private WebElement[] allSeats;


    //all unavailable seats in the plane
    @FindBy(xpath = "//div[@class='booking-flow__seat-map__map seat-map seat-map--selected-group-false" +
            " booking-flow__seat-map__map--320 seat-map--320']//input[@disabled]")
    private WebElement[] unavailableSeats;

    @FindBy(xpath = "//form[@name ='seat-selection']//button[@class = 'button button--medium button--filled' and text()='Continue' and @type = 'button']")
    private WebElement seatOriginContinue;


    @FindBy(xpath = "//form[@name ='seat-selection']//button[@class = 'button button--medium button--filled' and text()='Continue' and @type = 'submit']")
    private WebElement seatReturnContinue;


    public SelectSeatPage continueOrigin() {
        seatOriginContinue.click();
        return this;
    }


    public SelectSeatPage continueReturn() {

        wait.until(ExpectedConditions.elementToBeClickable(seatReturnContinue));

        seatReturnContinue.click();
        return this;

    }





    public void selectRandomAvailableSeat(){
        int numberOfAvailableSeats = getAllAvailableSeats().size();
        ArrayList<WebElement> availableSeatsList = getAllAvailableSeats();
        availableSeatsList.get(getRandomSeat(numberOfAvailableSeats)).click();
        continueButton.click();
    }

    //все доступные для выбора места в самолете
    private ArrayList<WebElement> getAllAvailableSeats(){
        ArrayList<WebElement> allSeatsList = new ArrayList<WebElement>(Arrays.asList(allSeats));
        ArrayList<WebElement> unavailableSeatsList = new ArrayList<WebElement>(Arrays.asList(unavailableSeats));
        allSeatsList.removeAll(unavailableSeatsList);
        return allSeatsList;
    }


    //можно будет перенести в класс утилит
    //генерация случайного числа из диапазона доступных мест
    private int getRandomSeat(int numberOfSeats) {
        Random rnd = new Random();
        return rnd.nextInt(numberOfSeats) + 1;
    }





}
