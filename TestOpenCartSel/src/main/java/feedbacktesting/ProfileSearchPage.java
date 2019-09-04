package feedbacktesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Includes elements needed for searching product from page opned after logining, and methods for working with them.
 * <p>
 * version 1.
 */
public class ProfileSearchPage {

    private WebDriver driver;

    @FindBy(name = "search")
    private WebElement searchLink;

    @FindBy(css = "#search > span > button")
    private WebElement searchButton;

    @FindBy(linkText = "iMac")
    private WebElement productButton;

    public ProfileSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Click on search button.
     */
    public void ClickOnSearchButton() {
        searchButton.click();
    }

    /**
     * Click on our product in product list page.
     */
    public void ClickOnProductButton() {
        productButton.click();
    }

    /**
     * Searching needed product from page opened after logging.
     *
     * @param item name of product.
     */
    public void searchItem(String item) {
        searchLink.click();
        searchLink.clear();
        searchLink.sendKeys(item);
        ClickOnSearchButton();
        ClickOnProductButton();
    }
}
