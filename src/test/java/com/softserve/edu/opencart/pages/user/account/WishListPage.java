package com.softserve.edu.opencart.pages.user.account;

import com.softserve.edu.opencart.data.Product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


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

	public int  getElementsCountInList(){
		int productCount = getProductComponentsContainer()
		.getWishListComponentsCount();
		return productCount;
	}
	public String  getProductModel(Product product){
		String productModel = getProductComponentsContainer()
				.getWishListComponentModelByName(product.getName());
		return productModel;
	}

	public String  getPresentsInStock(Product product){
		String presentsInStock = getProductComponentsContainer()
				.getWishListComponentStockStatusByName(product.getName());
		return presentsInStock;
	}

	public List<String> getInfoAboutProduct(Product product){
		List<String> stringList= new ArrayList<String>() ;
		stringList.add(getProductModel(product));
		stringList.add(getPresentsInStock(product));
		return stringList;
	}




}
