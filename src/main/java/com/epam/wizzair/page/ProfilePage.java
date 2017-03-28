package com.epam.wizzair.page;

import com.epam.wizzair.bean.FlightData;
import com.epam.wizzair.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Dzmitry_Sankouski on 23-Mar-17.
 */
public class ProfilePage {

//    @FindBy(xpath = "//li[@class='trip-list__item']")
    List<WebElement> flights;

    By details = By.xpath(".//a[text()='Details']");

    public FlightInfoPage gotoFlightInfo(){
        flights = DriverSingleton.getDriver().findElements(By.xpath("//li[@class='trip-list__item']"));
        System.out.println(flights.size());
        flights.get(0)
                .findElement(details)
                .click();
        return new FlightInfoPage();
    }

    public FlightInfoPage gotoFlightInfo(int position){
        flights.get(position).findElement(details).click();
        return new FlightInfoPage();
    }


}
