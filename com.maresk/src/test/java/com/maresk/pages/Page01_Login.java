package com.maresk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.maresk.utilities.UT01_WaitHelper;

public class Page01_Login {
	public WebDriver ldriver;
	public UT01_WaitHelper wh;

	public Page01_Login(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wh = new UT01_WaitHelper(rdriver);

	}

	@FindBy(linkText = "BlazeDemo")
	@CacheLookup
	WebElement lblBlazeDemo;

	@FindBy(id = "email")
	@CacheLookup
	WebElement txtemail;

	@FindBy(id = "password")
	@CacheLookup
	WebElement txtpassword;

	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(xpath = "//div[text()='Dashboard']")
	@CacheLookup
	WebElement lblDashboard;

	public void cmdEnterEmail(String email) {
		wh.waitHelp(txtemail, 60);
		txtemail.sendKeys(email);
	}
	
	public void cmdEnterPassword(String password) {
		wh.waitHelp(txtpassword, 30);
		txtpassword.sendKeys(password);
	}
	
	public void cmdClickLogin() {
		wh.waitHelp(btnLogin, 30);
		btnLogin.sendKeys();
	}

}
