import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgottenPasswordPage {
    @FindBy(id = "input-email")
    private WebElement email;
    @FindBy(css = "input.btn.btn-primary")
    private WebElement continueButton;


    public void sendEmail(String emailData) {
        email.sendKeys(emailData);
        continueButton.click();
    }
}
