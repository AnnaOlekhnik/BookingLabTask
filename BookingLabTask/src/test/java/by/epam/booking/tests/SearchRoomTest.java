package by.epam.booking.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchRoomTest extends BaseTest {

	
	@Test
	public void openPageTest() {
		steps.openBookingPage();
	}

	
	@Test
	public void searchRoomTest() {
		
		steps.findRooms();
	}

	@Test
	public void checkResultOfSearch() {

		int roomsAreFound = steps.getListOfAccomodaion();
		System.out.println(roomsAreFound);
		//Assert.assertTrue(roomsAreFound != 0);
	}

}
