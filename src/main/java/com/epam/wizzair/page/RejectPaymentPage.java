package com.epam.wizzair.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.wizzair.driver.DriverSingleton.getDriver;


public class RejectPaymentPage extends AbstractPage {

    private WebDriverWait wait = new WebDriverWait(getDriver(), 5, 1000);
    @FindBy(xpath = "//p[contains(text(),'It seems your bank rejected the payment.')]")
    private WebElement rejectMessage;


    public String getRejectMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(rejectMessage));
        return rejectMessage.getText();
    }

    public RejectPaymentPage() {
    }

}
