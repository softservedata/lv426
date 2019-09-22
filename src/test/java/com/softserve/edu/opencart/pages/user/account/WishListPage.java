package com.softserve.edu.opencart.pages.user.account;


import com.softserve.edu.opencart.pages.user.common.Alerts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class WishListPage extends AccountSidebarLoggedPart {

	protected WebDriver driver;
	protected WebElement wishListLayout;

	private Alerts alerts;
	private WebElement successfulAddingToShoppingCartFromWishListAlert;
	private WebElement successfulDeletingFromWishListAlert;
	private WishListContainerComponent wishListContainer;
	private WishListComponent wishListComponent;
	//private ProductDescriptionComponent productDescription;
	//public ProductReviewComponent productReview;

	public WishListPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	public void initElements(){
		wishListContainer = new WishListContainerComponent(driver);
		wishListComponent = new WishListComponent(wishListLayout);

		successfulDeletingFromWishListAlert = wishListLayout.findElement(By.cssSelector(".alert.alert-success.alert-dismissible"));
		successfulAddingToShoppingCartFromWishListAlert = wishListLayout.findElement(By.cssSelector(".alert.alert-success.alert-dismissible"));

    }
	public WishListContainerComponent getProductComponentsContainer() {
		return wishListContainer;
	}





	// Page Object



	// Functional


	// Business Logic
	public WishListPage deleteItemFromWishList(String productName){
		getProductComponentsContainer().clickOnWishListComponentDeleteButton(productName);
		return new WishListPage(driver);
	}
	public WebElement successfulDeletingFromWishList(){
		deleteItemFromWishList(wishListComponent.getNameText());
		alerts = new Alerts(successfulDeletingFromWishListAlert);
		return alerts.getAlert();
	}

	public void addItemFromWishListToShoppingCart(String productName){
		getProductComponentsContainer().clickOnWishListComponentAddToCartButton(productName);
	}

	public WebElement successfulAddingToShoppingCartFromWishList(){

		addItemFromWishListToShoppingCart(wishListComponent.getNameText());
		alerts = new Alerts(successfulAddingToShoppingCartFromWishListAlert);
		return alerts.getAlert();
	}
	/*
	public WishListContainerComponent getWishListContainer(){
		List<Object> wishListProducts = new ArrayList<Object>();
		wishListProducts = Collections.singletonList(wishListContainer.getWishListComponents());

	}
	*/


}
