package com.softserve.edu.opencart.pages.user.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentMethod extends CheckOutPage {

    private WebDriver driver;
    private WebElement element;

    private TermsAndConditions termsAndConditions;

    public PaymentMethod(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    //Page object

    private WebElement getWebChooseCashPayment(){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("input[name=\"payment_method\"]")));
        return driver.findElement(By.cssSelector("input[name=\"payment_method\"]"));
    }

    private WebElement getWebTextAreaInPaymentMethod(){
        return driver.findElement(By.cssSelector("div#collapse-payment-method textarea.form-control"));
    }

    private WebElement getWebPaymentMethodContinueButton(){
        return driver.findElement(By.cssSelector("input#button-payment-method"));
    }

    private WebElement getWebPrivacyPolicyAgreement(){
        return driver.findElement(By.cssSelector("input[name=\"agree\"]"));
    }

    private WebElement getWebPrivacyPolicyLink(){
        return driver.findElement(By.cssSelector("a.agree"));
    }

    public void setTextAreaInPaymentMethod(String text){
        getWebTextAreaInPaymentMethod().sendKeys(text);
    }

    //Functional

    public void clickPaymentMethodContinueButton(){
        getWebPaymentMethodContinueButton().click();
    }

    public void chooseCashPayment(){
        getWebChooseCashPayment().click();
    }

    public void clickTextAreaInPaymentMethod(){
        getWebTextAreaInPaymentMethod().click();
    }

    public void clearTextAreaInPaymentMethod(){
        getWebTextAreaInPaymentMethod().clear();
    }

    public void confirmAgreement(){
        getWebPrivacyPolicyAgreement().click();
    }

    public void gotoPrivacyPolicyPage(){
        termsAndConditions = new TermsAndConditions(driver);
        getWebPrivacyPolicyLink().click();
    }

    //Business logic

    /**
     * The method which completely do payment method part
     * @param text
     */
    public ConfirmOrder paymentMethodFullyComplete(String text){
        chooseCashPayment();
        clickTextAreaInPaymentMethod();
        clearTextAreaInPaymentMethod();
        setTextAreaInPaymentMethod(text);
        confirmAgreement();
        clickPaymentMethodContinueButton();
        return new ConfirmOrder(driver);
    }

    class TermsAndConditions {
        private WebDriver driver;
        private WebElement title;
        private WebElement body;
        private WebElement close;

        TermsAndConditions(WebDriver driver){
            this.driver = driver;
            initElements();
        }

        private void initElements(){
            (new WebDriverWait(driver,3)).until(ExpectedConditions
                    .visibilityOfElementLocated(By.cssSelector("h4.modal-title")));
            title = driver.findElement(By.cssSelector("h4.modal-title"));
            body = driver.findElement(By.cssSelector("div.modal-body p"));
            close = driver.findElement(By.cssSelector("button.close"));
        }



        public String getTitleText(){
            return  title.getText();
        }

        public String getBodyText(){
        return body.getText();
        }

        public void closeTermsAndConditionsAlert(){
            close.click();
        }
    }

}
