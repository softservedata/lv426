package com.softserve.edu.opencart.pages.user;

import com.softserve.edu.opencart.pages.user.common.ProductsContainerComponent;
import com.softserve.edu.opencart.pages.user.common.TopPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends TopPart {

	public static final String EXPECTED_IPHONE6 = "iPhone6";
	//
	private WebElement slideshow0;
	//
	private ProductsContainerComponent productsContainerComponent;

	public HomePage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
		slideshow0 = driver.findElement(By.id("slideshow0"));
		productsContainerComponent = new ProductsContainerComponent(driver);
	}

	// Page Object

	// slideshow0
	private WebElement getSlideshow0() {
		return slideshow0;
	}

	private WebElement getSlideshow0FirstImage() {
		return getSlideshow0().findElement(By.xpath(".//a/img"));
	}

	private String getSlideshow0FirstImageAttributeText(String attribute) {
		return getSlideshow0FirstImage().getAttribute(attribute).trim();
	}

	public String getSlideshow0FirstImageAttributeSrcText() {
		return getSlideshow0FirstImageAttributeText(TAG_ATTRIBUTE_SRC);
	}

	// productComponentsContainer
	public ProductsContainerComponent getProductComponentsContainer() {
		return productsContainerComponent;
	}

	// Functional

	// Business Logic
}
