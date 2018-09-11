package by.epam.booking.steps;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import by.epam.booking.pages.MainPage;

public class Steps {

	private WebDriver driver;
	private MainPage mainPage;

	public Steps(WebDriver driver) {
		this.driver = driver;
	}

	public void openBookingPage() {
		mainPage= new MainPage(driver);
		mainPage.openPage();
	}

	public void findRooms() {
		
		mainPage= new MainPage(driver);
		mainPage.setDestination();
		mainPage.setDates();
		mainPage.setPeopleNumber();
		mainPage.startSearch();
		
	}

	public int getListOfAccomodaion() {
		
		mainPage= new MainPage(driver);
		List <WebElement> results = mainPage.checkResultsOfSearch();
		
		return results.size();
	}

}
