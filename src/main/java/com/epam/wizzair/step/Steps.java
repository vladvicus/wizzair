package com.epam.wizzair.step;
import org.openqa.selenium.WebDriver;

import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.page.MainPage;
import com.epam.wizzair.page.SearchResult;



public class Steps {

    private WebDriver driver;

    public void initBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void findFlight() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.createNewRoad("Riga", "Tel-Aviv", "13 Apr 2017", "13 Apr 2017");
    }
    
    public String getFirstPrice() {
    	SearchResult searchResult = new SearchResult(driver);
    	return searchResult.chooseFlights();
    }
    
    public String getSum() {
    	SearchResult searchResult = new SearchResult(driver);
    	return searchResult.getSum();
    }
    
    

}
