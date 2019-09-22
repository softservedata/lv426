package com.softserve.edu.opencart.pages.user.account;

import com.softserve.edu.opencart.pages.user.common.ProductComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class WishListContainerComponent {

	protected WebDriver driver;
	private final String PRODUCT_COMPONENT_CSSSELECTOR = ".product-layout";
	private List<WishListComponent> wishListComponents;
	public WishListContainerComponent(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		wishListComponents = new ArrayList<>();
		for (WebElement current : driver.findElements(By.cssSelector(PRODUCT_COMPONENT_CSSSELECTOR)))
		{
			wishListComponents.add(new WishListComponent(current));
		}
	}
	public List<WishListComponent> getWishListComponents()
	{
		return wishListComponents;
	}
	// Page Object

	// Functional
	public List<String> getProductComponentNames()
	{
		List<String> wishListComponentNames = new ArrayList<>();
		for (WishListComponent current : getWishListComponents())
		{
			wishListComponentNames.add(current.getNameText());
		}
		return wishListComponentNames;
	}

	public WishListComponent getWishListComponentByName(String productName)
	{
		WishListComponent result = null;
		for (WishListComponent current : getWishListComponents())
		{
			if (current.getNameText().toLowerCase()
					.equals(productName.toLowerCase()))
			{
				result = current;
				break;
			}
		}
		if (result == null)
		{
			// TODO Develop Custom Exception
			throw new RuntimeException("ProductName: " + productName + " not Found.");
		}
		return result;
	}

	public String getProductComponentPriceByName(String productName)
	{
		return getWishListComponentByName(productName).getPriceText();
	}


	public void clickOnWishListComponentAddToCartButton(String productName)
	{
		getWishListComponentByName(productName).clickAddToCartButton();
	}

	public void clickOnWishListComponentDeleteButton(String productName)
	{
		getWishListComponentByName(productName).clickDeleteFromWishListButton();
	}



	public int getWishListComponentsCount()
	{
		return getWishListComponents().size();
	}

	// Business Logic
}
