package by.epam.booking.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import by.epam.booking.driver.DriverSingletone;
import by.epam.booking.steps.Steps;

public class BaseTest {

	
	protected WebDriver driver;
	protected Steps steps;
		
	@BeforeSuite
	public void setUpDriver() {
		
		driver = DriverSingletone.getDriver();
		steps = new Steps(driver);
	}

	@AfterSuite
	public void closeDriver() {
		DriverSingletone.closeDriver();
	}
}
