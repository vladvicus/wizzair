package com.epam.wizzair.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.epam.wizzair.driver.DriverSingleton.getDriver;


public class SearchResult extends AbstractPage {

    private final static String RETURN_DATE = "//div[@id='fare-selector-return']//time[@class='booking-flow__flight-select__chart__day__number title title--2' and text()[contains(.,'";

    @FindBy(xpath = "//*[@id='fare-selector-outbound']//div[@class = 'fare__price']")
    private WebElement firstFlight;

    @FindBy(xpath = "//*[@id='fare-selector-return']//div[@class = 'fare__price']")
    private WebElement secondFlight;

    @FindBy(xpath = "//div[@class='booking-flow__itinerary__total__price']")
    private WebElement totalPrice;

    @FindBy(id = "flight-select-continue-btn")
    private WebElement nextPage;

    @FindBy(css = "[class='booking-flow__flight-select__chart'")
    private List<WebElement> bookingChart;

    @FindBy (css = "[class='booking-flow__flight-select__chart__day__label booking-flow__flight-select__chart__day__label--selectable'")
    private List<WebElement> selectableFlights;

    @FindBy(xpath = "//div[@id='fare-selector-return']//i[@class='icon icon__arrow--toleft--pink']")
    private WebElement returnToPreviousFlight;

    @FindBy(xpath = "//div[@id='fare-selector-return']" +
            "//*[@class='booking-flow__flight-select__chart__day__label booking-flow__flight-select__chart__day__label--selectable']")
    private List<WebElement> selectableReturnFlights;

    @FindBy(css = "[class='booking-flow__prices-table__content__column booking-flow__" +
            "prices-table__content__column--price booking-flow__prices-table__content__column--basic booking-flow__prices-table__content__column--disabled'")
    private WebElement disabledSecondFlight;

    public String chooseFirstFlight() {
        firstFlight.click();
        return firstFlight.getText();
    }

    public String chooseSecondFlight() {
        secondFlight.click();
        return secondFlight.getText();
    }

    public void chooseWrongFlight(int date) {
        wait.until(ExpectedConditions.visibilityOf(returnToPreviousFlight));
        returnToPreviousFlight.click();
        wait.until(ExpectedConditions.visibilityOf(returnToPreviousFlight));
        returnToPreviousFlight.click();
        WebElement bookDate = getDriver().findElement(By.xpath(RETURN_DATE + date + "')]]"));
        firstFlight.click();
        bookDate.click();
        try {
            disabledSecondFlight.isDisplayed();
        }
        catch (NoSuchElementException e) {
           // System.out.println("Element which covers secondFlight element cannot be located");
        }
    }


    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public void continueToNextPage() {
        nextPage.click();
    }

    public boolean isButtonEnabled() {
        return nextPage.isEnabled();
    }

}
