package by.epam.booking.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {

	private static final String BASE_URL = "https://booking.com";

	@FindBy(xpath = "//*[@id=\"b_tt_holder_2\"]/div/span")
	private WebElement login;

	@FindBy(xpath = "//*[@id='ss']")
	private WebElement destinationField;

	@FindBy(xpath = "//button[@aria-label='Open calendar']")
	private WebElement dateField;

	@FindBy(xpath = "//td[@class='c2-day c2-day-s-weekend']")
	// @FindBy(xpath = "//span[@class='c2-day-inner' and contains (text(), '14')]")
	private WebElement checkInDate;

	// @FindBy(xpath = "//td[@class='c2-day c2-day-s-weekend c2-day-s-in-range
	// c2-day-s-last-in-range']")
	@FindBy(xpath = "//span[@class='c2-day-inner' and contains (text(), '16')]")
	private WebElement checkOutDate;

	@FindBy(xpath = "//span[@class='xp__guests__count']")
	private WebElement peopleNumber;

	@FindBy(xpath = "//select[@id='group_adults']")
	private List<WebElement> numberOfAdults;

	@FindBy(xpath = "//span[text()='Search']")
	private WebElement searchButton;

	@FindBy(xpath = "//*[@id='hotellist_inner']/div")
	private List<WebElement> resultOfSearch;


	public MainPage(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

	public void setDestination() {

		destinationField.click();
		destinationField.sendKeys("Minsk");

	}

	public void setDates() {

		dateField.click();
		checkInDate.click();
		dateField.click();
		checkOutDate.click();
	}

	public void setPeopleNumber() {

		peopleNumber.click();
		WebElement adults = numberOfAdults.get(0);
		adults.click();

		for (WebElement element : numberOfAdults) {
			if (element.getText().contains("2")) {
				element.click();
			}
		}
	}

	public void startSearch() {

		searchButton.click();

	}

	public int checkResultsOfSearch() {

		int numberOfResults = resultOfSearch.size();

		return numberOfResults;
	}

}
