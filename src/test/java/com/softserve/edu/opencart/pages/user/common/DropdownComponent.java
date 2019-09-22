package com.softserve.edu.opencart.pages.user.common;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownComponent {

	protected WebDriver driver;
	//
	private List<WebElement> listOptions;
<<<<<<< HEAD

=======
	
>>>>>>> 40c679a4d7b258b0d93712d093a711e40eed356b
	public DropdownComponent(WebDriver driver, By searchLocator) {
		this.driver = driver;
		initElements(searchLocator);
	}

	private void initElements(By searchLocator) {
		// init elements
<<<<<<< HEAD
		listOptions = driver.findElements(searchLocator);
		// listOptions = search.getWebElements(searchLocator); // for Strategy
=======
        listOptions = driver.findElements(searchLocator);
        // listOptions = search.getWebElements(searchLocator); // for Strategy
>>>>>>> 40c679a4d7b258b0d93712d093a711e40eed356b
	}

	// Page Object

	// listOptions
	public List<WebElement> getListOptions() {
		return listOptions;
	}

	// Functional

	// listOptions
<<<<<<< HEAD
	public WebElement getDropdownOptionByPartialName(String optionName)
	{
		WebElement result = null;
		for (WebElement current : getListOptions())
		{
			if (current
					.getText()
					.toLowerCase()
					.contains(optionName.toLowerCase()))
			{
				result = current;
				break;
			}
		}
		if (result == null)
		{
			// TODO Develop Custom Exception
			throw new RuntimeException("OptionName not Found.");
		}
		return result;
	}

	public List<String> getListOptionsText()
	{
		List<String> result = new ArrayList<>();
		for (WebElement current : getListOptions())
		{
			result.add(current.getText());
		}
		return result;
	}

	public boolean isExistDropdownOptionByPartialName(String optionName)
	{
		boolean isFound = false;
		for (String current : getListOptionsText())
		{
			if (current.toLowerCase()
					.contains(optionName.toLowerCase()))
			{
				isFound = true;
				break;
			}
		}
		return isFound;
	}

	public void clickDropdownOptionByPartialName(String optionName)
	{
		getDropdownOptionByPartialName(optionName).click();
	}

	// Business Logic

}
=======
    public WebElement getDropdownOptionByPartialName(String optionName)
    {
        WebElement result = null;
        for (WebElement current : getListOptions())
        {
            if (current
            		.getText()
            		.toLowerCase()
            		.contains(optionName.toLowerCase()))
            {
                result = current;
                break;
            }
        }
        if (result == null)
        {
            // TODO Develop Custom Exception 
            throw new RuntimeException("OptionName not Found.");
        }
        return result;
    }

    public List<String> getListOptionsText()
    {
        List<String> result = new ArrayList<>();
        for (WebElement current : getListOptions())
        {
            result.add(current.getText());
        }
        return result;
    }

    public boolean isExistDropdownOptionByPartialName(String optionName)
    {
    	boolean isFound = false;
        for (String current : getListOptionsText())
        {
            if (current.toLowerCase()
            		.contains(optionName.toLowerCase()))
            {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    public void clickDropdownOptionByPartialName(String optionName)
    {
        getDropdownOptionByPartialName(optionName).click();
    }
    
	// Business Logic
    
}
>>>>>>> 40c679a4d7b258b0d93712d093a711e40eed356b
