package com.softserve.edu.opencart.pages.user.common;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BreadCrumbPart extends TopPart {

    private final String BREADCRUMB_COMPONENT_CSSSELECTOR = "ul.breadcrumb li";
    //
    private WebElement breadCrumb;
    //
    private List<WebElement> breadCrumbComponents;
	
	public BreadCrumbPart(WebDriver driver) {
		super(driver);
		initElements();
	}

    public BreadCrumbPart() {
        super();
    }

    private void initElements() {
		// init elements
		breadCrumb = driver.findElement(By.cssSelector("ul.breadcrumb"));
		//
		breadCrumbComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(BREADCRUMB_COMPONENT_CSSSELECTOR)))
        {
        	breadCrumbComponents.add(current);
        }

	}

	// Page Object

	// breadCrumb
	public WebElement getBreadCrumb() {
		return breadCrumb;
	}
	
	// breadCrumbComponents
	public List<WebElement> getBreadCrumbComponents()
    {
        return breadCrumbComponents;
    }
	
	// Functional
	
    public List<String> getBreadCrumbComponentNames()
    {
        List<String> componentNames = new ArrayList<>();
        for (WebElement current : getBreadCrumbComponents())
        {
        	// TODO for first element
        	componentNames.add(current.getText());
        }
        return componentNames;
    }

    public WebElement getBreadCrumbComponentByName(String breadCrumbName)
    {
        WebElement result = null;
        for (WebElement current : getBreadCrumbComponents())
        {
        	// TODO for first element
        	if (current.findElement(By.cssSelector("a")).getText()
        			.toLowerCase().trim()
        			.contains(breadCrumbName.toLowerCase().trim())) {
        		result = current;
        		break;
        	}
        } 
        if (result == null)
        {
            // TODO Develop Custom Exception
            throw new RuntimeException("BreadCrumbName: " + breadCrumbName + " not Found.");
        }
        return result;
    }

    public void clickBreadCrumbComponentByName(String breadCrumbName)
    {
    	getBreadCrumbComponentByName(breadCrumbName).click();
    }

	// Business Logic
}
