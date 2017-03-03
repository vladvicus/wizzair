package com.epam.wizzair.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {

    private static WebDriver driver;
    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_DRIVER_EXE_PATH = "D:\\chromedriver.exe";

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_EXE_PATH);
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

    
}
