package com.epam.wizzair.driver;
import com.epam.wizzair.helper.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
//import com.epam.wizzair.helper.ProfilesIni;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class DriverSingleton {




    private static String driverType = Config.browser();

    private static WebDriver driver = null;

    private static Deque<String> windowStack = new LinkedList<>();

    private DriverSingleton() {

    }

    public static void setDriver(String driverType) {

        DriverSingleton.driverType = driverType;
    }


    public static WebDriver getDriver() {
        if (driver == null) {
            switch (driverType.toUpperCase()) {
                case "FIREFOX":
                    ProfilesIni profile = new ProfilesIni();
                    FirefoxProfile myprofile = profile.getProfile(Config.profile());
                    System.setProperty("webdriver.gecko.driver", Config.geckodriver());
                    driver = new FirefoxDriver(myprofile);
                    break;
                case "CHROME":
                    System.setProperty("webdriver.chrome.driver", Config.chromedriver());
                    driver = new ChromeDriver();
                    break;

                default:
                    driver = new FirefoxDriver();
                    break;

            }
            driver.manage().window().maximize();
            windowStack.push(driver.getWindowHandle());
            driver.manage().timeouts().implicitlyWait(Config.timeout(), TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(Config.timeout(), TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(Config.timeout(), TimeUnit.SECONDS);
        }
        return driver;
    }



    public static void openNewWindow(){
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(Keys.CONTROL + "n");

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        windowStack.push(driver.getWindowHandle());
    }

    public static void closeWidow(){
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(Keys.ALT, Keys.F4);
        windowStack.poll();
        driver.switchTo().window(windowStack.peek());
    }

    public static void open(String url){
        getDriver().get(url);
    }

    public static void quit(){
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }

    
}
