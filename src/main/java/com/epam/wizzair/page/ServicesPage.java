package com.epam.wizzair.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ServicesPage extends AbstractPage {

    public ServicesPage() {

    }

    @FindBy(id = "services-continue-btn")
    private WebElement nextPage;

    public ServicesPage continueToNextPage() {
        nextPage.click();
        return this;
    }

}
