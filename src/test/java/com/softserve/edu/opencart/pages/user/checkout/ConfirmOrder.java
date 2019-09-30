package com.softserve.edu.opencart.pages.user.checkout;

import com.softserve.edu.opencart.data.checkout.ConfirmOrderSumConclusionComponents;
import com.softserve.edu.opencart.data.checkout.ConfirmOrderSumConclusionContainer;
import com.softserve.edu.opencart.data.checkout.ConfirmOrderTableComponents;
import com.softserve.edu.opencart.data.checkout.ConfirmOrderTableContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ConfirmOrder extends CheckOutPage{

    private WebDriver driver;
    private WebElement element;
    private String CONFIRM_ORDER_TABLE_COMPONENTS_CSSSELECTOR = "//div[@class='panel-body']//tbody/tr";
    private String CONFIRM_ORDER_CONCLUSION_TABLE_CSSSELECTOR = "//tfoot/tr";
    private WebElement confirmCheckoutContinueButton;
    private List<ConfirmOrderTableComponents> listWithInfo;
    private List<ConfirmOrderSumConclusionComponents> listWithCashInfo;


    public ConfirmOrder(WebDriver driver) {
        super(driver);
        this.driver = driver;
        initElements();
    }

    private void initElements(){
        listWithInfo = new ArrayList<>();
        listWithCashInfo = new ArrayList<>();
        (new WebDriverWait(driver,3)).until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("input#button-confirm")));
        confirmCheckoutContinueButton = driver.findElement(By.cssSelector("input#button-confirm"));
        for(WebElement current : driver.findElements(By.xpath(CONFIRM_ORDER_TABLE_COMPONENTS_CSSSELECTOR))){
            listWithInfo.add(new ConfirmOrderTableComponents(current, driver));
        }
        for(WebElement current : driver.findElements(By.xpath(CONFIRM_ORDER_CONCLUSION_TABLE_CSSSELECTOR))) {
            listWithCashInfo.add(new ConfirmOrderSumConclusionComponents(current, driver));
        }
        listOrderInfo();
        listWithCashInfo();
    }

    public ConfirmOrderTableContainer listOrderInfo(){
        return new ConfirmOrderTableContainer(listWithInfo);
    }

    public ConfirmOrderSumConclusionContainer listWithCashInfo(){
        return new ConfirmOrderSumConclusionContainer(listWithCashInfo);
    }

    public ConfirmOrder confirmCheckoutButtonClick(){
        confirmCheckoutContinueButton.click();
        return new ConfirmOrder(driver);
    }

//    public
}
