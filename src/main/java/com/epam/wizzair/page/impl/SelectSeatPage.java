package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SelectSeatPage extends AbstractPage{

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


    public SelectSeatPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {

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
