package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.account.OrderHistoryPage;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderHistoryTest extends UserTestRunner {

    private OrderHistoryPage orderHistoryPage;
    @BeforeClass
    public void setUp() {
        IUser user = UserRepository.get().getRomanUser();
        orderHistoryPage = loadYuraApplication()
                .gotoLoginPage()
                .successfulLogin(user)
                .gotoOrderHistoryRight();
    }

    @AfterClass
    public void finish() {
        driver.quit();
    }

    @Override
    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        //  addressBookPage = loadYuraApplication()
    }




}
