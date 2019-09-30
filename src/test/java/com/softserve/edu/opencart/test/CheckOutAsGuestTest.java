package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.SearchFilter;
import com.softserve.edu.opencart.data.SearchFilterRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.data.shop.DiscountUsageCode;
import com.softserve.edu.opencart.data.shop.ShopRepository;
import com.softserve.edu.opencart.pages.user.checkout.PaymentMethod;
import com.softserve.edu.opencart.pages.user.checkout.SuccessCheckOutPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckOutAsGuestTest extends UserTestRunner {

    @DataProvider
    public Object[][] searchData() {
        return new Object[][]{
                {SearchFilterRepository.searchMacBook(), UserRepository.get().getValidUserForCheckoutAsGuest(),
                SearchFilterRepository.searchNikon(), ShopRepository.builderCodesForCoupon()}

        };
    }

    @Test(dataProvider = "searchData")
    public void checkoutAsGuestFailTest(SearchFilter searchFilter, IUser user, SearchFilter searchNikon,
                                        DiscountUsageCode discountUsageCode) {
        PaymentMethod paymentMethodFail = loadMaxApplication()
                .successfulSearch(searchFilter)
                .addProductToCartByProductCriteriaComponent(searchFilter)
                .gotoCheckOutPage()
                .continueCheckout()
                .continueCheckoutAsGuestWithoutDeliveryMethod()
                .billingDetailsAsGuestPartFillingWithoutDelivery(user)
                .paymentMethodFailForGuest(user.getCity());

        assertEquals(paymentMethodFail.getTextFromFatalAlertInPaymentMethod(),
                "Warning: Payment method required!\n×",
                "There is must be no any payment method to choose");

        SuccessCheckOutPage order = paymentMethodFail.gotoHomePageFromPaymentMethod()
                .successfulSearch(searchNikon)
                .addProductToCartByProductCriteriaComponent(searchNikon)
                .gotoShoppingCartPage()
                .tryToChangeSomething()
                .useCouponClick()
                .couponCodeInputsAndApplying(discountUsageCode)
                .gotoCheckOutPage()
                .continueCheckout()
                .continueCheckoutAsGuestWithDeliveryMethod()
                .billingDetailsAsGuestPartFilling(user)
                .addNewAddressInDeliveryDetailsAsGuest()
                .deliveryMethodFullyComplete(searchFilter.getProduct().getDescription())
                .paymentMethodFullyCompleteForUser(searchNikon.getProduct().getDescription())
                .confirmCheckoutButtonClick();
        assertEquals(order.getCheckoutFinishedTitle(), "Your order has been placed!",
                "The checkout has not finished yet");
        assertEquals(order.getCheckoutFinishedBodyFirstLine(),"Your order has been successfully processed!",
                "The checkout has not finished yet");
    }

}

