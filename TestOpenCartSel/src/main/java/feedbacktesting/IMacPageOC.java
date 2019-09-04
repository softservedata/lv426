package feedbacktesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class which includes all needed elements and methods for leaving review on iMac product page.
 * <p>
 * version 1
 */

public class IMacPageOC {

    private WebDriver driver;

    public IMacPageOC(WebDriver driver) {
        this.driver = driver;
    }


    private static final String BASE_URL = "http://192.168.68.132/opencart/upload/index.php?route=product/product&product_id=41&search=iMac";


    @FindBy(xpath = "//*[@id=\"form-review\"]/div/div")
    private WebElement nameWarning;


    @FindBy(xpath = "//*[@id=\"form-review\"]/div/div")
    private WebElement reviewWarning;


    @FindBy(xpath = "//*[@id=\"form-review\"]/div/div")
    private WebElement ratingWarning;


    @FindBy(xpath = "//ul[contains(@class,'list-unstyled')]/li[contains(text(),'Product Code: Product 14')]")
    private WebElement checkWords;


    @FindBy(xpath = "//li[contains(@class,'' )]//a[contains(text(),'Reviews')]")
    private WebElement reviewButton;

    @FindBy(id = "input-name")
    private WebElement inputNameBox;

    @FindBy(id = "input-review")
    private WebElement inputReviewBox;

    @FindBy(xpath = "//input[@name='rating' and @value='1']")
    private WebElement rating1;

    @FindBy(xpath = "//input[@name='rating' and @value='2']")
    private WebElement rating2;

    @FindBy(xpath = "//input[@name='rating' and @value='3']")
    private WebElement rating3;

    @FindBy(xpath = "//input[@name='rating' and @value='4']")
    private WebElement rating4;


    @FindBy(xpath = "//input[@name='rating' and @value='5']")
    private WebElement rating5;


    @FindBy(id = "button-review")
    private WebElement continueReviewButton;

    @FindBy(xpath = "//strong[contains(text(), 'iva qwerty')]")
    private WebElement checkReview;

    /**
     * Open iMc product page.
     */
    public void open() {
        driver.get(BASE_URL);
    }

    /**
     * Check does enabled review really exist.
     *
     * @return true or false due to review existing.
     */
    public boolean checkReview() {
        return checkReview.getText().contains("iva qwerty");
    }

    /**
     * Check does needed page is open.
     *
     * @return true or false due to needed page.
     */
    public boolean CheckValidiMacPageOpening() {
        return checkWords.getText().contains("Product Code: Product 14");
    }

    /**
     * Check does warning appear when we don't type any name or it`t too short or too long.
     *
     * @return true or false due to name length.
     */
    public boolean nameWarningExist() {
        return nameWarning.getText().contains(" Warning: Review Name must be between 3 and 25 characters!");
    }

    /**
     * Check does warning appear when we don't type any review or it`t too short or too long.
     *
     * @return true or false due to review length.
     */
    public boolean reviewWarningExist() {
        return reviewWarning.getText().contains(" Warning: Review Text must be between 25 and 1000 characters!");
    }

    /**
     * Check does warning appear when we don't choose any rating.
     *
     * @return true or false due to rating.
     */
    public boolean ratingWarningExist() {
        return ratingWarning.getText().contains(" Warning: Please select a review rating!");
    }

    /**
     * Click on review button.
     */
    public void clickOnReviewButton() {

        reviewButton.click();
    }

    /**
     * Enter name of user in username box for adding review.
     *
     * @param name name of user.
     */
    public void enterReviewName(String name) {
        inputNameBox.click();
        inputNameBox.clear();
        inputNameBox.sendKeys(name);
    }

    /**
     * Enter review in review box.
     *
     * @param review string whicl will be input.
     */
    public void enterReview(String review) {

        inputReviewBox.click();
        inputReviewBox.clear();
        inputReviewBox.sendKeys(review);
    }

    /**
     * Click on rating '1' button.
     */
    public void clickRating1() {
        rating1.click();
    }

    /**
     * Click on rating '2' button.
     */
    public void clickRating2() {

        rating2.click();
    }

    /**
     * Click on rating '3' button.
     */
    public void clickRating3() {
        rating3.click();
    }

    /**
     * Click on rating '4' button.
     */
    public void clickRating4() {
        rating4.click();
    }

    /**
     * Click on rating '5' button.
     */
    public void clickRating5() {
        rating5.click();
    }

    /**
     * Clicl on button 'Continue' after review inputing.
     */
    public void clickContinueReviewButton() {
        continueReviewButton.click();
    }

    /**
     * Write and send review with rating '1'
     *
     * @param name   string with name of user which will be input
     * @param review string with review which will be input
     */
    public void sendReviewR1(String name, String review) {
        clickOnReviewButton();
        enterReviewName(name);
        enterReview(review);
        clickRating1();
        clickContinueReviewButton();

    }

    /**
     * Write and send review with rating '2'
     *
     * @param name   string with name of user which will be input
     * @param review string with review which will be input
     */
    public void sendReviewR2(String name, String review) {
        clickOnReviewButton();
        enterReviewName(name);
        enterReview(review);
        clickRating2();
        clickContinueReviewButton();

    }

    /**
     * Write and send review with rating '3'
     *
     * @param name   string with name of user which will be input
     * @param review string with review which will be input
     */
    public void sendReviewR3(String name, String review) {
        clickOnReviewButton();
        enterReviewName(name);
        enterReview(review);
        clickRating3();
        clickContinueReviewButton();

    }

    /**
     * Write and send review with rating '4'
     *
     * @param name   string with name of user which will be input
     * @param review string with review which will be input
     */
    public void sendReviewR4(String name, String review) {
        clickOnReviewButton();
        enterReviewName(name);
        enterReview(review);
        clickRating4();
        clickContinueReviewButton();

    }

    /**
     * Write and send review with rating '5'
     *
     * @param name   string with name of user which will be input
     * @param review string with review which will be input
     */
    public void sendReviewR5(String name, String review) {
        clickOnReviewButton();
        enterReviewName(name);
        enterReview(review);
        clickRating5();
        clickContinueReviewButton();

    }

    /**
     * Write and send review without rating
     *
     * @param name   string with name of user which will be input
     * @param review string with review which will be input
     */
    public void sendReviewR0(String name, String review) {
        clickOnReviewButton();
        enterReviewName(name);
        enterReview(review);
        clickContinueReviewButton();

    }


}
