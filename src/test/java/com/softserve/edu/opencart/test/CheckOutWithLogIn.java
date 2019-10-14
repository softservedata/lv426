package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.SearchFilter;
import com.softserve.edu.opencart.data.SearchFilterRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.data.checkout.CheckOutRepository;
import com.softserve.edu.opencart.pages.user.checkout.ConfirmOrder;
import com.softserve.edu.opencart.pages.user.checkout.SuccessCheckOutPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckOutWithLogIn extends UserTestRunner{

    @DataProvider
    public Object[][] searchData() {
        return new Object[][]{
                {SearchFilterRepository.searchIPhone(), UserRepository.get().getMaksymUser(),
                        CheckOutRepository.get().getSpecialTextForCheckOut()}

        };
    }

    @Test(dataProvider = "searchData")
    public void checkOutWithLogIn(SearchFilter searchFilter, IUser user,String specialText){
        ConfirmOrder confirmOrder = loadMaxApplication()
                .successfulSearch(searchFilter)
                .addProductToCartByProductCriteriaComponent(searchFilter)
                .gotoCheckOutPage()
                .continueCheckout()
                .loginAsUser(user)
                .billingDetailsUsingExistingAddress(user.getPostCode())
                .setChooseDeliveryAccount()
                .deliveryMethodFullyComplete(searchFilter.getProduct().getDescription())
                .paymentMethodFullyCompleteForUser(specialText);

        assertEquals(confirmOrder.listWithCashInfo().getCashSumByTitle("Flat Shipping Rate:").getPriceConfirmTable(),
                "$5.00", "The flat rate does not equal");
        assertEquals(confirmOrder.listWithCashInfo().getCashSumByTitle("Sub-Total:").getPriceConfirmTable(),
                "$101.00", "The sub total does not equal");
        assertEquals(confirmOrder.listWithCashInfo().getCashSumByTitle("Total:").getPriceConfirmTable(),
                "$106.00", "The total does not equal");
        SuccessCheckOutPage successCheckOutPage = confirmOrder.confirmCheckoutButtonClick();
        assertEquals(successCheckOutPage.getCheckoutFinishedBodyThirdLine(),
                "Thanks for shopping with us online!",
                "The order checkout was not successed");
        successCheckOutPage.clickCheckoutFinishedContinueButton();
    }


}
