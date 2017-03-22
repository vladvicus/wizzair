package com.epam.wizzair.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.epam.wizzair.driver.DriverSingleton.getDriver;


public class SearchResult extends AbstractPage {

    private WebDriverWait wait = new WebDriverWait(getDriver(), 10, 5000);

    private final String RETURN_DATE = "//div[@id=\"fare-selector-return\"]//time[@class=\"booking-flow__flight-select__chart__day__number title title--2\" and text()[contains(.,'";

    @FindBy(xpath = "//*[@id='fare-selector-outbound']//div[@class = 'fare__price']")
    private WebElement firstFlight;

    @FindBy(xpath = "//*[@id='fare-selector-return']//div[@class = 'fare__price']")
    private WebElement secondFlight;

    @FindBy(xpath = "//div[@class='booking-flow__itinerary__total__price']")
    private WebElement totalPrice;

    @FindBy(id = "flight-select-continue-btn")
    private WebElement nextPage;

    @FindBy(css = "[class=\"booking-flow__flight-select__chart\"")
    private List<WebElement> bookingChart;

    @FindBy (css = "[class=\"booking-flow__flight-select__chart__day__label booking-flow__flight-select__chart__day__label--selectable\"")
    private List<WebElement> selectableFlights;

    @FindBy(xpath = "//div[@id=\"fare-selector-return\"]//i[@class=\"icon icon__arrow--toleft--pink\"]")
    private WebElement returnToPreviousFlight;

    @FindBy(xpath = "//div[@id=\"fare-selector-return\"]" +
            "//*[@class=\"booking-flow__flight-select__chart__day__label booking-flow__flight-select__chart__day__label--selectable\"]")
    private List<WebElement> selectableReturnFlights;

    public SearchResult(){

    }

    public String chooseFirstFlight() {

        String firstFlightPrice = firstFlight.getText();
        firstFlight.click();
        return firstFlightPrice;
    }
    public String chooseSecondFlight() {
        String secondFlightPrice = secondFlight.getText();
        secondFlight.click();
        return secondFlightPrice;
    }

    public void chooseWrongFlight(int date) {
        wait.until(ExpectedConditions.visibilityOf(returnToPreviousFlight));
        returnToPreviousFlight.click();
        wait.until(ExpectedConditions.visibilityOf(returnToPreviousFlight));
        returnToPreviousFlight.click();
        WebElement book_date = getDriver().findElement(By.xpath(RETURN_DATE + date + "')]]"));
        book_date.click();
    }


    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public void continueToNextPage() {
        nextPage.click();
    }

}
