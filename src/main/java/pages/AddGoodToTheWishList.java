package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * The AddGoodToTheWishList class implements a functionality which
 * add selected good to the wish list.
 *
 * @author  Beata Kovtan
 * @version 1.0
 * @since   2019-09-03
 */
public class AddGoodToTheWishList {
    private WebDriver chromeDriver;
    public AddGoodToTheWishList(WebDriver driver){
        this.chromeDriver = driver;
    }

    /**
     *  Search "MacBook",which adds it to wish list
     * and check that it was aded
     * @return text of the "MacBook's" model field
     */
    public String addToWishList() {
        chromeDriver.findElement(By.xpath("//div[@id='search']/input[@name='search']")).sendKeys("MacBook");
        chromeDriver.findElement(By.xpath("//div[@id='search']/span/button[@class='btn btn-default btn-lg']")).click();
        chromeDriver.findElement(By.xpath("//div[@class='button-group']//button[@data-original-title='Add to Wish List']")).click();
        chromeDriver.findElement(By.id("wishlist-total")).click();
        return chromeDriver.findElement(By.xpath("//div[@class='table-responsive']//td/a[text()='MacBook']/../following-sibling::td[text()='Product 16']")).getText();
    }
}
