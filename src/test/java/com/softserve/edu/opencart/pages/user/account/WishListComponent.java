package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WishListComponent {

	private WebElement wishListLayout;
	private WebElement price;
	private WebElement addToCartButton;
	private WebElement name;
	private WebElement deleteFromWishListButton;
	private WebElement model;
	private WebElement stock;

	public WishListComponent(WebElement wishListLayout) {
		this.wishListLayout = wishListLayout;
		initElements();
	}

	private void initElements() {
		name = wishListLayout.findElement(By.xpath("//tbody/tr/td[2]/a"));
		model= wishListLayout.findElement(By.xpath("//tbody/tr/td[3]"));
		stock = wishListLayout.findElement(By.xpath("//tbody/tr/td[4]"));
		price = wishListLayout.findElement(By.cssSelector(".price"));
		addToCartButton = wishListLayout.findElement(By.cssSelector("td button .fa.fa-shopping-cart"));
		deleteFromWishListButton = wishListLayout.findElement(By.xpath("td a .fa.fa-times"));

	}

	// Page Object
	// product
	public WebElement getWishListLayout() {
		return wishListLayout;
	}

	// name
	public WebElement getName() {
		return name;
	}

	public String getNameText() {
		return getName().getText();
	}

	public void clickName() {
		getName().click();
	}

	//model
	public WebElement getModel() {
		return model;
	}

	public String getModelText() {
		return getModel().getText();
	}

	//amount in stock
	public WebElement getStockStatus() {
		return stock;
	}

	public String getStockStatusText() {
		return getStockStatus().getText();
	}

	// price
	public WebElement getPrice() {
		return price;
	}

	public String getPriceText() {
		return getPrice().getText();
	}

	// addToCartButton
	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public void clickAddToCartButton() {
		getAddToCartButton().click();
	}

	// deleteFromWishListButton
	public WebElement getDeleteFromWishListButton() {
		return deleteFromWishListButton;
	}

	public void clickDeleteFromWishListButton() {
		getDeleteFromWishListButton().click();
	}


	// Functional

	// Business Logic
}
