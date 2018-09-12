package by.epam.booking.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage extends AbstractPage {

	private static final String BASE_URL = "https://www.booking.com/searchresults.en-gb.html?label=gen173nr-1DCAEoggJCAlhYSDNYBGgliAEBmAEuuAEIyAEM2AED6AEBkgIBeagCAw&lang=en-gb&sid=5e59aee432b6773cf99fc26d00ec9e70&sb=1&src=index&src_elem=sb&error_url=https%3A%2F%2Fwww.booking.com%2Findex.en-gb.html%3Flabel%3Dgen173nr-1DCAEoggJCAlhYSDNYBGgliAEBmAEuuAEIyAEM2AED6AEBkgIBeagCAw%3Bsid%3D5e59aee432b6773cf99fc26d00ec9e70%3Bsb_price_type%3Dtotal%26%3B&ss=Minsk&ssne=Minsk&ssne_untouched=Minsk&dest_id=-1946324&dest_type=city&checkin_monthday=15&checkin_month=9&checkin_year=2018&checkout_monthday=17&checkout_month=9&checkout_year=2018&no_rooms=1&group_adults=2&group_children=0&b_h4u_keep_filters=&from_sf=1";
	
	@FindBy(xpath = "//*[@id='hotellist_inner']/div")
	private List<WebElement> resultOfSearch;
	
	public ResultPage(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

	public List <WebElement> checkResultsOfSearch() {

		return resultOfSearch;
	}
	
}
