package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WishListComponent {

	private WebElement productLayout;
	private WebElement price;
	private WebElement addToCartButton;
	private WebElement name;
	private WebElement deleteFromWishListButton;
	private WebElement model;
	private WebElement stock;

	public WishListComponent(WebElement productLayout) {
		this.productLayout = productLayout;
		initElements();
	}

	private void initElements() {
		name = productLayout.findElement(By.xpath("//tbody/td/a"));
		model=productLayout.findElement(By.xpath("//tbody/td[2]]"));
		stock=productLayout.findElement(By.xpath("//tbody/td[3]]"));
		price = productLayout.findElement(By.cssSelector(".price"));
		addToCartButton = productLayout.findElement(By.cssSelector(".fa.fa-shopping-cart"));
		deleteFromWishListButton = productLayout.findElement(By.xpath(".fa.fa-times"));

	}

	// Page Object
	// product
	public WebElement getProductLayout() {
		return productLayout;
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
	// model
	public WebElement getModel() {
		return model;
	}

	public String getModelText() {
		return getModel().getText();
	}
	// presents in stock
	public WebElement getPresentsInStock() {
		return stock;
	}

	public String getStockText() {
		return getPresentsInStock().getText();
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
