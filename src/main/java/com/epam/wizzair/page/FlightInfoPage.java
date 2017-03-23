package com.epam.wizzair.page;

import com.epam.wizzair.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dzmitry_Sankouski on 23-Mar-17.
 */
public class FlightInfoPage {
    @FindBy(xpath = "//[@data-test='itinerary-content']")
    WebElement data;

    ////////////////
//    @FindBy(xpath = "//ul[@class='itinerary__flights']")
    List<WebElement> flights;
//    ----------relative to flights paths
    By route = By.xpath(".//div[1]/div/span");
    By date = By.xpath(".//div[@class='flight-info__date']/span[1]");
    By dayOfWeek = By.xpath(".//div[@class='flight-info__date']/span[2]");
    ///////////////
//    @FindBy(xpath = "//ul[@class='itinerary__passengers']")
    List<WebElement> passengers;
//    ----------relative to passengers paths
    By passengerName = By.xpath(".//h3[@class='block__header__value']");
    By departurePassengerData = By.xpath(".//div[@class='block__content block__content--no-border-bottom ie-flex__itinerary-content-box']");
    By returnPassengerData = By.xpath(".//div[@class='block__content block__content--no-border-bottom ie-flex__itinerary-content-box']");
    //    ----------relative to *Data paths
    By bags = By.xpath(".//ul[@class='bags']");
    ///////////

    public FlightInfoPage(){
        flights = DriverSingleton.getDriver().findElements(By.xpath("//ul[@class='itinerary__flights']"));
        passengers = DriverSingleton.getDriver().findElements(By.xpath("//ul[@class='itinerary__passengers']"));
    }

    public String getRoute(){
        return flights.get(0).findElement(route).getText();
    }

    public String getDate(){
        return flights.get(0).findElement(date).getText();
    }

    public String getWeekDay(){
        return flights.get(0).findElement(dayOfWeek).getText();
    }

    public String getPassengerName(){
        return passengers.get(0).findElement(passengerName).getText();
    }

    public Set<String> getDepartureBaggageRawData(){
        List<WebElement> elements = passengers.get(0).findElement(departurePassengerData).findElements(bags);
        Set<String> result = new HashSet<>();
        for (WebElement element :
                elements) {
            result.add(element.getText());
        }
        return result;
    }

    public Set<String> getReturnBaggageRawData(){
        List<WebElement> elements = passengers.get(0).findElement(returnPassengerData).findElements(bags);
        Set<String> result = new HashSet<>();
        for (WebElement element :
                elements) {
            result.add(element.getText());
        }
        return result;
    }

}
