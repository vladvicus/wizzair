package com.epam.wizzair.page.impl;

import com.epam.wizzair.bean.PassengerData;
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


    @FindBy(xpath = "//*[@id=\"booking-flow\"]/aside/div[2]")
    WebElement infoContainer;

    //flight section
    @FindBy(xpath = "//*[@id=\"booking-flow\"]/aside/div[2]/div[contains(@class,'step--flights')]")
    WebElement flightsSection;

    By titleLoc = By.xpath("/div[@class=\"booking-flow__itinerary__step__title\"]");
    By contentLoc = By.xpath("/div[contains(@class, 'booking-flow__itinerary__step__content')]");


    //passengers section
    @FindBy(xpath = "//*[@id=\"booking-flow\"]/aside/div[2]/div[contains(@class,'step--passengers')]")
    WebElement passengersSection;

    @FindBy(xpath = "//*[@id=\"booking-flow\"]/aside/div[2]/div[contains(@class,'step--services')]")
    WebElement servicesSection;

    @FindBy(xpath = "//*[@id=\"booking-flow\"]/aside/div[2]/div[contains(@class,'step--payment')]")
    WebElement paymentSection;

    @FindBy(xpath = "//*[@id=\"booking-flow\"]/aside/div[2]/div[1]")
    WebElement totalSection;



    public PassengerData getPassengerData(){
        WebElement content;
        List<WebElement> data = new ArrayList<>();
        content = passengersSection.findElement(contentLoc);
        data = content.findElements(By.xpath("/div[1]/div[2]/ul/li"));

        data = content.findElements(By.xpath("/div[1]/div[3]/ul/li"));
//*[@id="booking-flow"]/aside/div[2]/div[2]/div[2]/div[1]/div[3]/ul
        return new PassengerData();
    }

}
