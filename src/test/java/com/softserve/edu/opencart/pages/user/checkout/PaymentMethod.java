package com.softserve.edu.opencart.pages.user.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentMethod extends CheckOutPage {

    private WebDriver driver;
    private WebElement element;

    private WebElement chooseCashPayment;
    private WebElement textAreaInPaymentMethod;
    private WebElement paymentMethodContinueButton;
    private WebElement privacyPolicyLink;
    private WebElement privacyPolicyAgreement;
    private TermsAndConditions termsAndConditions;

    public PaymentMethod(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){
        chooseCashPayment = driver.findElement(By.cssSelector("input[name=\"payment_method\"]"));
        textAreaInPaymentMethod = driver
                .findElement(By.cssSelector("div#collapse-payment-method textarea.form-control"));
        paymentMethodContinueButton = driver.findElement(By.cssSelector("input#button-payment-method"));
        privacyPolicyAgreement = driver.findElement(By.cssSelector("input[name=\"agree\"]"));
        privacyPolicyLink = driver.findElement(By.cssSelector("a.agree"));
        termsAndConditions = new TermsAndConditions(driver);
    }

    //Page object

    public void setTextAreaInPaymentMethod(String text){
        textAreaInPaymentMethod.sendKeys(text);
    }

    //Functional

    public void clickPaymentMethodContinueButton(){
        paymentMethodContinueButton.click();
    }

    public void chooseCashPayMent(){
        chooseCashPayment.click();
    }

    public void clickTextAreaInPaymentMethod(){
        textAreaInPaymentMethod.click();
    }

    public void clearTextAreaInPaymentMethod(){
        textAreaInPaymentMethod.clear();
    }

    public void confirmAgreement(){
        privacyPolicyAgreement.click();
    }

    public void gotoPrivacyPolicyPage(){
        privacyPolicyLink.click();
    }

    //Business logic

    /**
     * The method which completely do payment method part
     * @param text
     */
    public void paymentMethodFullyComplete(String text){
        chooseCashPayMent();
        clickTextAreaInPaymentMethod();
        clearTextAreaInPaymentMethod();
        setTextAreaInPaymentMethod(text);
        clickPaymentMethodContinueButton();
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
