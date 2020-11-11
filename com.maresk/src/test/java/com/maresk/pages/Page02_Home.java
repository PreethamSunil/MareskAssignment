package com.maresk.pages;

import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.maresk.utilities.UT01_WaitHelper;

public class Page02_Home {

	public WebDriver ldriver;
	public UT01_WaitHelper wh;
	public HashSet<String> DepSet;
	public HashSet<String> ArrSet;

	public Page02_Home(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wh = new UT01_WaitHelper(rdriver);

	}

	@FindBy(tagName = "h1")
	@CacheLookup
	WebElement lblWelcome;

	@FindBy(xpath = "//select[@name='fromPort']")
	@CacheLookup
	WebElement drpFromport;

	@FindBy(xpath = "//select[@name='toPort']")
	@CacheLookup
	WebElement drpToport;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	@CacheLookup
	WebElement btnFindFlights;

	public String cmdGetWelcomeMessage() {
		wh.waitHelp(lblWelcome, 30);
		return lblWelcome.getText();
	}

	public void fromPortList(HashSet<String> ExpectedSet) {
		wh.waitHelp(drpFromport, 30);
		Select fromport = new Select(drpFromport);
		DepSet = new HashSet<String>();
		List<WebElement> FromCity = fromport.getOptions();
		for (WebElement x : FromCity) {
			System.out.println(x.getText());
			DepSet.add(x.getText());
		}

		Assert.assertEquals(DepSet, ExpectedSet, "Departure List is Validated");

	}

	public void fromToList(HashSet<String> ExpectedSet) {
		wh.waitHelp(drpToport, 30);
		Select fromport = new Select(drpToport);
		ArrSet = new HashSet<String>();
		List<WebElement> FromCity = fromport.getOptions();
		for (WebElement x : FromCity) {
			System.out.println(x.getText());
			ArrSet.add(x.getText());
		}
		Assert.assertEquals(ArrSet, ExpectedSet, "Arrival List is Validated");
	}

	public void SelectfromPortList(String city) {
		wh.waitHelp(drpFromport, 30);
		Select fromcity = new Select(drpFromport);
		fromcity.selectByVisibleText(city);
	}

	public void SelectToPortList(String city) {
		wh.waitHelp(drpToport, 30);
		Select Tocity = new Select(drpToport);
		Tocity.selectByVisibleText(city);
	}
	
	public void cmdSearch()
	{
		wh.waitHelp(btnFindFlights, 30);
		btnFindFlights.click();
		
	}
}
