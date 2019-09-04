import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage {
    @FindBy(id = "input-password")
    private WebElement password;
    @FindBy(id = "input-confirm")
    private WebElement confirmPassword;
    @FindBy(css = "input.btn.btn-primary")
    private WebElement continueButton;

    public void changePassword(String passwordData, String confirmData) {
        password.click();
        password.clear();
        password.sendKeys(passwordData);
        confirmPassword.click();
        confirmPassword.clear();
        confirmPassword.sendKeys(confirmData);
        continueButton.click();
    }
}
