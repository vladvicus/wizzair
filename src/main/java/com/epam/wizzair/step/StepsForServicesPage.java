package com.epam.wizzair.step;

import com.epam.wizzair.page.ServicesPage;

/**
 * Created by Dzmitry_Sankouski on 13-Mar-17.
 */
public class StepsForServicesPage {
    private ServicesPage servicesPage = new ServicesPage();

    public StepsForWizzairDiscount submitServices(){
        servicesPage.continueToNextPage();
        return new StepsForWizzairDiscount();
    }

}
