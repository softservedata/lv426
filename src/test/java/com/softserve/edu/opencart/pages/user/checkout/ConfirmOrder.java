package com.softserve.edu.opencart.pages.user.checkout;

import com.softserve.edu.opencart.data.checkout.ConfirmOrderSumConclusionComponents;
import com.softserve.edu.opencart.data.checkout.ConfirmOrderSumConclusionContainer;
import com.softserve.edu.opencart.data.checkout.ConfirmOrderTableComponents;
import com.softserve.edu.opencart.data.checkout.ConfirmOrderTableContainer;
import com.softserve.edu.opencart.pages.user.shop.ShoppingCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ConfirmOrder extends CheckOutPage{

    private WebElement element;
    private String CONFIRM_ORDER_TABLE_COMPONENTS_CSSSELECTOR = "//div[@class='panel-body']//tbody/tr";
    private String CONFIRM_ORDER_CONCLUSION_TABLE_CSSSELECTOR = "//tfoot/tr";
    private List<ConfirmOrderTableComponents> listWithInfo;
    private List<ConfirmOrderSumConclusionComponents> listWithCashInfo;


    public ConfirmOrder(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){
        listWithInfo = new ArrayList<>();
        listWithCashInfo = new ArrayList<>();
        for(WebElement current : driver.findElements(By.xpath(CONFIRM_ORDER_TABLE_COMPONENTS_CSSSELECTOR))){
            listWithInfo.add(new ConfirmOrderTableComponents(current, driver));
        }
        for(WebElement current : driver.findElements(By.xpath(CONFIRM_ORDER_CONCLUSION_TABLE_CSSSELECTOR))) {
            listWithCashInfo.add(new ConfirmOrderSumConclusionComponents(current, driver));
        }
        listOrderInfo();
        listWithCashInfo();
    }
    private WebElement getWebConfirmCheckoutContinueButton(){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver,10)).until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("input#button-confirm")));
        return driver.findElement(By.cssSelector("input#button-confirm"));
    }

    public ConfirmOrderTableContainer listOrderInfo(){
        return new ConfirmOrderTableContainer(listWithInfo);
    }

    public ConfirmOrderSumConclusionContainer listWithCashInfo(){
        return new ConfirmOrderSumConclusionContainer(listWithCashInfo);
    }


    public SuccessCheckOutPage confirmCheckoutButtonClick(){
        getWebConfirmCheckoutContinueButton().click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new SuccessCheckOutPage(driver);
    }

//    public
}
