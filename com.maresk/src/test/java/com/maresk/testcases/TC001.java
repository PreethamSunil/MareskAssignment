package com.maresk.testcases;

import java.io.IOException;
import java.util.HashSet;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001 extends TestBase {

	@Test(priority = 1)
	public void VerifyHomePage() {
		logger.info("TC001 -- Test Verify Home Page Started -- ");
		String WelcomeMessage = Hp.cmdGetWelcomeMessage();
		Assert.assertEquals("Welcome to the Simple Travel Agency!", WelcomeMessage);
		logger.info("TC001 -- Test Verify Home Page Completed Succesfully -- ");
	}

	@Test(priority = 2)
	public void Validate_DepartureCityList() {
		logger.info("TC002 -- Started --Test to validate Departure City List -- ");
		HashSet<String> ExpectDep = new HashSet<String>();
		ExpectDep.add("Paris");
		ExpectDep.add("Philadelphia");
		ExpectDep.add("Boston");
		ExpectDep.add("Portland");
		ExpectDep.add("San Diego");
		ExpectDep.add("Mexico City");
		ExpectDep.add("São Paolo");
		Hp.fromPortList(ExpectDep);
		logger.info("TC002 -- Completed --Test to validate Departure City List -- ");

	}

	@Test(priority = 3)
	public void Validate_ArrivalCityList() {
		logger.info("TC003 -- Started --Test to validate Arrival City List -- ");
		HashSet<String> ExpectArr = new HashSet<String>();
		ExpectArr.add("Buenos Aires");
		ExpectArr.add("Rome");
		ExpectArr.add("London");
		ExpectArr.add("Berlin");
		ExpectArr.add("New York");
		ExpectArr.add("Dublin");
		ExpectArr.add("Cairo");
		Hp.fromToList(ExpectArr);
		logger.info("TC003 -- Completed --Test to validate Arrival City List -- ");

	}

	@Test(priority = 4)
	public void ValidateSearchFlightResults() {
		logger.info("TC004 -- Started --Test to validate flight Search -- ");
		String FromCity = "Boston";
		String ToCity = "London";
		Hp.SelectfromPortList(FromCity);
		Hp.SelectToPortList(ToCity);
		Hp.cmdSearch();
		String ExpectedLabel = "Flights from " + FromCity + " to " + ToCity + ":";
		Assert.assertEquals(Sp.cmdCompareSearchLabel(), ExpectedLabel);
		Assert.assertEquals(Sp.cmdValidateSerachColumnCount(), 6);
		Assert.assertEquals(Sp.cmdValidateSerachResultsCount(), 6);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("TC004 -- Completed --Test to validate flight Search -- ");
	}

	@Test(priority = 5)
	public void BookFlights() throws IOException
	{
		logger.info("TC005 -- Started --Test to validate Book flights -- ");
		String SheetName = "Flight";
		int rowcount = Dd.getRowCount(SheetName);
		for (int i = 1; i <= rowcount; i++) {
		String[] Data = Dd.getValue(SheetName, i, 0).split(":");
		Sp.cmdFlightSelect(Data[1]);
		Bp.cmdEnterName(Dd.getValue(SheetName, i, 1));
		Bp.cmdEnterAddress(Dd.getValue(SheetName, i, 2));
		Bp.cmdEnterCity(Dd.getValue(SheetName, i, 3));
		Bp.cmdEnterState(Dd.getValue(SheetName, i, 4));
		Bp.cmdScrolltpPurchase();
		Bp.cmdEnterZipCode(Dd.getValue(SheetName, i, 5));
		Bp.cmdEnterdrpCardType(Dd.getValue(SheetName, i, 6));
		Bp.cmdEntertxtCreditCardNumber(Dd.getValue(SheetName, i, 7));
		Bp.cmdEntertxtCreditCardMonth(Dd.getValue(SheetName, i,8));
		Bp.cmdEntertxtCreditCardYear(Dd.getValue(SheetName, i, 9));
		Bp.cmdEntertxtNameOnCard(Dd.getValue(SheetName,i, 10));
		Bp.cmdClickPurchase();
		Fc.cmdConfirmBooking();
		logger.info("TC005 -- Completed --Test to validate Book flights -- ");
		}
	}
}

