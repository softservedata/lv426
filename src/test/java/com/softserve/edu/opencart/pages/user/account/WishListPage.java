package com.softserve.edu.opencart.pages.user.account;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WishListPage extends AccountSidebarLoggedPart {

	protected WebDriver driver;
	protected WebElement wishListLayout;

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

}
