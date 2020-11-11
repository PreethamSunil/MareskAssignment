package com.maresk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.maresk.utilities.UT01_WaitHelper;

public class Page03_FlightsResults {

	public WebDriver ldriver;
	public UT01_WaitHelper wh;

	public Page03_FlightsResults(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wh = new UT01_WaitHelper(rdriver);

	}

	@FindBy(tagName = "h3")
	@CacheLookup
	WebElement lblSearch;
	
	By tblSearchColoumn = By.xpath("//table[@class='table']//th");
	
	By tblSearchRow = By.xpath("//table[@class='table']//tr");

	public String cmdCompareSearchLabel() {
		wh.waitHelp(lblSearch, 30);
		return lblSearch.getText();

	}
	
	public int cmdValidateSerachColumnCount()
	{
		return ldriver.findElements(tblSearchColoumn).size();	
	}

	public int cmdValidateSerachResultsCount()
	{
		return ldriver.findElements(tblSearchRow).size();	
	}
	
	public void cmdFlightSelect(String Flightnum)
	{
			for(int i =1; i<=cmdValidateSerachResultsCount();i++ )
			{
				if(ldriver.findElement(By.xpath("//table[@class='table']/tbody[1]/tr[" + i + "]/td[2]")).getText().equals(Flightnum))
						{
					ldriver.findElement(By.xpath("//table[@class='table']/tbody[1]/tr[" + i + "]/td[1]")).click();
						}
			}
	}

}
