package com.newtours.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.FindFlightPage;
import pages.FlightConfirmationPage;
import pages.FlightDetailPage;
import pages.RegistrationConfirmationPage;
import pages.RegistrationPage;
import tests.BaseTest;

public class BookFlightTest extends BaseTest{
	
   private String noOfPassengers;
	private String expectedPrice;
	
	@BeforeTest
	@Parameters({"noOfPassengers","expectedPrice"})
	public void setupParameters(String noOfPassengers, String expectedPrice){
		this.noOfPassengers=noOfPassengers;
		this.expectedPrice=expectedPrice;
		
	}
	
	@Test
	public void registrationPage(){
		RegistrationPage registeratioPage=new RegistrationPage(driver);
		registeratioPage.goTo();
		registeratioPage.enterUserDetails("selenium", "docker");
		registeratioPage.enterUserCredentials("selenium", "docker");
		registeratioPage.submit();		
	}
	
	@Test(dependsOnMethods="registrationPage")
	public void registerationConfirmationPage(){
		RegistrationConfirmationPage registerationConfirmationPage=new RegistrationConfirmationPage(driver);
		registerationConfirmationPage.goToFlightDetailsPage();
		
	}
	
	@Test(dependsOnMethods="registerationConfirmationPage")
	public void flightDetailPage(){
		FlightDetailPage flightDetailPage=new FlightDetailPage(driver);
		flightDetailPage.selectPassengers(noOfPassengers);
		flightDetailPage.goToFindFlightsPage();
	}
	
	@Test(dependsOnMethods="flightDetailPage")
	public void findFlightPage(){
		FindFlightPage findFlightPage=new FindFlightPage(driver);
		findFlightPage.submitFindFlightPage();
		findFlightPage.goToFlightConfirmationPage();
	}
	
	@Test(dependsOnMethods="findFlightPage")
	public void flightConfirmationPage(){
		FlightConfirmationPage flightConfirmationPage=new FlightConfirmationPage(driver);
		String actualprice=flightConfirmationPage.getPrice();
		Assert.assertEquals(actualprice, expectedPrice);
	}
	
	
	

}
