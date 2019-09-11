package parking_system.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class UserTest {
	
	User user; 
	UserErrorMsgs userErrorMsgs;

	@Before
	public void setUp() throws Exception {
		user = new User();
		userErrorMsgs = new UserErrorMsgs();
	}
 
	@Test
	@FileParameters("test/User_test_cases.csv")
	public void test(int testcaseNo, String action, String username, String firstName, String lastName, 
			String email, String password, String role, String utaid, String phone, String streetaddress, 
			String city, String state, String zipcode, String vehiclenumber, String status, String permit, String search, String searchfilter,
			String errorMsg, String userNameError, String userFirstNameError, String userLastNameError, 
			String userEmailError, String userPasswordError, String utaIDerror, String phoneError, 
			String streetAddError, String cityError, String stateError, String zipCodeError, 
			String vehicleNumberError, String searchError) {
		 
		user.setUser(username, firstName, lastName, email, password, role, utaid, phone, streetaddress, city, state, zipcode, vehiclenumber, status, permit, "");
		user.setSearch(search);
		user.setSearchfilter(searchfilter);
		user.setGreetingText("xyz");
		user.validateUser(action, user, userErrorMsgs);
		assertTrue(user.getRole().equals(role));
		assertTrue(user.getStatus().equals(status));
		assertTrue(user.getPermit().equals(permit));
		assertTrue(user.getComments().equals(""));
		assertTrue(user.getGreetingText().equals("xyz"));
		assertTrue(errorMsg.equals(userErrorMsgs.getErrorMsg()));
		assertTrue(userNameError.equals(userErrorMsgs.getUserNameError()));
		assertTrue(userFirstNameError.equals(userErrorMsgs.getUserFirstNameError()));
		assertTrue(userLastNameError.equals(userErrorMsgs.getUserLastNameError()));
		assertTrue(userEmailError.equals(userErrorMsgs.getUserEmailError()));
		assertTrue(userPasswordError.equals(userErrorMsgs.getUserPasswordError()));
		assertTrue(phoneError.equals(userErrorMsgs.getPhoneError()));	
		assertTrue(utaIDerror.equals(userErrorMsgs.getUtaIDerror()));
		assertTrue(streetAddError.equals(userErrorMsgs.getStreetAddError()));
		assertTrue(cityError.equals(userErrorMsgs.getCityError()));
		assertTrue(stateError.equals(userErrorMsgs.getStateError()));
		assertTrue(zipCodeError.equals(userErrorMsgs.getZipCodeError()));
		assertTrue(vehicleNumberError.equals(userErrorMsgs.getVehicleNumberError()));
		assertTrue(searchError.equals(userErrorMsgs.getSearchError()));
	}

}
