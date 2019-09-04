import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class which contains fields and methods
 *  to edit password of existing user
 */
public class EditPasswordPage {

    @FindBy(xpath = "//div[contains(@class, 'list-group')]//a[contains(text(), 'Password')]")
    private WebElement editPasswordLink;

    @FindBy(name = "password")
    private WebElement passwordLink;

    @FindBy(name = "confirm")
    private WebElement confirmPasswordLink;

    @FindBy(css = "div.buttons.clearfix div.pull-right input")
    private WebElement continueButton;

    @FindBy(css = "div.buttons.clearfix div.pull-left a")
    private WebElement backButton;

    @FindBy(css = "div.alert.alert-success")
    private WebElement successEdit;

    public EditPasswordPage(WebDriver driver) {
    }

    boolean checkValidPasswordEdit() {
        //verify success password edit
        return successEdit.getText().contains("Your password has been successfully updated.");
    }

    private  void editPassword(){
        //click on edit password
        editPasswordLink.click();
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

    public void editPasswordAs(String password, String confirmPassword) {
        //edit password method
        editPassword();
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
    }

    void clickOnContinueButton() {
        //click on Continue button after edit password
        continueButton.click();
    }

    void clickOnBackButton() {
        //click on Back button after edit password
        backButton.click();
    }
}
