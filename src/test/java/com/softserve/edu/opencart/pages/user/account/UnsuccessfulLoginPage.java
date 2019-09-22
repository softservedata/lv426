package com.softserve.edu.opencart.pages.user.account;

<<<<<<< HEAD

=======
>>>>>>> 40c679a4d7b258b0d93712d093a711e40eed356b
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnsuccessfulLoginPage extends LoginPage {

	public static final String EXPECTED_LOGIN_MESSAGE = "Warning: No match for E-Mail Address and/or Password.";
	//
	private WebElement alertWarning;
<<<<<<< HEAD

=======
	
>>>>>>> 40c679a4d7b258b0d93712d093a711e40eed356b
	public UnsuccessfulLoginPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		alertWarning = driver.findElement(By.cssSelector(".alert.alert-danger"));
	}

	// Page Object
	
	// alertWarning
	public WebElement getAlertWarning() {
		return alertWarning;
	}

<<<<<<< HEAD
	// alertWarning
	public WebElement getAlertWarning() {
		return alertWarning;
	}

	public String getAlertWarningText() {
		return getAlertWarning().getText();
	}

=======
    public String getAlertWarningText() {
        return getAlertWarning().getText();
    }
    
>>>>>>> 40c679a4d7b258b0d93712d093a711e40eed356b
	// Functional

	// Business Logic
}
