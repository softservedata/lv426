import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetPasswordPage {
    @FindBy(id = "input-password")
    private WebElement password;
    @FindBy(id = "input-confirm")
    private WebElement confirmPassword;
    @FindBy(css = "button.btn.btn-primary")
    private WebElement continueButton;

    public void resetPassword(String passwordData, String confirmData) {
        password.sendKeys(passwordData);
        confirmPassword.sendKeys(confirmData);
        continueButton.click();
    }
}