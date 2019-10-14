package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.data.shop.FinalPriceTableComponent;
import com.softserve.edu.opencart.pages.user.account.OrderDetailPage;
import com.softserve.edu.opencart.pages.user.account.OrderHistoryPage;
import com.softserve.edu.opencart.pages.user.account.ReturnOrderPage;
import com.softserve.edu.opencart.pages.user.account.SuccessfulReturnPage;
import com.softserve.edu.opencart.pages.user.adminpanel.AdminLoginPage;
import com.softserve.edu.opencart.pages.user.adminpanel.ReturnsPage;
import com.softserve.edu.opencart.pages.user.shop.ShoppingCartPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderHistoryTest extends UserTestRunner {

    private OrderHistoryPage orderHistoryPage;
    private static final String id = "2";

    @BeforeClass
    public void setUp() {
        IUser user = UserRepository.get().getRomanUser();
        orderHistoryPage = loadYuraApplication()
                .gotoLoginPage()
                .successfulLogin(user)
                .gotoOrderHistoryRight();
    }


    @Override
    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        orderHistoryPage  = loadOrderHistory();
    }

    @Test
    public void reorderTest() {
        OrderDetailPage orderDetailPage =
                orderHistoryPage.getOrdersTable().getOrderById(id)
                        .clickLookDetailButton().reorderButtonClick();
        ShoppingCartPage shoppingCartPage =
                orderDetailPage.gotoShoppingCartPage();
        Assert.assertFalse(
                shoppingCartPage.getFinalPriceTableComponentElements()
                        .isEmpty());


    }

    @Test
    public void returnTest() {
        ReturnOrderPage returnOrderPage =
                orderHistoryPage.getOrdersTable().getOrderById(id)
                        .clickLookDetailButton().returnButtonClick();

        SuccessfulReturnPage successfulReturnPage =
                returnOrderPage.clickSubmitButton();
        Assert.assertTrue(successfulReturnPage.isSuccessfulPage());

    }


}
