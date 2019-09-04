package feedbacktesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class opens edit page of one of reviews were admin can make some changes and enable a feedback.
 * <p>
 * version 1.
 */
public class EditReviewPageOC {
    public WebDriver driver;


    @FindBy(id = "input-status")
    private WebElement statusButton;

    @FindBy(xpath = "//*[@id=\"input-status\"]/option[1]")
    private WebElement enableButton;

    @FindBy(css = "div.pull-right button")
    private WebElement saveButton;


    public EditReviewPageOC(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method which in edit page enables review.
     **/

    public void enableReview() {
        statusButton.click();
        enableButton.click();
        saveButton.click();
    }


}
