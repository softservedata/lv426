package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.SearchFilter;
import com.softserve.edu.opencart.data.SearchFilterRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.checkout.ConfirmOrder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.opencart.data.checkout.CheckOutRepository.FULL_TEST_ACC;
import static com.softserve.edu.opencart.pages.user.shop.UtilsForShoppingCart.Phones.IPHONE;
import static org.testng.Assert.assertEquals;

public class CheckOutTest extends UserTestRunner{


    @DataProvider
    public Object[][] searchData() {
        return new Object[][]{
                {SearchFilterRepository.searchIPhone(), UserRepository.get().getValidUserForCheckout(), IPHONE.getPhone()}

        };
    }

    @Test(dataProvider = "searchData")
    public void checkoutMainTest(SearchFilter searchFilter, IUser user, String orderName){
        ConfirmOrder confirmOrder = loadMaxApplication()
                .successfulSearch(searchFilter.getProduct())
                .addProductToCartByProductCriteriaComponent(searchFilter)
                .gotoCheckOutPage()
                .continueCheckout()
                .continueCheckoutWithRegistration()
                .accountAndBillingDetailsFilling(user)
                .setChooseDeliveryAccount(FULL_TEST_ACC)
                .deliveryMethodFullyComplete(user.getLastName())
                .paymentMethodFullyComplete(user.getPostCode());
                //.confirmCheckoutButtonClick();

        assertEquals(confirmOrder.listOrderInfo().getProductByNameConfirmOrderPage(orderName).getTotalFromConfirmPage()
                ,confirmOrder.listWithCashInfo().getCashSumByTitle("Sub-Total:").getPriceConfirmTable(),
                "Compare the total price of order and the sub total that must be equal");


    }
}
