package com.maresk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.maresk.utilities.UT01_WaitHelper;
import com.maresk.utilities.UT05_GenericMethods;

public class Page04_FlightBooking {

	public WebDriver ldriver;
	public UT01_WaitHelper wh;
	public UT05_GenericMethods Gm;

	public Page04_FlightBooking(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wh = new UT01_WaitHelper(rdriver);
		Gm = new UT05_GenericMethods();
	}

	@FindBy(id = "inputName")
	@CacheLookup
	WebElement txtName;

	@FindBy(id = "address")
	@CacheLookup
	WebElement txtAddress;

	@FindBy(id = "city")
	@CacheLookup
	WebElement txtCity;

	@FindBy(id = "state")
	@CacheLookup
	WebElement txtState;

	@FindBy(id = "zipCode")
	@CacheLookup
	WebElement txtZipCode;

	@FindBy(id = "creditCardNumber")
	@CacheLookup
	WebElement txtCreditCardNumber;

	@FindBy(id = "creditCardMonth")
	@CacheLookup
	WebElement txtCreditCardMonth;

	@FindBy(id = "creditCardYear")
	@CacheLookup
	WebElement txtCreditCardYear;

	@FindBy(id = "nameOnCard")
	@CacheLookup
	WebElement txtNameOnCard;

	@FindBy(id = "cardType")
	@CacheLookup
	WebElement drpCardType;

	@FindBy(xpath = "//input[@type='submit']")
	@CacheLookup
	WebElement btnPurchase;

	public void cmdEnterName(String input) {
		wh.waitHelp(txtName, 30);
		txtName.sendKeys(input);
	}

	public void cmdEnterAddress(String input) {
		wh.waitHelp(txtAddress, 30);
		txtAddress.sendKeys(input);
	}

	public void cmdEnterCity(String input) {
		wh.waitHelp(txtCity, 30);
		txtCity.sendKeys(input);
	}

	public void cmdEnterState(String input) {
		wh.waitHelp(txtState, 30);
		txtState.sendKeys(input);
	}

	public void cmdEnterZipCode(String input) {
		wh.waitHelp(txtZipCode, 30);
		txtZipCode.sendKeys(input);
	}

	public void cmdEntertxtCreditCardNumber(String input) {
		wh.waitHelp(txtCreditCardNumber, 30);
		txtCreditCardNumber.sendKeys(input);
	}

	public void cmdEntertxtCreditCardMonth(String input) {
		wh.waitHelp(txtCreditCardMonth, 30);
		txtCreditCardMonth.clear();
		txtCreditCardMonth.sendKeys(input);
	}

	public void cmdEntertxtCreditCardYear(String input) {
		wh.waitHelp(txtCreditCardYear, 30);
		txtCreditCardYear.clear();
		txtCreditCardYear.sendKeys(input);
	}

	public void cmdEntertxtNameOnCard(String input) {
		wh.waitHelp(txtNameOnCard, 30);
		txtNameOnCard.sendKeys(input);
	}

	public void cmdEnterdrpCardType(String input) {
		wh.waitHelp(drpCardType, 30);
		drpCardType.sendKeys(input);
	}

	public void cmdScrolltpPurchase() {
		wh.waitHelp(btnPurchase, 30);
		Gm.cmdScroll(ldriver, btnPurchase);
	}
	
	public void cmdClickPurchase()
	{
		wh.waitHelp(btnPurchase, 30);
		btnPurchase.click();
	}
}
