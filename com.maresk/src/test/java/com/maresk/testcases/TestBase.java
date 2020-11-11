package com.maresk.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.maresk.utilities.*;
import com.maresk.pages.Page01_Login;
import com.maresk.pages.Page02_Home;
import com.maresk.pages.Page03_FlightsResults;
import com.maresk.pages.Page04_FlightBooking;
import com.maresk.pages.Page05_FlightConfirmation;


public class TestBase {

	public WebDriver driver;
	public UT02_ReadConfig rc;
	public Logger logger;
	public String browser = "chrome";
	public Page01_Login Lp;
	public Page02_Home Hp;
	public Page03_FlightsResults Sp;
	public Page04_FlightBooking Bp;
	public UT04_DataDriven Dd;
	public String Userid;
	public String Password;
	public Page05_FlightConfirmation Fc;
	
	@BeforeSuite
	public void Setup() throws IOException {
		logger = Logger.getLogger("Automation Logger");
		PropertyConfigurator.configure("../com.maresk/log4j.properties");
		logger.info("----------Automation Scripts are Strated----------- ");

		System.setProperty("webdriver.chrome.driver", "../com.maresk/drivers/chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
		logger.info("Chrome Browser has been Initiated");

		rc = new UT02_ReadConfig();
		Lp = new Page01_Login(driver);
		Hp = new Page02_Home(driver);
		Sp = new Page03_FlightsResults(driver);
		Bp = new Page04_FlightBooking(driver);
		Dd = new UT04_DataDriven();
		Fc = new Page05_FlightConfirmation(driver);

		driver.navigate().to( rc.getUrl());
		logger.info("Launched the URL " + rc.getUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		

		

	}

	@AfterSuite
	public void teardown() {
		driver.quit();
		logger.info("---------Driver has been Terminated Successfully---------");

	}

}
