package com.softserve.edu.opencart.pages.user.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.softserve.edu.opencart.tools.PriceUtils.getCurrency;

public class ProductComponent {

	private WebElement productLayout;
	//
	public WebElement name;
	public WebElement partialDescription;
	public WebElement price;
	public WebElement addToCartButton;
	public WebElement addToWishButton;
	public WebElement addToCompareButton;

	public ProductPage productPage;

	public ProductComponent(WebElement productLayout) {
		this.productLayout = productLayout;
		initElements();
	}

	public ProductComponent() {

	}

	private void initElements() {
		// init elements
		name = productLayout.findElement(By.cssSelector("h4 a"));
		partialDescription = productLayout.findElement(By.cssSelector("h4 + p"));
		price = productLayout.findElement(By.cssSelector(".price"));
		addToCartButton = productLayout.findElement(By.cssSelector(".fa.fa-shopping-cart"));
		addToWishButton = productLayout.findElement(By.cssSelector(".fa.fa-heart"));
		addToCompareButton = productLayout.findElement(By.cssSelector(".fa.fa-exchange"));

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

	// partialDescription
	public WebElement getPartialDescription() {
		return partialDescription;
	}

	public String getPartialDescriptionText() {
		return getPartialDescription().getText();
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

	// addToWishButton
	public WebElement getAddToWishButton() {
		return addToWishButton;
	}

	public void clickAddToWishButton() {
		getAddToWishButton().click();
	}

	// addToCompareButton
	public WebElement getAddToCompareButton() {
		return addToCompareButton;
	}

	public void clickAddToCompareButton() {
		getAddToCompareButton().click();
	}




	// Functional

	public boolean hasName(String name) {
		return getNameText().equals(name);//TODO
	}

	public double getCurrentPrice() {
		return getCurrency(getPrice().getText());
	}
	// Business Logic

}
