package com.epam.wizzair.page.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.wizzair.driver.DriverSingleton.getDriver;

/**
 * Created by Nadzeya_Parkhimovich on 13-Mar-17.
 */
public class TimetablePage extends AbstractPage {

    private WebDriverWait wait = new WebDriverWait(getDriver(), 5, 1000);
    private final String URL = "https://wizzair.com/en-gb/information-and-services/destinations/timetable#/";
    private final String CITY = "//strong[text()='";

    @FindBy(id= "search-departure-station")
    private WebElement inputOriginName;

    @FindBy(id = "search-arrival-station")
    private WebElement inputDestinationName;

    @FindBy(xpath = "//div[@class='fare-finder__sidebar__submit']/button[text()='Search']")
    private WebElement searchButton;

    public TimetablePage(){

    }

    @Override
    public void openPage() {
        getDriver().navigate().to(URL);
    }

    public TimetablePage fillOrigin(String origin){
        wait.until(ExpectedConditions.elementToBeClickable(inputOriginName));
        inputOriginName.click();
        inputOriginName.sendKeys(origin);
        WebElement originCity = getDriver().findElement(By.xpath(CITY + origin + "']"));
        originCity.click();
        return this;
    }

    public TimetablePage fillDestination(String destination){

        wait.until(ExpectedConditions.elementToBeClickable(inputDestinationName));
        inputDestinationName.click();
        inputDestinationName.sendKeys(destination);
        WebElement destinationCity = getDriver().findElement(By.xpath(CITY + destination + "']"));
        destinationCity.click();
        return this;
    }

    public TimetablePage search() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        return this;
    }
}
