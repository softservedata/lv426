package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends AccountSidebarGuestPart {

	private WebElement firstName;
	private WebElement lastName;
	private WebElement email;
	private WebElement telephone;
	private WebElement password;
	private WebElement confirmPassword;
	private WebElement fax;
	private WebElement company;
	private WebElement address01;
	private WebElement address02;
	private WebElement city;
	private WebElement postcode;
	private WebElement zone;
	private WebElement country;
	private WebElement continueButton;
	private WebElement agreePrivacyPolicyLink;

	public RegisterPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		firstName = driver.findElement(By.name("firstname"));
		lastName = driver.findElement(By.name("lastname"));
		email = driver.findElement(By.name("email"));
		telephone = driver.findElement(By.name("telephone"));
		password = driver.findElement(By.name("password"));
		confirmPassword = driver.findElement(By.name("confirm"));
		fax = driver.findElement(By.name("fax"));
		company = driver.findElement(By.name("company"));
		address01 = driver.findElement(By.name("address_1"));
		address02 = driver.findElement(By.name("address_2"));
		city = driver.findElement(By.name("city"));
		postcode = driver.findElement(By.name("postcode"));
		continueButton = driver.findElement(By.cssSelector("div.buttons div.pull-right input.btn.btn-primary"));
		agreePrivacyPolicyLink = driver.findElement(By.name("agree"));
		zone = driver.findElement(By.id("input-zone"));
		country = driver.findElement(By.id("input-country"));
	}

	// Page Object

	// Functional
	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getTelephone() {
		return telephone;
	}

	public WebElement getFax() {
		return fax;
	}

	public WebElement getCompany() {
		return company;
	}

	public WebElement getAddress01() {
		return address01;
	}

	public WebElement getAddress02() {
		return address02;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getPostcode() {
		return postcode;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getAgreePrivacyPolicyLink() {
		return agreePrivacyPolicyLink;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getZone() {
		return zone;
	}

	public void clickFirstNameField() {
		getFirstName().click();
	}

	public void clickLastNameField() {
		getLastName().click();
	}

	public void clickEmailField() {
		getEmail().click();
	}

	public void clickFaxField() {
		getFax().click();
	}

	public void clickTelephoneField() {
		getTelephone().click();
	}

	public void clickCompanyField() {
		getCompany().click();
	}

	public void clickAddress01Field() {
		getAddress01().click();
	}

	public void clickAddress02Field() {
		getAddress02().click();
	}

	public void clickCityField() {
		getCity().click();
	}

	public void clickPostcodeField() {
		getPostcode().click();
	}

	public void clickCountryField() {
		getCountry().click();
	}

	public void clickZoneField() {
		getZone().click();
	}

	public void clickPasswordField() {
		getPassword().click();
	}

	public void clickConfirmPasswordField() {
		getConfirmPassword().click();
	}

	public void clearFirstNameField() {
		getFirstName().clear();
	}

	public void clearLastNameField() {
		getLastName().clear();
	}

	public void clearEmailField() {
		getEmail().clear();
	}

	public void clearFaxField() {
		getFax().clear();
	}

	public void clearTelephoneField() {
		getTelephone().clear();
	}

	public void clearCompanyField() {
		getCompany().clear();
	}

	public void clearAddress01Field() { getAddress01().clear(); }

	public void clearAddress02Field() {
		getAddress02().clear();
	}

	public void clearCityField() {
		getCity().clear();
	}

	public void clearPostcodeField() {
		getPostcode().clear();
	}

	public void clearPasswordField() {
		getPassword().clear();
	}

	public void clearConfirmPasswordField() {
		getConfirmPassword().clear();
	}

	public void clickContinueButton() {
		getContinueButton().click();
	}

	public void clickAgreePrivacyPolicyLink() {
		getAgreePrivacyPolicyLink().click();
	}

	public void setFirstName(String firstName) {
		getFirstName().sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		getLastName().sendKeys(lastName);
	}

	public void setEmail(String email) {
		getEmail().sendKeys(email);
	}

	public void setTelephone(String telephone) {
		getTelephone().sendKeys(telephone);
	}

	public void setFax(String fax) {
		getFax().sendKeys(fax);
	}

	public void setCompany(String company) {
		getCompany().sendKeys(company);
	}

	public void setAddress01(String address01) {
		getAddress01().sendKeys(address01);
	}

	public void setAddress02(String address02) {
		getAddress01().sendKeys(address02);
	}

	public void setCity(String city) {
		getCity().sendKeys(city);
	}

	public void setPostcode(String postcode) {
		getPostcode().sendKeys(postcode);
	}

	public void setCountry(String country) {
		getCountry().sendKeys(country);
	}

	public void setZone(String zone) {
		getZone().sendKeys(zone);
	}

	public void setPassword(String password) {
		getPassword().sendKeys(password);
	}

	public void setConfirmPassword(String confirmPassword) {
		getConfirmPassword().sendKeys(confirmPassword);
	}

	// Business Logic

	private void enterFirstName(String firstname) {
		clickFirstNameField();
		clearFirstNameField();
		setFirstName(firstname);
	}

	private void enterLastName(String lastname) {
		clickLastNameField();
		clearLastNameField();
		setLastName(lastname);
	}

	private void enterEmail(String email) {
		clickEmailField();
		clearEmailField();
		setEmail(email);
	}

	private void enterTelephone(String phone) {
		clickTelephoneField();
		clearTelephoneField();
		setTelephone(phone);
	}

	private void enterFax(String fax) {
		clickFaxField();
		clearFaxField();
		setFax(fax);
	}

	private void enterCompany(String company) {
		clickCompanyField();
		clearCompanyField();
		setCompany(company);
	}

	private void enterAddress01(String address) {
		clickAddress01Field();
		clearAddress01Field();
		setAddress01(address);
	}

	private void enterAddress02(String address) {
		clickAddress02Field();
		clearAddress02Field();
		setAddress02(address);
	}

	private void enterCity(String city) {
		clickCityField();
		clearCityField();
		setCity(city);
	}

	private void enterPostcode(String postcode) {
		clickPostcodeField();
		clearPostcodeField();
		setPostcode(postcode);
	}

	private void enterCountry(String country) {
		clickCountryField();
		setCountry(country);
	}

	private void enterZone(String zone) {
		clickZoneField();
		setZone(zone);
	}

	private void enterPassword(String password) {
		clickPasswordField();
		clearPasswordField();
		setPassword(password);
	}

	private void enterConfirmPassword(String confirmPassword) {
		clickConfirmPasswordField();
		clearConfirmPasswordField();
		setConfirmPassword(confirmPassword);
	}

	public MyAccountPage registerAs(String firstname, String lastname, String email,
						   String telephone, String fax, String company,
						   String adress01, String adress02, String city,
						   String country, String obl, String postcode,
						   String password, String confirmPassword) {
		enterFirstName(firstname);
		enterLastName(lastname);
		enterEmail(email);
		enterTelephone(telephone);
		enterFax(fax);

		enterCompany(company);
		enterAddress01(adress01);
		enterAddress02(adress02);
		enterCity(city);
		enterPostcode(postcode);
		enterCountry(country);
		enterZone(obl);

		enterPassword(password);
		enterConfirmPassword(confirmPassword);
		clickAgreePrivacyPolicyLink();
		clickContinueButton();

		return new MyAccountPage(driver);
	}

}
