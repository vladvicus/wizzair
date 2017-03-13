package com.epam.wizzair.step.impl;

import com.epam.wizzair.driver.DriverSingleton;
import com.epam.wizzair.page.impl.ServicesPage;

/**
 * Created by Dzmitry_Sankouski on 13-Mar-17.
 */
public class StepsForServicesPage {
    ServicesPage servicesPage = new ServicesPage();

    public StepsForWizzairDiscount submit(){
        servicesPage.continueToNextPage();
        return new StepsForWizzairDiscount();
    }

}
