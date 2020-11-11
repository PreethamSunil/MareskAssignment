package com.maresk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.maresk.utilities.UT01_WaitHelper;




public class Page05_FlightConfirmation {
	public WebDriver ldriver;
	public UT01_WaitHelper wh;

	public Page05_FlightConfirmation(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wh = new UT01_WaitHelper(rdriver);
	}
	
	@FindBy(tagName = "h1")
	@CacheLookup
	WebElement lblConfirmation;
	
	public void cmdConfirmBooking()
	{
		wh.waitHelp(lblConfirmation, 60);
		Assert.assertEquals("Thank you for your purchase today!", lblConfirmation.getText());
	}
	
}

