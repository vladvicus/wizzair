package com.epam.wizzair.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Random;

public class MapPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='leaflet-marker-icon marker leaflet-zoom-animated leaflet-interactive']")
    private List<WebElement> cities;

    @FindBy(xpath = "//input[@placeholder='Origin']/preceding-sibling::div")
    private WebElement inputOriginName;

    @FindBy(xpath = "//input[@placeholder='Destination']/preceding-sibling::div")
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
