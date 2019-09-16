package com.softserve.edu.opencart.pages.user.account;

import com.softserve.edu.opencart.pages.user.common.ProductComponent;
import com.softserve.edu.opencart.pages.user.common.TopPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListPage extends AccountSidebarLoggedPart {

	public WishListPage(WebDriver driver) {
		super(driver);
		initElements();
	}
	private WebElement deleteFromWishListButton;
	private WebElement addToCartFromWishListButton;

	private void initElements() {
		deleteFromWishListButton = driver.findElement(By.xpath("//td[contains(text(),'Product 16')]/following-sibling::td/a[contains(@class,'btn btn-danger')]"));

		addToCartFromWishListButton = driver.findElement(By.xpath("//ul[@class='list-inline']/li/a/i[@class='fa fa-shopping-cart']"));

	}

	// Page Object

	// Functional
	public void clickDeleteFromWishListButton() {
		deleteFromWishListButton.click();
	}
	public void clickAddToCartFromWishListButton() {
		addToCartFromWishListButton.click();
	}

	// Business Logic

}
