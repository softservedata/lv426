package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * The WishListAccess class implements a functionality which
 * check that it is possible get into wish list.
 *
 * @author  Beata Kovtan
 * @version 1.0
 * @since   2019-09-03
 */
public class WishListAccess {
    private WebDriver chromeDriver;
    public WishListAccess(WebDriver driver) {
        this.chromeDriver = driver;
    }

    /**
     * The getIntoWishList() method enters into wish list
     * and check that it is actually wish list page
     * @return url of the actual page
     */
    public String getIntoWishList(){
        chromeDriver.findElement(By.id("wishlist-total")).click();
        return chromeDriver.getCurrentUrl();
    }
}
