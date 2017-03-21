package com.epam.wizzair.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Random;

import static com.epam.wizzair.driver.DriverSingleton.getDriver;

/**
 * Created by Nadzeya_Parkhimovich on 21-Mar-17.
 */
public class MapPage extends AbstractPage {

    private WebDriverWait wait = new WebDriverWait(getDriver(), 5, 1000);

    @FindBy(xpath = "//div[@class='leaflet-marker-icon marker leaflet-zoom-animated leaflet-interactive']")
    private List<WebElement> cities;

    @FindBy(xpath = "//form[@name='flight-search']/fieldset/div/div[1]/div[@class='input-set__location input-set__location--hint']")
    private WebElement inputOriginName;

    @FindBy(xpath = "//form[@name='flight-search']/fieldset/div/div[3]/div[@class='input-set__location input-set__location--hint']")
    private WebElement inputDestinationName;

    @FindBy(xpath = "//form[@name='flight-search']//button[text()='Search']")
    private WebElement searchButton;

    public MapPage chooseFirstCity() {
        Random r = new Random();
        int i = r.nextInt(cities.size());
        cities.get(i).click();
        return this;
    }

    public MapPage chooseSecondCity() {
        Random r = new Random();
        cities.get(r.nextInt(cities.size())).click();
        return this;
    }

    public String getOriginName() {
        return inputOriginName.getText();
    }

    public String getDestinationName() {
        return inputDestinationName.getText();
    }

    public TimetablePage search() {
        searchButton.click();
        return new TimetablePage();
    }

}
