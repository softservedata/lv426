package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListComponent {

	private WebElement productLayout;
	private WebElement price;
	private WebElement addToCartButton;
	private WebElement name;
	private WebElement deleteFromWishListButton;
	private WebElement model;

	public WishListComponent(WebElement productLayout) {
		this.productLayout = productLayout;
		initElements();
	}

	private void initElements() {
		name = productLayout.findElement(By.cssSelector("h4 a"));
		model=productLayout.findElement(By.xpath("//div[@class='table-responsive']//td/a[text()='MacBook']/../following-sibling::td[text()='Product 16']"));
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
