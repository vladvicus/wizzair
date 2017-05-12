package com.epam.wizzair.page;

import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.helper.DriverConfig;
import com.epam.wizzair.bean.enumeration.PassengerSetting;
import com.epam.wizzair.page.exception.NotSignedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static com.epam.wizzair.driver.DriverSingleton.getDriver;

public class MainPage extends AbstractPage{

    private final static String PATH_DATE = "//div[@class='calendar']//td[@data-day='";
    private final static String PATH_CITY = "//strong[text()='";
    private final static String URL = "https://wizzair.com/en-gb/profile";

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

    @FindBy (xpath = "//*[text()='Flights & destinations']/following-sibling::ul//a[text()='Timetable']")
    private WebElement timetableButton;

    @FindBy(xpath = "//*[@class='cookie-policy__button']")
    private WebElement stickyBarButton;

    @FindBy(linkText = "Map")
    private WebElement mapButton;

    @FindBy(id = "search-passenger")
    private WebElement passengerField;

    @FindBy(xpath = "//span[text()='adult']/../following-sibling::button")
    private WebElement addAdultButton;

    @FindBy(xpath = "//span[text()='child']/../following-sibling::button")
    private WebElement addChildButton;

    @FindBy(xpath = "//span[text()='infant']/../following-sibling::button")
    private WebElement addInfantButton;

    public void openPage(){
        DriverSingleton.openNewWindowJS();
        getDriver().navigate().to(DriverConfig.urlMain());
    }

    public void closeWindow() {
        DriverSingleton.closeWindow();
    }

    public MainPage fillOrigin(String origin){
        inputOriginName.click();
        inputOriginName.clear();
        inputOriginName.sendKeys(origin);
        WebElement originCity = getDriver().findElement(By.xpath(PATH_CITY + origin + "']"));
        originCity.click();
        return this;
    }

    public MainPage fillDestination(String destination){
        wait.until(ExpectedConditions.elementToBeClickable(inputDestinationName));
        inputDestinationName.click();
        inputDestinationName.clear();
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

    public MainPage setPassenger(PassengerSetting passengerSetting, int numberOfPassengers) {
        int i = 0;
        do
        {
            switch (passengerSetting) {
                case ADULT:
                    numberOfPassengers=numberOfPassengers-1;
                    passengerField.click();
                    addAdultButton.click();
                    break;
                case CHILD:
                    passengerField.click();
                    addChildButton.click();
                    break;
                case INFANT:
                    passengerField.click();
                    addInfantButton.click();
                    break;
                case NO:
                    break;
            }
            i++;
        }
        while (i<=numberOfPassengers-1);
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

    public ProfilePage gotoProfile() throws NotSignedException {
        //note that variable loginButton is just 3rd in the container
        if(loginButton.getText().equalsIgnoreCase("sign in")){
            throw new NotSignedException();
        } else {
            DriverSingleton.getDriver().get(URL);
        }
        return new ProfilePage();
    }

    public MainPage servicesClick() {
        servicesButton.click();
        return this;
    }

    public TimetablePage timetableClick() {
        wait.until(ExpectedConditions.elementToBeClickable(timetableButton));
        timetableButton.click();
        return new TimetablePage();
    }

    public MapPage mapClick() {
        wait.until(ExpectedConditions.elementToBeClickable(mapButton));
        mapButton.click();
        return new MapPage();
    }

    public MainPage stickyBarClose() {

        if(stickyBarButton.isDisplayed()){
            stickyBarButton.click();
        }
        return this;
    }


}