
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Class which contains fields and methods
 *  to register new user
 */
public class RegisterPage {
    private WebDriver driver;

    @FindBy(name = "firstname")
    private WebElement firstNameLink;

    @FindBy(name = "lastname")
    private WebElement lastNameLink;

    @FindBy(name = "email")
    private WebElement emailLink;

    @FindBy(name = "telephone")
    private WebElement telephoneLink;

    @FindBy(name = "password")
    private WebElement passwordLink;

    @FindBy(name = "confirm")
    private WebElement confirmPasswordLink;

    @FindBy(name = "fax")
    private WebElement faxLink;

    @FindBy(name = "company")
    private WebElement companyLink;

    @FindBy(name = "address_1")
    private WebElement address01Link;

    @FindBy(name = "address_2")
    private WebElement address02Link;

    @FindBy(name = "city")
    private WebElement cityLink;

    @FindBy(name = "postcode")
    private WebElement postcodeLink;

    @FindBy(css = "div.buttons div.pull-right input.btn.btn-primary")
    private WebElement continueButton;

    @FindBy(name = "agree")
    private WebElement agreePrivacyPolicyLink;

    @FindBy(id = "content")
    private WebElement successRegister;

    @FindBy(css = "div.container div.alert.alert-danger")
    private WebElement withoutConfirmPrivacyPolicy;

    @FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
    private WebElement invalidFirstNameInput;

    @FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
    private WebElement invalidLastNameInput;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    boolean checkValidRegistration() {
        //verify success registration
        return successRegister.getText().contains("Your Account Has Been Created!");
    }

    boolean checkWithoutConfirmPrivacyPolicy() {
        //verify unsuccessful registration without
        // confirm privacy policy
        return withoutConfirmPrivacyPolicy.getText()
                .contains("You must agree to the Privacy Policy!");
    }

    boolean checkWithInvalidFirstNameInput() {
        //verify unsuccessful registration with invalid first name
        return invalidFirstNameInput.getText()
                .contains("First Name must be between 1 and 32 characters!");
    }

    boolean checkWithInvalidLastNameInput() {
        //verify unsuccessful registration with invalid last name
        return invalidLastNameInput.getText()
                .contains("Last Name must be between 1 and 32 characters!");
    }

    private void enterCountry(String country) {
        //enter country field
        Select select = new Select(driver.findElement(By.id("input-country")));
        select.selectByVisibleText(country);
    }

    private void enterZone(String obl) {
        //enter zone field
        Select select = new Select(driver.findElement(By.id("input-zone")));
        select.selectByVisibleText(obl);
    }

    private void enterFirstName(String name) {
        //enter first name field
        firstNameLink.click();
        firstNameLink.clear();
        firstNameLink.sendKeys(name);
    }

    private void enterLastName(String surname) {
        //enter last name field
        lastNameLink.click();
        lastNameLink.clear();
        lastNameLink.sendKeys(surname);
    }

    private void enterEmail(String email) {
        //enter email field
        emailLink.click();
        emailLink.clear();
        emailLink.sendKeys(email);
    }

    private void enterTelephone(String phone) {
        //enter telephone field
        telephoneLink.click();
        telephoneLink.clear();
        telephoneLink.sendKeys(phone);
    }

    private void enterPassword(String password) {
        //enter password field
        passwordLink.click();
        passwordLink.clear();
        passwordLink.sendKeys(password);
    }

    private void enterConfirmPassword(String confirmPassword) {
        //enter confirm password field
        confirmPasswordLink.click();
        confirmPasswordLink.clear();
        confirmPasswordLink.sendKeys(confirmPassword);
    }

    private void enterFax(String fax) {
        //enter fax field
        faxLink.click();
        faxLink.clear();
        faxLink.sendKeys(fax);
    }

    private void enterCompany(String company) {
        //enter company field
        companyLink.click();
        companyLink.clear();
        companyLink.sendKeys(company);
    }

    private void enterAddress01(String address) {
        //enter first address field
        address01Link.click();
        address01Link.clear();
        address01Link.sendKeys(address);
    }

    private void enterAddress02(String address) {
        //enter second address field
        address02Link.click();
        address02Link.clear();
        address02Link.sendKeys(address);
    }

    private void enterCity(String city) {
        //enter city field
        cityLink.click();
        cityLink.clear();
        cityLink.sendKeys(city);
    }

    private void enterPostcode(String postcode) {
        //enter postcode field
        postcodeLink.click();
        postcodeLink.clear();
        postcodeLink.sendKeys(postcode);
    }

    void clickOnRegisterButton() {
        //click on Continue Button after registration
        continueButton.click();
    }

    void clickOnPrivacyPolicyAgree() {
        //confirm privacy policy
        agreePrivacyPolicyLink.click();
    }

    public void registerAs(String firstname, String lastname, String email,
                           String telephone, String fax, String company,
                           String adress01, String adress02, String city,
                           String country, String obl, String postcode,
                           String password, String confirmPassword) {
        //register new user method
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
    }
}
