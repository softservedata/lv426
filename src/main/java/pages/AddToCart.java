package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * The AddToCart class implements a functionality which
 * add selected good from wish list to the shopping cart.
 *
 * @author  Beata Kovtan
 * @version 1.0
 * @since   2019-09-03
 */
public class AddToCart {
    private WebDriver chromeDriver;
    public AddToCart(WebDriver driver){
        this.chromeDriver = driver;
    }

    /**
     * Add "MacBook" from wishlist to the shopping cart
     * and check that it was added
     * @return cartlist.size(), amount of the good in the shopping cart
     */
    public int addToCart(){
        chromeDriver.findElement(By.linkText("MacBook"));
        chromeDriver.findElement(By.xpath("//td[contains(text(),'Product 16')]/following-sibling::td/button[contains(@class,'btn btn-primary')]")).click();
        chromeDriver.findElement(By.xpath("//ul[@class='list-inline']/li/a/i[@class='fa fa-shopping-cart']")).click();
        List<WebElement> cartlist = chromeDriver.findElements(By.xpath("//div[@class='table-responsive']//td/a[text()='MacBook']/../following-sibling::td[text()='Product 16']"));
        return cartlist.size();

    }
}
