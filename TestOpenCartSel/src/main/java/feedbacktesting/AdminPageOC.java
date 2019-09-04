package feedbacktesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * AdminPageOc class includes all elements and mathods
 * which we need while working with main admin page.
 * <p>
 * version 1
 */

public class AdminPageOC {

    public WebDriver driver;

    @FindBy(id = "menu-catalog")
    private WebElement catalogButton;


    @FindBy(xpath = "//ul[contains(@id,'menu')]//a[contains(text(),'Reviews')]")
    private WebElement reviewsButton;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/h1")
    private WebElement dashboard;

    public AdminPageOC(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method which check is it a right page.
     *
     * @return value true or false due to the  page.
     */
    public boolean CheckValidAdminPageOpening() {
        return dashboard.getText().contains("Dashboard");
    }

    /**
     * Method which clicks on catalog button.
     */
    public void clickOnCatalog() {
        catalogButton.click();
    }

    /**
     * Method whick clicks on review button.
     */

    public void clickOnReviews() {
        reviewsButton.click();
    }

    /**
     * Method which includes two previous for opening reviews page from main admin page.
     */

    public void openReviews() {
        clickOnCatalog();
        clickOnReviews();
    }
}
