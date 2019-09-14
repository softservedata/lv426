package com.softserve.edu.opencart.pages.user.common;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsContainerComponent {

    public final String PRODUCT_NOT_FOUND = "There is no product that matches the search criteria.";
    private final String PRODUCT_COMPONENT_CSSSELECTOR = ".product-layout";
    //
    protected WebDriver driver;
	//
	private List<ProductComponent> productComponents;

	public ProductsContainerComponent(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		// init elements
        productComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(PRODUCT_COMPONENT_CSSSELECTOR)))
        {
            productComponents.add(new ProductComponent(current));
        }
	}

	// Page Object
	
    // productComponents
    public List<ProductComponent> getProductComponents()
    {
        return productComponents;
    }

    // Functional

    public List<String> getProductComponentNames()
    {
        List<String> productComponentNames = new ArrayList<>();
        for (ProductComponent current : getProductComponents())
        {
            productComponentNames.add(current.getNameText());
        }
        return productComponentNames;
    }

    public ProductComponent getProductComponentByName(String productName)
    {
        ProductComponent result = null;
        for (ProductComponent current : getProductComponents())
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
        return getProductComponentByName(productName).getPriceText();
    }

    public String getProductComponentDescriptionByName(String productName)
    {
        return getProductComponentByName(productName).getPartialDescriptionText();
    }

    public void clickProductComponentAddToCartButtonByName(String productName)
    {
        getProductComponentByName(productName).clickAddToCartButton();
    }

    public void clickProductComponentAddToWishButtonByName(String productName)
    {
        getProductComponentByName(productName).clickAddToWishButton();
    }

    public int getProductComponentsCount()
    {
        return getProductComponents().size();
    }

    //public String getProductComponentPriceByProduct(Product product)
    //{
    //    return getProductComponentPriceByName(product.getName());
    //}

    //public String getProductComponentDescriptionByProduct(Product product)
    //{
    //    return getProductComponentDescriptionByName(product.getName());
    //}

    // Business Logic

}