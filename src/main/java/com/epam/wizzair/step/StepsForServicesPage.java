package com.epam.wizzair.step;

import com.epam.wizzair.page.ServicesPage;

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
