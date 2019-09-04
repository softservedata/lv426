import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class which contains fields and methods
 *  to edit account of existing user
 */
public class EditAccountPage {

    @FindBy(xpath = "//div[contains(@class, 'list-group')]//a[contains(text(), 'Edit Account')]")
    private WebElement editAccountLink;

    @FindBy(name = "firstname")
    private WebElement firstNameLink;

    @FindBy(name = "lastname")
    private WebElement lastNameLink;

    @FindBy(name = "email")
    private WebElement emailLink;

    @FindBy(name = "telephone")
    private WebElement telephoneLink;

    @FindBy(name = "fax")
    private WebElement faxLink;

    @FindBy(css = "div.buttons.clearfix div.pull-right input")
    private WebElement continueButton;

    @FindBy(css = "div.alert.alert-success")
    private WebElement successEdit;

    @FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
    private WebElement invalidLastNameInput;

    public EditAccountPage(WebDriver driver) {
    }

    boolean checkValidAccountEdit() {
        //verify success account edit
        return successEdit.getText().contains("Your account has been successfully updated.");
    }

    private void editAccount() {
        //click on edit account
        editAccountLink.click();
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

    private void enterFax(String fax) {
        //enter fax field
        faxLink.click();
        faxLink.clear();
        faxLink.sendKeys(fax);
    }

    public void editAccountAs(String firstname, String lastname, String email,
                              String telephone, String fax) {
        //edit account method
        editAccount();
        enterFirstName(firstname);
        enterLastName(lastname);
        enterEmail(email);
        enterTelephone(telephone);
        enterFax(fax);
    }

    void clickOnContinueButton() {
        //click Continue button after edit account
        continueButton.click();
    }
}
