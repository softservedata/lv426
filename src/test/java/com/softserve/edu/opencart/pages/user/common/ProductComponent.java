package com.softserve.edu.opencart.pages.user.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.softserve.edu.opencart.tools.PriceUtils.getCurrency;
import static com.softserve.edu.opencart.tools.PriceUtils.getSpecialCurrency;

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
		addToWishButton = productLayout.findElement(By.cssSelector(".fa.fa-heart"));
		addToCompareButton = productLayout.findElement(By.cssSelector(".fa.fa-exchange"));

	}

	// Page Object

	// product
	private WebElement getProductLayout() {
		return productLayout;
	}

	// name
	public WebElement getName() {
		return name;
	}

	public String getNameText() {
		return getName().getText();
	}
	private WebElement getNewPrice() {
		return getProductLayout().findElement(By.xpath(".//span[@class='price-new']"));
	}
	private WebElement getOldProductPrice() {
		return getProductLayout().findElement(By.xpath(".//span[@class='price-old']"));
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
		return productLayout.findElement(By.cssSelector(".fa.fa-shopping-cart"));
	}

	public void clickAddToCartButton() {
		getAddToCartButton().click();
	}
	//	public SearchSuccessPage clickAddToCartButton() {
//		getAddToCartButton().click();
//		return new SearchSuccessPage();
//	}

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

	private double getSpecial() {
		return getSpecialCurrency(getNewPrice().getText());
	}

	private double getOld() {
		return getSpecialCurrency(getOldProductPrice().getText());
	}





	public Map<String, Double> getNewPrices() {
		Map<String, Double> rezult = new HashMap<>();
		rezult.put("NewPrice", getSpecial());
		rezult.put("OldPrice", getOld());
		return rezult;
	}







}
