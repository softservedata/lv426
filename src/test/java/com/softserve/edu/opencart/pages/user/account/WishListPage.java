package com.softserve.edu.opencart.pages.user.account;

import com.softserve.edu.opencart.data.Product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WishListPage extends AccountSidebarLoggedPart {

	protected WebDriver driver;
	protected WebElement wishListLayout;
	
	private WishListContainerComponent wishListContainer;


	public WishListPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	public void initElements(){
		wishListContainer = new WishListContainerComponent(driver);
	}
	public WishListContainerComponent getProductComponentsContainer() {
		return wishListContainer;
	}


	// Business Logic

	public WishListAlertPage deleteItemFromWishList(Product product){
		getProductComponentsContainer().
				clickOnWishListComponentDeleteButton(product.getName());
		return new WishListAlertPage(driver);
	}


	public WishListAlertPage addItemFromWishListToShoppingCart(Product product){
		getProductComponentsContainer().clickOnWishListComponentAddToCartButton(product.getName());
		return new WishListAlertPage(driver);
	}





}
