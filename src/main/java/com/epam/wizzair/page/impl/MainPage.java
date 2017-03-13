package com.epam.wizzair.page.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.wizzair.driver.DriverSingleton.getDriver;

public class MainPage extends AbstractPage{

    private WebDriverWait wait = new WebDriverWait(getDriver(), 5, 1000);

    private final String BASE_URL = "https://wizzair.com/en-gb/main-page#/";

    private final String PATH_DATE = "//div[@class='calendar']//td[@data-day='";
    private final String PATH_CITY = "//strong[text()='";

    @FindBy(id= "search-departure-station")
    private WebElement inputOriginName;

    @FindBy(id = "search-arrival-station")
    private WebElement inputDestinationName;

    @FindBy(xpath = "//*[@id='search-departure-date']")
    private WebElement departureDateName;

    @FindBy(xpath = "//*[@id='search-return-date']")
    private WebElement returnDateName;

    @FindBy(xpath = "//form[@name='flight-search']//button[text()='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//ul[@class='navigation__container']/li[3]")
    private WebElement loginButton;

    @FindBy(xpath = "//ul[@class='navigation__container']/li[1]")
    private WebElement servicesButton;

    @FindBy(linkText = "Timetable")
    private WebElement timetableButton;

    @FindBy(css = "[class=\"cookie-policy__button\"")
    private WebElement stickyBar;

    public MainPage(){
    }

    @Override
    public void openPage(){
        getDriver().navigate().to(BASE_URL);
    }


    public MainPage fillOrigin(String origin){

        inputOriginName.click();
        inputOriginName.sendKeys(origin);
        WebElement originCity = getDriver().findElement(By.xpath(PATH_CITY + origin + "']"));
        originCity.click();
        return this;
    }

    public MainPage fillDestination(String destination){

        wait.until(ExpectedConditions.elementToBeClickable(inputDestinationName));
        inputDestinationName.click();
        inputDestinationName.sendKeys(destination);
        WebElement destinationCity = getDriver().findElement(By.xpath(PATH_CITY + destination + "']"));
        destinationCity.click();
        return this;
    }

    public MainPage fillDepartureDate(int day) {
        departureDateName.click();
        WebElement calendarDepartureDate = getDriver().findElement(By.xpath(PATH_DATE + day + "']"));
        calendarDepartureDate.click();
        return this;
    }

    public MainPage fillReturnDate(int day) {
        returnDateName.click();
        WebElement calendarReturnDate = getDriver().findElement(By.xpath(PATH_DATE + day + "']"));
        calendarReturnDate.click();
        return this;
    }

    public SearchResult search() {
        searchButton.click();
        return new SearchResult();
    }

    public LoginPage signIn(){

        loginButton.click();
        return new LoginPage();
    }

    public void servicesClick() {
        servicesButton.click();
    }

    public void timetableClick() {
        wait.until(ExpectedConditions.elementToBeClickable(timetableButton));
        timetableButton.click();
    }

    public MainPage stickyBarClose() {

        if(stickyBar.isDisplayed()){
            stickyBar.click();
        }
        return this;
    }



}