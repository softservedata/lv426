package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * The DeleteFromWishList class implements a functionality which
 * deletes selected good from wish list.
 *
 * @author  Beata Kovtan
 * @version 1.0
 * @since   2019-09-03
 */
public class DeleteFromWishList {
    private WebDriver chromeDriver;
    public DeleteFromWishList(WebDriver driver){
        this.chromeDriver = driver;
    }

    /**
     * Delete "MacBook" from wish list
     * and check that it was deleted
     * @return amountInTheList.size() the amount of the good in the wish list
     */
    public int deleteFromWishList() {
        chromeDriver.findElement(By.xpath("//td[contains(text(),'Product 16')]/following-sibling::td/a[contains(@class,'btn btn-danger')]")).click();
        List<WebElement> amountInTheList = chromeDriver.findElements(By.xpath("//div[@class='table-responsive']//td/a[text()='MacBook']"));
        return amountInTheList.size();
    }
}
