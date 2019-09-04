package feedbacktesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Includes all elements needed for filtering, finding and opening edit page of needed review, methods for working with them.
 *
 * version 1.
 */
public class ReviewListPageOC {

    public WebDriver driver;

    //@FindBy(xpath = "//*[@id=\"form-review\"]/div/table//*td[contains (text(),'Action')]/td")
    @FindBy(css = "tr a.btn.btn-primary")
    WebElement editButton;


    @FindBy(linkText = "Reviews")
    WebElement checkReviewPage;

    @FindBy(id = "input-product")
    WebElement productBox;

    @FindBy(id = "input-author")
    WebElement authorBox;

    @FindBy(id = "button-filter")
    WebElement filterButton;

    public ReviewListPageOC(WebDriver driver) {

        this.driver = driver;
    }

    /**
     * Checking is needed page open.
     * @return true or false due to open page.
     */
    public boolean CheckValidReviewPageOpening() {
        return checkReviewPage.getText().contains("Your Store");
    }

    /**
     * Click on Edit button.
     */
    public void clickEdit() {

        editButton.click();
    }

    /**
     * Entering product name and filtering by it
     * @param product name of item you searching.
     */
    public void filterByProduct(String product) {
        productBox.click();
        productBox.clear();
        productBox.sendKeys(product);
        filterButton.click();
    }

    /**
     * Entering author name and filtering by it.
     * @param author name of user.
     */
    public void filterByAuthor(String author) {
        authorBox.click();
        authorBox.clear();
        authorBox.sendKeys(author);
        filterButton.click();

    }

}
