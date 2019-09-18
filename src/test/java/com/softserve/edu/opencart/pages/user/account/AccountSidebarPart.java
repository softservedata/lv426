package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;

public class AccountSidebarPart extends BreadCrumbPart {

	private WebElement myAccountRight;
	private WebElement addressBookRight;
	private WebElement wishListRight;
	private WebElement orderHistoryRight;
	private WebElement downloadsRight;
	private WebElement recurringpaymentsRight;
	private WebElement rewardPointsRight;
	private WebElement returnsRight;
	private WebElement transactionsRight;
	private WebElement newsletterRight;

	public AccountSidebarPart(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
		myAccountRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/account')]"));
		addressBookRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/address')]"));
		wishListRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/wishlist')]"));
		orderHistoryRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/order')]"));
		downloadsRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/download')]"));
		recurringpaymentsRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/recurring')]"));
		rewardPointsRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/reward')]"));
		returnsRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/return')]"));
		transactionsRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/transaction')]"));
		newsletterRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/newsletter')]"));
	}

	// Page Object

	// myAccountRight
	// addressBookRight
	// wishListRight
	// orderHistoryRight
	// downloadsRight
	// recurringpaymentsRight
	// rewardPointsRight
	// returnsRight
	// transactionsRight
	// newsletterRight

	// Functional

	// Business Logic
}
