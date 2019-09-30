package com.softserve.edu.opencart.pages.user.shop;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.SearchFilter;
import com.softserve.edu.opencart.data.shop.CartTableFullOrderInfo;
import com.softserve.edu.opencart.data.shop.ShoppingCartTableElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShoppingCartContainerComponent extends ShoppingCartPage {
	
	private WebDriverWait explicitWait;
	private WebElement submitOrderChangesButton;
	private final String SHOPPINGCART_COMPONENTS_CSSSELECTOR="//div[contains(@class,'table-responsive')]" +
			"/table[contains(@class,'table table-bordered')]/tbody/tr";

	private List<CartTableFullOrderInfo> ordersInfo ;

	public ShoppingCartContainerComponent(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		ordersInfo = new ArrayList<>();
		for(WebElement productTable : driver.findElements(By.xpath(SHOPPINGCART_COMPONENTS_CSSSELECTOR))){
			ordersInfo.add(new CartTableFullOrderInfo(productTable, driver));
			listOfCartOrders();
		}
	}


	public ShoppingCartTableElements listOfCartOrders(){
		return new ShoppingCartTableElements(ordersInfo);
	}

	// Page Object
	public WebElement elementToChangeACountOfOrderingByName(String orderName){
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		(new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//td/a[contains(text(),'"+ orderName
						+"')]/../following-sibling::td/div/input")));
		return driver.findElement(By.xpath("//td/a[contains(text(),'"+ orderName
				+"')]/../following-sibling::td/div/input"));
	}

	public WebElement elementToDeleteSomeOrderByName(String orderName){
		return driver.findElement(By.xpath("//td/a[contains(text(),'"+orderName
				+"')]/../following-sibling::td/div/span/button[contains(@class,'btn btn-danger')]"));
	}

	public String getOrderModelInShopCart(String orderName){
		return driver.findElement(By.xpath("//td[contains(@class,'text-left')]/a[contains(text(),'"+orderName+"')]" +
				"/../following-sibling::td[contains(text(),'roduct')]")).getText();
	}

	public String getOrderCountInShopCart(String orderName){
		return elementToChangeACountOfOrderingByName(orderName).getText();
	}

	public String getOrderUnitPriceInShopCart(String orderName){
		return driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]" +
				"//td[contains(@class,'text-left')]/a[contains(text(),'"+orderName+"')]" +
				"/../following-sibling::td[contains(@class,'text-right')][1]")).getText();
	}

	public String getOrderTotalPriceInShopCart(String orderName){
		return driver.findElement(By.xpath("//div[contains(@class,'table-responsive')]" +
				"/table[contains(@class,'table table-bordered')]" +
				"//tbody/tr/td/a[contains(text(),'"+orderName+"')]/../following-sibling::td[4]")).getText();
	}

	public ShoppingCartPage deleteSomeOrderByName(String orderName){
		elementToDeleteSomeOrderByName(orderName);
		return new ShoppingCartPage(driver);
	}

	public ShoppingCartPage changeCountOfSomeOrderByName(Product orderName, String count){
		clickInputACountOfOrderByName(orderName);
		clearInputACountOfOrderByName(orderName);
		setInputACountOfOrderByName(orderName.getName(),count);
		clickToSubmitChangesInCartTable();
		return new ShoppingCartPage(driver);
	}



	// Functional

	public void clickInputACountOfOrderByName(Product orderName){
		elementToChangeACountOfOrderingByName(orderName.getName()).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void clearInputACountOfOrderByName(Product orderName){
		elementToChangeACountOfOrderingByName(orderName.getName()).clear();
	}

	public void setInputACountOfOrderByName(String orderName, String count){
		elementToChangeACountOfOrderingByName(orderName).sendKeys(count);
	}

	public ShoppingCartPage clickToSubmitChangesInCartTable(){
		submitOrderChangesButton = driver.findElement(By.cssSelector("button[type=submit]"));
		submitOrderChangesButton.click();
		return new ShoppingCartPage(driver);
	}

	// Business Logic
}
