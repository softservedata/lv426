package com.softserve.edu.opencart.pages.user.account;

import com.softserve.edu.opencart.pages.user.common.ProductPageWithAlert;

import org.openqa.selenium.By;
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

	public WishListPageModifiedByAlert deleteItemFromWishList(String productName){
		getProductComponentsContainer().
				clickOnWishListComponentDeleteButton(productName);
		return new WishListPageModifiedByAlert(driver);
	}


	public WishListPageModifiedByAlert addItemFromWishListToShoppingCart(String productName){
		getProductComponentsContainer().clickOnWishListComponentAddToCartButton(productName);
		return new WishListPageModifiedByAlert(driver);
	}





}
