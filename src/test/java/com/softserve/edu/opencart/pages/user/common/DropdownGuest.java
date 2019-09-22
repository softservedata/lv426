<<<<<<< HEAD
package com.softserve.edu.opencart.pages.user.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownGuest {
    private WebDriver driver;
    //
    private WebElement register;
    private WebElement login;

    protected DropdownGuest(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        register = driver.findElement(By.xpath("//a[contains(@href,'account/register')]"));
        login  = driver.findElement(By.xpath("//a[contains(@href,'account/login')]"));
    }

    // Page Object

    // register
    public WebElement getRegister() {
        //return driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle"));
        return register;
    }

    public String getRegisterText() {
        return getRegister().getText();
    }

    public void clickRegister() {
        getRegister().click();
    }

    // login
    public WebElement getLogin() {
        return login;
    }

    public String getLoginText() {
        return getLogin().getText();
    }

    public void clickLogin() {
        getLogin().click();
    }

    // Functional

    // Business Logic
}
=======
package com.softserve.edu.opencart.pages.user.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownGuest {

	private WebDriver driver;
	//
	private WebElement register;
	private WebElement login;
	
    protected DropdownGuest(WebDriver driver) {
        this.driver = driver;
        initElements();
    }
    
    private void initElements() {
    	register = driver.findElement(By.xpath("//a[contains(@href,'account/register')]"));
    	login  = driver.findElement(By.xpath("//a[contains(@href,'account/login')]"));
    }
    
	// Page Object

	// register
    public WebElement getRegister() {
    	//return driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle"));
        return register;
    }

    public String getRegisterText() {
        return getRegister().getText();
    }

    public void clickRegister() {
        getRegister().click();
    }

	// login
    public WebElement getLogin() {
        return login;
    }

    public String getLoginText() {
        return getLogin().getText();
    }

    public void clickLogin() {
        getLogin().click();
    }

	// Functional

	// Business Logic

}
>>>>>>> 40c679a4d7b258b0d93712d093a711e40eed356b
