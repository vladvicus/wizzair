package com.epam.wizzair.step;

import com.epam.wizzair.page.WizzDiscountPage;

/**
 * Created by Dzmitry_Sankouski on 13-Mar-17.
 */
public class StepsForWizzairDiscount {
    WizzDiscountPage discountPage = new WizzDiscountPage();

    public StepsForPaymentPage continueToNextPage(){
        discountPage.declineOffer();
        return new StepsForPaymentPage();
    }

}
