package com.epam.wizzair.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class RejectPaymentPage extends AbstractPage {

    @FindBy(xpath = "//p[contains(text(),'It seems your bank rejected the payment.')]")
    private WebElement rejectMessage;


    public String getRejectMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(rejectMessage));
        return rejectMessage.getText();
    }

}
