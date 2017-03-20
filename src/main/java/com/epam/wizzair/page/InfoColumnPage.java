package com.epam.wizzair.page;

import com.epam.wizzair.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dzmitry_Sankouski on 14-Mar-17.
 */

public class InfoColumnPage {
    private static InfoColumnPage instance = new InfoColumnPage();

    private InfoColumnPage() {
    }

    public static InfoColumnPage getInstance() {
        return instance;
    }

    @FindBy(xpath = "//*[@id=\"booking-flow\"]/aside/div[2]")
    private WebElement infoContainer;

    //flight section
    @FindBy(xpath = "//div[contains(@class, 'step--flights')]")
    private WebElement flightsSection;

    @FindBy(xpath = "((//span[@class='flight-info__time'])[1]")
    private WebElement directTicketInfo;

    @FindBy(xpath = "((//span[@class='flight-info__time'])[2]")
    private WebElement returnTicketInfo;

    @FindBy(xpath = "(//span[@class='flight-info__stations'])[1]")
    private WebElement directTicketStations;

    @FindBy(xpath = "(//span[@class='flight-info__stations'])[2]")
    private WebElement returnTicketStations;

    @FindBy(xpath = "((//span[@class='flight-info__day'])[1]")
    private WebElement directTicketDay;

    @FindBy(xpath = "((//span[@class='flight-info__day'])[2]")
    private WebElement returnTicketDay;

    @FindBy(xpath = "(//span[@class='flight-info__month'])[1]")
    private WebElement directTicketMonth;

    @FindBy(xpath = "(//span[@class='flight-info__month'])[2]")
    private WebElement returnTicketMonth;


    public String getTotalPrice(){
        return totalPrice.getText().split("€")[1];
    }

    public String getDirectTicketDay(){
        return directTicketDay.getText();
    }

    public String getDirectTicketMonth(){
        return directTicketMonth.getText();
    }

    public String getReturnTicketDay(){
        return returnTicketDay.getText();
    }

    public String getReturnTicketMonth(){
        return returnTicketMonth.getText();
    }
    //------------end of Flight section

    //passengers section
    @FindBy(xpath = "//div[contains(@class,'step--passengers')]")
    private WebElement passengersSection;

    @FindBy(xpath = "//div[contains(@class,'passenger-names__content')]")
    private WebElement[] allPassengers;

    By passengerName = By.xpath("//div[@class=\"booking-flow__itinerary__passenger-names__content\"]");
    public String getPassengerFullName(){
        return DriverSingleton.getDriver().findElement(passengerName).getText();
    }

    public String[] getDepPassengerRawData(){
        List<WebElement> depPassengerRawData = DriverSingleton.getDriver().findElements(By.xpath("//*[@id=\"booking-flow\"]/aside/div[2]/div[2]/div[2]/div[1]/div[2]/ul/li"));
        if (depPassengerRawData == null){
            //todo throw exception
        }
        String[] result = new String[depPassengerRawData.size()];
        for (int i = 0; i < depPassengerRawData.size(); i++) {
            result[i] = depPassengerRawData.get(i).findElement(By.xpath("./span[1]")).getText() +
                    depPassengerRawData.get(i).findElement(By.xpath("./span[2]")).getText();
        }
        return result;
    }

    public String[] getRetPassengerRawData(){
        List<WebElement> retPassengerRawData = DriverSingleton.getDriver().findElements(By.xpath("//*[@id=\"booking-flow\"]/aside/div[2]/div[2]/div[2]/div[1]/div[3]/ul/li"));
        if (retPassengerRawData == null){
            //todo throw exception
        }
        String[] result = new String[retPassengerRawData.size()];
        for (int i = 0; i < retPassengerRawData.size(); i++) {
            result[i] = retPassengerRawData.get(i).findElement(By.xpath("./span[1]")).getText() +
            retPassengerRawData.get(i).findElement(By.xpath("./span[2]")).getText();
        }
        return result;
    }// data from booking info column

    //services section
    @FindBy(xpath = "//div[contains(@class,'step--services')]")
    private WebElement servicesSection;

    //payment section
    @FindBy(xpath = "//div[contains(@class,'step--payment')]")
    private WebElement paymentSection;

    //total section
    @FindBy(xpath = "//div[contains(@class,'total')]")
    private WebElement totalSection;

    @FindBy(xpath = "//div[contains(@class,'total')]/span")
    private WebElement totalPrice;

    public List<String> getPassengersNames(){
        List<String> passengerNames = new ArrayList<>();
        for (WebElement obj: allPassengers){
            passengerNames.add(obj.getText());
        }
        return passengerNames;
    }




}
